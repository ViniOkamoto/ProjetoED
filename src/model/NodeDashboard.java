package model;

import view.Dashboard;

public class NodeDashboard {
	private Dashboard data;
	private NodeDashboard next;
	private NodeDashboard before;
	
	public NodeDashboard(Dashboard data) {
		this.data = data;
		this.next = null;
		this.before = null;
	}

	public Dashboard getData() {
		return data;
	}

	public void setData(Dashboard data) {
		this.data = data;
	}

	public NodeDashboard getNext() {
		return next;
	}

	public void setNext(NodeDashboard next) {
		this.next = next;
	}

	public NodeDashboard getBefore() {
		return before;
	}

	public void setBefore(NodeDashboard before) {
		this.before = before;
	}
	
	
}
