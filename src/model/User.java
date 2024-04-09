package model;

import java.util.Date;

import javax.swing.ImageIcon;

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
	
	private ImageIcon Avatar;
	private String Avatar_path;
	
	
	
	
	
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

	public ImageIcon getAvatar() {
		return Avatar;
	}

	public void setAvatar(ImageIcon avatar) {
		Avatar = avatar;
	}

	public String getAvatar_path() {
		return Avatar_path;
	}

	public void setAvatar_path(String avatar_path) {
		Avatar_path = avatar_path;
	}
	
}