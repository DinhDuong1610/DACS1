package model.jbutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.*;
import model.*;

public class model_user_password_edit_save implements ActionListener {
	
	private User userObj;
	private MainUI main;
	private model_user_password_edit_save_jdbc mupesj;
	
	public model_user_password_edit_save(User user, MainUI mainUI) {
		this.userObj = user;
		this.main = mainUI;
		
		mupesj = new model_user_password_edit_save_jdbc(user, mainUI);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == main.getBt_user_password_edit_save()) {
			String textcheck;
			
			
			// kiểm tra xem pwf_user_password_edit_old đã nhập chưa
			if ((new String(main.getPwf_user_password_eidt_old().getPassword())).isEmpty()) {
				JOptionPane.showMessageDialog(null, "vui lòng nhập mật khẩu cũ của bạn!",
						"Warning", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			// kiểm tra xem pwf_user_password_edit_new đã nhập chưa
			if ((new String(main.getPwf_user_password_edit_new().getPassword())).isEmpty()) {
				JOptionPane.showMessageDialog(null, "vui lòng nhập mật khẩu mới của bạn!",
						"Warning", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			// kiểm tra xem pwf_user_password_edit_new_confirm đã nhập chưa
			if ((new String(main.getPwf_user_password_edit_new_confirm().getPassword())).isEmpty()) {
				JOptionPane.showMessageDialog(null, "vui lòng nhập lại mật khẩu mới của bạn!",
						"Warning", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			// kiểm tra xem mật khẩu cũ có đúng không
			textcheck = new String(main.getPwf_user_password_eidt_old().getPassword());
			if (mupesj.Password_Check(textcheck, userObj.getUser_Id())) {
				JOptionPane.showMessageDialog(null, "Mật khẩu cũ của bạn không đúng!",
						"Incorrect password", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			// kiểm tra xem mật khẩu mới có trùng với xác nhận mật khẩu mới hay không
			String pw1 = new String(main.getPwf_user_password_edit_new().getPassword());
			String pw2 = new String(main.getPwf_user_password_edit_new_confirm().getPassword());
			if (!(pw1.equals(pw2)) ) {
				JOptionPane.showMessageDialog(null, "Mật khẩu mới của bạn không giống với xác nhận mật khẩu mới!",
						"Warning!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			// if all above contidions all approved then save to User.java and database
			// save to User.java
			userObj.setPassword(new String(main.getPwf_user_password_edit_new().getPassword()));
			
			// updating database
			mupesj.Update_Password(new String(main.getPwf_user_password_edit_new().getPassword()), userObj.getUser_Id());
			JOptionPane.showMessageDialog(null, "Bạn đã thay đổi mật khẩu thành công",
					"Password changed", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
}