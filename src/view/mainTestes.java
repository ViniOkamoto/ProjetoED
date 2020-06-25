package view;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import controller.DatabaseController;
import controller.LotController;
import controller.ProductController;
import controller.ProjectionController;
import controller.SaleController;
import model.Lot;
import model.Product;
import model.Projection;
import model.Sale;

public class mainTestes {

//	public static void main(String[] args) {
//	 //Teste para criação database
//		LotController lotController = new LotController();
//		ProductController productController = new ProductController();
//		DatabaseController database = new DatabaseController();
//		SaleController saleController = new SaleController();
//		ProjectionController projectionController = new ProjectionController();
//		
//		
//		try {
//			//Le a database do produto
//			productController = database.getDatasProduct(productController);
//			//cria produto
//			if(productController == null) {
//				productController = new ProductController();
//			}
//			Product produto = new Product(1, "Produto", "alimento", "Qualquer");
//			productController.addAndSave(produto);
//			try {
//			//Le a database do lot	
//				lotController = database.getDatasLote(lotController);
//				if(lotController == null) {
//					lotController = new LotController();
//					}
//				System.out.println(lotController.show());
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			
//			//Adiciona o Lote
//			Lot lote = new Lot(1, produto, 10, 0, 10.00, 15.00, new Date() );
//			lotController.addAndSave(lote);
//			
//			//Le a database do sale
//			 try {
//				database.getDatasSale(saleController);
//				System.out.println(lotController.show());
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			 //Adiciona a venda
//			 Sale sale = new Sale(1, lote, 5, new Date());
//			 saleController.addAndSave(sale);
//			 // Le a database do projection
//			try {
//				projectionController = database.getDatasProjection(projectionController);
//				if(projectionController == null) {
//					projectionController = new ProjectionController();
//				}
//				System.out.println(projectionController.show());
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			//Adiciona o projection
//			Projection projection = new Projection(1, produto, 6.0, "cagou", new Date() );
//			 projectionController.addAndSave(projection);
//			//Teste para leitura da database ap�s adicionar
//			System.out.println( "Table Product" + "\n" + productController.show());
//			System.out.println("Table Lot" + "\n" + lotController.show());
//			System.out.println("Table Sale" + "\n" + saleController.show());
//			System.out.println("Table Projection" + "\n" + projectionController.show());
//			//Teste para remoção de dados
//			System.out.println("------Remoção-------");
////			database.removeLot(lotController);
////			database.removeProduct(productController, 5);
////			
//			System.out.println(productController.show());
//			System.out.println(lotController.show());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
