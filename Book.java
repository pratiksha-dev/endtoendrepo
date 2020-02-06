package com.scp.java.endtoend;

//POJO or Bean -- Both
public class Book implements Comparable<Book>{
	
	private int bkId;
	private String bkName;
	private double bkPrice;
	private String bkRemarks;
	
	@Override
	public String toString() {
		return "\n [bkId=" + bkId + ", bkName=" + bkName + ", bkPrice=" + bkPrice + ", bkRemarks=" + bkRemarks + "]";
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bkId, String bkName, double bkPrice, String bkRemarks) {
		super();
		this.bkId = bkId;
		this.bkName = bkName;
		this.bkPrice = bkPrice;
		this.bkRemarks = bkRemarks;
	}
	
	public Book(String bkName, double bkPrice, String bkRemarks) {
		super();
		this.bkName = bkName;
		this.bkPrice = bkPrice;
		this.bkRemarks = bkRemarks;
	}
	
	public int getBkId() {
		return bkId;
	}
	public void setBkId(int bkId) {
		this.bkId = bkId;
	}
	public String getBkName() {
		return bkName;
	}
	public void setBkName(String bkName) {
		this.bkName = bkName;
	}
	public double getBkPrice() {
		return bkPrice;
	}
	public void setBkPrice(double bkPrice) {
		this.bkPrice = bkPrice;
	}
	public String getBkRemarks() {
		return bkRemarks;
	}
	public void setBkRemarks(String bkRemarks) {
		this.bkRemarks = bkRemarks;
	}
	public int compareTo(Book o) {
		return this.bkId - o.getBkId();
	}
	
	
	
}
