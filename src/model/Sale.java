package model;

import java.util.Date;

public class Sale {
	private Lot lot;
	private int qtOut;
	private double total;
	private Date date;
	
	public Sale(Lot lot, int qtOut, double total) {
		this.lot = lot;
		this.qtOut = qtOut;
		this.total = total;
		this.date = new Date();
	}

	public Lot getLot() {
		return lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public int getQtOut() {
		return qtOut;
	}

	public void setQtOut(int qtOut) {
		this.qtOut = qtOut;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
