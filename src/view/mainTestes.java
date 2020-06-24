package view;

import java.io.IOException;

import controller.DatabaseController;
import controller.LotController;
import controller.ProductController;
import model.Lot;
import model.Product;

public class mainTestes {

	public static void main(String[] args) {
	 //Teste para criação database
		LotController lotController = new LotController();
		ProductController productController = new ProductController();
		
		Product produto = new Product(3, "test", "teste", "teste");
		Lot lote = new Lot(3, produto, 3, 2, 10.00, 15.00 );
		lotController.addAndSave(lote);
		//Teste para leitura da database
		/*DatabaseController database = new DatabaseController();
		try {
			productController = database.getDatasProduct(productController);
			System.out.println(productController.mostrar());
		} catch (IOException e) {
			e.printStackTrace();
		}
	*/
	}
}
