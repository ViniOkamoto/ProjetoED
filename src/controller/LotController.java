package controller;

import java.io.IOException;

import model.Lot;
import model.NodeLot;

public class LotController {
	private NodeLot start;
	//private int id;
	
	public LotController() {
		this.start = null;
	}
	
	public void addAndSave(Lot data) {
		NodeLot n = new NodeLot(data);
		if(this.start == null) {
			this.start = n;
		}else {
			NodeLot aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(n);
			n.setBack(aux);
		}
		DatabaseController database = new DatabaseController();
		try {
			database.saveLot(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void add(Lot data) {
		NodeLot n = new NodeLot(data);
		if(this.start == null) {
			this.start = n;
		}else {
			NodeLot aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(n);
			n.setBack(aux);
		}
	}
	
	public NodeLot remove() {
		if(this.start==null) {
			System.err.println("A lista está vazia");
			return null;
		}else {
			this.start = this.start.getNext();
			NodeLot aux = this.start;
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
			NodeLot aux = this.start;
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
