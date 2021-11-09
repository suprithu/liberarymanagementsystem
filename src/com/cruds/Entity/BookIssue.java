package com.cruds.Entity;

import java.util.Date;

public class BookIssue {
	
	private String issueId;
	private Date issuedDate;
	private Date returnDate;
	private int bookISBN;
	private String USN;
	



	public BookIssue() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public BookIssue(String issueId, Date issuedDate, Date returnDate) {
		super();
		this.issueId = issueId;
		this.issuedDate = issuedDate;
		this.returnDate = returnDate;
	}



	public int getBookISBN() {
		return bookISBN;
	}



	public void setBookISBN(int bookISBN) {
		this.bookISBN = bookISBN;
	}



	public String getUSN() {
		return USN;
	}



	public void setUSN(String uSN) {
		USN = uSN;
	}



	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", issuedDate=" + issuedDate + ", returnDate=" + returnDate + "]";
	}
	
	

}
