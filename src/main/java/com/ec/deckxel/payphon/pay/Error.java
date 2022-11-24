
package com.ec.deckxel.payphon.pay;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "message",
    "errorCode",
    "errorDescriptions"
})
public class Error {

    @JsonProperty("message")
    private String message;
    @JsonProperty("errorCode")
    private Integer errorCode;
    @JsonProperty("errorDescriptions")
    private Object[] errorDescriptions = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Error() {
    }

    /**
     * 
     * @param message
     * @param errorDescriptions
     * @param errorCode
     */
  

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("errorCode")
    public Integer getErrorCode() {
        return errorCode;
    }

    @JsonProperty("errorCode")
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @JsonProperty("errorDescriptions")
    public Object[] getErrorDescriptions() {
        return errorDescriptions;
    }

    @JsonProperty("errorDescriptions")
    public void setErrorDescriptions(Object[] errorDescriptions) {
        this.errorDescriptions = errorDescriptions;
    }

}
