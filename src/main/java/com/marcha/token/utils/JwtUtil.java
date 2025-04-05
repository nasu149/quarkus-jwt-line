package com.marcha.token.utils;

import org.jboss.logging.Logger;

import io.smallrye.jwt.algorithm.SignatureAlgorithm;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;

public class JwtUtil {
    private static final Logger logger = Logger.getLogger(JwtUtil.class);

    private String kid;
    private String channelId;

    public JwtUtil(String kid, String channelId){
        this.kid = kid;
        this.channelId = channelId;
    }

    public String getJwt(){
        logger.debug("getJwt Started");
        logger.debug("kid = " + kid);
        logger.debug("channelId = " + channelId);

        JwtClaimsBuilder builder = Jwt.claims();
        String signedJwt = builder.subject(channelId)//.claim("token_exp", 86400)
            .jws().keyId(kid).algorithm(SignatureAlgorithm.RS256).sign();
        return signedJwt;
    }
}
