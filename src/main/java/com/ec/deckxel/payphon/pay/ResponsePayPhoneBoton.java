
package com.ec.deckxel.payphon.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "paymentId",
    "payWithPayPhone",
    "payWithCard"
})
public class ResponsePayPhoneBoton {

    @JsonProperty("paymentId")
    private String paymentId;
    @JsonProperty("payWithPayPhone")
    private String payWithPayPhone;
    @JsonProperty("payWithCard")
    private String payWithCard;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponsePayPhoneBoton() {
    }

    /**
     * 
     * @param payWithCard
     * @param payWithPayPhone
     * @param paymentId
     */
    public ResponsePayPhoneBoton(String paymentId, String payWithPayPhone, String payWithCard) {
        super();
        this.paymentId = paymentId;
        this.payWithPayPhone = payWithPayPhone;
        this.payWithCard = payWithCard;
    }

    @JsonProperty("paymentId")
    public String getPaymentId() {
        return paymentId;
    }

    @JsonProperty("paymentId")
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @JsonProperty("payWithPayPhone")
    public String getPayWithPayPhone() {
        return payWithPayPhone;
    }

    @JsonProperty("payWithPayPhone")
    public void setPayWithPayPhone(String payWithPayPhone) {
        this.payWithPayPhone = payWithPayPhone;
    }

    @JsonProperty("payWithCard")
    public String getPayWithCard() {
        return payWithCard;
    }

    @JsonProperty("payWithCard")
    public void setPayWithCard(String payWithCard) {
        this.payWithCard = payWithCard;
    }

}
