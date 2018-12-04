package GIS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

import Geom.Point3D;
/**
 * This class represent the data on collection(Points)  in the kml.
 * The UTC is the time the Current time.
 * the time in data displayed in two ways, as string and long.
 * @author DanielAbergel
 *
 */
public class MetaDataLayer implements Meta_data
{
	private long UTC ; 
	private String timeAsString;
	private ArrayList<MetaDataElement> Data ;
	
	/**
	 * The Constructor set the time to Current time and Setting up an array
	 * @throws ParseException if there a wrong time format
	 */
	public MetaDataLayer() throws ParseException 
	{
		setUTC();
		Data = new ArrayList<MetaDataElement>();
		
	}
	/**
	 * source : https://stackoverflow.com/questions/12081417/convert-utc-date-into-milliseconds
	 * source : https://stackoverflow.com/questions/5175728/how-to-get-the-current-date-time-in-java
	 * set the time to Current time .
	 * @throws ParseException if there a wrong time format
	 */
	private void setUTC() throws ParseException 
	{
		timeAsString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date date = format.parse(timeAsString);
		UTC = date.getTime();
	}
	/**
	 * @return the time as long 
	 */
	@Override
	public long getUTC() throws ParseException {
			
		return UTC;
	}

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * toString method
	 */
	@Override
	public String toString() {
		Iterator<MetaDataElement> it = Data.iterator();
		String toString = "["; 
		while(it.hasNext())
		{
			toString += it.next().toString() + "\n";
		}
		toString += "]\n";
		return toString;
	}
	

}
