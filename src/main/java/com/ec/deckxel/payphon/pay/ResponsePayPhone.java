
package com.ec.deckxel.payphon.pay;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "message",
    "errorCode",
    "errors"
})
public class ResponsePayPhone {

    @JsonProperty("message")
    private String message;
    @JsonProperty("errorCode")
    private Integer errorCode;
    @JsonProperty("errors")
    private Object[] errors = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponsePayPhone() {
    }

    /**
     * 
     * @param message
     * @param errors
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

    @JsonProperty("errors")
    public Object[] getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(Object[] errors) {
        this.errors = errors;
    }

}
