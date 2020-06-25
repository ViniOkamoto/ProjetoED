package model;

import java.text.SimpleDateFormat;
import java.util.Date;

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
			return list.size()+1;
		else
			return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Date date = list.getSale(rowIndex).getDate();
		String sdate = new SimpleDateFormat("dd/MM/yyyy").format(date);
		switch(columnIndex) {
			case 0: return list.getSale(rowIndex).getId();
			case 1:	return sdate;
			case 2:	return list.getSale(rowIndex).getLot().getProduct().getName();
			case 3:	return list.getSale(rowIndex).getQtOut();
			case 4:	return list.getSale(rowIndex).getTotal();
		}
		return null;
	}
	
	public void addRow() {
		fireTableDataChanged();
	}

}
