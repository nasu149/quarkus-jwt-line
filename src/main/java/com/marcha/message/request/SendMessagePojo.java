
package com.marcha.message.request;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "to",
    "messages"
})
@Generated("jsonschema2pojo")
public class SendMessagePojo {

    @JsonProperty("to")
    private String to;
    @JsonProperty("messages")
    private List<Message> messages;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SendMessagePojo() {
    }

    public SendMessagePojo(String to, List<Message> messages) {
        super();
        this.to = to;
        this.messages = messages;
    }

    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(String to) {
        this.to = to;
    }

    @JsonProperty("messages")
    public List<Message> getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SendMessagePojo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("to");
        sb.append('=');
        sb.append(((this.to == null)?"<null>":this.to));
        sb.append(',');
        sb.append("messages");
        sb.append('=');
        sb.append(((this.messages == null)?"<null>":this.messages));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
