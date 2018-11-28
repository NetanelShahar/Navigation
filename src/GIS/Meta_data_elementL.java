package GIS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import Geom.Point3D;


public class Meta_data_elementL implements Meta_data{
	
	private long UTC  ; 
	
	public void setUTC(String DateAndTime) throws ParseException
	{
		String[] TimeData = DateAndTime.split("  ");
		String Date = ChangeFormatDate(TimeData[0]);
		DateAndTime = Date + " " + TimeData[1];
		long millis  = DateToMilis(DateAndTime);
		UTC = millis;
	}
	
	private long DateToMilis(String dateAndTime) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date date = format.parse(dateAndTime);
		long millis = date.getTime();
		return millis;
	}
	// change format 03/12/2017 >>  2017-12-03
	private static String ChangeFormatDate(String Date)
	{
		String[] DateAS = Date.split("/");
		Date = DateAS[2] + "-" + DateAS[1]  + "-" + DateAS[0];
	return Date;
	}
	
	@Override
	public long getUTC()
	{
	
		return UTC;
	}
	private String longToDate(long millis)
	{
		SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(new Date(millis));
	}
	@Override
	public Point3D get_Orientation()
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString()
	{
		return "The UTC is " + longToDate(UTC) ;
	}


}
