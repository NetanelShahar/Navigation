package GIS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import Geom.Point3D;

/**
 * This class represent the data on every point in the kml.
 * Data such as : UTC(time and date) , name , _AccuracyMeters , type , color and more .
 * the time in data displayed in two ways, as string and long.
 * longToString function allows us to convert time shown as long back to string.
 *  * @author DanielAbergel 
 *
 */
public class MetaDataElement implements Meta_data{

	private long UTC  ;
	private String _timeAsString;
	private String _MAC;
	private String _SSID;
	private String _AccuracyMeters;
	private String _type;
	public MetaDataElement() {

	}
	/**
	 * constructor for Meta_Data 
	 * @param time represent time as long 
	 * @param SSID represent the point name
	 * @param type represent the type of the point
	 * @param MAC represent the MAC of the point
	 * @param AccuracyMeters represent the Accuracy of the point in google earth
	 * @throws ParseException if there a wrong time format
	 */
	public MetaDataElement(String time ,String SSID , String type , String MAC , String AccuracyMeters) throws ParseException 
	{
		_timeAsString = time ; 
		setUTC(time);
		_SSID = SSID ; 
		_type = type;
		_MAC = MAC;
		_AccuracyMeters = AccuracyMeters;
	}
	/**
	 * The function takes time as String and covert the String to long 
	 * @param DateAndTime represent the time as String 
	 * @throws ParseException if there a wrong time format
	 */
	public void setUTC(String DateAndTime) throws ParseException
	{
		String[] TimeData = DateAndTime.split(" ");
		String Date = ChangeFormatDate(TimeData[0]);
		DateAndTime = Date + " " + TimeData[1];
		long millis  = DateToMilis(DateAndTime);
		UTC = millis;
	}
	/**
	 * The function convert the the time from string to  long and returns it
	 * source : https://stackoverflow.com/questions/12081417/convert-utc-date-into-milliseconds
	 * @param dateAndTime represent the time as String 
	 * @return the time as long .
	 * @throws ParseException if there a wrong time format
	 */
	private long DateToMilis(String dateAndTime) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date date = format.parse(dateAndTime);
		long millis = date.getTime();
		return millis;
	}
	// change format 03/12/2017 >>  2017-12-03 (Example)
	private static String ChangeFormatDate(String Date)
	{
		String[] DateAS = Date.split("-");
		Date = DateAS[2] + "-" + DateAS[1]  + "-" + DateAS[0];
		return Date;
	}
	/**
	 * return Time and date as long 
	 * @return time as long 
	 */
	@Override
	public long getUTC()
	{
		return UTC;
	}
	/**
	 * the function convert time from long to String 
	 * @param millis represent the time as long  
	 * @return the time and date as String
	 */
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
	/**
	 * toString method
	 */
	@Override
	public String toString()
	{
		return _MAC + "," + _SSID + ","  + _timeAsString + "," + _AccuracyMeters + "," + _type;
	}


}
