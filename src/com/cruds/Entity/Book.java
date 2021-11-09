package com.cruds.Entity;

public class Book {
	private int bookISBN;
	private String booktitle;
	 private String category;
	private int noofbooks;
	Author author;
	
	public Book(int bookISBN, String booktitle, String category, int noofbooks) {
		super();
		this.bookISBN = bookISBN;
		this.booktitle = booktitle;
		this.category = category;
		this.noofbooks = noofbooks;
	}

	

	/*public Book(int bookISBN, String booktitle, String category, int noofbooks, Author author) {
		super();
		this.bookISBN = bookISBN;
		this.booktitle = booktitle;
		this.category = category;
		this.noofbooks = noofbooks;
		this.author = author;
	}*/

    

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Author getAuthor() {
		return author;
	}



	public void setAuthor(Author author) {
		this.author = author;
	}



	public int getBookISBN() {
		return bookISBN;
	}


	public void setBookISBN(int bookISBN) {
		this.bookISBN = bookISBN;
	}


	public String getBooktitle() {
		return booktitle;
	}


	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getNoofbooks() {
		return noofbooks;
	}


	public void setNoofbooks(int noofbooks) {
		this.noofbooks = noofbooks;
	}



	/*@Override*/
	public String toString() {
		
		return "BOOK ISBN:" +bookISBN + "\t" +"BOOK TITLE:" +booktitle + "\t" + "CATEGORY:" +category + "\t" + "NO OF BOOKS:" +noofbooks + "\t" + "AuthorName:" +author+ "\t";
		
	}
	void printdetails(){
		System.out.println("BOOK ISBN:" +bookISBN + "\t" +"BOOK TITLE:" +booktitle + "\t" + "CATEGORY:" +category + "\t" + "NO OF BOOKS:" +noofbooks + "\t" + "AuthorName:" +author+ "\t"    );
	}
	
	

}
