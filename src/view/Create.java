package view;

import javax.swing.JOptionPane;

import controller.ProductController;
import model.Product;

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
	
	public void createLot() {
		
	}
	
	public void createSale() {
		
	}
}
