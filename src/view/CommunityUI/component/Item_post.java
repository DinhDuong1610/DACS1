package view.CommunityUI.component;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import view.ChatUI.swing.ImageAvatar;
import view.ChatUI.swing.JIMSendTextPane;

public class Item_post extends JPanel{
	private ImageAvatar imageAvatar;

	public Item_post(String userName, String time, String content) {

		setBorder(new EmptyBorder(0, 20, 10, 10));
		
		JPanel panel_title = new JPanel();
		
		JPanel panel_content = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_content, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_title, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_content, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JIMSendTextPane lb_content = new JIMSendTextPane();
		lb_content.setText(content);
		lb_content.setEditable(false);
		lb_content.setPreferredSize(new Dimension(lb_content.getPreferredSize().width, lb_content.getPreferredSize().height));
		lb_content.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GroupLayout gl_panel_content = new GroupLayout(panel_content);
		gl_panel_content.setHorizontalGroup(
			gl_panel_content.createParallelGroup(Alignment.LEADING)
				.addComponent(lb_content, GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
		);
		gl_panel_content.setVerticalGroup(
			gl_panel_content.createParallelGroup(Alignment.LEADING)
				.addComponent(lb_content, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
		);
		panel_content.setLayout(gl_panel_content);
		
//		JLabel lb_avatar = new JLabel("");
		imageAvatar = new ImageAvatar();
		imageAvatar.setBorderSize(0);
		imageAvatar.setImage(new ImageIcon(getClass().getResource("/images/testing/dinhdeptrai.jpg")));
		
		JLabel lb_userName = new JLabel(userName);
		lb_userName.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel lb_time = new JLabel(time);
		lb_time.setForeground(Color.GRAY);
		lb_time.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout gl_panel_title = new GroupLayout(panel_title);
		gl_panel_title.setHorizontalGroup(
			gl_panel_title.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_title.createSequentialGroup()
					.addComponent(imageAvatar, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_title.createParallelGroup(Alignment.LEADING)
						.addComponent(lb_userName, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addComponent(lb_time, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(639, Short.MAX_VALUE))
		);
		gl_panel_title.setVerticalGroup(
			gl_panel_title.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_title.createSequentialGroup()
					.addContainerGap()
					.addComponent(lb_userName)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lb_time)
					.addContainerGap())
				.addComponent(imageAvatar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		panel_title.setLayout(gl_panel_title);
		setLayout(groupLayout);
		
		setBackground(Color.white);
		panel_content.setBackground(Color.white);
		panel_title.setBackground(Color.white);
	}
}
