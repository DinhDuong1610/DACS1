package view.CommunityUI.form;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class HomeCommu extends JPanel{
	public HomeCommu() {
		setLayout(new MigLayout("fillx, filly", "0[300!]5[fill, 100%]0", "0[fill]0"));
		
		this.add(new Menu_Left());
		this.add(new Body());
		
	}
}
