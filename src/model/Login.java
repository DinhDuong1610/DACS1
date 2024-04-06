package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatDarkLaf;

import model.*;

public class Login extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public static JTextField tf_Username;
	public static JPasswordField pwf_Password;
	public static JButton bt_Login;
	public static JLabel lblSignUp;
	
	private static JDialog dialog;
	
	public Login() {
		
	}
	
	// TODO checking database
	private static int checking() {
		// if database checks exists username with password
		if (1 + 1 != 0) {
			// TODO transfer to temporary data holder in temp.java (data)
			return 1;
		} else {
			// if database checks doens't have username or password is not correct
			return 0;
		}
		
	}
	
	
    public void showCustomDialog(JFrame parentFrame) {
    	Model_Methods.level = 1;
    	
    	// use Flatlaf look and feel
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
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
        
        
		JLabel lb1 = new JLabel("Welcome back!");
		lb1.setFont(new Font("Roboto", Font.PLAIN, 38));
		lb1.setBounds(30, 10, 326, 48);
		dialog.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("Please sign in to access you account");
		lb2.setVerticalAlignment(SwingConstants.TOP);
		lb2.setForeground(new Color(219, 219, 219));
		lb2.setBounds(30, 54, 356, 30);
		lb2.setFont(new Font("Roboto", Font.PLAIN, 12));
		dialog.getContentPane().add(lb2);
		
		JLabel lb3 = new JLabel("Username");
		lb3.setVerticalAlignment(SwingConstants.BOTTOM);
		lb3.setHorizontalAlignment(SwingConstants.LEFT);
		lb3.setBounds(35, 81, 194, 23);
		lb3.setForeground(new Color(219, 219, 219));
		lb3.setFont(new Font("Roboto", Font.PLAIN, 14));
		dialog.getContentPane().add(lb3);
		
		tf_Username = new JTextField();
		tf_Username.setOpaque(false);
		tf_Username.setBounds(30, 105, 320, 30);
		tf_Username.setFont(new Font("Roboto", Font.PLAIN, 14));
		tf_Username.setColumns(10);
		dialog.getContentPane().add(tf_Username);
		
		JLabel lb4 = new JLabel("Password\r\n");
		lb4.setVerticalAlignment(SwingConstants.BOTTOM);
		lb4.setHorizontalAlignment(SwingConstants.LEFT);
		lb4.setFont(new Font("Dialog", Font.PLAIN, 14));
		lb4.setForeground(new Color(219, 219, 219));
		lb4.setBounds(35, 145, 194, 23);
		dialog.getContentPane().add(lb4);
		
		pwf_Password = new JPasswordField();
		pwf_Password.setOpaque(false);
		pwf_Password.setBounds(30, 169, 320, 30);
		pwf_Password.setFont(new Font("Roboto", Font.PLAIN, 14));
		dialog.getContentPane().add(pwf_Password);
		
		bt_Login = new JButton("Login\r\n");
		bt_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checking() == 0) {
					JOptionPane.showMessageDialog(null, "Please check your Username or Password!", "User not found!", JOptionPane.PLAIN_MESSAGE);
				} else {
					dialog.dispose();			
				}
			}
		});
		bt_Login.setBounds(30, 232, 320, 32);
		dialog.getContentPane().add(bt_Login);
		
		JLabel lb5 = new JLabel("Don't have an account ?");
		lb5.setBounds(85, 274, 133, 30);
		lb5.setFont(new Font("Roboto", Font.PLAIN, 12));
		dialog.getContentPane().add(lb5);
		
		lblSignUp = new JLabel("Sign up");
		lblSignUp.setForeground(new Color(4, 125, 247));
		lblSignUp.setBounds(219, 274, 55, 30);
		lblSignUp.setFont(new Font("Roboto", Font.PLAIN, 12));
		dialog.getContentPane().add(lblSignUp);
		
		
		MyMouseAdapter MouseAdapterList = new MyMouseAdapter();
		lblSignUp.addMouseListener(MouseAdapterList);
		

        // Set dialog properties
        dialog.setSize(390, 400);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
	
    
	private class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent evt) {
			Model_Methods.level = 2;
			dialog.dispose();
		}
	}
    
}