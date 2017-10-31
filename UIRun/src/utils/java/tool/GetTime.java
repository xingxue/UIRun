package tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {

	public SimpleDateFormat dateFormat ;
	Date now ; 
	
	public String getNewTime() {
		now = new Date();
		dateFormat  = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat .format(now);
	}

}
