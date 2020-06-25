package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import controller.ProjectionController;

public class DashboardTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String [] columns = {"Data","Produto","Media","Relatório"};
		private ProjectionController list;
		public DashboardTableModel(ProjectionController list) {
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
			Date date = list.getProjection(rowIndex).getDate();
			String sdate = new SimpleDateFormat("dd/MM/yyyy").format(date);
			switch(columnIndex) {
				case 0:	return sdate;
				case 1:	return list.getProjection(rowIndex).getProduct().getName();
				case 2:	return list.getProjection(rowIndex).getAverage();
				case 3:	return list.getProjection(rowIndex).getReport();
			}
			return null;
		}
		
		public void addRow() {
			fireTableDataChanged();
		}
}
