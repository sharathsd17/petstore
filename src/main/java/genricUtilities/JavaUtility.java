package genricUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists of generic methods related to specific
 * @author Chaitra M
 *
 */
public class JavaUtility {
	
	/**
	 * This method will capture the current system date and return to caller
	 * @return Date
	 */
	public String getSystemDate() //Screenshot name , report name
	{
		Date d = new Date(); //04 June 2025 Wednesday IST 12:54:34
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = s.format(d);
		return date;
	}

}