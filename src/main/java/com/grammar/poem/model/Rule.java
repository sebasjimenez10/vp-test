package com.grammar.poem.model;

import java.util.List;

public class Rule {

	private String name;
	private String value;
	private List<List<String>> evaluables;
	
	public Rule() {
		// Constructor
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<List<String>> getEvaluables() {
		return evaluables;
	}

	public void setEvaluables(List<List<String>> evaluables) {
		this.evaluables = evaluables;
	}
}
