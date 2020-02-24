package fmi.informatics.gui;

import java.awt.Dimension;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.ArrayList;



import java.util.Collections;

import java.util.Comparator;



import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTable;





import fmi.informatics.extending.Person;

import fmi.informatics.util.FileReader;
public class People extends JFrame{
private static final long serialVersionUID = 1L;
Person[] people = FileReader.readPeople();

	ArrayList<Person> peopleList = new ArrayList<Person>();	

	public People() {

		this.setSize(600, 700);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new GridLayout(3,1));
		for (Person person : people) {

			peopleList.add(person);	

		}	

		JPanel buttonPanel = new JPanel();

		JPanel tablePanel = new JPanel();

		JButton sortLastascendingButton = new JButton("Sort Last Name (ascending)");
		JButton sortLastdescendingButton = new JButton("Sort Last Name (descending)");
		JButton sortFirstascendingButton = new JButton("Sort First Name (ascending)");
		JButton sortFirstdescendingButton = new JButton("Sort First Name (descending)");
		JButton searchFamilyButton = new JButton("Search Family Name");
		JButton firstNameCountButton = new JButton("Filter First Name");

		PersonDataModel personDataModel = new PersonDataModel(peopleList);

		JTable table = new JTable(personDataModel);		
		JScrollPane scroller = new JScrollPane(table);		
		this.add(tablePanel);
		this.add(buttonPanel);

		buttonPanel.setLayout(new GridLayout(3,1));
		buttonPanel.add(sortLastascendingButton);
		buttonPanel.add(sortLastdescendingButton);
		buttonPanel.add(sortFirstascendingButton);
		buttonPanel.add(sortFirstdescendingButton);
		buttonPanel.add(searchFamilyButton);
		buttonPanel.add(firstNameCountButton);

		scroller.setPreferredSize(new Dimension(550,200));
		tablePanel.add(scroller);

		firstNameCountButton.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {	
				Person[] people = new Person[1];
				String input = JOptionPane.showInputDialog("Enter name you wish to count:");
				 int counter = 0;
				 for(int i = 0;i<peopleList.size();i++) {
					 if(peopleList.get(i).getfName().toString().equals(input)) {
						counter++;					
					 }
				 }

				Filter filter = new Filter(people);
				 people[0].setfName(input);
				 people[0].setNameCounter(counter);
				table.setModel(filter);
				 table.repaint();			
			}
		});
	searchFamilyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				 String input = JOptionPane.showInputDialog("Enter last name you are looking for:");
				 for(int i = 0;i<peopleList.size();i++) {
					 if(!(peopleList.get(i).getlName().toString().equals(input))) {
						peopleList.remove(i); 
					 }
				 }
				 table.repaint();			
			}
		});
	sortLastascendingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(peopleList, new Comparator<Person>() {
				    @Override
				    public int compare(Person p1, Person p2) {
				        return p1.getlName().compareTo(p2.getlName());
				    }				    				    
				});							
				table.repaint();
			}
		});
	sortLastdescendingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(peopleList, new Comparator<Person>() {
				    @Override
				    public int compare(Person p1, Person p2) {
				        return p2.getlName().compareTo(p1.getlName());
				   }				    				    
				});							
				table.repaint();
			}
		});
	sortFirstascendingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(peopleList, new Comparator<Person>() {
				    @Override
				    public int compare(Person p1, Person p2) {
				        return p1.getfName().compareTo(p2.getfName());
				    }				    				    
				});							
				table.repaint();
			}
		});
	sortFirstdescendingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(peopleList, new Comparator<Person>() {
				    @Override
				    public int compare(Person p1, Person p2) {
				        return p2.getfName().compareTo(p1.getfName());
				    }				    				    
				});							
				table.repaint();
			}
		});
	this.setVisible(true);
	}//end constructor
	}//end class People