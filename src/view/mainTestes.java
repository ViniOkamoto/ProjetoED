package view;

import java.io.IOException;

import controller.DatabaseController;
import controller.ProductController;
import model.Product;

public class mainTestes {

	/*public static void main(String[] args) {
	 //Teste para criação database
		DatabaseController database = new DatabaseController();
		ProductController productController = new ProductController();
		
		try {
			productController = database.getDatasProduct(productController);
			//Teste para criação de dados
			Product produto = new Product(5, "test", "teste", "teste");
			productController.addAndSave(produto);
			//Teste para leitura da database

			System.out.println(productController.mostrar());
			database.removeProduct(productController, 5);
			//Teste para remoção de dados
			System.out.println("------Remoção-------");
			System.out.println(productController.mostrar());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
}
