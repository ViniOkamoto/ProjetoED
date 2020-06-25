package model;

import javax.swing.table.AbstractTableModel;

import controller.LotController;

public class LotTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private LotController list;
	private static final long serialVersionUID = 1L;
	private String [] columns = {"Código","Produto","Entrada","Saída","Compra(R$)","Venda(R$)","Opções"};
	public LotTableModel(LotController list) {
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
		if(list!=null) {
			return list.size();
		}else {
			return 0;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0: return list.getLot(rowIndex).getId();
			case 1: return list.getLot(rowIndex).getProduct().getName();
			case 2: return list.getLot(rowIndex).getQtIn();
			case 3: return list.getLot(rowIndex).getQtOut();
			case 4: return list.getLot(rowIndex).getPurcasheValue();
			case 5: return list.getLot(rowIndex).getSaleValue();
		}
		return null;
	}
	
	public void addRow() {
		this.fireTableDataChanged();
	}

}
