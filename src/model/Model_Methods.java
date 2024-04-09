package model;

import javax.swing.JFrame;
import java.util.*;
import java.sql.*;

public class Model_Methods extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static int level = 4;
	
	private User userObj;	// userObj inside Model_Methods.java haven't use yet.
	private Login LoginObj;
	private Register RegisterObj;
	
	
	public Model_Methods(User user) {
		this.userObj = user;
		this.LoginObj = new Login(user);
		this.RegisterObj = new Register(user);
	}
	
	
// <Login and Register>
	/*
	 	Level int explaination (for login/registering)
	 	1 == login/register successful
	 	2 == go to register
	 	3 == go to login
	 	4 == exit the app
	 */
	public void checking(JFrame fr) {
		if (level == 2) {
			Register_Show(fr);
		} else if (level == 3) {
			Login_Show(fr);
		} else if (level == 4) {
			System.exit(0);
		}
	}
	
	
	public void Login_Show(JFrame fr) {
		LoginObj.showCustomDialog(fr);
		checking(fr);
	}
	
	public void Register_Show(JFrame fr) {
		RegisterObj.showCustomDialog(fr);
		checking(fr);
	}
// <Login and Register />	
	
}