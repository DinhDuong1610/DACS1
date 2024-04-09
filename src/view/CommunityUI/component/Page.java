package view.CommunityUI.component;

import java.awt.CardLayout;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class Page extends JPanel{
	private News news;
	private NewPost newPost;
	private JPanel panel_post;
	private JPanel panel_event;
	private CardLayout cardLayout_Page;
	private Meets meets;
	
	public Page() {
		panel_post = new JPanel();
		panel_event = new JPanel();
		
		cardLayout_Page = new CardLayout();
		setLayout(cardLayout_Page);
		add(panel_post, "panel_post");
		add(panel_event, "panel_event");
		
		news = new News();
		newPost = new NewPost();
		meets = new Meets();
		
		panel_post.setLayout(new MigLayout("fillx", "0[fill]0", "0[120!]0[100%, fill]0"));
		
		panel_post.add(newPost, "wrap");
		JScrollPane sp = new JScrollPane(news);
		sp.setBorder(null);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_post.add(sp);	
		
		panel_event.setLayout(new MigLayout("fillx", "0[fill]0", "15[100%, fill]0"));
		JScrollPane sp2 = new JScrollPane(meets);
		sp2.setBorder(null);
		sp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_event.add(sp2);	
	}

	public CardLayout getCardLayout_Page() {
		return cardLayout_Page;
	}

	public void setCardLayout_Page(CardLayout cardLayout_Page) {
		this.cardLayout_Page = cardLayout_Page;
	}
	
	
}
