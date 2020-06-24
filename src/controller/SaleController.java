package controller;

import model.NOSale;

public class SaleController {
	private NOSale start;
	
	public SaleController() {
		this.start = null;
	}
	
	public void adicionarInicio(int data) {
		NOSale n = new NOSale(data);
		if(this.start==null) {
			this.start = n;
		}else {
			NOSale aux = this.start;
			n.setNext(aux);
			aux.setBack(n);
			this.start = n;
		}
	}
	
	public void adicionarFinal(int data) {
		NOSale n = new NOSale(data);
		if(this.start == null) {
			this.start = n;
		}else {
			NOSale aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(n);
			n.setBack(aux);
		}
	}
	
	public void adicionarMeio(int data, int pos) {
		if(pos == 1) {
			adicionarInicio(data);
		}else if(pos==size(this.start)+1) {
			adicionarFinal(data);
		}else if(pos<size(this.start) && pos>0) {
			NOSale n = new NOSale(data);
			NOSale aux = start;
			for(int i=0; i<pos-1; i++) {
				aux = aux.getNext();
			}
			NOSale aux2 = aux.getBack();
			aux2.setNext(n);
			n.setBack(aux2);
			n.setNext(aux);
			aux.setBack(n);
		}else {
			System.err.println("A posi��o � inv�lida");
		}
	}
	
	public void removerInicio() {
		if(this.start == null) {
			System.err.println("A lista est� vazia :/");
		}else {
			this.start = this.start.getNext();
			if(this.start!=null) {
				this.start.setBack(null);
			}
		}
	}
	
	public void removerFinal() {
		if(this.start==null) {
			System.err.println("A lista est� vazia :/");
		}else if (this.start.getNext()==null){
			this.start = null;
		}else {
			NOSale aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			NOSale aux2 = aux.getBack();
			aux.setBack(null);
			aux2.setNext(null);
		}
	}
	
	public void removerMeio(int pos) {
		if(pos==1) {
			removerInicio();
		}else if(pos==size(this.start) + 1) {
			removerFinal();
		}else if(pos<size(this.start)) {
			NOSale aux = this.start;
			for(int i=0; i<pos-1; i++) {
				aux = aux.getNext();
			}
			NOSale aux2 = aux.getBack();
			aux = aux.getNext();
			aux2.setNext(aux);
			aux.setBack(aux2);
		}else {
			System.err.println("Posi��o � inv�lida XD");
		}
	}
	
	public String mostra() {
		String mostrar;
		StringBuffer buffer = new StringBuffer();
		if(this.start==null) {
			return "A lista est� vazia :P";
		}else {
			buffer.append("A lista �: \n");
			NOSale aux = this.start;
			while(aux!=null) {
				buffer.append(aux.getData() + ", ");
				aux = aux.getNext();
			}
			mostrar = buffer.toString();
		}
		return mostrar;
	}
	
	private int size(NOSale x) {
		int r = 0;
		while(x.getNext()!=null) {
			x = x.getNext();
			r++;
		}
		return r;
	}
}
