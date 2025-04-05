package com.marcha;

import java.util.Arrays;
import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import com.marcha.clients.AccessTokenClient;
import com.marcha.clients.SendMessageClient;
import com.marcha.message.request.Message;
import com.marcha.message.request.SendMessagePojo;
import com.marcha.message.response.SentMessagePojo;
import com.marcha.token.AccessTokenPojo;
import com.marcha.token.utils.JwtUtil;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/notify-message")
public class NotifyMessage {

    private static final Logger logger = Logger.getLogger(NotifyMessage.class);

    @ConfigProperty(name = "notify.message.jwt.private.key.id")
    String kid;
    @ConfigProperty(name = "notify.message.jwt.channel.id")
    String channelId;
    @ConfigProperty(name = "notify.message.client.id")
    String clientId;

    @Inject @RestClient
    AccessTokenClient accessTokenClient;

    @Inject @RestClient
    SendMessageClient sendMessageClient;

    @GET @Path("{message}")
    @Produces(MediaType.TEXT_PLAIN)
    public String notifyMessage(String message) {

        // get an access token
        AccessTokenPojo accessTokenPojo = createAccessTokenPojo();
        String accessToken = accessTokenPojo.getAccessToken();  
        String accessTokenWithBearer = "Bearer " + accessToken;

        // create the messages
        SendMessagePojo sendMessagePojo = creatSendMessagePojo(message);

        // Rest to Line API to notify messages.
        SentMessagePojo sentMessagePojo = sendMessageClient.sendMessage(accessTokenWithBearer, sendMessagePojo);
        logger.debug("sentMessagePojo = " + sentMessagePojo);

        return "OK! I sent the word '" + message + "'!";
    }

    private AccessTokenPojo createAccessTokenPojo(){
        // create a JWT
        JwtUtil jwtUtil = new JwtUtil(kid, channelId);
        String signedJwt = jwtUtil.getJwt();

        // Rest to Line API to get AccessToken
        String grantType = "client_credentials";
        String clientAssertionType = "urn:ietf:params:oauth:client-assertion-type:jwt-bearer";
        AccessTokenPojo accessTokenPojo = accessTokenClient.getAccessToken(grantType, clientAssertionType, signedJwt);

        // logger.debug("accessToken = " + accessToken);
        logger.debug("ccessTokenPojo.getTokenType() = " + accessTokenPojo.getTokenType());
        logger.debug("accessTokenPojo.getExpiresIn() = " + accessTokenPojo.getExpiresIn());
        return accessTokenPojo;
    }

    private SendMessagePojo creatSendMessagePojo(String message){
        // create a message to send to Line users
        Message message1 = new Message("text", message);
        List<Message> messages = Arrays.asList(message1);
        SendMessagePojo sendMessagePojo = new SendMessagePojo(clientId, messages);
        return sendMessagePojo;
    }
}
