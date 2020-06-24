package model;

import javax.swing.table.AbstractTableModel;

import controller.ProductController;

public class ProductTableModel extends AbstractTableModel {

	private ProductController list;
	private static final long serialVersionUID = 1L;
	private String [] columns = {"Código","Tipo","Nome","Marca","Opções"};
	public ProductTableModel(ProductController list) {
		this.list = list;
	}
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}
	@Override
	public int getColumnCount() {
		return this.columns.length;
	}

	@Override
	public int getRowCount() {
		if(this.list!=null) {
			return this.list.size()+1;
		}else {
			return 0;
		}
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0:return list.getProduct(rowIndex).getId();
			case 1:return list.getProduct(rowIndex).getType();
			case 2:return list.getProduct(rowIndex).getName();
			case 3:return list.getProduct(rowIndex).getBrand();
		}
		return null;
	}
	
	public void addRow() {
		this.fireTableDataChanged();
	}

}
