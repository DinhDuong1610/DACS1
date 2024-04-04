package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import controller.CardLayout.CardLayout_MainUI;
import controller.CardLayout.CardLayout_User;

public class MainUI extends JFrame {
	private JPanel contentPane;
	private JButton button_chat;
	private JButton button_community;
	private JButton button_calender;
	private JPanel panel_card;
	private JPanel panel_card_community;
	private JButton button_user;
	private JPanel panel_card_chat;
	private JPanel panel_card_calender;
	private JTextField tf_HoVaTen;
	private JPanel panel_card_user;
	private JPanel panel_card_user_view;
	private JLabel label_user_avatar;
	private JLabel label_user_TenTaiKhoan;
	private JLabel label_user_HoVaTen;
	private JLabel label_user_NgaySinh;
	private JLabel label_user_email;
	private JLabel label_user_sdt;
	private JLabel label_user_DiaChi;
	private JTextField tf_user_TenTaiKhoan;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JScrollPane scrollPane;
	private JPanel panel_card_user_edit;
	private JLabel label_user_avatar_1;
	private JLabel label_user_TenTaiKhoan_1;
	private JLabel label_user_HoVaTen_1;
	private JLabel label_user_NgaySinh_1;
	private JLabel label_user_email_1;
	private JLabel label_user_sdt_1;
	private JLabel label_user_DiaChi_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;
	private JTextField tf_user_NgaySinh;
	private JTextField tf_user_email;
	private JTextArea ta_DiaChi;
	private JTextField tf_user_sdt;
	private JTextField tf_user_HoVaTen;
	private JTextField tf_user_TenTaiKhoan_edit;
	private JTextField tf_user_HoVaTen_edit;
	private JTextField tf_user_NgaySinh_edit;
	private JTextField tf_user_email_edit;
	private JTextField tf_user_sdt_edit;
	private JTextArea ta_DiaChi_edit;
	private JButton bt_edit;
	private JButton bt_return;
	private JLabel lb_user_password_edit;
	private JButton bt_user_password_edit;
	private JPanel panel_user_password_edit;
	private JPanel panel_user_password_edit_hidden;
	private JPanel panel_user_password_edit_view;
	private JLabel lb_user_password_eidt_old;
	private JLabel lb_user_password_edit_new;
	private JLabel lb_user_password_edit_new_confirm;
	private JPasswordField pwf_user_password_eidt_old;
	private JPasswordField pwf_user_password_edit_new;
	private JPasswordField pwf_user_password_edit_new_confirm;
	private JButton bt_user_password_edit_save;
	private JButton bt_user_edit_save;
	private CardLayout cardLayout_MainUI;
	private JPanel panel_main;
	private CardLayout cardLayout;
	private CardLayout cardLayout_User;
	private CardLayout cardLayout_password_edit;
	private JLabel lb_tenTaiKhoan;
	private JLabel lb_tenTaiKhoan_1;
	private JButton bt_user_avatar_edit;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					MainUI frame = new MainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-5,0, 1554, 840);
		setTitle("TEAMS");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0 ,0, 1554, 840);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_main = new JPanel();
		contentPane.add(panel_main);
		panel_main.setLayout(null);
		panel_main.setBounds(0,0, 1545, 803);
	
// <Thanh Menu>
		CardLayout_MainUI action_cardLayout_MainUI = new CardLayout_MainUI(this);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBackground(new Color(135, 206, 250));
		panel_menu.setBounds(0, 0, 61, 803);
		panel_main.add(panel_menu);
		panel_menu.setLayout(null);
		
		button_user = new JButton("");
		button_user.setBounds(5, 190, 50, 50);
		button_user.addActionListener(action_cardLayout_MainUI);
		button_user.setIcon(new ImageIcon((new ImageIcon((MainUI.class.getResource("/images/icon/user.png"))).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH))));
		panel_menu.add(button_user);
		
		button_chat = new JButton("");
		button_chat.setBounds(5, 70, 50, 50);
		button_chat.addActionListener(action_cardLayout_MainUI);
		button_chat.setIcon(new ImageIcon((new ImageIcon((MainUI.class.getResource("/images/icon/message.png"))).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH))));
		panel_menu.add(button_chat);
		
		button_community = new JButton("");
		button_community.setBounds(5, 10, 50, 50);
		button_community.addActionListener(action_cardLayout_MainUI);
		button_community.setIcon(new ImageIcon((new ImageIcon((MainUI.class.getResource("/images/icon/icon_community.png"))).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH))));
		panel_menu.add(button_community);
		
		button_calender = new JButton("");
		button_calender.setBounds(5, 130, 50, 50);
		button_calender.addActionListener(action_cardLayout_MainUI);
		button_calender.setIcon(new ImageIcon((new ImageIcon((MainUI.class.getResource("/images/icon/icon_calender.png"))).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH))));
		panel_menu.add(button_calender);
		
// <Thanh Menu/>
		
// <VIEW>
		panel_card = new JPanel();
		panel_card.setBounds(63, 0, 1472, 803);
		panel_main.add(panel_card);
		cardLayout_MainUI = new CardLayout(0, 0);
		panel_card.setLayout(cardLayout_MainUI);
		
		panel_card_community = new JPanel();
		panel_card.add(panel_card_community, "panel_card_community");
		
		panel_card_chat = new JPanel();
		panel_card.add(panel_card_chat, "panel_card_chat");
		
		panel_card_calender = new JPanel();
		panel_card.add(panel_card_calender, "panel_card_calender");
		
	// <Panel_card_user>		
		CardLayout_User action_cardLayout_user = new CardLayout_User(this);
		panel_card_user = new JPanel();
		panel_card.add(panel_card_user, "panel_card_user");
		cardLayout_User = new CardLayout(0, 0);
		panel_card_user.setLayout(cardLayout_User);
		// <Panel_card_user_view>
		panel_card_user_view = new JPanel();
		panel_card_user_view.setLayout(null);
		panel_card_user.add(panel_card_user_view, "panel_card_user_view");
		
		label_user_avatar = new JLabel("");
		label_user_avatar.setOpaque(true);
		label_user_avatar.setBackground(new Color(144, 238, 144));
		label_user_avatar.setBounds(83, 87, 350, 350);
		panel_card_user_view.add(label_user_avatar);
		
		label_user_TenTaiKhoan = new JLabel("TÊN TÀI KHOẢN");
		label_user_TenTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_user_TenTaiKhoan.setBounds(503, 87, 217, 48);
		panel_card_user_view.add(label_user_TenTaiKhoan);
		
		label_user_HoVaTen = new JLabel("HỌ VÀ TÊN");
		label_user_HoVaTen.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_user_HoVaTen.setBounds(503, 145, 217, 48);
		panel_card_user_view.add(label_user_HoVaTen);
		
		label_user_NgaySinh = new JLabel("NGÀY SINH");
		label_user_NgaySinh.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_user_NgaySinh.setBounds(503, 203, 217, 48);
		panel_card_user_view.add(label_user_NgaySinh);
		
		label_user_email = new JLabel("EMAIL");
		label_user_email.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_user_email.setBounds(503, 319, 217, 48);
		panel_card_user_view.add(label_user_email);
		
		label_user_sdt = new JLabel("SỐ ĐIỆN THOẠI");
		label_user_sdt.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_user_sdt.setBounds(503, 261, 217, 48);
		panel_card_user_view.add(label_user_sdt);
		
		label_user_DiaChi = new JLabel("ĐỊA CHỈ");
		label_user_DiaChi.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_user_DiaChi.setBounds(503, 377, 217, 48);
		panel_card_user_view.add(label_user_DiaChi);
		
		tf_user_TenTaiKhoan = new JTextField();
		tf_user_TenTaiKhoan.setColumns(10);
		tf_user_TenTaiKhoan.setBounds(745, 87, 640, 48);
		panel_card_user_view.add(tf_user_TenTaiKhoan);
		
		tf_user_HoVaTen = new JTextField();
		tf_user_HoVaTen.setColumns(10);
		tf_user_HoVaTen.setBounds(745, 145, 640, 48);
		panel_card_user_view.add(tf_user_HoVaTen);
		
		tf_user_NgaySinh = new JTextField();
		tf_user_NgaySinh.setColumns(10);
		tf_user_NgaySinh.setBounds(745, 203, 640, 48);
		panel_card_user_view.add(tf_user_NgaySinh);
		
		tf_user_email = new JTextField();
		tf_user_email.setColumns(10);
		tf_user_email.setBounds(745, 261, 640, 48);
		panel_card_user_view.add(tf_user_email);
		
		tf_user_sdt = new JTextField();
		tf_user_sdt.setColumns(10);
		tf_user_sdt.setBounds(745, 319, 640, 48);
		panel_card_user_view.add(tf_user_sdt);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(745, 377, 640, 121);
		panel_card_user_view.add(scrollPane);
		ta_DiaChi = new JTextArea();
		scrollPane.setViewportView(ta_DiaChi);
		
		lb_tenTaiKhoan = new JLabel("DINH_DUONG");
		lb_tenTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lb_tenTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 30));
		lb_tenTaiKhoan.setBounds(83, 447, 350, 51);
		panel_card_user_view.add(lb_tenTaiKhoan);
		
		bt_edit = new JButton("");
		bt_edit.setBounds(1409, 24, 40, 40);
		bt_edit.addActionListener(action_cardLayout_user);
		bt_edit.setIcon(new ImageIcon((new ImageIcon((MainUI.class.getResource("/images/icon/icon_edit.png"))).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH))));
		panel_card_user_view.add(bt_edit);
		// <Panel_card_user_view/>
		
		// <Panel_card_user_edit>
		panel_card_user_edit = new JPanel();
		panel_card_user_edit.setLayout(null);
		panel_card_user.add(panel_card_user_edit, "panel_card_user_edit");
		
		label_user_avatar_1 = new JLabel("");
		label_user_avatar_1.setOpaque(true);
		label_user_avatar_1.setBackground(new Color(144, 238, 144));
		label_user_avatar_1.setBounds(83, 87, 350, 350);
		panel_card_user_edit.add(label_user_avatar_1);
		
		label_user_TenTaiKhoan_1 = new JLabel("TÊN TÀI KHOẢN");
		label_user_TenTaiKhoan_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_user_TenTaiKhoan_1.setBounds(503, 87, 217, 48);
		panel_card_user_edit.add(label_user_TenTaiKhoan_1);
		
		label_user_HoVaTen_1 = new JLabel("HỌ VÀ TÊN");
		label_user_HoVaTen_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_user_HoVaTen_1.setBounds(503, 145, 217, 48);
		panel_card_user_edit.add(label_user_HoVaTen_1);
		
		label_user_NgaySinh_1 = new JLabel("NGÀY SINH");
		label_user_NgaySinh_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_user_NgaySinh_1.setBounds(503, 203, 217, 48);
		panel_card_user_edit.add(label_user_NgaySinh_1);
		
		label_user_email_1 = new JLabel("EMAIL");
		label_user_email_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_user_email_1.setBounds(503, 319, 217, 48);
		panel_card_user_edit.add(label_user_email_1);
		
		label_user_sdt_1 = new JLabel("SỐ ĐIỆN THOẠI");
		label_user_sdt_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_user_sdt_1.setBounds(503, 261, 217, 48);
		panel_card_user_edit.add(label_user_sdt_1);
		
		label_user_DiaChi_1 = new JLabel("ĐỊA CHỈ");
		label_user_DiaChi_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_user_DiaChi_1.setBounds(503, 377, 217, 48);
		panel_card_user_edit.add(label_user_DiaChi_1);
		
		tf_user_TenTaiKhoan_edit = new JTextField();
		tf_user_TenTaiKhoan_edit.setColumns(10);
		tf_user_TenTaiKhoan_edit.setBounds(745, 87, 640, 48);
		panel_card_user_edit.add(tf_user_TenTaiKhoan_edit);
		
		tf_user_HoVaTen_edit = new JTextField();
		tf_user_HoVaTen_edit.setColumns(10);
		tf_user_HoVaTen_edit.setBounds(745, 145, 640, 48);
		panel_card_user_edit.add(tf_user_HoVaTen_edit);
		
		tf_user_NgaySinh_edit = new JTextField();
		tf_user_NgaySinh_edit.setColumns(10);
		tf_user_NgaySinh_edit.setBounds(745, 203, 640, 48);
		panel_card_user_edit.add(tf_user_NgaySinh_edit);
		
		tf_user_email_edit = new JTextField();
		tf_user_email_edit.setColumns(10);
		tf_user_email_edit.setBounds(745, 261, 640, 48);
		panel_card_user_edit.add(tf_user_email_edit);
		
		tf_user_sdt_edit = new JTextField();
		tf_user_sdt_edit.setColumns(10);
		tf_user_sdt_edit.setBounds(745, 319, 640, 48);
		panel_card_user_edit.add(tf_user_sdt_edit);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(745, 377, 640, 121);
		panel_card_user_edit.add(scrollPane_1);
		ta_DiaChi_edit = new JTextArea();
		scrollPane_1.setViewportView(ta_DiaChi_edit);
		
		bt_return = new JButton("");
		bt_return.setBounds(23, 21, 40, 40);
		bt_return.addActionListener(action_cardLayout_user);
		bt_return.setIcon(new ImageIcon((new ImageIcon((MainUI.class.getResource("/images/icon/icon_return.png"))).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH))));
		panel_card_user_edit.add(bt_return);
		
		lb_user_password_edit = new JLabel("MẬT KHẨU");
		lb_user_password_edit.setFont(new Font("Tahoma", Font.BOLD, 24));
		lb_user_password_edit.setBounds(503, 525, 209, 36);
		panel_card_user_edit.add(lb_user_password_edit);
		
		bt_user_password_edit = new JButton("Đổi");
		bt_user_password_edit.setFont(new Font("Tahoma", Font.BOLD, 22));
		bt_user_password_edit.setBounds(746, 526, 104, 36);
		bt_user_password_edit.addActionListener(action_cardLayout_user);
		panel_card_user_edit.add(bt_user_password_edit);
		
		panel_user_password_edit = new JPanel();
		panel_user_password_edit.setBounds(710, 565, 675, 183);
		panel_card_user_edit.add(panel_user_password_edit);
		cardLayout_password_edit = new CardLayout(0, 0);
		panel_user_password_edit.setLayout(cardLayout_password_edit);
		
		panel_user_password_edit_hidden = new JPanel();
		panel_user_password_edit.add(panel_user_password_edit_hidden, "panel_user_password_edit_hidden");
		
		panel_user_password_edit_view = new JPanel();
		panel_user_password_edit_view.setLayout(null);
		panel_user_password_edit.add(panel_user_password_edit_view, "panel_user_password_edit_view");
		
		lb_user_password_eidt_old = new JLabel("Nhập mật khẩu cũ");
		lb_user_password_eidt_old.setFont(new Font("Tahoma", Font.BOLD, 21));
		lb_user_password_eidt_old.setBounds(38, 10, 211, 30);
		panel_user_password_edit_view.add(lb_user_password_eidt_old);
		
		lb_user_password_edit_new = new JLabel("Nhập mật khẩu mới");
		lb_user_password_edit_new.setFont(new Font("Tahoma", Font.BOLD, 21));
		lb_user_password_edit_new.setBounds(38, 51, 211, 30);
		panel_user_password_edit_view.add(lb_user_password_edit_new);
		
		lb_user_password_edit_new_confirm = new JLabel("Nhập lại mật khẩu");
		lb_user_password_edit_new_confirm.setFont(new Font("Tahoma", Font.BOLD, 21));
		lb_user_password_edit_new_confirm.setBounds(38, 91, 211, 30);
		panel_user_password_edit_view.add(lb_user_password_edit_new_confirm);
		
		pwf_user_password_eidt_old = new JPasswordField();
		pwf_user_password_eidt_old.setFont(new Font("Tahoma", Font.PLAIN, 19));
		pwf_user_password_eidt_old.setBounds(280, 10, 281, 30);
		panel_user_password_edit_view.add(pwf_user_password_eidt_old);
		
		pwf_user_password_edit_new = new JPasswordField();
		pwf_user_password_edit_new.setFont(new Font("Tahoma", Font.PLAIN, 19));
		pwf_user_password_edit_new.setBounds(280, 52, 281, 30);
		panel_user_password_edit_view.add(pwf_user_password_edit_new);
		
		pwf_user_password_edit_new_confirm = new JPasswordField();
		pwf_user_password_edit_new_confirm.setFont(new Font("Tahoma", Font.PLAIN, 19));
		pwf_user_password_edit_new_confirm.setBounds(280, 92, 281, 30);
		panel_user_password_edit_view.add(pwf_user_password_edit_new_confirm);
		
		bt_user_password_edit_save = new JButton("Lưu mật khẩu");
		bt_user_password_edit_save.setFont(new Font("Tahoma", Font.BOLD, 17));
		bt_user_password_edit_save.setBounds(242, 139, 165, 36);
		panel_user_password_edit_view.add(bt_user_password_edit_save);
		
		bt_user_edit_save = new JButton("LƯU THAY ĐỔI");
		bt_user_edit_save.setFont(new Font("Tahoma", Font.BOLD, 18));
		bt_user_edit_save.setBounds(928, 758, 217, 38);
		panel_card_user_edit.add(bt_user_edit_save);
		
		lb_tenTaiKhoan_1 = new JLabel("DINH_DUONG");
		lb_tenTaiKhoan_1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_tenTaiKhoan_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lb_tenTaiKhoan_1.setBounds(83, 447, 350, 51);
		panel_card_user_edit.add(lb_tenTaiKhoan_1);
		
		bt_user_avatar_edit = new JButton("");
		bt_user_avatar_edit.setIcon(new ImageIcon(MainUI.class.getResource("/images/icon/icon_camera.png")));
		bt_user_avatar_edit.setBounds(83, 400, 350, 37);
		panel_card_user_edit.add(bt_user_avatar_edit);
		// <Panel_card_user_edit/>
	// <Panel_card_user/>	
// <VIEW/>
	}

	public JButton getButton_chat() {
		return button_chat;
	}

	public JButton getButton_community() {
		return button_community;
	}

	public JButton getButton_calender() {
		return button_calender;
	}

	public JPanel getPanel_card() {
		return panel_card;
	}

	public JPanel getPanel_card_community() {
		return panel_card_community;
	}

	public JButton getButton_user() {
		return button_user;
	}

	public JPanel getPanel_card_chat() {
		return panel_card_chat;
	}

	public JPanel getPanel_card_calender() {
		return panel_card_calender;
	}

	public JTextField getTf_HoVaTen() {
		return tf_HoVaTen;
	}

	public JPanel getPanel_card_user() {
		return panel_card_user;
	}

	public JPanel getPanel_card_user_view() {
		return panel_card_user_view;
	}

	public JTextField getTf_user_TenTaiKhoan() {
		return tf_user_TenTaiKhoan;
	}

	public JPanel getPanel_card_user_edit() {
		return panel_card_user_edit;
	}

	public JTextField getTf_user_NgaySinh() {
		return tf_user_NgaySinh;
	}

	public JTextField getTf_user_email() {
		return tf_user_email;
	}

	public JTextArea getTa_DiaChi() {
		return ta_DiaChi;
	}

	public JTextField getTf_user_sdt() {
		return tf_user_sdt;
	}

	public JTextField getTf_user_HoVaTen() {
		return tf_user_HoVaTen;
	}

	public JTextField getTf_user_TenTaiKhoan_edit() {
		return tf_user_TenTaiKhoan_edit;
	}

	public JTextField getTf_user_HoVaTen_edit() {
		return tf_user_HoVaTen_edit;
	}

	public JTextField getTf_user_NgaySinh_edit() {
		return tf_user_NgaySinh_edit;
	}

	public JTextField getTf_user_email_edit() {
		return tf_user_email_edit;
	}

	public JTextField getTf_user_sdt_edit() {
		return tf_user_sdt_edit;
	}

	public JTextArea getTa_DiaChi_edit() {
		return ta_DiaChi_edit;
	}

	public JButton getBt_edit() {
		return bt_edit;
	}

	public JButton getBt_return() {
		return bt_return;
	}

	public JButton getBt_user_password_edit() {
		return bt_user_password_edit;
	}

	public JPanel getPanel_user_password_edit() {
		return panel_user_password_edit;
	}

	public JPanel getPanel_user_password_edit_hidden() {
		return panel_user_password_edit_hidden;
	}

	public JPanel getPanel_user_password_edit_view() {
		return panel_user_password_edit_view;
	}

	public JPasswordField getPwf_user_password_eidt_old() {
		return pwf_user_password_eidt_old;
	}

	public JPasswordField getPwf_user_password_edit_new() {
		return pwf_user_password_edit_new;
	}

	public JPasswordField getPwf_user_password_edit_new_confirm() {
		return pwf_user_password_edit_new_confirm;
	}

	public JButton getBt_user_password_edit_save() {
		return bt_user_password_edit_save;
	}

	public JButton getBt_user_edit_save() {
		return bt_user_edit_save;
	}

	public CardLayout getCardLayout_MainUI() {
		return cardLayout_MainUI;
	}

	public JPanel getPanel_main() {
		return panel_main;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public CardLayout getCardLayout_User() {
		return cardLayout_User;
	}

	public CardLayout getCardLayout_password_edit() {
		return cardLayout_password_edit;
	}
}
