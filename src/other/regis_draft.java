package other;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.util.FontUtils;

import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;

public class regis_draft extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {				
					FlatRobotoFont.install();
					UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 15));
					
					FlatIntelliJLaf.setup();
					
					regis_draft frame = new regis_draft();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public regis_draft() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb1 = new JLabel("Register your account.");
		lb1.setFont(new Font("Roboto", Font.PLAIN, 38));
		lb1.setBounds(30, 10, 482, 48);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("Make sure to remeber your password !");
		lb2.setVerticalAlignment(SwingConstants.TOP);
		lb2.setForeground(new Color(0, 0, 0));
		lb2.setBounds(30, 54, 356, 30);
		lb2.setFont(new Font("Roboto", Font.PLAIN, 12));
		contentPane.add(lb2);
		
		JButton bt_Login = new JButton("Login\r\n");
		bt_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		bt_Login.setBounds(333, 505, 320, 32);
		contentPane.add(bt_Login);
		
		JLabel lb9 = new JLabel("Already have an account ?");
		lb9.setBounds(383, 547, 146, 30);
		lb9.setFont(new Font("Roboto", Font.PLAIN, 12));
		contentPane.add(lb9);
		
		JLabel lb_Login = new JLabel("Back to login");
		lb_Login.setForeground(new Color(4, 125, 247));
		lb_Login.setBounds(530, 547, 102, 30);
		lb_Login.setFont(new Font("Roboto", Font.PLAIN, 12));
		contentPane.add(lb_Login);
		
		JPanel pad1 = new JPanel();
		pad1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Main information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pad1.setBounds(10, 79, 966, 172);
		contentPane.add(pad1);
		pad1.setLayout(null);
		
		JLabel lb3_regis = new JLabel("Username");
		lb3_regis.setBounds(25, 25, 194, 23);
		pad1.add(lb3_regis);
		lb3_regis.setVerticalAlignment(SwingConstants.BOTTOM);
		lb3_regis.setHorizontalAlignment(SwingConstants.LEFT);
		lb3_regis.setForeground(new Color(0, 0, 0));
		lb3_regis.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JTextField tf_Username_regis = new JTextField();
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
		
		JPasswordField pwf_Password_regis = new JPasswordField();
		pwf_Password_regis.setBounds(20, 113, 320, 30);
		pad1.add(pwf_Password_regis);
		pwf_Password_regis.setOpaque(false);
		pwf_Password_regis.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JPanel pad2 = new JPanel();
		pad2.setBorder(new TitledBorder(null, "Side information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pad2.setBounds(10, 261, 966, 234);
		contentPane.add(pad2);
		pad2.setLayout(null);
		
		JLabel lb_5_regis = new JLabel("Email");
		lb_5_regis.setVerticalAlignment(SwingConstants.BOTTOM);
		lb_5_regis.setHorizontalAlignment(SwingConstants.LEFT);
		lb_5_regis.setForeground(Color.BLACK);
		lb_5_regis.setFont(new Font("Dialog", Font.PLAIN, 14));
		lb_5_regis.setBounds(26, 28, 194, 23);
		pad2.add(lb_5_regis);
		
		JTextField tf_Email_regis = new JTextField();
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
		
		JTextField tf_Phone_regis = new JTextField();
		tf_Phone_regis.setOpaque(false);
		tf_Phone_regis.setFont(new Font("Dialog", Font.PLAIN, 14));
		tf_Phone_regis.setColumns(10);
		tf_Phone_regis.setBounds(343, 52, 270, 30);
		pad2.add(tf_Phone_regis);
		
		JLabel lb_7_regis = new JLabel("Birthday");
		lb_7_regis.setVerticalAlignment(SwingConstants.BOTTOM);
		lb_7_regis.setHorizontalAlignment(SwingConstants.LEFT);
		lb_7_regis.setForeground(Color.BLACK);
		lb_7_regis.setFont(new Font("Dialog", Font.PLAIN, 14));
		lb_7_regis.setBounds(674, 28, 194, 23);
		pad2.add(lb_7_regis);
		
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        JFormattedTextField ftf_Birthday = new JFormattedTextField(dateFormat);
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
		
		JTextArea ta_Address_regis = new JTextArea();
		ta_Address_regis.setBackground(new Color(234, 234, 234));
		ta_Address_regis.setWrapStyleWord(true);
		ta_Address_regis.setLineWrap(true);
		ta_Address_regis.setBounds(26, 131, 913, 75);
		pad2.add(ta_Address_regis);
		
	}
}
