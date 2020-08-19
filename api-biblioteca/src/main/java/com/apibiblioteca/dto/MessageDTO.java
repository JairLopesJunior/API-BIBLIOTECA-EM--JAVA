package com.apibiblioteca.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class MessageDTO implements Serializable {

	private static final long serialVersionUID = -7590644294490307105L;

	public MessageDTO(boolean success, String details) {
        this.success = success;
        this.details = details;
    }

    public MessageDTO(){

    }

    private boolean success;

    private String details;

    @JsonIgnore
    private HttpStatus statusCode;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
}

