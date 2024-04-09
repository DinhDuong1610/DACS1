package model.jbutton;

import view.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.temp;
import model.*;



public class model_user_password_edit_save_jdbc {
	
	private User userObj;
	private MainUI main;
	
	public model_user_password_edit_save_jdbc(User user, MainUI mainUI) {
		
		this.userObj = user;
		this.main = mainUI;
	}
	
	public boolean Password_Check(String pass, int User_Id) {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dacs1_data?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
				temp.SQL_Username, temp.SQL_Userpass);

				Statement stmt = conn.createStatement();) {
			String str1 = "SELECT Password FROM users WHERE User_id = " + User_Id + ";";
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

		// meaning the old Password is incorrect!
		return true;
	}
	
	
	public void Update_Password(String pass, int user_id) {

		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dacs1_data?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
				temp.SQL_Username, temp.SQL_Userpass);

				Statement stmt = conn.createStatement();) {

			String str1 = "UPDATE Users SET Password = '" + pass + "' WHERE User_Id = " + user_id + " ;";
			
			int rset1 = stmt.executeUpdate(str1);

			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
	
	
	
	
	
	
}