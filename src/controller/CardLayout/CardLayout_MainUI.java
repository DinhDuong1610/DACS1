package controller.CardLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainUI;

public class CardLayout_MainUI implements ActionListener{
	private MainUI main;
	
	public CardLayout_MainUI(MainUI main) {
		super();
		this.main = main;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == main.getButton_community()) {
			main.getCardLayout_MainUI().show(main.getPanel_card(), "panel_card_community");
		}
		else if(e.getSource() == main.getButton_chat()) {
			main.getCardLayout_MainUI().show(main.getPanel_card(), "panel_card_chat");
		}
		else if(e.getSource() == main.getButton_calender()) {
			main.getCardLayout_MainUI().show(main.getPanel_card(), "panel_card_calender");
		}
		else if(e.getSource() == main.getButton_user()) {
			main.getCardLayout_MainUI().show(main.getPanel_card(), "panel_card_user");
		}	
	}

}
