Tất cả files trong package "other" là file nháp, không có gì để bận tâm


user_view
0. từ Username của Login và Register lấy User_Id bỏ vào User
1. sau khi đăng nhập xong, lấy thông tin từ database bỏ vào user.java thông qua bootup.java và bootup_jdbc.java (ngoại trừ avatar)
+ tf_user_TenTaiKhoan
+ tf_user_HoVaTen
+ tf_user_NgaySinh
+ tf_user_email
+ tf_user_sdt
+ ta_DiaChi

2. kiểm tra avatar , nếu null để ảnh default



user_edit
1. lấy thông tin từ user.java bỏ lên các mục và thử chỉnh sửa (chưa có ảnh + password)
+ tf_user_TenTaiKhoan
+ tf_user_HoVaTen
+ tf_user_NgaySinh
+ tf_user_email
+ tf_user_sdt
+ ta_DiaChi

+ kiểm tra xem tên tài khoản đã có người sử dụng hay chưa
+ kiểm tra ngày sinh có hợp lệ không

2. nghiên cứu phần chỉnh sửa ảnh
3. nghiên cứu phần thay đổi password










	Blob Imgblob = res.getBlob("Image");
	BufferedImage img = Model_Functions.BufferedResize(Model_Functions.BlobtoBufferedImage(Imgblob), 240, 236);
    BAODI_Application.Quanly_Sanpham_AnhSP_Lb.setIcon(new ImageIcon(img));
    
    
	public static BufferedImage BlobtoBufferedImage(Blob blo) {
		BufferedImage img1 = null;
		try {
			// convert from Blob to BufferedImage
			ByteArrayInputStream bais = new ByteArrayInputStream(blo.getBytes(1, (int) blo.length()));
			img1 = ImageIO.read(bais);
	    
		} catch (IOException e) {
			// // e.printStackTrace();
		} catch (SQLException e) {
			// // e.printStackTrace();
		}
		
		return img1;
	}
	
	public static BufferedImage BufferedResize(BufferedImage BuffImg, int wid, int hei) {
	    Image tmp = BuffImg.getScaledInstance(wid, hei, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(wid, hei, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();
	    
	    return dimg;
	}