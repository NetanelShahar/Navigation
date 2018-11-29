package GIS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import Geom.Point3D;

public class MetaDataProject implements Meta_data{
	
	
	long UTC;
	String timeAsString;

	
	@Override
	public long getUTC() throws ParseException 
	{
		// TODO Auto-generated method stub
		return UTC;
	}
	private void setUTC() throws ParseException 
	{
		timeAsString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date date = format.parse(timeAsString);
		UTC = date.getTime();
	}

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}

}
