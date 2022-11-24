package com.ec.deckxel.postpayphone;

public class RespuestaPost {
	private Boolean Response;
	private String ErrorCode;
	
	
	public RespuestaPost() {
		super();
	}
	public RespuestaPost(Boolean response, String errorCode) {
		super();
		Response = response;
		ErrorCode = errorCode;
	}
	public Boolean getResponse() {
		return Response;
	}
	public void setResponse(Boolean response) {
		Response = response;
	}
	public String getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	
	

}
