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

public class MetaDataLayer implements Meta_data
{
	private long UTC ; 
	private String timeAsString;
	private ArrayList<MetaDataElement> Data ;
	
	
	public MetaDataLayer() throws ParseException 
	{
		setUTC();
		Data = new ArrayList<MetaDataElement>();
		
	}
	
	public void push(MetaDataElement DataElement) 
	{
		Data.add(DataElement);
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
	public long getUTC() throws ParseException {
			
		return UTC;
	}

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}
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
