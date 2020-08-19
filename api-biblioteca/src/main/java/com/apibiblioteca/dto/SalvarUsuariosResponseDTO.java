package com.apibiblioteca.dto;

import java.io.Serializable;

public class SalvarUsuariosResponseDTO implements Serializable {

	private static final long serialVersionUID = -8200113024681154890L;
	
	public SalvarUsuariosResponseDTO(boolean success, String details) {
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
