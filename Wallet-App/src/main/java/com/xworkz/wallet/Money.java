package com.xworkz.wallet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Money {
	@Value("Cash")
	private String type;
	@Value("6.0")
	private double size;
	@Value("pink")

	private String color;

	public Money() {
		System.out.println(this.getClass().getSimpleName() + " Bean created ");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Money(String type, double size, String isCoinORNote, String color) {
		super();
		this.type = type;
		this.size = size;

		this.color = color;
	}

	@Override
	public String toString() {
		return "Money [type=" + type + ", size=" + size + ",  color=" + color + "]";
	}

}
