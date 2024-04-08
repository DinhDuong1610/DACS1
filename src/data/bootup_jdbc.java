package data;

import java.sql.*;

import model.*;

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
			
//				Blob jdbc_Avatar = rset1.getBlob("Avatar");
				
				
				// lấy thông tin từ User_Id bỏ lên User.java giữ tạm thời
				UserObj.setUsername(jdbc_Name);
				UserObj.setFullname(jdbc_Fullname);
				
				java.util.Date Birth = Utili.sqlDate_to_utilDate(jdbc_Birth);
				UserObj.setBirth(Birth);
				
				UserObj.setEmail(jdbc_Email);
				UserObj.setPhone(jdbc_Phone);
				UserObj.setAddress(jdbc_Address);
				UserObj.setPassword(jdbc_Password);		// :D
				
//				UserObj.setAvatar();
				
				
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}