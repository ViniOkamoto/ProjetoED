package controller;

import java.io.IOException;

import model.NodeProjection;
import model.Projection;

public class ProjectionController {
	private NodeProjection start;
	
	public ProjectionController() {
		this.start = null;
	}
	
  public Projection getProjection(int x) {
	         NodeProjection aux = this.start;
	         for(int i=0; i< x; i++) {
	             aux = aux.getNext();
	         }
	         if(aux == null) {
	        	 return null;
	         }
	         return aux.getData();
	     }
	     
	     public int getIndex(int id) {
	 		NodeProjection aux = this.start;
	 		boolean exist = false;
	 		int pos = 1;
	 		
	 		if(id == aux.getData().getId()) {
	 			exist = true;
	 		}
	 		while (aux != null && id != aux.getData().getId()  ) {
	 			aux = aux.getNext();
	 			if(id == aux.getData().getId()) {
	 	 			exist = true;
	 	 		}
	 			pos++;
	 		}
	 		if(exist) {
	 			return pos;
	 		} else {
	 			return 0;
	 		}
	 	}
	   
		public void addAndSave(Projection data) {
			NodeProjection n = new NodeProjection(data);
			if(this.start == null) {
				this.start = n;
			}else {
				NodeProjection aux = this.start;
				while(aux.getNext()!=null) {
					aux = aux.getNext();
				}
				aux.setNext(n);
				n.setBefore(aux);
			}
			DatabaseController database = new DatabaseController();
			try {
				database.saveProjection(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void add(Projection data) {
			NodeProjection n = new NodeProjection(data);
			if(this.start == null) {
				this.start = n;
			}else {
				NodeProjection aux = this.start;
				while(aux.getNext()!=null) {
					aux = aux.getNext();
				}
				aux.setNext(n);
				n.setBefore(aux);
			}
		}

		
		public void removeStart() {
			if(this.start==null) {
				System.err.println("A lista está vazia");
			}else {
				this.start = this.start.getNext();
				if(this.start!=null) {
					this.start.setBefore(null);
				}
			}
		}
		
		public void removeLast() {
			if(this.start==null) {
				System.err.println("A lista está vazia");
			}else if(this.start.getNext()==null){
				this.start = null;
			}else {
				NodeProjection aux = this.start;
				while(aux.getNext()!=null) {
					aux = aux.getNext();
				}
				aux = aux.getBefore();
				aux.setNext(null);
			}
		}
		
		public void removeMiddle(int pos) {
			if(pos==1) {
				removeStart();
			}else if(pos == size() + 1) {
				removeLast();
			}else if(pos <= size() && pos>0) {
				NodeProjection aux = this.start;
				for(int i=0; i<pos-1; i++) {
					aux = aux.getNext();
				}
				NodeProjection aux2 = aux.getBefore();
				aux = aux.getNext();
				aux2.setNext(aux);
				aux.setBefore(aux2);
			}else {
				System.err.println("Posição inválida :/");
			}
		}
		
		public String show() {
	        if(this.start == null) {
	            return null;
	        }else {
	            String data;
	            StringBuffer buffer = new StringBuffer();
	            NodeProjection aux = this.start;
	            while(aux!=null) {
	                buffer.append("Codigo: " + aux.getData().getId() + " |Id Produto: " 
	            + aux.getData().getId() + " |M�dia: " + aux.getData().getAverage() + " |Mensagem: " + aux.getData().getReport() + " |Data: " + aux.getData().getDate() + "\n");
	                aux = aux.getNext();
	            }
	            data = buffer.toString();
	            return data;
	        }
	    }
			
		public Projection getLastElement() {
			NodeProjection aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			return aux.getData();
		}
		/*------------------------------------------------------------------------------------*/
		
		public int size() {
			NodeProjection n = this.start;
			int r = 0;
			if(n!=null) {
				while(n.getNext()!=null) {
					n = n.getNext();
					r++;
				}
			}
			return r;
		}
		
		/*----------------------------------------------------------------------------*/
		public void sort() {
			quickSort(0, size());
		}
		
		private void quickSort(int start, int end) {
			if(start<end) {
				int pivo= partition(start, end);
				quickSort(start, pivo-1);
				quickSort(pivo+1, end);
			}
		}
		
		private int partition(int start, int end) {
			int i = start;
			for(int j=start; j<end; j++) {
				if(find(j).getData().getAverage()<=find(end).getData().getAverage()) {
					trocar(i++, j);
				}
			}
			trocar(i, end);
			return i;
		}
		
		private NodeProjection find(int pos) {
			NodeProjection aux = this.start;
			for(int i=0; i<pos; i++) {
				aux = aux.getNext();
			}
			return aux;
		}
		
		private void trocar(int i, int j) {
			NodeProjection auxi = find(i);
			Projection alunoi = auxi.getData();
			NodeProjection auxj = find(j);
			Projection alunoj = auxj.getData();
			auxi.setData(alunoj);
			auxj.setData(alunoi);
		}
}
