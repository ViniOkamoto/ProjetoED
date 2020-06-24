package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
	// -------- Lot DATABASE ----------
	public void saveLot(Lot data) throws IOException {
        verifyDir();
        String path = "C:\\databasePadaria\\lot.csv";
        File file = new File(path);
        if(verifyExistsData("lot")) {
        	String save = data.getId() + ";" + data.getProduct().getId() + ";" +data.getQtIn() + ";" + data.getQtOut()  + ";"
       			 + data.getPurcasheValue() + ";" + data.getSaleValue() + ";" + data.getDateIn() + "\n";
            FileWriter writer = new FileWriter(file, true);
            PrintWriter printer = new PrintWriter(writer);
            printer.write(save);
            printer.flush();
            printer.close();
            writer.close();
        }else {
            String save = "Id;Id do Produto;Quantidade de Entrada;Quantidade de Saída;Valor de Compra;Valor de Venda;Data de Entrada\n";
            save += data.getId() + ";" + data.getProduct().getId() + ";" +data.getQtIn() + ";" + data.getQtOut()  + ";"
    			 + data.getPurcasheValue() + ";" + data.getSaleValue() + ";" + data.getDateIn() + "\n";
            FileWriter writer = new FileWriter(file);
            PrintWriter printer = new PrintWriter(writer);
            printer.write(save);
            printer.flush();
            printer.close();
            writer.close();
        }
        System.out.println("Lote salvo com sucesso!");
    }
	
	public LotController getDatasLote(LotController lotController) throws IOException, ParseException {
        verifyDir();
        int indexProduct;
        ProductController productController = this.getDatasProduct(new ProductController());
        Product product;
        Lot lot;
        DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
        String path = "C:\\databasePadaria\\lot.csv";
        File file = new File(path);
        if(verifyExistsData("lot")) {
            FileInputStream stream = new FileInputStream(file);
            InputStreamReader flow = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(flow);
            String line = reader.readLine();
            line = reader.readLine();
            while(line!=null) {
                String [] auxs = line.split(";");
                indexProduct = productController.getIndex(Integer.parseInt(auxs[1]));
                product = productController.getProduct(indexProduct);
                Date result = df.parse(auxs[6]);
                lot = new Lot(Integer.parseInt(auxs[0]), product, Integer.parseInt(auxs[2]), Integer.parseInt(auxs[3]), Double.parseDouble(auxs[4]), 
                		Double.parseDouble(auxs[5]), result);
                lotController.add(lot);
                line = reader.readLine();
            }
            reader.close();
            flow.close();
            stream.close();
        }else {
            System.err.println("Não existem cadastros!");
        }
        return lotController;
    }
	
	public void removeLot(LotController controller) throws IOException {
		if(controller.remove() != null){
			verifyDir();
		    String path = "C:\\databasePadaria\\lot.csv";
		    File file = new File(path);
		    String save = "Id;Id do Produto;Quantidade de Entrada;Quantidade de Saída;Valor de Compra;Valor de Venda;Data de Entrada\n";
	        save += prepareLot(controller);
	        FileWriter writer = new FileWriter(file);
	        PrintWriter printer = new PrintWriter(writer);
	        printer.write(save);
	        printer.flush();
	        printer.close();
	        writer.close();
	        System.out.println("Lote removido com sucesso!");
		} else {
			System.out.println("N�o existe cadastro");
		}
	}
	
	private String prepareLot(LotController controller) {
        StringBuffer buffer = new StringBuffer();
        String preparo;
        int pos = 0;
        Lot data = controller.getLot(pos);
        do {
            buffer.append(data.getId() + ";" + data.getProduct().getId() + ";" +data.getQtIn() + ";" + data.getQtOut()  + ";"
       			 + data.getPurcasheValue() + ";" + data.getSaleValue() + ";" + data.getDateIn());
            buffer.append("\n");
            pos++;
            data = controller.getLot(pos);
        }while(data!=null);
        preparo = buffer.toString();
        return preparo;
    }
	
//----------End Lot DATABSE------------
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
	
	private String prepareProduct(ProductController controller) {
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
			verifyDir();
		    String path = "C:\\databasePadaria\\product.csv";
		    File file = new File(path);
			controller.removeMiddle(indexProduct);
			if(controller.getProduct(0)==null) {
				file.delete();
			}else {
				String save = "Id;Nome;Tipo;Marca\n";
		        save += prepareProduct(controller);
		        FileWriter writer = new FileWriter(file);
		        PrintWriter printer = new PrintWriter(writer);
		        printer.write(save);
		        printer.flush();
		        printer.close();
		        writer.close();
			}
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
