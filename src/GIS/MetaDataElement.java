package GIS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import Geom.Point3D;


public class MetaDataElement implements Meta_data{

	private long UTC  ;
	private String _timeAsString;
	private String _MAC;
	private String _SSID;
	private String _AccuracyMeters;
	private String _type;
	public MetaDataElement() {
		
	}
	public MetaDataElement(String time ,String SSID , String type , String MAC , String AccuracyMeters) throws ParseException 
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
		String[] TimeData = DateAndTime.split(" ");
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
		String[] DateAS = Date.split("-");
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
		return "MAC:"+ _MAC + " SSID: " + _SSID + " Time: "  + _timeAsString + " Accuracy: " + _AccuracyMeters + " type: " + _type;
	}
	public static void main(String[] args) throws ParseException {
		MetaDataElement m = new MetaDataElement();
		m.setUTC("03/12/2017 08:53:08");
		System.out.println(m.UTC);
	}

}
