package model;

import java.sql.*;

import data.*;

public class Register_jdbc {

	public Register_jdbc() {

	}

	public boolean Username_Check(String name) {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dacs1_data?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
				temp.SQL_Username, temp.SQL_Userpass);

				Statement stmt = conn.createStatement();) {
			String str1 = "SELECT * FROM users ;";
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
					return true;
				}

				//				System.out.println(User_Id + ", " + Username + ", " + Birth + ", " + Email + ", " + Phone + ", "
				//						+ Address + ", " + Password);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		// meaning the Username is valid and fresh!
		return false;
	}
	

	public void Create_Account(String Username, String Birth, String Email, String Phone, String Address, String Password) {

		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dacs1_data?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
				temp.SQL_Username, temp.SQL_Userpass);

				Statement stmt = conn.createStatement();) {
			String str1 = "INSERT INTO Users(Name, Birth, Email, Phone, Address, Password) VALUES"
					+ "('" + Username + "', '" + Birth + "', '" + Email + "', '" + Phone + "', '" + Address + "', '" + Password + "');";
			System.out.println("The SQL statement is: " + str1 + "\n");
			int rset1 = stmt.executeUpdate(str1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
