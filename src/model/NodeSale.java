package model;

public class NodeSale {
	private Sale data;
	private NodeSale next;
	private NodeSale before;
	
	public NodeSale(Sale data) {
		this.data = data;
		this.next = null;
		this.before = null;
	}

	public Sale getData() {
		return data;
	}

	public void setData(Sale data) {
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
