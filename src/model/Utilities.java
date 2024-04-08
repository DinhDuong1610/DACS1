package model;

import java.text.SimpleDateFormat;

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

}
