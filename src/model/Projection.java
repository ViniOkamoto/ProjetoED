package model;

import java.util.Date;

public class Projection {
	private Product product;
	private double average;
	private String report;
	private Date date;
	
	public Projection(Product product, double average, String report) {
		this.product = product;
		this.average = average;
		this.report = report;
		this.date = new Date();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
