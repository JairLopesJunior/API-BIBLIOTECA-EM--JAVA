package com.apibiblioteca.dto;

import java.io.Serializable;

public class SalvarLivrosResponseDTO implements Serializable {

	private static final long serialVersionUID = -4308236773547781867L;
	
	public SalvarLivrosResponseDTO(boolean success, String details) {
		this.message = new MessageDTO(success, details);
	}
	
	private MessageDTO message;

	public MessageDTO getMessage() {
		return message;
	}

	public void setMessage(MessageDTO message) {
		this.message = message;
	}

}
