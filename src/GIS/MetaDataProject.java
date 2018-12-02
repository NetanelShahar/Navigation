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
 * This class represent the data on collection(layers)(layer is collection(points))  in the kml.
 * The UTC is the time the Current time.
 * the time in data displayed in two ways, as string and long.
 * @author DanielAbergel
 *
 */
public class MetaDataProject implements Meta_data{
	
	
	long UTC;
	String timeAsString;
	ArrayList<MetaDataLayer> Data ; 
	/**
	 * The Constructor set the time to Current time and Setting up an array
	 * @throws ParseException if there a wrong time format
	 */
	public MetaDataProject() throws ParseException
	{
		setUTC();
		Data = new ArrayList<MetaDataLayer>();
	}
	
	/**
	 * @return the time as long 
	 */
	@Override
	public long getUTC() throws ParseException 
	{
		// TODO Auto-generated method stub
		return UTC;
	}
	/**
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

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * toString method
	 */
	public String toString() {
		Iterator<MetaDataLayer> it = Data.iterator();
		String toString = "{"; 
		while(it.hasNext())
		{
			toString += it.next().toString() + "\n";
		}
		toString += "}\n";
		return toString;
	}

}
