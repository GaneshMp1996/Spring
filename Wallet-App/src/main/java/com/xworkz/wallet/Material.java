package com.xworkz.wallet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Material {
	@Value("3.2")
	private double size;
	@Value("Leather")
	private String type;
	@Value("3.5")
	private float thickness;
	@Value("2500.00")
	private double price;

	public Material() {

		// this.price=8000;

		System.out.println(this.getClass().getSimpleName() + " Bean created");

	}

	public void setSize(double size) {
		this.size = size;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setThickness(float thickness) {
		this.thickness = thickness;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Material(double size, String type, float thickness, double price) {
		super();
		this.size = size;
		this.type = type;
		this.thickness = thickness;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Material [size=" + size + ", type=" + type + ", thickness=" + thickness + ", price=" + price + "]";
	}

}
