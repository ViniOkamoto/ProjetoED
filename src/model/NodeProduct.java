package model;

public class NodeProduct{
	private Product data;
	private NodeProduct next;
	private NodeProduct before;

	public NodeProduct (Product e){
		data = e;
		next = null;
		before = null;
	}

	public Product getData() {
		return data;
	}

	public void setData(Product data) {
		this.data = data;
	}

	public NodeProduct getNext() {
		return next;
	}

	public void setNext(NodeProduct next) {
		this.next = next;
	}

	public NodeProduct getBefore() {
		return before;
	}

	public void setBefore(NodeProduct before) {
		this.before = before;
	}
}
