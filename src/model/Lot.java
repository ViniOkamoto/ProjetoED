package model;

import java.util.Date;

public class Lot {
	private Product product;
	private int qtIn;
	private int qtOut;
	private Date dateIn;
	private double purcasheValue;
	private double saleValue;
	
	public Lot(Product product, int qtIn, int qtOut, double purcasheValue, double saleValue ) {
		this.product = product;
		this.qtIn = qtIn;
		this.qtOut = qtOut;
		this.dateIn = new Date();
		this.purcasheValue = purcasheValue;
		this.saleValue = saleValue;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQtIn() {
		return qtIn;
	}

	public void setQtIn(int qtIn) {
		this.qtIn = qtIn;
	}

	public int getQtOut() {
		return qtOut;
	}

	public void setQtOut(int qtOut) {
		this.qtOut = qtOut;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public double getPurcasheValue() {
		return purcasheValue;
	}

	public void setPurcasheValue(double purcasheValue) {
		this.purcasheValue = purcasheValue;
	}

	public double getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(double saleValue) {
		this.saleValue = saleValue;
	}
	
}
