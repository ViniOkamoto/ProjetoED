package model;

public class NodeSale {
	private int data;
	private NodeSale next;
	private NodeSale before;
	
	public NodeSale(int data) {
		this.data = data;
		this.next = null;
		this.before = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public NodeSale getNext() {
		return next;
	}

	public void setNext(NodeSale next) {
		this.next = next;
	}

	public NodeSale getBefore() {
		return before;
	}

	public void setBefore(NodeSale before) {
		this.before = before;
	}

}
