package view;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JOptionPane;

import controller.DatabaseController;
import controller.LotController;
import controller.ProductController;
import controller.SaleController;
import model.Lot;
import model.Product;
import model.Sale;

public class Create {
	public Create() {
		super();
	}
	
	public void createProduct(ProductController list) {
		Product last;
		int id;
		if(list!=null) {
			last = list.getLastElement();
			id = last.getId() + 1;
		}else {
			id = 1;
			list = new ProductController();
		}
		Product data;
		String name = JOptionPane.showInputDialog("Insira o nome do produto:");
		String type = JOptionPane.showInputDialog("Insira o tipo do produto:");
		String brand = JOptionPane.showInputDialog("Insira a marca do produto:");
		data = new Product(id, name, type, brand);
		list.addAndSave(data);
	}
	
	public void createLot(LotController list) {
		Product aux = null;
		ProductController productList = new ProductController();
		DatabaseController database = new DatabaseController();
		try {
			productList = database.getDatasProduct(productList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Lot last;
		int id;
		int idProduct = 0;
		if(list!=null) {
			last = list.getLastElement();
			id = last.getId() + 1;
		}else {
			id = 1;
			list = new LotController();
		}
		if(productList!=null) {
			Product aux2 = null;
			Lot data;
			String productIds = "";
			int index = 0;
			do {
				aux = productList.getProduct(index);
				if(aux!=null)
					productIds += "Id: " + aux.getId() + " |Nome: " + aux.getName() + "\n";
				index++;
			}while(aux!=null);
			while(aux2 == null) {
				idProduct = Integer.parseInt(JOptionPane.showInputDialog(productIds + "Insira o id do produto deste lote:"));
				int n = productList.getIndex(idProduct);
				if(n!=0) {
					aux2 = productList.getProduct(n-1);
				}else {
					JOptionPane.showMessageDialog(null, "Id do produto inválido!", "Error",0);
				}
			}
			int qtIn = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade adiquirida:"));
			int qtOut = 0;
			double purcasheValue = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor de compra (R$):"));
			double saleValue = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor de venda (R$):"));
			Date date = new Date(System.currentTimeMillis());
			data = new Lot(id, aux2,qtIn, qtOut, purcasheValue, saleValue, date);
			list.addAndSave(data);
		}else {
			JOptionPane.showMessageDialog(null, "Registre produtos primeiro!", "Error",0);
		}
	}
	
	public void createSale(SaleController list) {
		Sale last;
		Product aux;
		DatabaseController database = new DatabaseController();
		LotController lotList = new LotController();
		ProductController productList = new ProductController();
		try {
			lotList = database.getDatasLote(lotList);
			productList = database.getDatasProduct(productList);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int id;
		if(list != null) {
			last = list.getLastElement();
			id = last.getId()+1;
		}else {
			id = 1;
			list = new SaleController();
		}
		if(lotList!=null) {
			Product aux2 = null;
			int index = 0;
			int idProduct;
			String LotIds = "";
			do {
				aux = productList.getProduct(index);
				if(aux!=null)
					LotIds += "Id: " + aux.getId() + " |Nome: " + aux.getName() + "\n";
				index++;
			}while(aux!=null);
			while(aux2 == null) {
				idProduct = Integer.parseInt(JOptionPane.showInputDialog(LotIds + "Insira o id do produto:"));
				int n = productList.getIndex(idProduct);
				if(n!=0) {
					aux2 = productList.getProduct(n-1);
				}else {
					JOptionPane.showMessageDialog(null, "Id do lot inválido!", "Error",0);
				}
			}
			int qtd = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade que irá sair:"));
			Date date = new Date(System.currentTimeMillis());
			list.addFromView(lotList, id, aux2.getId(), qtd, date);
		}else {
			JOptionPane.showMessageDialog(null, "Insira lotes primeiro!","Error",0);
		}
	}
}
