package com.bs.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddKey {
	private String title;
	private String emailId;
	public AddKey(String title, String emailId) {
		this.title = title;
		this.emailId = emailId;
	}
}
