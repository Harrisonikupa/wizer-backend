package com.easynotes.easynotes.dto;

import java.math.BigInteger;

public class DataObject {

	String author[];
	
	BigInteger count[];

	public BigInteger[] getCount() {
		return count;
	}

	public void setCount(BigInteger[] count) {
		this.count = count;
	}

	public String[] getAuthor() {
		return author;
	}

	public void setAuthor(String[] author) {
		this.author = author;
	}
}
