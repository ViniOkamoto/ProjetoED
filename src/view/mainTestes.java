package view;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import controller.DatabaseController;
import controller.LotController;
import controller.ProductController;
import model.Lot;
import model.Product;

public class mainTestes {

	/* public static void main(String[] args) {
	 //Teste para criação database
		LotController lotController = new LotController();
		ProductController productController = new ProductController();
		DatabaseController database = new DatabaseController();
		
		
		//Teste para leitura da database
		
		try {
			productController = database.getDatasProduct(productController);
			//Teste para criação de dados
			Product produto = new Product(4, "test", "teste", "teste");
//			productController.addAndSave(produto);
			try {
				database.getDatasLote(lotController);
				System.out.println(lotController.show());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			Lot lote = new Lot(5, produto, 3, 2, 10.00, 15.00, new Date() );
			
			database.removeLot(lotController);
			//lotController.addAndSave(lote);
			//Teste para leitura da database
			
			/*System.out.println(productController.mostrar());
			database.removeProduct(productController, 5);
			//Teste para remoção de dados
			System.out.println("------Remoção-------");
			System.out.println(productController.mostrar());
			System.out.println(lotController.show());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}*/
}
