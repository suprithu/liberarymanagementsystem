package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.cruds.Entity.Student;
import com.mysql.cj.util.DataTypeUtil;

import Exception.LibraryException;

public class StudentDAO {

	public boolean createBook(Student student) {

		String sql = "insert into student(USN, name) values(?,?)";
	//	String sql1= "insert into bookissue(issueId,issuedDate,returnDate,bookISBN,USN) values (?,?,?,?,?)";
		
		int rows = 0;
		
		try (Connection conn = DBManager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getUSN());
			ps.setString(2, student.getName());
			rows = ps.executeUpdate();
			
					} catch (SQLException e) {
			e.printStackTrace();
			if (e.getMessage().contains("Duplicate")) {
				throw new LibraryException(student.getUSN() + "This USN Already Exists!");
			} else {
				throw new LibraryException(e.getMessage() + "ERROR!");
			}

		}

		return rows > 0;

	}
}
