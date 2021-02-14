package com.cg.electricity.dto;

public class Electricity {
	
	private int cnum;
	private double lread;
	private double cread;
	private String cname;
	private String address;
	private String city;
	private double units;
	private double namnt;
	
	
	public double getUnits() {
		return units;
	}
	public void setUnits(double units) {
		this.units = units;
	}
	public double getNamnt() {
		return namnt;
	}
	public void setNamnt(double namnt) {
		this.namnt = namnt;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public double getLread() {
		return lread;
	}
	public void setLread(double lread) {
		this.lread = lread;
	}
	public double getCread() {
		return cread;
	}
	public void setCread(double cread) {
		this.cread = cread;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
