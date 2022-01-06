package controller;

import java.io.IOException;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Lot;
import model.NodeSale;
import model.Sale;

public class SaleController {
	private NodeSale start;
	
	public SaleController() {
		this.start = null;
	}
	//Estive aqui
	   public Sale getSale(int x) {
	         NodeSale aux = this.start;
	         for(int i=0; i< x; i++) {
	             aux = aux.getNext();
	         }
	         if(aux == null) {
	        	 return null;
	         }
	         return aux.getData();
	     }
	     
	     public int getIndex(int id) {
	 		NodeSale aux = this.start;
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
	   
		public void addAndSave(Sale data) {
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
			DatabaseController database = new DatabaseController();
			try {
				database.saveSale(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void add(Sale data) {
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
				NodeSale aux = this.start;
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
				NodeSale aux = this.start;
				for(int i=0; i<pos-1; i++) {
					aux = aux.getNext();
				}
				NodeSale aux2 = aux.getBefore();
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
	            NodeSale aux = this.start;
	            while(aux!=null) {
	                buffer.append("Codigo: " + aux.getData().getId() + " |Lote: " 
	            + aux.getData().getLot().getId() + " |Quantidade Vendida: " + aux.getData().getQtOut() + " |Total: " + aux.getData().getTotal() + " |Data: " + aux.getData().getDate() + "\n");
	                aux = aux.getNext();
	            }
	            data = buffer.toString();
	            return data;
	        }
	    }
			
		public Sale getLastElement() {
			NodeSale aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			return aux.getData();
		}
		
		public void addFromView(LotController lotController,int id, int idProduct, int qtd, Date date) {
			Lot lot = lotController.getLotByProduct(idProduct);
			if(lot != null) {
				int r = lotController.editLot(lot.getId(), qtd);
				if(r==0) {
					Sale sale = new Sale(id, lot, qtd, date);
					this.addAndSave(sale);
					DatabaseController database = new DatabaseController();
					try {
						database.editLot(lotController);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Lote n�o t�m a quantidade para consumir!","Error",0);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Insira lotes primeiro!","Error",0);
			}
		}
		/*------------------------------------------------------------------------------------*/
		
		public int size() {
			NodeSale n = this.start;
			int r = 0;
			if(n!=null) {
				while(n.getNext()!=null) {
					n = n.getNext();
					r++;
				}
			}
			return r;
		}
}
