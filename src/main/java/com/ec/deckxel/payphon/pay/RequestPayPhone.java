
package com.ec.deckxel.payphon.pay;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "amount",
    "tax",
    "amountWithTax",
    "amountWithoutTax",
    "service",
    "tip",
    "currency",
    "reference",
    "clientTransactionId",
    "responseUrl",
    "cancellationUrl",
    "phoneNumber",
    "storeId",
    "additionalData",
    "oneTime",
    "expireIn"
})
public class RequestPayPhone {

    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("tax")
    private Integer tax;
    @JsonProperty("amountWithTax")
    private Integer amountWithTax;
    @JsonProperty("amountWithoutTax")
    private Integer amountWithoutTax;
    @JsonProperty("service")
    private Integer service;
    @JsonProperty("tip")
    private Integer tip;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("clientTransactionId")
    private String clientTransactionId;
    @JsonProperty("responseUrl")
    private String responseUrl;
    @JsonProperty("cancellationUrl")
    private String cancellationUrl;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("storeId")
    private String storeId;
    @JsonProperty("additionalData")
    private String additionalData;
    @JsonProperty("oneTime")
    private String oneTime;
    @JsonProperty("expireIn")
    private Integer expireIn;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @JsonProperty("tax")
    public Integer getTax() {
        return tax;
    }

    @JsonProperty("tax")
    public void setTax(Integer tax) {
        this.tax = tax;
    }

    @JsonProperty("amountWithTax")
    public Integer getAmountWithTax() {
        return amountWithTax;
    }

    @JsonProperty("amountWithTax")
    public void setAmountWithTax(Integer amountWithTax) {
        this.amountWithTax = amountWithTax;
    }

    @JsonProperty("amountWithoutTax")
    public Integer getAmountWithoutTax() {
        return amountWithoutTax;
    }

    @JsonProperty("amountWithoutTax")
    public void setAmountWithoutTax(Integer amountWithoutTax) {
        this.amountWithoutTax = amountWithoutTax;
    }

    @JsonProperty("service")
    public Integer getService() {
        return service;
    }

    @JsonProperty("service")
    public void setService(Integer service) {
        this.service = service;
    }

    @JsonProperty("tip")
    public Integer getTip() {
        return tip;
    }

    @JsonProperty("tip")
    public void setTip(Integer tip) {
        this.tip = tip;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("reference")
    public String getReference() {
        return reference;
    }

    @JsonProperty("reference")
    public void setReference(String reference) {
        this.reference = reference;
    }

    @JsonProperty("clientTransactionId")
    public String getClientTransactionId() {
        return clientTransactionId;
    }

    @JsonProperty("clientTransactionId")
    public void setClientTransactionId(String clientTransactionId) {
        this.clientTransactionId = clientTransactionId;
    }

    @JsonProperty("responseUrl")
    public String getResponseUrl() {
        return responseUrl;
    }

    @JsonProperty("responseUrl")
    public void setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
    }

    @JsonProperty("cancellationUrl")
    public String getCancellationUrl() {
        return cancellationUrl;
    }

    @JsonProperty("cancellationUrl")
    public void setCancellationUrl(String cancellationUrl) {
        this.cancellationUrl = cancellationUrl;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("storeId")
    public String getStoreId() {
        return storeId;
    }

    @JsonProperty("storeId")
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @JsonProperty("additionalData")
    public String getAdditionalData() {
        return additionalData;
    }

    @JsonProperty("additionalData")
    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    @JsonProperty("oneTime")
    public String getOneTime() {
        return oneTime;
    }

    @JsonProperty("oneTime")
    public void setOneTime(String oneTime) {
        this.oneTime = oneTime;
    }

    @JsonProperty("expireIn")
    public Integer getExpireIn() {
        return expireIn;
    }

    @JsonProperty("expireIn")
    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
