
package com.marcha.token;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "access_token",
    "token_type",
    "expires_in",
    "key_id"
})
@Generated("jsonschema2pojo")
public class AccessTokenPojo {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("expires_in")
    private Integer expiresIn;
    @JsonProperty("key_id")
    private String keyId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AccessTokenPojo() {
    }

    public AccessTokenPojo(String accessToken, String tokenType, Integer expiresIn, String keyId) {
        super();
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.keyId = keyId;
    }

    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty("access_token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty("token_type")
    public String getTokenType() {
        return tokenType;
    }

    @JsonProperty("token_type")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @JsonProperty("expires_in")
    public Integer getExpiresIn() {
        return expiresIn;
    }

    @JsonProperty("expires_in")
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    @JsonProperty("key_id")
    public String getKeyId() {
        return keyId;
    }

    @JsonProperty("key_id")
    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AccessTokenPojo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accessToken");
        sb.append('=');
        sb.append(((this.accessToken == null)?"<null>":this.accessToken));
        sb.append(',');
        sb.append("tokenType");
        sb.append('=');
        sb.append(((this.tokenType == null)?"<null>":this.tokenType));
        sb.append(',');
        sb.append("expiresIn");
        sb.append('=');
        sb.append(((this.expiresIn == null)?"<null>":this.expiresIn));
        sb.append(',');
        sb.append("keyId");
        sb.append('=');
        sb.append(((this.keyId == null)?"<null>":this.keyId));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
