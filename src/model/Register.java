package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.json.ParseException;

import model.*;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;

	private static Register_jdbc Register_jdbcObj = new Register_jdbc();
	
	private static JLabel lb_Login;
	private static JDialog dialog;

	public static JTextField tf_Username_regis;
	public static JPasswordField pwf_Password_regis;
	public static JFormattedTextField ftf_Birthday;
	public static JTextField tf_Email_regis;
	public static JTextField tf_Phone_regis;
	public static JTextArea ta_Address_regis;
	public static JLabel lblSignUp;

	public Register() {

	}

	
	private static void checking_Regis() {
		String textcheck;
		
		// checking if Username is blank
		if ((textcheck = tf_Username_regis.getText()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "Your Username cannot be blank!",
					"Warning", JOptionPane.ERROR_MESSAGE);
			return;
			
		// checking if Password is blank
		} else if ((textcheck = new String(pwf_Password_regis.getPassword())).isEmpty()) {
			JOptionPane.showMessageDialog(null, "Your Password cannot be blank!",
					"Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// checking if the date format is allowed for database
		try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false); // Disable lenient parsing
	        dateFormat.parse(ftf_Birthday.getText());
		} catch (java.text.ParseException ex) {
			JOptionPane.showMessageDialog(null, "Invalid date format. Please enter date in YYYY-MM-DD format.",
					"Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// checking if Username is already used
		if (Register_jdbcObj.Username_Check(tf_Username_regis.getText())) {
			JOptionPane.showMessageDialog(null, "This Username is already used!",
					"Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		// if all above conditions all approved then proceed to create new account
		String Username = tf_Username_regis.getText();
		String Birth = ftf_Birthday.getText();
		String Email = tf_Email_regis.getText();
		String Phone = tf_Phone_regis.getText();
		String Address = ta_Address_regis.getText();
		String Password = new String(pwf_Password_regis.getPassword());
		
		Register_jdbcObj.Create_Account(Username, Birth, Email, Phone, Address, Password);
		
		Model_Methods.level = 1;
		dialog.dispose();
	}
	

	public void showCustomDialog(JFrame parentFrame) {
		Model_Methods.level = 4;

		// use Flatlaf look and feel
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		dialog = new JDialog(parentFrame, "", true);
		dialog.setLayout(null);

		// Set FlatDarkLaf properties for this dialog
		UIDefaults defaults = new UIDefaults();
		defaults.put("Panel.background", Color.DARK_GRAY); // Example: Set panel background color to dark gray
		dialog.getRootPane().putClientProperty("JDialog.windowDecoration", Boolean.FALSE); // Disable window decorations
		dialog.getRootPane().putClientProperty("Nimbus.Overrides", defaults);

		JLabel lb1 = new JLabel("Register your account.");
		lb1.setFont(new Font("Roboto", Font.PLAIN, 38));
		lb1.setBounds(30, 10, 482, 48);
		dialog.getContentPane().add(lb1);

		JLabel lb2 = new JLabel("Make sure to remeber your password !");
		lb2.setVerticalAlignment(SwingConstants.TOP);
		lb2.setForeground(new Color(0, 0, 0));
		lb2.setBounds(30, 54, 356, 30);
		lb2.setFont(new Font("Roboto", Font.PLAIN, 12));
		dialog.getContentPane().add(lb2);

		JButton bt_Login = new JButton("Create my account!");
		bt_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checking_Regis();
			}
		});
		bt_Login.setBounds(333, 505, 320, 32);
		dialog.getContentPane().add(bt_Login);

		JLabel lb9 = new JLabel("Already have an account ?");
		lb9.setBounds(383, 547, 146, 30);
		lb9.setFont(new Font("Roboto", Font.PLAIN, 12));
		dialog.getContentPane().add(lb9);

		lb_Login = new JLabel("Back to login");
		lb_Login.setForeground(new Color(4, 125, 247));
		lb_Login.setBounds(530, 547, 102, 30);
		lb_Login.setFont(new Font("Roboto", Font.PLAIN, 12));
		dialog.getContentPane().add(lb_Login);

		JPanel pad1 = new JPanel();
		pad1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Main information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pad1.setBounds(10, 79, 966, 172);
		dialog.getContentPane().add(pad1);
		pad1.setLayout(null);

		JLabel lb3_regis = new JLabel("Username");
		lb3_regis.setBounds(25, 25, 194, 23);
		pad1.add(lb3_regis);
		lb3_regis.setVerticalAlignment(SwingConstants.BOTTOM);
		lb3_regis.setHorizontalAlignment(SwingConstants.LEFT);
		lb3_regis.setForeground(new Color(0, 0, 0));
		lb3_regis.setFont(new Font("Roboto", Font.PLAIN, 14));

		tf_Username_regis = new JTextField();
		tf_Username_regis.setBounds(20, 49, 320, 30);
		pad1.add(tf_Username_regis);
		tf_Username_regis.setOpaque(false);
		tf_Username_regis.setFont(new Font("Roboto", Font.PLAIN, 14));
		tf_Username_regis.setColumns(10);

		JLabel lb4_regis = new JLabel("Password\r\n");
		lb4_regis.setBounds(25, 89, 194, 23);
		pad1.add(lb4_regis);
		lb4_regis.setVerticalAlignment(SwingConstants.BOTTOM);
		lb4_regis.setHorizontalAlignment(SwingConstants.LEFT);
		lb4_regis.setFont(new Font("Dialog", Font.PLAIN, 14));
		lb4_regis.setForeground(new Color(0, 0, 0));

		pwf_Password_regis = new JPasswordField();
		pwf_Password_regis.setBounds(20, 113, 320, 30);
		pad1.add(pwf_Password_regis);
		pwf_Password_regis.setOpaque(false);
		pwf_Password_regis.setFont(new Font("Roboto", Font.PLAIN, 14));

		JPanel pad2 = new JPanel();
		pad2.setBorder(new TitledBorder(null, "Side information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pad2.setBounds(10, 261, 966, 234);
		pad2.setLayout(null);
		dialog.getContentPane().add(pad2);

		JLabel lb_5_regis = new JLabel("Email");
		lb_5_regis.setVerticalAlignment(SwingConstants.BOTTOM);
		lb_5_regis.setHorizontalAlignment(SwingConstants.LEFT);
		lb_5_regis.setForeground(Color.BLACK);
		lb_5_regis.setFont(new Font("Dialog", Font.PLAIN, 14));
		lb_5_regis.setBounds(26, 28, 194, 23);
		pad2.add(lb_5_regis);

		tf_Email_regis = new JTextField();
		tf_Email_regis.setOpaque(false);
		tf_Email_regis.setFont(new Font("Dialog", Font.PLAIN, 14));
		tf_Email_regis.setColumns(10);
		tf_Email_regis.setBounds(21, 52, 270, 30);
		pad2.add(tf_Email_regis);

		JLabel lb_6_regis = new JLabel("Phone number");
		lb_6_regis.setVerticalAlignment(SwingConstants.BOTTOM);
		lb_6_regis.setHorizontalAlignment(SwingConstants.LEFT);
		lb_6_regis.setForeground(Color.BLACK);
		lb_6_regis.setFont(new Font("Dialog", Font.PLAIN, 14));
		lb_6_regis.setBounds(348, 28, 194, 23);
		pad2.add(lb_6_regis);

		tf_Phone_regis = new JTextField();
		tf_Phone_regis.setOpaque(false);
		tf_Phone_regis.setFont(new Font("Dialog", Font.PLAIN, 14));
		tf_Phone_regis.setColumns(10);
		tf_Phone_regis.setBounds(343, 52, 270, 30);
		pad2.add(tf_Phone_regis);

		JLabel lb_7_regis = new JLabel("Birthday (yyyy-mm-dd)");
		lb_7_regis.setVerticalAlignment(SwingConstants.BOTTOM);
		lb_7_regis.setHorizontalAlignment(SwingConstants.LEFT);
		lb_7_regis.setForeground(Color.BLACK);
		lb_7_regis.setFont(new Font("Dialog", Font.PLAIN, 14));
		lb_7_regis.setBounds(674, 28, 194, 23);
		pad2.add(lb_7_regis);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		ftf_Birthday = new JFormattedTextField(dateFormat);
		ftf_Birthday.setOpaque(false);
		ftf_Birthday.setFont(new Font("Dialog", Font.PLAIN, 14));
		ftf_Birthday.setColumns(10);
		ftf_Birthday.setBounds(669, 52, 270, 30);
		pad2.add(ftf_Birthday);

		JLabel lb_8_regis = new JLabel("Address");
		lb_8_regis.setVerticalAlignment(SwingConstants.BOTTOM);
		lb_8_regis.setHorizontalAlignment(SwingConstants.LEFT);
		lb_8_regis.setForeground(Color.BLACK);
		lb_8_regis.setFont(new Font("Dialog", Font.PLAIN, 14));
		lb_8_regis.setBounds(26, 108, 194, 23);
		pad2.add(lb_8_regis);

		ta_Address_regis = new JTextArea();
		ta_Address_regis.setBackground(new Color(234, 234, 234));
		ta_Address_regis.setWrapStyleWord(true);
		ta_Address_regis.setLineWrap(true);
		ta_Address_regis.setBounds(26, 131, 913, 75);
		pad2.add(ta_Address_regis);

		MyMouseAdapter MouseAdapterList = new MyMouseAdapter();
		lb_Login.addMouseListener(MouseAdapterList);

		// Set dialog properties
		dialog.setSize(1000, 700);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}

	private class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent evt) {
			Model_Methods.level = 3;
			dialog.dispose();
		}
	}

}