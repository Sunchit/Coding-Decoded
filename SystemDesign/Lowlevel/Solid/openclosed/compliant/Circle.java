package com.codingdecoded.lowlevel.solid.openclosed.compliant;

public class Circle implements Shape{

	private int radius;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public Double getArea() {
		return 3.14d * radius *radius;
	}

	@Override
	public Double getPerimeter() {
		return 2 * 3.14d * radius;
	}
}
