
package com.marcha.message.response;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "quoteToken"
})
@Generated("jsonschema2pojo")
public class SentMessage {

    @JsonProperty("id")
    private String id;
    @JsonProperty("quoteToken")
    private String quoteToken;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SentMessage() {
    }

    public SentMessage(String id, String quoteToken) {
        super();
        this.id = id;
        this.quoteToken = quoteToken;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("quoteToken")
    public String getQuoteToken() {
        return quoteToken;
    }

    @JsonProperty("quoteToken")
    public void setQuoteToken(String quoteToken) {
        this.quoteToken = quoteToken;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SentMessage.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("quoteToken");
        sb.append('=');
        sb.append(((this.quoteToken == null)?"<null>":this.quoteToken));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
