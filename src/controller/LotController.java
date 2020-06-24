package controller;

import model.NOLot;

public class LotController {
	private NOLot start;
	//private int id;
	
	public LotController() {
		// TODO Auto-generated constructor stub
		this.start = null;
	}
	
	public void add(int data) {
		NOLot n = new NOLot(data);
		if(this.start == null) {
			this.start = n;
		}else {
			NOLot aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(n);
			n.setBack(aux);
		}
	}
	
	public NOLot remove() {
		if(this.start==null) {
			System.err.println("A lista está vazia");
			return null;
		}else {
			this.start = this.start.getNext();
			NOLot aux = this.start;
			if(this.start!=null) {
				this.start.setBack(null);
			}
			return aux;
		}
	}
	
	public String show() {
		String mostra;
		if(this.start == null) {
			mostra = "A fila está vazia :/";
		}else {
			StringBuffer buffer = new StringBuffer();
			buffer.append("{");
			NOLot aux = this.start;
			while(aux!=null) {
				buffer.append(aux.getData());
				buffer.append(", ");
				aux = aux.getNext();
			}
			buffer.append("}");
			mostra = buffer.toString();
		}
		return mostra;
	}
}
