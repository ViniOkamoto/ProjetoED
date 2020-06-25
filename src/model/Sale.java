package model;

import java.util.Date;

public class Sale {
	private int id;
	private Lot lot;
	private int qtOut;
	private double total;
	private Date date;
	
	public Sale(int id, Lot lot, int qtOut, Date date) {
		this.id = id;
		this.lot = lot;
		this.qtOut = qtOut;
		this.total = (qtOut * lot.getSaleValue());
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
