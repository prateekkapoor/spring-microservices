package com.restful.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HelloWorldBean(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

	public HelloWorldBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
