package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import model.Lot;
import model.Product;

public class DatabaseController {
	
	public DatabaseController() {
	}

	public void verifyDir() throws IOException {
        String path = "C:\\databasePadaria";
        File dir = new File(path);
        if(!dir.exists() || !dir.isDirectory()) {
            if(dir.mkdir()) {
                System.out.println("Diret�rio databasePadaria criado com sucesso!");
            }else {
                System.err.println("Error!");
            }
        }
    }
	
	public void saveLot(Lot data) throws IOException {
        verifyDir();
        String path = "C:\\databasePadaria\\lot.csv";
        File file = new File(path);
        if(verifyExistsData("lot")) {
        	String save = data.getId() + ";" + data.getProduct().getId() + ";" + data.getPurcasheValue() + ";" + data.getSaleValue() + ";"
       			 		+ data.getQtIn() + ";" + data.getQtOut() + ";" + data.getDateIn() + "\n"; 
            FileWriter writer = new FileWriter(file, true);
            PrintWriter printer = new PrintWriter(writer);
            printer.write(save);
            printer.flush();
            printer.close();
            writer.close();
        }else {
            String save = "Id;Id do Produto;Valor de Compra;Valor de Venda;Quantidade de Entrada;Quantidade de Saída;Data de Entrada\n";
            save += data.getId() + ";" + data.getProduct().getId() + ";" + data.getPurcasheValue() + ";" + data.getSaleValue() + ";"
    			 + data.getQtIn() + ";" + data.getQtOut() + ";" + data.getDateIn() + "\n";
            FileWriter writer = new FileWriter(file);
            PrintWriter printer = new PrintWriter(writer);
            printer.write(save);
            printer.flush();
            printer.close();
            writer.close();
        }
        System.out.println("Lote salvo com sucesso!");
    }
	

    // ------------- Product DATABASE --------
	public void saveProduct(Product data) throws IOException {
        verifyDir();
        String path = "C:\\databasePadaria\\product.csv";
        File file = new File(path);
        if(verifyExistsData("product")) {
        	String save = data.getId() + ";" + data.getName() + ";" + data.getType() + ";" + data.getBrand() + "\n"; 
            FileWriter writer = new FileWriter(file, true);
            PrintWriter printer = new PrintWriter(writer);
            printer.write(save);
            printer.flush();
            printer.close();
            writer.close();
        } else {
            String save = "Id;Nome;Tipo;Marca\n";
            save += data.getId() + ";" + data.getName() + ";" + data.getType() + ";" + data.getBrand()+ "\n";
            FileWriter writer = new FileWriter(file);
            PrintWriter printer = new PrintWriter(writer);
            printer.write(save);
            printer.flush();
            printer.close();
            writer.close();
        }
        System.out.println("Produto salvo com sucesso!");
    }
	
	public ProductController getDatasProduct(ProductController productController) throws IOException {
        verifyDir();
        Product product;
        String path = "C:\\databasePadaria\\product.csv";
        File file = new File(path);
        if(verifyExistsData("product")) {
            FileInputStream stream = new FileInputStream(file);
            InputStreamReader flow = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(flow);
            String line = reader.readLine();
            line = reader.readLine();
            while(line!=null) {
                String [] auxs = line.split(";");
                product = new Product(Integer.parseInt(auxs[0]), auxs[1], auxs[2], auxs[3]);
                productController.add(product);
                line = reader.readLine();
            }
            reader.close();
            flow.close();
            stream.close();
            return productController;
        }else {
            System.err.println("Não existem cadastros!");
            return null;
        }
    }
	
	private String preparar (ProductController controller) {
        StringBuffer buffer = new StringBuffer();
        String preparo;
        int pos = 0;
        Product data = controller.getProduct(pos);
        do {
            buffer.append(data.getId() + ";" + data.getName() + ";" + data.getType() + ";" + data.getBrand());
            buffer.append("\n");
            pos++;
            data = controller.getProduct(pos);
        }while(data!=null);
        preparo = buffer.toString();
        return preparo;
    }
	
	public void removeProduct(ProductController controller, int id) throws IOException {
		int indexProduct = controller.getIndex(id);
		if(indexProduct != 0) {
			controller.removeMiddle(indexProduct);
			verifyDir();
		    String path = "C:\\databasePadaria\\product.csv";
		    File file = new File(path);
		    String save = "Id;Nome;Tipo;Marca\n";
	        save += preparar(controller);
	        FileWriter writer = new FileWriter(file);
	        PrintWriter printer = new PrintWriter(writer);
	        printer.write(save);
	        printer.flush();
	        printer.close();
	        writer.close();
	        System.out.println("Produto removido com sucesso!");
		} else {
			System.out.println("Produto não encontrado");
		}
	}
// ------------ End Product Database --------------	
	
	public boolean verifyExistsData(String db) throws IOException {
        String path = "C:\\databasePadaria\\" + db + ".csv";
        File file = new File(path);
        return file.exists();
    }
}
