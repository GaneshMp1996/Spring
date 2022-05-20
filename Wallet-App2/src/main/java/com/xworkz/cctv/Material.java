package com.xworkz.cctv;

public class Material {
	private double size;
	private String type;
	private float thickness;
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
