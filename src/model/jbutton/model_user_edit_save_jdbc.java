package model.jbutton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

import data.*;
import model.*;
import view.*;

public class model_user_edit_save_jdbc {

	private User userObj;
	private MainUI main;
	
	public model_user_edit_save_jdbc(User user, MainUI mainUI) {
		this.userObj = user;
		this.main = mainUI;
	}

	public boolean Username_Check(String name, int user_id) {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dacs1_data?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
				temp.SQL_Username, temp.SQL_Userpass);

				Statement stmt = conn.createStatement();) {
			String str1 = "SELECT Name FROM users WHERE NOT User_Id = " + user_id + " ;";
			ResultSet rset1 = stmt.executeQuery(str1);

			while (rset1.next()) {
				String Username = rset1.getString("Name");

				if (name.equals(Username)) {	// meaning this new username is already used by someone else!
					return true;
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		// meaning the Username is valid and fresh!
		return false;
	}
	

	public void Update_Account(String Username, String Fullname, String Birth, String Email, String Phone, String Address, String Password, String avatar_path, int user_id) {
	    try (Connection conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/dacs1_data?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
	            temp.SQL_Username, temp.SQL_Userpass);) {

	        String str1 = "UPDATE Users SET Name = ?, "
	                + "Fullname = ?, Birth = ?, Email = ?, Phone = ?, Address = ?, Password = ?, Avatar = ? WHERE User_Id = ?";

	        PreparedStatement stmt = conn.prepareStatement(str1);
	        stmt.setString(1, Username);
	        stmt.setString(2, Fullname);
	        stmt.setString(3, Birth);
	        stmt.setString(4, Email);
	        stmt.setString(5, Phone);
	        stmt.setString(6, Address);
	        stmt.setString(7, Password);
	        
	        // image
	    	File image = new File(avatar_path);
	    	FileInputStream fis = new FileInputStream(image);
	        stmt.setBinaryStream(8, fis, (int) image.length());
	        
	        stmt.setInt(9, user_id);
	        
	        
	        
	        int rset1 = stmt.executeUpdate();
	        
	        stmt.close();
	    } catch (SQLException | FileNotFoundException ex) {
	        ex.printStackTrace();
	    }

	}
	
	
	
}
