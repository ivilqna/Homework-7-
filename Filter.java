package fmi.informatics.gui;

import javax.swing.table.AbstractTableModel;

import fmi.informatics.extending.Person;

public class Filter extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	Person[] people;
	// constructor

	public Filter(Person[] people) {
		this.people = people;
	}
	@Override
	public int getColumnCount() {
		return 2; 
	}
	@Override
	public int getRowCount() {
		return people.length; 
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				return people[rowIndex].getfName();
			case 1:
				return people[rowIndex].getNameCounter();
		}
		return null;
	}
	@Override

	public String getColumnName(int column) {
		switch (column) {
			case 0:
				return "Първо име";
			case 1:
				return "Брой";
			default:
				return super.getColumnName(column);
		}
	}
}