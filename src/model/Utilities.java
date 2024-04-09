package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import images.*;
import data.*;

// this class is just for converting, ..., utilities, it shouldn't be use for any object/data storing
public class Utilities {

	//	public Utilities() {
	//		
	//	}

	// Both conversions sql and util Date involve utilizing the milliseconds representation to perform the conversion.
	// convert java.sql.Date to Java.util.Date
	public java.util.Date sqlDate_to_utilDate(java.sql.Date sqlDate) {
		java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		return utilDate;
	}

	
	// convert java.sql.Date to Java.util.Date
	public java.sql.Date utilDate_to_sqlDate(java.util.Date utilDate) {
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}

	
	// convert java.util.Date to String
	public String utilDate_to_String(java.util.Date utilDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(utilDate);
        return dateString;
	}
	
	
	
	// convert java.sql.Blob to ImageIcon
//	public ImageIcon Blob_to_ImageIcon(java.sql.Blob blob) {
//		ImageIcon imageIcon = new ImageIcon(imgGiver.class.getResource("/images/icon/error.png"));
//		
//		try {
//			byte[] imageData;
//			imageData = blob.getBytes(1, (int) blob.length());
//			imageIcon = new ImageIcon(imageData);
//			
//			return imageIcon;
//		} catch (SQLException e) {
//			System.out.println("converting blob to ImageIcon failed");
//			e.printStackTrace();
//		}
//		
//		return imageIcon;
//	}
	
	
	// convert InputStream to ImageIcon
	public ImageIcon InputStream_to_ImageIcon(InputStream is) {
		ImageIcon imageIcon = new ImageIcon(imgGiver.class.getResource("/images/icon/default.jpeg"));
		
		try {
		    BufferedImage image = ImageIO.read(is);
		    imageIcon = new ImageIcon(image);

		    return imageIcon;

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        is.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		// InputStream_to_ImageIcon failed!
		return imageIcon;
	}
	
	

	// ImageIcon Scaling
	public ImageIcon ImageIcon_Label_Scale(ImageIcon imageicon, JLabel lb) {
		ImageIcon imgicon = new ImageIcon(imageicon.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_SMOOTH));
		return imgicon;
	}
	
	
}
