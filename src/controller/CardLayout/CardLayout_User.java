package controller.CardLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainUI;

public class CardLayout_User implements ActionListener{
	private MainUI main;
	
	public CardLayout_User(MainUI main) {
		super();
		this.main = main;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == main.getBt_edit()) {
			main.getCardLayout_User().show(main.getPanel_card_user(), "panel_card_user_edit");
		}
		else if(e.getSource() == main.getBt_return()) {
			main.getCardLayout_User().show(main.getPanel_card_user(), "panel_card_user_view");
		}
		else if(e.getSource() == main.getBt_user_password_edit()) {
			main.getCardLayout_password_edit().next(main.getPanel_user_password_edit());
		}
		
	}
	
}
