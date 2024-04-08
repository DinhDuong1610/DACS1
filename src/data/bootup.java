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
		mainUIObj.getTf_user_TenTaiKhoan().setText(UserObj.getUsername());
		mainUIObj.getTf_user_HoVaTen().setText(UserObj.getFullname());
		
		String strDate = Utili.utilDate_to_String(UserObj.getBirth());
		mainUIObj.getTf_user_NgaySinh().setText(strDate);
		
		mainUIObj.getTf_user_email().setText(UserObj.getEmail());
		mainUIObj.getTf_user_sdt().setText(UserObj.getPhone());
		mainUIObj.getTa_DiaChi().setText(UserObj.getAddress());
		
		// TODO mainUIObj avatar label
	}
	
	
}