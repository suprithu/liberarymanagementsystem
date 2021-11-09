package com.cruds.Entity;

public class Student {

	private String USN;
	private String name;
	BookIssue issue;
	
	/*public Student(String uSN, String name, BookIssue issue) {
		super();
		USN = uSN;
		this.name = name;
		this.issue = issue;
	}*/
	
	

	


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}






	public Student(String uSN, String name) {
		super();
		USN = uSN;
		this.name = name;
	}






	public String getUSN() {
		return USN;
	}

	public void setUSN(String uSN) {
		USN = uSN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BookIssue getIssue() {
		return issue;
	}

	public void setIssue(BookIssue issue) {
		this.issue = issue;
	}

	@Override
	public String toString() {
		return "Student [USN=" + USN + ", name=" + name + ", issue=" + issue + "]";
	}
	
	
}
