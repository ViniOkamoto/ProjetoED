package model;

import javax.swing.table.AbstractTableModel;

import controller.SaleController;

public class SaleTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String [] columns = {"Código","Data","Produto","Quantidade","Total(R$)","Opções"};
	private SaleController list;
	public SaleTableModel(SaleController list) {
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
		if(list!=null)
			return list.size();
		else
			return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

}
