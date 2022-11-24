
package com.ec.deckxel.payphon.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class RequestPayPhoneBoton {

   // @JsonProperty("amount")
    private Integer amount;
   // @JsonProperty("amountWithoutTax")
    private Integer amountWithoutTax;
   // @JsonProperty("amountWithTax")
    private Integer amountWithTax;
   // @JsonProperty("tax")
    private Integer tax;
   // @JsonProperty("service")
    private Integer service;
   // @JsonProperty("tip")
    private Integer tip;
   // @JsonProperty("currency")
    private String currency;
   // @JsonProperty("clientTransactionId")
    private String clientTransactionId;
   // @JsonProperty("responseUrl")
    private String responseUrl;
   // @JsonProperty("storeId")
    private String storeId;
   // @JsonProperty("reference")
    private String reference;
   // @JsonProperty("phoneNumber")
    private String phoneNumber;
   // @JsonProperty("email")
    private String email;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RequestPayPhoneBoton() {
    }

    /**
     * 
     * @param amount
     * @param phoneNumber
     * @param tax
     * @param email
     * @param responseUrl
     * @param service
     * @param amountWithoutTax
     * @param clientTransactionId
     * @param storeId
     * @param reference
     * @param tip
     * @param amountWithTax
     * @param currency
     */
    public RequestPayPhoneBoton(Integer amount, Integer amountWithoutTax, Integer amountWithTax, Integer tax, Integer service, Integer tip, String currency, String clientTransactionId, String responseUrl, String storeId, String reference, String phoneNumber, String email) {
        super();
        this.amount = amount;
        this.amountWithoutTax = amountWithoutTax;
        this.amountWithTax = amountWithTax;
        this.tax = tax;
        this.service = service;
        this.tip = tip;
        this.currency = currency;
        this.clientTransactionId = clientTransactionId;
        this.responseUrl = responseUrl;
        this.storeId = storeId;
        this.reference = reference;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

   // @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

   // @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

   // @JsonProperty("amountWithoutTax")
    public Integer getAmountWithoutTax() {
        return amountWithoutTax;
    }

   // @JsonProperty("amountWithoutTax")
    public void setAmountWithoutTax(Integer amountWithoutTax) {
        this.amountWithoutTax = amountWithoutTax;
    }

   // @JsonProperty("amountWithTax")
    public Integer getAmountWithTax() {
        return amountWithTax;
    }

   // @JsonProperty("amountWithTax")
    public void setAmountWithTax(Integer amountWithTax) {
        this.amountWithTax = amountWithTax;
    }

   // @JsonProperty("tax")
    public Integer getTax() {
        return tax;
    }

   // @JsonProperty("tax")
    public void setTax(Integer tax) {
        this.tax = tax;
    }

   // @JsonProperty("service")
    public Integer getService() {
        return service;
    }

   // @JsonProperty("service")
    public void setService(Integer service) {
        this.service = service;
    }

   // @JsonProperty("tip")
    public Integer getTip() {
        return tip;
    }

   // @JsonProperty("tip")
    public void setTip(Integer tip) {
        this.tip = tip;
    }

   // @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

   // @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

   // @JsonProperty("clientTransactionId")
    public String getClientTransactionId() {
        return clientTransactionId;
    }

   // @JsonProperty("clientTransactionId")
    public void setClientTransactionId(String clientTransactionId) {
        this.clientTransactionId = clientTransactionId;
    }

   // @JsonProperty("responseUrl")
    public String getResponseUrl() {
        return responseUrl;
    }

   // @JsonProperty("responseUrl")
    public void setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
    }

   // @JsonProperty("storeId")
    public String getStoreId() {
        return storeId;
    }

   // @JsonProperty("storeId")
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

   // @JsonProperty("reference")
    public String getReference() {
        return reference;
    }

   // @JsonProperty("reference")
    public void setReference(String reference) {
        this.reference = reference;
    }

   // @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

   // @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

   // @JsonProperty("email")
    public String getEmail() {
        return email;
    }

   // @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

}
