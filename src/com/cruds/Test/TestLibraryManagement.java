package com.cruds.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.cruds.Entity.Author;
import com.cruds.Entity.Book;
import com.cruds.Entity.BookIssue;
import com.cruds.Entity.Student;
import com.cruds.db.BookDAO;
import com.cruds.db.DBManager;
import com.cruds.db.StudentDAO;
import com.cruds.db.searchkey;

import Exception.LibraryException;

public class TestLibraryManagement {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		BookDAO dao = new BookDAO();
		StudentDAO  dao2= new StudentDAO();
		String choice = "";
		do {
			System.out.println("============WELCOME TO THE LIBRARY MANAGEMENT SYSTEM============");
			System.out.println(
					"1.To Add Book Details(Book ISBN,Book Title, Category, No.of Books, Authorname, Author Mail-Id)");
			System.out.println("2.To Search a Book Based on Book Title");
			System.out.println("3.To Search a Book Based on Book Category");
			System.out.println("4.To Search a Book based on Author");
			System.out.println("5.Display list of all Books along with author information");
			System.out.println("6.Issue Book to the student");
			System.out.println("7.Books Issued to the Student Based on the USN Number(Enter the USN No.)");
			System.out.println("8.Books which are to be returned for current date");
			System.out.println("6. Exit");

			choice = sc.nextLine();

			switch (choice) {
			case "1":
				System.out.println("Enter the Book ISBN");
				int isbn = sc.nextInt();
			

				System.out.println("Enter the Book Title");
				String btitle = sc.next();
				sc.nextLine();

				System.out.println("Enter the Book Category");
				String bcategory = sc.nextLine();
				// sc.nextLine();

				System.out.println("Enter the Number of Books");
				int nobooks = sc.nextInt();

				System.out.println("Enter the Author Name");
				String aname = sc.next();
				sc.nextLine();

				System.out.println("Enter the Author Mail-ID");
				String amailid = sc.nextLine();
				

				Book b = new Book(isbn, btitle, bcategory, nobooks);
				Author a = new Author(aname, amailid);
				b.setAuthor(a);
				if (dao.createBook(b)) {
					System.out.println("Book Details Entered Sucessfully!");

				}
				break;

			case "2":
				System.out.println("Enter the Book Title to search");
				String searchtitle=sc.next();
				
				     
					String sql1 = "SELECT * from book WHERE booktitle= ?";
					
					try (Connection con = DBManager.getConnection()) {

						PreparedStatement ps = con.prepareStatement(sql1);
						ps.setString(1,searchtitle);
						ResultSet rs = ps.executeQuery();
						while (rs != null && rs.next()) {
							
							System.out.print("BOOK ISBN: " + rs.getInt(1));
				            System.out.print(", BOOK TITLE: " + rs.getString("booktitle"));
				            System.out.print(", CATEGORY: " + rs.getString("category"));
				            System.out.println(", No OF BOOKS: " + rs.getInt(4));
						}
						

					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("Book Title not found");
					}
					
				
				break;

			case "3":
				System.out.println("3.The Book Search Based on Category");
				
				System.out.println("Enter the categories to search 1.Fictional 2.Literature 3.Sports 4.Entertainment");
				String category=sc.next();
				     
					String sql = "SELECT * from book WHERE category= ?";
					
					try (Connection con = DBManager.getConnection()) {

						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1,category);
						ResultSet rs = ps.executeQuery();
						while (rs != null && rs.next()) {
							
							System.out.print("BOOK ISBN: " + rs.getInt(1));
				            System.out.print(", BOOK TITLE: " + rs.getString("booktitle"));
				            System.out.print(", CATEGORY: " + rs.getString("category"));
				            System.out.println(", No OF BOOKS: " + rs.getInt(4));
						}
						

					} catch (SQLException e) {
						e.printStackTrace();
					}
					

					
				
				break;

			case "4":
				System.out.println("Enter the Author Name to search a Book by Author");
				String searchauthor = sc.next();
				String sql2 = "select book.bookISBN,book.booktitle,book.category,book.noofbooks,author.authorname,author.authormailid FROM book book,author author  where authorname like ? and book.bookISBN=author.bookISBN";

				try (Connection con = DBManager.getConnection()) {

					PreparedStatement ps1 = con.prepareStatement(sql2);
					ps1.setString(1, searchauthor);
					ResultSet rs1 = ps1.executeQuery();

					while (rs1 != null && rs1.next()) {

						System.out.print("BOOK ISBN: " + rs1.getInt("bookISBN"));
						System.out.print(", BOOK TITLE: " + rs1.getString("booktitle"));
						System.out.print(", CATEGORY: " + rs1.getString("category"));
						System.out.println(", No OF BOOKS: " + rs1.getInt("noofbooks"));
						System.out.println(" AUTHOR NAME:" + rs1.getString("authorname") + " AUTHOR MAIL_ID:  "
								+ rs1.getString("authormailid"));
					}

				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Book Title not found");
				}

				break;

			case "5":
				System.out.println("The Available Book Details");
				
				List<String> list1= dao.getAllBooks();
				
				/*int i = 0;
			    for (String value : list1) {
			        if (i < list1.size()-1) {
			            System.out.print(value + ",");
			        } else {
			            System.out.print(value);
			        }
			        i++;
			    }*/
				/*String output = "User #%d: %s - %s - %s - %s";
			    System.out.println(String.format(output, ++count, name, pass, fullname, email));
				*/
				System.out.println(list1.toString());
				/*for (String element : list1) {
				    System.out.println(element);
				   
				}*/
				 System.out.println("============================");
				/*System.out.println("BOOK_ISBN  BOOK _TITLE  CATEGORY NO_OF_BOOKS AUTHOR_NAME MAIL_ID");
				System.out.println(list1.toString());
*/
				break;
				
			case "6":
				System.out.println("The Following Book details issued to the student!");
				System.out.println("Enter the USN");
				String busn = sc.next();
				sc.nextLine();
				
				System.out.println("Enter the Student Name");
				String sname = sc.next();
				sc.nextLine();
				
				System.out.println("Enter the Book Issue ID");
				String bissueid= sc.next();
				sc.nextLine();
				
				System.out.println("Enter the Issued Date");
				String bissuedate=sc.next();
				Date date1= new SimpleDateFormat("dd/MM/yyyy").parse(bissuedate);
				System.out.println("You Entered Date is:" +bissuedate + date1);
					
				
				System.out.println("Enter the Return Date");
				String breturndate=sc.next();				
				Date date2= new SimpleDateFormat("dd/MM/yyyy").parse(breturndate);
				System.out.println("You Entered Date is:" +breturndate + date2);
				
				Student ss= new Student(busn, sname);
				BookIssue bi= new BookIssue(bissueid, date1, date2);
				
				ss.setIssue(bi);
				
				if (dao2.createBook(ss))
				 {
					System.out.println("Student Details Entered Sucessfully!");

				}
				
				break;

			case "7":
				System.out.println("Based on USN Number Book details issued!");

				break;
			case "8":
				System.out.println("Books which are returned");

				break;

			default:
				System.out.println("Entered Choice is invalid");
				break;
			}

		} while (choice.equals("4"));
		sc.close();

	}

}
