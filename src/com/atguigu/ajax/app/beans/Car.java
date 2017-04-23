package com.atguigu.ajax.app.beans;

public class Car {
	private String brand;
	private String year;
	private String color;
	private String vin;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Car(String brand, String year, String color, String vin) {
		super();
		this.brand = brand;
		this.year = year;
		this.color = color;
		this.vin = vin;
	}
	
	
	
}
