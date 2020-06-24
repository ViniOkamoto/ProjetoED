package model;

public class NOSale {
	private int data;
	private NOSale next;
	private NOSale back;
	
	public NOSale(int data) {
		this.data = data;
		this.next = null;
		this.back = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public NOSale getNext() {
		return next;
	}

	public void setNext(NOSale next) {
		this.next = next;
	}

	public NOSale getBack() {
		return back;
	}

	public void setBack(NOSale back) {
		this.back = back;
	}
	
	
}
