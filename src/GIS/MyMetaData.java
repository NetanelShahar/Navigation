package GIS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import Geom.Point3D;


public class MyMetaData implements Meta_data{

	private long UTC  ;
	private String _timeAsString;
	private String _MAC;
	private String _SSID;
	private String _AccuracyMeters;
	private String _type;
	public MyMetaData(String time ,String SSID , String type , String MAC , String AccuracyMeters) throws ParseException 
	{
		_timeAsString = time ; 
		setUTC(time);
		_SSID = SSID ; 
		_type = type;
		_MAC = MAC;
		_AccuracyMeters = AccuracyMeters;
	}
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
	public static void main(String[] args) throws ParseException
	{
		MyMetaData m = new MyMetaData("03/12/2017  08:53:08", "Ariel_University", "WIFI", "1c:b9:c4:15:42:68", "3");
		System.out.println(m.UTC);
		System.out.println(m._timeAsString);
		System.out.println(m._MAC);
		System.out.println(m._AccuracyMeters);
		System.out.println(m._type);
		System.out.println(m._SSID);
		
	}

}
