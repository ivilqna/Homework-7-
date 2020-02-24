package fmi.informatics.extending;

import java.util.concurrent.ThreadLocalRandom;

public class Person {

	private String fName;
	private String sName;
	private String lName;
	private int nameCounter;
	public Person(String fName, String sName, String lName) {
		super();
		this.fName = fName;
		this.sName = sName;
		this.lName = lName;
	}
	public Person(String firstName, int nameCounter, String fName) {
		this.fName = fName;
		this.nameCounter = nameCounter;
	}
	public int getNameCounter() {
		return nameCounter;
	}
	public void setNameCounter(int nameCounter) {
		this.nameCounter = nameCounter;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
	this.sName = sName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public static class StudentGenerator {
		private static String[] fNames = { "Ivan", "Mariya", "Stoyan", "Petyr", "Petya" };
		private static String[] sNames = { "Ivanov", "Hristova", "Petrov", "Kirilov", "Yordanova" };
		private static String[] lNames = { "Petrov", "Ivanova", "Petrov", "Korchev", "Petrova" };
		public static Person make() {
			int arrayIndex = ThreadLocalRandom.current().nextInt(0, fNames.length);
			String fname = fNames[arrayIndex];
			String sname = sNames[arrayIndex];
			String lname = lNames[arrayIndex];
			return new Person(fname, sname, lname);
		}
	}
}