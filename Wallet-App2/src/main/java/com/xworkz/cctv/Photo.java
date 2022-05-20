package com.xworkz.cctv;

public class Photo {
	String color;
	double size;

	public Photo() {
		System.out.println(this.getClass().getSimpleName() + "Bean created ");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Photo [color=" + color + ", size=" + size + "]";
	}

	public Photo(String color, double size) {
		super();
		this.color = color;
		this.size = size;
	}

}
