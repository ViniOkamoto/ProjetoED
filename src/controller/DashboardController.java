package controller;

import model.NodeDashboard;
import view.Dashboard;

public class DashboardController {
	private NodeDashboard start;
	
	public DashboardController() {
		this.start = null;
	}
	
	public Dashboard getDashboard(int x) {
        NodeDashboard aux = this.start;
        for(int i=0; i< x; i++) {
            aux = aux.getNext();
        }
        if(aux == null) {
       	 return null;
        }
        return aux.getData();
    }
	
	public void adicionarInicio(Dashboard data) {
		NodeDashboard n = new NodeDashboard(data);
		if(this.start==null) {
			this.start = n;
		}else {
			NodeDashboard aux = this.start;
			n.setNext(aux);
			aux.setBefore(n);
			this.start = n;
		}
	}
	
	public void adicionarFinal(Dashboard data) {
		NodeDashboard n = new NodeDashboard(data);
		if(this.start == null) {
			this.start = n;
		}else {
			NodeDashboard aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(n);
			n.setBefore(aux);
		}
	}
	
	public void adicionarMeio(Dashboard data, int pos) {
		if(pos == 1) {
			adicionarInicio(data);
		}else if(pos==size(this.start)+1) {
			adicionarFinal(data);
		}else if(pos<size(this.start) && pos>0) {
			NodeDashboard n = new NodeDashboard(data);
			NodeDashboard aux = start;
			for(int i=0; i<pos-1; i++) {
				aux = aux.getNext();
			}
			NodeDashboard aux2 = aux.getBefore();
			aux2.setNext(n);
			n.setBefore(aux2);
			n.setNext(aux);
			aux.setBefore(n);
		}else {
			System.err.println("A posição é inválida");
		}
	}
	
	public void removerInicio() {
		if(this.start == null) {
			System.err.println("A lista está vazia");
		}else {
			this.start = this.start.getNext();
			if(this.start!=null) {
				this.start.setBefore(null);
			}
		}
	}
	
	public void removerFinal() {
		if(this.start==null) {
			System.err.println("A lista está vazia");
		}else if (this.start.getNext()==null){
			this.start = null;
		}else {
			NodeDashboard aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			NodeDashboard aux2 = aux.getBefore();
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
			NodeDashboard aux = this.start;
			for(int i=0; i<pos-1; i++) {
				aux = aux.getNext();
			}
			NodeDashboard aux2 = aux.getBefore();
			aux = aux.getNext();
			aux2.setNext(aux);
			aux.setBefore(aux2);
		}else {
			System.err.println("Posição é inválida");
		}
	}
	
	public String mostra() {
		String mostrar;
		StringBuffer buffer = new StringBuffer();
		if(this.start==null) {
			return "A lista está vazia";
		}else {
			buffer.append("A lista é: \n");
			NodeDashboard aux = this.start;
			while(aux!=null) {
				buffer.append(aux.getData() + ", ");
				aux = aux.getNext();
			}
			mostrar = buffer.toString();
		}
		return mostrar;
	}
	
	private int size(NodeDashboard x) {
		int r = 0;
		while(x.getNext()!=null) {
			x = x.getNext();
			r++;
		}
		return r;
	}
}
