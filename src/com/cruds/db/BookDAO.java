package com.cruds.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.Entity.Book;

import Exception.LibraryException;

public class BookDAO {

	//searchkey ss= new searchkey(null);
	public boolean createBook(Book book) {

		String sql = "insert into book(bookISBN, booktitle, category, noofbooks) values(?,?,?,?)";
		String sql1 = "insert into author(authorname, authormailid, bookISBN) values(?,?,?)";
		int rows = 0;
		int auth_rows = 0;
		try (Connection conn = DBManager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getBookISBN());
			ps.setString(2, book.getBooktitle());
			ps.setString(3, book.getCategory());
			ps.setInt(4, book.getNoofbooks());
			rows = ps.executeUpdate();

			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1 = conn.prepareStatement(sql1);
			ps1.setString(1, book.getAuthor().getAuthorname());
			ps1.setString(2, book.getAuthor().getAuthormailid());
			ps1.setInt(3, book.getBookISBN());
			auth_rows = ps1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getMessage().contains("Duplicate")) {
				throw new LibraryException(book.getBookISBN() + " already exists!");
			} else {
				throw new LibraryException(e.getMessage() + "ERROR!");
			}

		}

		return rows > 0 && auth_rows > 0;

	}

	public List<String> getAllBooks() {

		String sql = "SELECT book.bookISBN, book.booktitle, book.category, book.noofbooks, author.authorname, author.authormailid FROM book INNER JOIN author ON book.bookISBN=author.bookISBN";
		List<String> list = new ArrayList<>();
		List<String> fdisplay = new ArrayList<>();
		try (Connection con = DBManager.getConnection()) {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs != null && rs.next()) {
				list = new ArrayList<>();
				list.add(String.valueOf(rs.getInt(1)));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(String.valueOf(rs.getInt(4)));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
				fdisplay.addAll(list);

				/*
				 * int bisbn= rs.getInt("bookISBN"); String btitle=
				 * rs.getString("booktitle"); String Cat=
				 * rs.getString("category"); int no= rs.getInt("noofbooks");
				 * String auname=rs.getString("authorname"); String
				 * aumail=rs.getString("authormailid"); System.out.println();
				 */
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fdisplay;

	}
	
	
	

	


}
