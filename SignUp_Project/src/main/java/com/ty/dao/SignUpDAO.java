package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.exceptions.RSAException;
import com.ty.dto.SignUp;

public class SignUpDAO {

	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;

	public String insertSignUp(SignUp s) {

		String query = "insert into signup values(?,?,?,?,?,?,?)";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, s.getFirstName());
			pstmt.setString(2, s.getLastName());
			pstmt.setString(3, s.getEmail());
			pstmt.setString(4, s.getPassword());
			pstmt.setLong(5, s.getPhone());
			pstmt.setString(6, s.getDob());
			pstmt.setString(7, s.getGender());
			int row = pstmt.executeUpdate();
			if (row == 1) {
				return "Inserted Successfully";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Not inserted Try again Don't Give Up!!!!";
	}

	public String updateSignUp(SignUp s) {

		String query = "update signup set firstname = ?,lastname=?,password=?,phone=?,dob=?,gender=? where email=?";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, s.getFirstName());
			pstmt.setString(2, s.getLastName());
			pstmt.setString(3, s.getPassword());
			pstmt.setLong(4, s.getPhone());
			pstmt.setString(5, s.getDob());
			pstmt.setString(6, s.getGender());
			pstmt.setString(7, s.getEmail());

			int row = pstmt.executeUpdate();
			if (row == 1) {
				return "Updated Successfully";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Not Updated Try again Don't Give Up!!!!";
	}

	public String deleteSignUp(String email) {

		String query = "delete from signup where email=?";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			int row = pstmt.executeUpdate();
			if (row == 1) {
				return "Deleted Successfully";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Not Deleted Try again Don't Give Up!!!!";
	}

	public SignUp getSignUp(String email) {

		String query = "select * from signup where email = ?";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			SignUp s = new SignUp();
			while (rs.next()) {
				s.setFirstName(rs.getString(1));
				s.setLastName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setPhone(rs.getLong(5));
				s.setDob(rs.getString(6));
				s.setGender(rs.getString(7));

				return s;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public List<SignUp> getAllSignUp() {
		List<SignUp> list = new ArrayList<SignUp>();
		String query = "select * from signup";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SignUp sUp = new SignUp();

				sUp.setFirstName(rs.getString(1));
				sUp.setLastName(rs.getString(2));
				sUp.setEmail(rs.getString(3));
				sUp.setPassword(rs.getString(4));
				sUp.setPhone(rs.getLong(5));
				sUp.setDob(rs.getString(6));
				sUp.setGender(rs.getString(7));

				list.add(sUp);

			}

			return list;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public SignUp getSignUpByEmailAndPassword(String email, String password) {

		String query = "select * from signup where email=? AND password=?";

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, this.password);
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				SignUp signUp = new SignUp();
				signUp.setFirstName(resultSet.getString(1));
				signUp.setLastName(resultSet.getString(2));
				signUp.setEmail(resultSet.getString(3));
				signUp.setPassword(resultSet.getString(4));
				signUp.setPhone(resultSet.getLong(5));
				signUp.setDob(resultSet.getString(6));
				signUp.setGender(resultSet.getString(7));

				return signUp;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
