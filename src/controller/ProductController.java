package controller;

import java.io.IOException;

import model.NodeProduct;
import model.Product;

public class ProductController{
     private NodeProduct start;
     
     public ProductController(){
    	 this.start = null;
     }

     public Product getProduct(int x) {
         NodeProduct aux = this.start;
         for(int i=0; i< x; i++) {
             aux = aux.getNext();
         }
         if(aux == null) {
        	 return null;
         }
         return aux.getData();
     }
     
     public int getIndex(int id) {
 		NodeProduct aux = this.start;
 		boolean exist = false;
 		int pos = 1;
 		
 		if(id == aux.getData().getId()) {
 			exist = true;
 		}
 		while (aux != null && id != aux.getData().getId()  ) {
 			if(id == aux.getData().getId()) {
 	 			exist = true;
 	 		}
 			pos++;
 			aux = aux.getNext();
 		}
 		if(exist) {
 			return pos;
 		} else {
 			return 0;
 		}
 	}
   
	public void addAndSave(Product data) {
		NodeProduct n = new NodeProduct(data);
		if(this.start == null) {
			this.start = n;
		}else {
			NodeProduct aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(n);
			n.setBefore(aux);
		}
		DatabaseController database = new DatabaseController();
		try {
			database.saveProduct(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void add(Product data) {
		NodeProduct n = new NodeProduct(data);
		if(this.start == null) {
			this.start = n;
		}else {
			NodeProduct aux = this.start;
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
			NodeProduct aux = this.start;
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
		}else if(pos == size(this.start) + 1) {
			removeLast();
		}else if(pos <= size(this.start) && pos>0) {
			NodeProduct aux = this.start;
			for(int i=0; i<pos-1; i++) {
				aux = aux.getNext();
			}
			NodeProduct aux2 = aux.getBefore();
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
            NodeProduct aux = this.start;
            while(aux!=null) {
                buffer.append("Codigo: " + aux.getData().getId() + " |Nome: " 
            + aux.getData().getName() + " |Tipo: " + aux.getData().getType() + " |Marca: " + aux.getData().getBrand() + "\n");
                aux = aux.getNext();
            }
            data = buffer.toString();
            return data;
        }
    }
	
	
	/*------------------------------------------------------------------------------------*/
	
	private int size(NodeProduct n) {
		int r = 0;
		while(n.getNext()!=null) {
			n = n.getNext();
			r++;
		}
		return r;
	}
}
