package com.ssafy.dto;

public class Car {
	private String num;
	private String model;
	private int price;
	private String vcode;
	private String vname;
	
	public Car(String num, String model, int price, String vcode, String vname) {
		setNum(num);
		setModel(model);
		setPrice(price);
		setVcode(vcode);
		setVname(vname);
	}

	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getVcode() {
		return vcode;
	}
	
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	
	public String getVname() {
		return vname;
	}
	
	public void setVname(String vname) {
		this.vname = vname;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Car [num=").append(num)
		  .append(", model=").append(model)
		  .append(", price=").append(price)
		  .append(", vcode=").append(vcode)
		  .append(", vname=").append(vname).append("]");
		return sb.toString();
	}
}
