package com.marcha.clients;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.logging.Logger;

import com.marcha.message.request.SendMessagePojo;
import com.marcha.message.response.SentMessagePojo;

import io.quarkus.rest.client.reactive.ClientExceptionMapper;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/push")
@RegisterRestClient(configKey="send-message-api")
public interface SendMessageClient {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    SentMessagePojo sendMessage(@HeaderParam("Authorization") String accessTokenWithBearer, @RequestBody SendMessagePojo sendMessagePojo);

    @ClientExceptionMapper
    static RuntimeException toException(Response response) {
        if (response.getStatus() == 400) {
            Logger logger = Logger.getLogger(AccessTokenClient.class);
            logger.debug(response.getHeaders());
            return new RuntimeException("The remote service responded with HTTP 500");
        }
        return null;
    }
}
