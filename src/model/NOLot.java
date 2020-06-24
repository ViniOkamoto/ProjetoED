package model;

public class NOLot {
	private int data;
	private NOLot next;
	private NOLot back;
	
	public NOLot(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.back = null;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public NOLot getNext() {
		return next;
	}

	public void setNext(NOLot next) {
		this.next = next;
	}

	public NOLot getBack() {
		return back;
	}

	public void setBack(NOLot back) {
		this.back = back;
	}
	
	
}
