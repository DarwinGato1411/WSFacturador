
package com.ec.deckxel.payphon.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "amount",
    "amountWithoutTax",
    "clientTransactionId",
    "responseURL"
})
public class RequestBoton {

    @JsonProperty("amount")
    private String amount;
    @JsonProperty("amountWithoutTax")
    private String amountWithoutTax;
    @JsonProperty("clientTransactionId")
    private String clientTransactionId;
    @JsonProperty("responseURL")
    private String responseURL;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RequestBoton() {
    }

    /**
     * 
     * @param responseURL
     * @param amount
     * @param amountWithoutTax
     * @param clientTransactionId
     */
    public RequestBoton(String amount, String amountWithoutTax, String clientTransactionId, String responseURL) {
        super();
        this.amount = amount;
        this.amountWithoutTax = amountWithoutTax;
        this.clientTransactionId = clientTransactionId;
        this.responseURL = responseURL;
    }

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("amountWithoutTax")
    public String getAmountWithoutTax() {
        return amountWithoutTax;
    }

    @JsonProperty("amountWithoutTax")
    public void setAmountWithoutTax(String amountWithoutTax) {
        this.amountWithoutTax = amountWithoutTax;
    }

    @JsonProperty("clientTransactionId")
    public String getClientTransactionId() {
        return clientTransactionId;
    }

    @JsonProperty("clientTransactionId")
    public void setClientTransactionId(String clientTransactionId) {
        this.clientTransactionId = clientTransactionId;
    }

    @JsonProperty("responseURL")
    public String getResponseURL() {
        return responseURL;
    }

    @JsonProperty("responseURL")
    public void setResponseURL(String responseURL) {
        this.responseURL = responseURL;
    }

}
