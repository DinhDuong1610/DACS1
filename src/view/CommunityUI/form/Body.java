package view.CommunityUI.form;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import controller.CardLayout.CardLayout_Community;
import net.miginfocom.swing.MigLayout;
import view.CommunityUI.component.NewPost;
import view.CommunityUI.component.News;
import view.CommunityUI.component.Page;
import view.CommunityUI.component.Title;

public class Body extends JPanel{
	private Title title;
	private Page page;
	
	public Body() {
		title = new Title("PROJECT 1");
		page = new Page();
		
		setBackground(new Color(242, 242, 242));
		
		
		setLayout(new MigLayout("fillx", "0[fill]0", "0[50]0[100%, fill]0"));
		
		this.add(title, "wrap");
		this.add(page);
		cardLayout();
	}
	
	public void cardLayout() {
		CardLayout_Community action_cardLayout_Community = new CardLayout_Community(this);
		getTitle().getBt_post().addActionListener(action_cardLayout_Community);
		getTitle().getBt_event().addActionListener(action_cardLayout_Community);
	}

	public Title getTitle() {
		return title;
	}

	public Page getPage() {
		return page;
	}

	
	

	
	
}
