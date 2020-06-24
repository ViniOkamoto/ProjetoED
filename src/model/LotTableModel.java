package model;

import javax.swing.table.AbstractTableModel;

public class LotTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String [] columns = {"C�digo","Produto","Entrada","Sa�da","Compra(R$)","Venda(R$)","Op��es"};
	
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
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

}
