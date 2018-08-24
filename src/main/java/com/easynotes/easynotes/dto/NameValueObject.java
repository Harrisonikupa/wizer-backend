package com.easynotes.easynotes.dto;

import java.math.BigInteger;

public class NameValueObject {
	
	String name;
	
	BigInteger value;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setValue(BigInteger b) {
		this.value = b;
	}
	
	public BigInteger getValue() {
		return this.value;
	}

}
