package model.jbutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.*;
import images.*;
import model.*;

public class model_user_avatar_edit implements ActionListener {

	private Utilities Utili = new Utilities();

	private User userObj;
	private MainUI main;

	public model_user_avatar_edit(User user, MainUI mainUI) {
		this.userObj = user;
		this.main = mainUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == main.getBt_user_avatar_edit()) {
			String path2 = browseimage();

			main.getLabel_user_avatar_edit().setIcon(Utili.ImageIcon_Label_Scale(new ImageIcon(path2), main.getLabel_user_avatar_edit()));
			userObj.setAvatar_path(path2);
		}

	}

	public String browseimage() {
		JFileChooser FC = new JFileChooser();
		FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGE5", "png", "jpg", "jpeg");
		FC.addChoosableFileFilter(fnef);

		int showFC = FC.showOpenDialog(null);
		if (showFC == JFileChooser.APPROVE_OPTION) {
			return FC.getSelectedFile().getAbsolutePath();
		} else if (showFC == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "Image not found!", "Error!", JOptionPane.PLAIN_MESSAGE);
		}

		URL url = imgGiver.class.getResource("/images/icon/error.png");
		String path1 = URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8);
		return path1;
	}

}