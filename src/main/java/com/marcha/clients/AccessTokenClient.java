package com.marcha.clients;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.logging.Logger;

import com.marcha.token.AccessTokenPojo;

import io.quarkus.rest.client.reactive.ClientExceptionMapper;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/token")
@RegisterRestClient(configKey="access-token-api")
public interface AccessTokenClient {
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    AccessTokenPojo getAccessToken(@FormParam("grant_type") String grantType, @FormParam("client_assertion_type") String clientAssertionType, @FormParam("client_assertion") String clientAssertion);

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
