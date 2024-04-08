package model;

import java.util.Date;

// gốc class java ni là trong MainUI.java
// User.java ni hiện tại chỉ đang dùng để lưu trữ thông tin tạm thời, chưa có gì quá đặc sắc

public class User {
	
	public User() {
		
	}

	private int User_Id;
	private String Username;
	private String Fullname;
	private Date Birth;
	private String Email;
	private String Phone;	// phone uses String type
	private String Address;
	private String Password;
	
	private byte[] Avatar;
	
	
	
	
	
	public int getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public Date getBirth() {
		return Birth;
	}

	public void setBirth(Date birth) {
		Birth = birth;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public byte[] getAvatar() {
		return Avatar;
	}

	public void setAvatar(byte[] avatar) {
		Avatar = avatar;
	}
	
}