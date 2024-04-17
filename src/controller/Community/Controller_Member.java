package controller.Community;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CommunityUI.form.Body;

public class Controller_Member implements ActionListener{
	private Body body;

	public Controller_Member(Body body) {
		this.body = body;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == body.getTitle().getBt_member()) {
			body.memberProject();
		}
		
	}
	
	
}
