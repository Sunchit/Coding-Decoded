package com.codingdecoded.lowlevel.solid.openclosed.noncompliant;

public class Rectangle  implements Shape {


	private int length;
	private int breadth;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
}

