package view.CommunityUI.component;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

import controller.CardLayout.CardLayout_Community;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Title extends JPanel{
	private JButton bt_post;
	private JButton bt_event;

	public Title(String nameProject) {
		
		JLabel lb_nameProject = new JLabel(nameProject);
		lb_nameProject.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		bt_post = new JButton("Post");
		bt_post.setBorder(null);
		bt_post.setFont(new Font("Tahoma", Font.BOLD, 18));
		bt_post.setBackground(new Color(242, 242, 242));
		
		bt_event = new JButton("Event");
		bt_event.setBorder(null);
		bt_event.setFont(new Font("Tahoma", Font.BOLD, 18));
		bt_event.setBackground(new Color(242, 242, 242));
		
		JButton bt_newMeeting = new JButton("New meeting");
		bt_newMeeting.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_newMeeting.setBackground(new Color(242, 242, 242));
		
		JButton bt_member = new JButton("Member");
		bt_member.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_member.setBackground(new Color(242, 242, 242));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lb_nameProject, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(bt_post, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bt_event, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
					.addComponent(bt_newMeeting)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bt_member)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bt_member, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(bt_newMeeting, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
					.addContainerGap())
				.addComponent(lb_nameProject, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
				.addComponent(bt_event, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
				.addComponent(bt_post, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
		
		setBackground(Color.white);
	}

	public JButton getBt_post() {
		return bt_post;
	}

	public JButton getBt_event() {
		return bt_event;
	}

	
	
}
