package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import model.Product;

public class DatabaseController {
	
	public DatabaseController() {
	}

	public void verifyDir() throws IOException {
        String path = "C:\\databasePadaria";
        File dir = new File(path);
        if(!dir.exists() || !dir.isDirectory()) {
            if(dir.mkdir()) {
                System.out.println("Diretório Temp criado com sucesso!");
            }else {
                System.err.println("Error!");
            }
        }
    }
	
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
        }else {
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
        }else {
            System.err.println("Não existem cadastros!");
        }
        return productController;
    }
	
	public boolean verifyExistsData(String db) throws IOException {
        String path = "C:\\databasePadaria\\" + db + ".csv";
        File file = new File(path);
        return file.exists();
    }
}
