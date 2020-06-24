package model;

public class NodeLot {
	private Lot data;
	private NodeLot next;
	private NodeLot back;
	
	public NodeLot(Lot data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.back = null;
		this.next = null;
	}


	public Lot getData() {
		return data;
	}


	public void setData(Lot data) {
		this.data = data;
	}


	public NodeLot getNext() {
		return next;
	}

	public void setNext(NodeLot next) {
		this.next = next;
	}

	public NodeLot getBack() {
		return back;
	}

	public void setBack(NodeLot back) {
		this.back = back;
	}
	
	
}
