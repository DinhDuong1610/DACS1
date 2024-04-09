package data;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.*;

import javax.swing.ImageIcon;

import images.*;
import model.*;
import data.*;

public class bootup_jdbc {
	
	private Utilities Utili = new Utilities();
	private User UserObj;

	
	public bootup_jdbc(User user) {
		this.UserObj = user;
	}

	
	public void initial_User() {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dacs1_data?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
				temp.SQL_Username, temp.SQL_Userpass);

				Statement stmt = conn.createStatement();) {
			String str1 = "SELECT * FROM users WHERE User_Id = " + UserObj.getUser_Id() + " ;";
//			System.out.println("The SQL statement is: " + str1 + "\n");
			ResultSet rset1 = stmt.executeQuery(str1);

			while (rset1.next()) {
				
//				int jdbc_User_Id = rset1.getInt("User_Id");	// Login/Register already put this into User.java
				String jdbc_Name = rset1.getString("Name");
				String jdbc_Fullname = rset1.getString("Fullname");
				java.sql.Date jdbc_Birth = rset1.getDate("Birth");
				String jdbc_Email = rset1.getString("Email");
				String jdbc_Phone = rset1.getString("Phone");
				String jdbc_Address = rset1.getString("Address");
				String jdbc_Password = rset1.getString("Password");
				InputStream jdbc_Avatar = rset1.getBinaryStream("Avatar"); 
				
				
				// lấy thông tin từ User_Id bỏ lên User.java giữ tạm thời
				UserObj.setUsername(jdbc_Name);
				UserObj.setFullname(jdbc_Fullname);
				
				java.util.Date Birth = Utili.sqlDate_to_utilDate(jdbc_Birth);
				UserObj.setBirth(Birth);
				
				UserObj.setEmail(jdbc_Email);
				UserObj.setPhone(jdbc_Phone);
				UserObj.setAddress(jdbc_Address);
				UserObj.setPassword(jdbc_Password);		// :D
				
				// User.java avatar and avatar_path
				if (jdbc_Avatar != null) {
					ImageIcon imageicon = Utili.InputStream_to_ImageIcon(jdbc_Avatar);
					writeTo_imgholder(jdbc_Avatar);
					UserObj.setAvatar(imageicon);
					
					URL imgholder_url = bootup.class.getResource("/data/imgholder.txt");
		            String imgholder_path = URLDecoder.decode(imgholder_url.getPath(), StandardCharsets.UTF_8);
					UserObj.setAvatar_path(imgholder_path);
				} else {
					ImageIcon imageicon = new ImageIcon(imgGiver.class.getResource("/images/icon/default.jpeg"));
					UserObj.setAvatar(imageicon);
					
					URL imgholder_url = imgGiver.class.getResource("/images/icon/default.jpeg");
		            String imgholder_path = URLDecoder.decode(imgholder_url.getPath(), StandardCharsets.UTF_8);
					UserObj.setAvatar_path(imgholder_path);

				}
				
				
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
	public void writeTo_imgholder(InputStream is) {
		FileOutputStream fos = null;
		
		try {
			// reset the InputStream to make sure it goes from the beginning
			is.reset();
			
			URL imgholder_url = bootup.class.getResource("/data/imgholder.txt");
            String imgholder_path = URLDecoder.decode(imgholder_url.getPath(), StandardCharsets.UTF_8);
//            System.out.println(imgholder_url.getPath());
//            System.out.println(imgholder_path);
            
		    fos = new FileOutputStream(imgholder_path);
		    
		    // writing stream of raw bytes data from jdbc_Avatar to imghodler.txt
		    byte[] buffer = new byte[1024];
		    int bytesRead;
		    while ((bytesRead = is.read(buffer)) != -1) {
		        fos.write(buffer, 0, bytesRead);
		    }
		    System.out.println("Writing(tranfering) protocol completed!");
		    
		} catch (IOException e) {
			System.out.println("what happened?????");
		    e.printStackTrace();
		} finally {
		    try {
		        // close FileOutputStream
		        if (fos != null) {
		            fos.close();
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	}

	
	
}