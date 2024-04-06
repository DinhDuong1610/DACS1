package view.ChatUI.form;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import view.MainUI;
import view.ChatUI.component.Item_People;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_Left extends JPanel{
	private JLayeredPane panel_menu_list;

	public Menu_Left() {
		setSize(300, 803);
		setLayout(new MigLayout("fillx, filly", "0[300]0", "0[50]0[100%,fill]0"));
		JPanel panel_menu = new JPanel();
		add(panel_menu, "width 300:300:300, wrap");
		panel_menu.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton bt_chat2P = new JButton("");
		bt_chat2P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPeople();
			}
		});
		panel_menu.add(bt_chat2P);
		
		JButton bt_chatGroup = new JButton("");
		bt_chatGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showGroup();
			}
		});
		panel_menu.add(bt_chatGroup);
		
		bt_chat2P.setIcon(new ImageIcon((new ImageIcon((MainUI.class.getResource("/images/icon/chat2p.png"))).getImage())));
		bt_chatGroup.setIcon(new ImageIcon((new ImageIcon((MainUI.class.getResource("/images/icon/chatgroup.png"))).getImage())));
		panel_menu_list = new JLayeredPane();
		panel_menu_list.setLayout(new MigLayout("fillx", "2[300]2", "3[]3"));
//		add(panel_menu_list);
		
		JScrollPane jScrollPane = new JScrollPane(panel_menu_list);
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(jScrollPane);
		
		showPeople();
		setBackground(Color.blue);
	}
	
	public void showPeople() {
		panel_menu_list.removeAll();
		panel_menu_list.add(new Item_People("Đính Dương"), "width 296:296:296, height 50:50:50, wrap");
		panel_menu_list.add(new Item_People("Lê Hữu Anh Tú"), "width 296:296:296, height 50:50:50, wrap");
		panel_menu_list.add(new Item_People("Cao Hoàng Phước Bảo"), "width 296:296:296, height 50:50:50, wrap");
		for(int i = 1; i <= 20; i++) {
			panel_menu_list.add(new Item_People("People " + i), "width 296:296:296, height 50:50:50, wrap");
		}
		panel_menu_list.repaint();
		panel_menu_list.revalidate();
	}
	
	public void showGroup() {
		panel_menu_list.removeAll();
		for(int i = 1; i <= 10; i++) {
			panel_menu_list.add(new Item_People("Group " + i), "width 296:296:296, height 50:50:50, wrap");
		}
		panel_menu_list.repaint();
		panel_menu_list.revalidate();
	}
}
