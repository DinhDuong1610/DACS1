package view.CommunityUI.component;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Item_Project extends JPanel{
	private JLabel lb_nameProject;
	
	public Item_Project(String nameProject) {
		lb_nameProject = new JLabel(nameProject);
		lb_nameProject.setHorizontalAlignment(SwingConstants.LEFT);
		lb_nameProject.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		setBackground(Color.white);
		setBorder(new EmptyBorder(10, 20, 10, 10));
		
		JButton bt_delete = new JButton("...");
		bt_delete.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lb_nameProject, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
					.addGap(21)
					.addComponent(bt_delete, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(bt_delete, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(lb_nameProject, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
					.addGap(0))
		);
		setLayout(groupLayout);
		
		init();
	}
	
	public void init() {
		
    	addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(new Color(230, 230, 230));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(new Color(255, 255, 255));
            }
        });
    }
}
