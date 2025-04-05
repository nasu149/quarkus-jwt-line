
package com.marcha.message.response;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sentMessages"
})
@Generated("jsonschema2pojo")
public class SentMessagePojo {

    @JsonProperty("sentMessages")
    private List<SentMessage> sentMessages;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SentMessagePojo() {
    }

    public SentMessagePojo(List<SentMessage> sentMessages) {
        super();
        this.sentMessages = sentMessages;
    }

    @JsonProperty("sentMessages")
    public List<SentMessage> getSentMessages() {
        return sentMessages;
    }

    @JsonProperty("sentMessages")
    public void setSentMessages(List<SentMessage> sentMessages) {
        this.sentMessages = sentMessages;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SentMessagePojo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("sentMessages");
        sb.append('=');
        sb.append(((this.sentMessages == null)?"<null>":this.sentMessages));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
