package controller;

import java.io.IOException;

import model.Lot;
import model.NodeLot;

public class LotController {
	private NodeLot start;
	
	public LotController() {
		this.start = null;
	}
	
	public Lot getLot(int x) {
        NodeLot aux = this.start;
        for(int i=0; i< x; i++) {
            aux = aux.getNext();
        }
        if(aux == null) {
       	 return null;
        }
        return aux.getData();
    }
	
	private NodeLot getNodeLot(int x) {
        NodeLot aux = this.start;
        for(int i=0; i< x; i++) {
            aux = aux.getNext();
        }
        if(aux == null) {
       	 return null;
        }
        return aux;
    }
	
	public int getIndex(int id) {
		NodeLot aux = this.start;
		boolean exist = false;
		int pos = 1;
		while (id != aux.getData().getId() && aux != null) {
			pos++;
			aux = aux.getNext();
		}
		if(id == aux.getData().getId()) {
			exist = true;
		}
		if(exist) {
			return pos;
		} else {
			return 0;
		}
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
	
	public int editLot(int id, int neg) {
		int r=0;
		int index = getIndex(id);
		Lot lot = getLot(index-1);
		if((lot.getQtIn()-lot.getQtOut())<neg) {
			neg = neg-(lot.getQtIn()-lot.getQtOut());
			lot.setQtOut(neg + lot.getQtOut());
			r=neg;
		}else {
			lot.setQtOut(neg+lot.getQtOut());
			NodeLot aux = getNodeLot(index-1);
			aux.setData(lot);
		}
		return r;
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
			mostra = "A fila está vazia";
		}else {
			StringBuffer buffer = new StringBuffer();
			NodeLot aux = this.start;
			while(aux!=null) {
				buffer.append("Codigo: " + aux.getData().getId() + " |IdProduto: " 
			            + aux.getData().getProduct().getId() + " |qtdEntrada: " + aux.getData().getQtIn() + " |qtdSaida: " + aux.getData().getQtOut() + 
			            " |valorCompra: " + aux.getData().getPurcasheValue() + " |valorVenda: " + aux.getData().getSaleValue() +  "\n");
				aux = aux.getNext();
			}
			mostra = buffer.toString();
		}
		return mostra;
	}
	
	public int size() {
		NodeLot aux = this.start;
		int cont = 0;
		while(aux!=null) {
			cont++;
			aux = aux.getNext();
		}
		return cont;
	}
	
	public Lot getLotByProduct(int id) {
		NodeLot aux = this.start;
		if(aux.getData().getQtIn() == aux.getData().getQtOut()) {
			aux = aux.getNext();
		}
		boolean exist = false;
		while(aux.getData().getProduct().getId() != id && aux != null) {
			aux = aux.getNext();
			if(aux==null) {
				break;
			}
			while(aux.getData().getQtIn() == aux.getData().getQtOut() && aux != null) {
				aux = aux.getNext();
				if(aux==null) {
					break;
				}
			}
			if(aux==null) {
				break;
			}
		}
		if(aux!=null) {
			if(aux.getData().getProduct().getId() == id) {
				exist = true;
			}
			if(exist) {
				return aux.getData();			
			}
		}
		
		return null;
	}
	
	public Lot getLastElement() {
		NodeLot aux = this.start;
		while(aux.getNext()!=null) {
			aux = aux.getNext();
		}
		return aux.getData();
	}
}
