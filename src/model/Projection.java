package model;

import java.util.Date;

public class Projection {
	private int id;
	private Product product;
	private double average;
	private String report;
	private Date date;
	
	public Projection(int id,Product product, double average, String report, Date date) {
		this.id = id;
		this.product = product;
		this.average = average;
		this.report = report;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
