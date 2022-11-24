package com.ec.deckxel.postpayphone;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Email", "CardType", "Bin", "DeferredCode", "DeferredMessage", "Deferred", "CardBrandCode",
		"CardBrand", "Amount", "ClientTransactionId", "PhoneNumber", "StatusCode", "TransactionStatus",
		"AuthorizationCode", "TransactionId", "Document", "Taxes", "Currency", "StoreId","AdditionalData" })
public class PostPayphoneResponse {
	@JsonProperty("Email")
	private String Email;
	@JsonProperty("CardType")
	private String CardType;
	@JsonProperty("Bin")
	private String Bin;
	@JsonProperty("DeferredCode")
	private String DeferredCode;
	@JsonProperty("DeferredMessage")
	private String DeferredMessage;
	@JsonProperty("Deferred")
	private Boolean Deferred;
	@JsonProperty("CardBrandCode")
	private String CardBrandCode;
	@JsonProperty("CardBrand")
	private String CardBrand;
	@JsonProperty("Amount")
		private Integer Amount;
		@JsonProperty("ClientTransactionId")
	private String ClientTransactionId;
	@JsonProperty("PhoneNumber")
	private String PhoneNumber;
	@JsonProperty("StatusCode")
	private Integer StatusCode;
	@JsonProperty("TransactionStatus")
	private String TransactionStatus;
	@JsonProperty("AuthorizationCode")
	private String AuthorizationCode;
	@JsonProperty("TransactionId")
	private Integer TransactionId;
	@JsonProperty("Document")
	private String Document;
	@JsonProperty("Taxes")
	private List<Tax> Taxes = null;
	@JsonProperty("Currency")
	private String Currency;
	@JsonProperty("StoreId")
	private String StoreId;
	@JsonProperty("AdditionalData")
	private String AdditionalData;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Email")
	public String getEmail() {
		return Email;
	}

	@JsonProperty("Email")
	public void setEmail(String Email) {
		this.Email = Email;
	}

	@JsonProperty("CardType")
	public String getCardType() {
		return CardType;
	}

	@JsonProperty("CardType")
	public void setCardType(String CardType) {
		this.CardType = CardType;
	}

	@JsonProperty("Bin")
	public String getBin() {
		return Bin;
	}

	@JsonProperty("Bin")
	public void setBin(String Bin) {
		this.Bin = Bin;
	}

	@JsonProperty("DeferredCode")
	public String getDeferredCode() {
		return DeferredCode;
	}

	@JsonProperty("DeferredCode")
	public void setDeferredCode(String DeferredCode) {
		this.DeferredCode = DeferredCode;
	}

	@JsonProperty("DeferredMessage")
	public String getDeferredMessage() {
		return DeferredMessage;
	}

	@JsonProperty("DeferredMessage")
	public void setDeferredMessage(String DeferredMessage) {
		this.DeferredMessage = DeferredMessage;
	}

	@JsonProperty("Deferred")
	public Boolean getDeferred() {
		return Deferred;
	}

	@JsonProperty("Deferred")
	public void setDeferred(Boolean Deferred) {
		this.Deferred = Deferred;
	}

	@JsonProperty("CardBrandCode")
	public String getCardBrandCode() {
		return CardBrandCode;
	}

	@JsonProperty("CardBrandCode")
	public void setCardBrandCode(String CardBrandCode) {
		this.CardBrandCode = CardBrandCode;
	}

	@JsonProperty("CardBrand")
	public String getCardBrand() {
		return CardBrand;
	}

	@JsonProperty("CardBrand")
	public void setCardBrand(String CardBrand) {
		this.CardBrand = CardBrand;
	}

	@JsonProperty("Amount")
	public Integer getAmount() {
		return Amount;
	}

	@JsonProperty("Amount")
	public void setAmount(Integer Amount) {
		this.Amount = Amount;
	}

	@JsonProperty("ClientTransactionId")
	public String getClientTransactionId() {
		return ClientTransactionId;
	}

	@JsonProperty("ClientTransactionId")
	public void setClientTransactionId(String ClientTransactionId) {
		this.ClientTransactionId = ClientTransactionId;
	}

	@JsonProperty("PhoneNumber")
	public String getPhoneNumber() {
		return PhoneNumber;
	}

	@JsonProperty("PhoneNumber")
	public void setPhoneNumber(String PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}

	@JsonProperty("StatusCode")
	public Integer getStatusCode() {
		return StatusCode;
	}

	@JsonProperty("StatusCode")
	public void setStatusCode(Integer StatusCode) {
		this.StatusCode = StatusCode;
	}

	@JsonProperty("TransactionStatus")
	public String getTransactionStatus() {
		return TransactionStatus;
	}

	@JsonProperty("TransactionStatus")
	public void setTransactionStatus(String TransactionStatus) {
		this.TransactionStatus = TransactionStatus;
	}

	@JsonProperty("AuthorizationCode")
	public String getAuthorizationCode() {
		return AuthorizationCode;
	}

	@JsonProperty("AuthorizationCode")
	public void setAuthorizationCode(String AuthorizationCode) {
		this.AuthorizationCode = AuthorizationCode;
	}

	@JsonProperty("TransactionId")
	public Integer getTransactionId() {
		return TransactionId;
	}

	@JsonProperty("TransactionId")
	public void setTransactionId(Integer TransactionId) {
		this.TransactionId = TransactionId;
	}

	@JsonProperty("Document")
	public String getDocument() {
		return Document;
	}

	@JsonProperty("Document")
	public void setDocument(String Document) {
		this.Document = Document;
	}

	@JsonProperty("Taxes")
	public List<Tax> getTaxes() {
		return Taxes;
	}

	@JsonProperty("Taxes")
	public void setTaxes(List<Tax> Taxes) {
		this.Taxes = Taxes;
	}

	@JsonProperty("Currency")
	public String getCurrency() {
		return Currency;
	}

	@JsonProperty("Currency")
	public void setCurrency(String Currency) {
		this.Currency = Currency;
	}

	@JsonProperty("StoreId")
	public String getStoreId() {
		return StoreId;
	}

	@JsonProperty("StoreId")
	public void setStoreId(String StoreId) {
		this.StoreId = StoreId;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public String getAdditionalData() {
		return AdditionalData;
	}

	public void setAdditionalData(String AdditionalData) {
		this.AdditionalData = AdditionalData;
	}
}
