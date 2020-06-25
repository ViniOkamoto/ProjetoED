package controller;

import model.NodeSale;

public class SaleController {
	private NodeSale start;
	
	public SaleController() {
		this.start = null;
	}
	
	public void adicionarInicio(int data) {
		NodeSale n = new NodeSale(data);
		if(this.start==null) {
			this.start = n;
		}else {
			NodeSale aux = this.start;
			n.setNext(aux);
			aux.setBefore(n);
			this.start = n;
		}
	}
	
	public void adicionarFinal(int data) {
		NodeSale n = new NodeSale(data);
		if(this.start == null) {
			this.start = n;
		}else {
			NodeSale aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(n);
			n.setBefore(aux);
		}
	}
	
	public void adicionarMeio(int data, int pos) {
		if(pos == 1) {
			adicionarInicio(data);
		}else if(pos==size(this.start)+1) {
			adicionarFinal(data);
		}else if(pos<size(this.start) && pos>0) {
			NodeSale n = new NodeSale(data);
			NodeSale aux = start;
			for(int i=0; i<pos-1; i++) {
				aux = aux.getNext();
			}
			NodeSale aux2 = aux.getBefore();
			aux2.setNext(n);
			n.setBefore(aux2);
			n.setNext(aux);
			aux.setBefore(n);
		}else {
			System.err.println("A posi��o � inv�lida");
		}
	}
	
	public void removerInicio() {
		if(this.start == null) {
			System.err.println("A lista est� vazia");
		}else {
			this.start = this.start.getNext();
			if(this.start!=null) {
				this.start.setBefore(null);
			}
		}
	}
	
	public void removerFinal() {
		if(this.start==null) {
			System.err.println("A lista est� vazia");
		}else if (this.start.getNext()==null){
			this.start = null;
		}else {
			NodeSale aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			NodeSale aux2 = aux.getBefore();
			aux.setBefore(null);
			aux2.setNext(null);
		}
	}
	
	public void removerMeio(int pos) {
		if(pos==1) {
			removerInicio();
		}else if(pos==size(this.start) + 1) {
			removerFinal();
		}else if(pos<size(this.start)) {
			NodeSale aux = this.start;
			for(int i=0; i<pos-1; i++) {
				aux = aux.getNext();
			}
			NodeSale aux2 = aux.getBefore();
			aux = aux.getNext();
			aux2.setNext(aux);
			aux.setBefore(aux2);
		}else {
			System.err.println("Posi��o � inv�lida");
		}
	}
	
	public String mostra() {
		String mostrar;
		StringBuffer buffer = new StringBuffer();
		if(this.start==null) {
			return "A lista est� vazia";
		}else {
			buffer.append("A lista �: \n");
			NodeSale aux = this.start;
			while(aux!=null) {
				buffer.append(aux.getData() + ", ");
				aux = aux.getNext();
			}
			mostrar = buffer.toString();
		}
		return mostrar;
	}
	
	private int size(NodeSale x) {
		int r = 0;
		while(x.getNext()!=null) {
			x = x.getNext();
			r++;
		}
		return r;
	}
}
