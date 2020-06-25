package model;

import view.Dashboard;

public class NodeProjection {
	private Projection data;
	private NodeProjection next;
	private NodeProjection before;
	
	public NodeProjection(Projection data) {
		this.data = data;
		this.next = null;
		this.before = null;
	}

	public Projection getData() {
		return data;
	}

	public void setData(Projection data) {
		this.data = data;
	}

	public NodeProjection getNext() {
		return next;
	}

	public void setNext(NodeProjection next) {
		this.next = next;
	}

	public NodeProjection getBefore() {
		return before;
	}

	public void setBefore(NodeProjection before) {
		this.before = before;
	}
	
	
}
