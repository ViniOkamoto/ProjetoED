package model;

import javax.swing.table.AbstractTableModel;

public class DashboardTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String [] columns = {"Data","Produto","Media","Relatório"};
		
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
