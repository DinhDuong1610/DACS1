package model;

import javax.swing.JFrame;

public class Model_Methods extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static int level = 1;
	
	private static Login LoginObj = new Login();
	private static Register RegisterObj = new Register();
	
	
	public Model_Methods() {

	}
	
	
	/*
	 	Level int explaination
	 	1 == login/register successful
	 	2 == go to register
	 	3 == go to login
	 */
	public static void checking(JFrame fr) {
		if (level == 2) {
			Register_Show(fr);
		} else if (level == 3) {
			Login_Show(fr);
		}
	}
	
	
	public static void Login_Show(JFrame fr) {
		LoginObj.showCustomDialog(fr);
		checking(fr);
	}
	
	public static void Register_Show(JFrame fr) {
		RegisterObj.showCustomDialog(fr);
		checking(fr);
	}
	
}