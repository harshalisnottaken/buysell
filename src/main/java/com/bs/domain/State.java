package com.bs.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;

@Setter
@Getter
public class State {
	@Id
	private String state;
	private List<String> cities;

}
