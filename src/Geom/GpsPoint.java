package Geom;
import  Coords.MyCoords;
public class GpsPoint implements Geom_element {
	
	private double _lat;
	private double _lon;
	private double _alt;
	
	
	public GpsPoint(double lat , double lon , double alt) 
	{
		if(!IsValid()) 
		{
			throw new RuntimeException("the gps Point not valid GpsPoint");
		}
		this._lat = lat;
		this._lon = lon;
		this._alt = alt;
		
	}
	public boolean IsValid() {
		return this._lat<90&&this._lat>-90&&this._lon>-180&&this._lon<180&&this._alt>-450;
	}
	public double getAlt() {
		return _alt;
	}
	
	public void setAlt(double alt) 
	{
		this._alt = alt;
	}
	
	public double getLon()
	{
		return _lon;
	}
	
	public void setLon(double lon)
	{
		this._lon = lon;
	}
	
	public double getLat() 
	{
		return _lat;
	}
	
	public void setLat(double lat)
	{
		this._lat = lat;
	}
	
	@Override
	public double distance3D(Point3D p) 
	{
		return 0;
	}
	@Override
	public double distance2D(Point3D p)
	{
		return 0;
	}

}
