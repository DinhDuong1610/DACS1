package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.temp;

public class Login_jdbc {
	
	public Login_jdbc() {
		
	}
	
	
	public boolean Username_Check(String name) {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dacs1_data?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
				temp.SQL_Username, temp.SQL_Userpass);

				Statement stmt = conn.createStatement();) {
			String str1 = "SELECT Name FROM users ;";
			//			System.out.println("The SQL statement is: " + str1 + "\n");
			ResultSet rset1 = stmt.executeQuery(str1);

			while (rset1.next()) {
//				int User_Id = rset1.getInt("User_Id");
				String Username = rset1.getString("Name");
//				Date Birth = rset1.getDate("Birth");
//				String Email = rset1.getString("Email");
//				String Phone = rset1.getString("Phone");
//				String Address = rset1.getString("Address");
//				String Password = rset1.getString("Password");

				if (name.equals(Username)) {
					return false;
				}

				//				System.out.println(User_Id + ", " + Username + ", " + Birth + ", " + Email + ", " + Phone + ", "
				//						+ Address + ", " + Password);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		// meaning the Username is not exists in database!
		return true;
	}
	
	
	public boolean Password_Check(String name, String pass) {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dacs1_data?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
				temp.SQL_Username, temp.SQL_Userpass);

				Statement stmt = conn.createStatement();) {
			String str1 = "SELECT Password FROM users WHERE Name = '" + name + "' ;";
			//			System.out.println("The SQL statement is: " + str1 + "\n");
			ResultSet rset1 = stmt.executeQuery(str1);

			while (rset1.next()) {
//				int User_Id = rset1.getInt("User_Id");
//				String Username = rset1.getString("Name");
//				Date Birth = rset1.getDate("Birth");
//				String Email = rset1.getString("Email");
//				String Phone = rset1.getString("Phone");
//				String Address = rset1.getString("Address");
				String Password = rset1.getString("Password");

				if (pass.equals(Password)) {
					return false;
				}

				//				System.out.println(User_Id + ", " + Username + ", " + Birth + ", " + Email + ", " + Phone + ", "
				//						+ Address + ", " + Password);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		// meaning the Password is incorrect for that Username
		return true;
	}
}