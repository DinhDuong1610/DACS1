package view.ChatUI.form;

import java.awt.Color;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class Home extends JPanel{
	
	public Home() {
		setSize(1472, 803);
		setLayout(new MigLayout("fillx, filly", "0[300!]5[fill, 100%]0", "0[fill]0"));
		
        this.add(new Menu_Left());
        this.add(new Chat());
        
	}
}
