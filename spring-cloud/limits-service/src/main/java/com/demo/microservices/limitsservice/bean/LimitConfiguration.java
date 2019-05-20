package com.demo.microservices.limitsservice.bean;

public class LimitConfiguration {
	private Integer minimum;
	private Integer maximum;

	public Integer getMinimum() {
		return minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

	public Integer getMaximum() {
		return maximum;
	}

	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}

	public LimitConfiguration(Integer minimum, Integer maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

}
