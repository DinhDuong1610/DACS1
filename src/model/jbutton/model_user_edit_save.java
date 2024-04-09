package model.jbutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.sql.*;

import view.*;
import model.*;


public class model_user_edit_save implements ActionListener {
	
	private User userObj;
	private MainUI main;
	private model_user_edit_save_jdbc muesj_Obj;
	
	private Utilities Utili = new Utilities();
	
	public model_user_edit_save(User user, MainUI mainUI) {
		this.userObj = user;
		this.main = mainUI;
		
		this.muesj_Obj = new model_user_edit_save_jdbc(user, mainUI);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == main.getBt_user_edit_save()) {
			
			// check whether username is duplicate or not
			if (muesj_Obj.Username_Check(main.getTf_user_TenTaiKhoan_edit().getText(), userObj.getUser_Id())) {
				JOptionPane.showMessageDialog(null, "Tên tài khoản mới của bạn đã được sử dụng rồi!",
						"Warning", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			// checking if the date format is allowed for database
			try {
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        dateFormat.setLenient(false); // Disable lenient parsing
		        dateFormat.parse(main.getTf_user_NgaySinh_edit().getText());
			} catch (java.text.ParseException ex) {
				JOptionPane.showMessageDialog(null, "Dạng ngày sai, vui lòng nhập dạng ngày theo kiểu YYYY-MM-DD !",
						"Warning", JOptionPane.ERROR_MESSAGE);
				return;
			}
						
			
			
			// if all above conditions all approved then proceed to save to User.java then update user informations
			// updating user.java
			userObj.setUsername(main.getTf_user_TenTaiKhoan_edit().getText());
			userObj.setFullname(main.getTf_user_HoVaTen_edit().getText());
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				java.util.Date date = (java.util.Date)dateFormat.parse(main.getTf_user_NgaySinh_edit().getText());
				userObj.setBirth(date);
			} catch (ParseException e1) {
				System.out.println("recheck the user_edit save button conditions!");
				e1.printStackTrace();
			}
			
			userObj.setEmail(main.getTf_user_email_edit().getText());
			userObj.setPhone(main.getTf_user_sdt_edit().getText());
			userObj.setAddress(main.getTa_DiaChi_edit().getText());
			
			ImageIcon imageicon = (ImageIcon) main.getLabel_user_avatar_edit().getIcon();
			userObj.setAvatar(imageicon);
			
			
			// updating to database (yeah, i know the password here is redundant tho...)
			String birth = Utili.utilDate_to_String(userObj.getBirth());
			
			muesj_Obj.Update_Account(userObj.getUsername(), userObj.getFullname(),
					birth, userObj.getEmail(), userObj.getPhone(),
					userObj.getAddress(), userObj.getPassword(), userObj.getAvatar_path(),
					userObj.getUser_Id());
			
			
			// refresh the user view UI
			refresh_userview();
			
			
			JOptionPane.showMessageDialog(null, "Tài khoản của bạn cập nhật thành công!",
					"Update success!", JOptionPane.INFORMATION_MESSAGE);
			return;
			
		}
		
	}
	
	
	public void refresh_userview() {
		main.getLb_tenTaiKhoan().setText(userObj.getUsername());
		main.getTf_user_TenTaiKhoan().setText(userObj.getUsername());
		main.getTf_user_HoVaTen().setText(userObj.getFullname());
		
		String strDate = Utili.utilDate_to_String(userObj.getBirth());
		main.getTf_user_NgaySinh().setText(strDate);
		
		main.getTf_user_email().setText(userObj.getEmail());
		main.getTf_user_sdt().setText(userObj.getPhone());
		main.getTa_DiaChi().setText(userObj.getAddress());
		main.getLabel_user_avatar().setIcon(Utili.ImageIcon_Label_Scale(userObj.getAvatar(), main.getLabel_user_avatar()));
	}
	
	
}