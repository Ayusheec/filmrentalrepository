package com.filmrentalstore.exception;

import java.time.LocalDate;

public class ErrorMsg {
	private String errorMsg;
	private LocalDate errorDate;
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public LocalDate getErrorDate() {
		return errorDate;
	}
	public void setErrorDate(LocalDate errorDate) {
		this.errorDate = errorDate;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
