package data;

import model.*;
import view.*;


public class bootup {
	
	private Utilities Utili = new Utilities();

	private User UserObj;
	private bootup_jdbc bootup_jdbcObj;
	
	private MainUI mainUIObj;
	
	
	public bootup(User user, MainUI mainUI) {
		this.UserObj = user;
		this.bootup_jdbcObj = new bootup_jdbc(user);
		this.mainUIObj = mainUI;
		
	}
	
	
	public void bootup_initial() {
		bootup_jdbcObj.initial_User();
	}
	
	
	public void bootup_userview() {
		mainUIObj.getLb_tenTaiKhoan().setText(UserObj.getUsername());
		mainUIObj.getTf_user_TenTaiKhoan().setText(UserObj.getUsername());
		mainUIObj.getTf_user_HoVaTen().setText(UserObj.getFullname());
		
		String strDate = Utili.utilDate_to_String(UserObj.getBirth());
		mainUIObj.getTf_user_NgaySinh().setText(strDate);
		
		mainUIObj.getTf_user_email().setText(UserObj.getEmail());
		mainUIObj.getTf_user_sdt().setText(UserObj.getPhone());
		mainUIObj.getTa_DiaChi().setText(UserObj.getAddress());
		mainUIObj.getLabel_user_avatar().setIcon(Utili.ImageIcon_Label_Scale(UserObj.getAvatar(), mainUIObj.getLabel_user_avatar()));
	}
	
	
	public void bootup_useredit() {
		mainUIObj.getLb_tenTaiKhoan_edit().setText(UserObj.getUsername());
		mainUIObj.getTf_user_TenTaiKhoan_edit().setText(UserObj.getUsername());
		mainUIObj.getTf_user_HoVaTen_edit().setText(UserObj.getFullname());
		
		String strDate = Utili.utilDate_to_String(UserObj.getBirth());
		mainUIObj.getTf_user_NgaySinh_edit().setText(strDate);
		
		mainUIObj.getTf_user_email_edit().setText(UserObj.getEmail());
		mainUIObj.getTf_user_sdt_edit().setText(UserObj.getPhone());
		mainUIObj.getTa_DiaChi_edit().setText(UserObj.getAddress());
		mainUIObj.getLabel_user_avatar_edit().setIcon(Utili.ImageIcon_Label_Scale(UserObj.getAvatar(), mainUIObj.getLabel_user_avatar()));
	}
	
	
	
	
	
	
	
	
	
	
}