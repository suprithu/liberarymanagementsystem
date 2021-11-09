package com.cruds.Entity;

public class Author {
	private String authorname;
	private String authormailid;
	private int bookISBN;
	
	
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(String authorname, String authormailid, int bookISBN) {
		super();
		this.authorname = authorname;
		this.authormailid = authormailid;
		this.bookISBN = bookISBN;
	}

	public Author(String authorname, String authormailid) {
		super();
		this.authorname = authorname;
		this.authormailid = authormailid;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getAuthormailid() {
		return authormailid;
	}

	public void setAuthormailid(String authormailid) {
		this.authormailid = authormailid;
	}
	
	

	public int getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(int bookISBN) {
		this.bookISBN = bookISBN;
	}

	@Override
	public String toString() {
		return "Author [authorname=" + authorname + ", authormailid=" + authormailid + "]";
	}
	
	
	
	
	
	
	

}
