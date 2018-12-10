package Game_objects;

import Geom.GpsPoint;
import Geom.Point3D;
import Maps.Map;
import Maps.Pixel;

public class Fruit {

	private int _id;
	private int _value;
	private GpsPoint _GPS; 
	private Point3D _GPSConvert;
	private Pixel _PixelLocation;
	
	
	public Fruit(int id,GpsPoint GpsLocation,int value , Map map)
	{
		this._id=id;
		this._GPS=GpsLocation;
		this._value=value;
		_GPSConvert = new Point3D(GpsLocation.getLon(),GpsLocation.getLat(),GpsLocation.getAlt());
		this._PixelLocation = new Pixel(_GPSConvert, map);
	}
	public Fruit(int id,Pixel PixelLocation,int value, Map map)
	{
		this._id=id;
		this._PixelLocation=PixelLocation;
		this._value=value;
		this._GPSConvert = new Point3D(map.Pixel2GPSPoint(PixelLocation.get_PixelX(),PixelLocation.get_PixelY()));
		this._GPS = new GpsPoint(_GPSConvert);
	}
	public Point3D _GPSConvert() {
		return _GPSConvert;
	}

	public void _GPSConvert(Point3D xYZlocation) {
		_GPSConvert = xYZlocation;
	}

	public int getId() {
		return _id;
	}


	public void setId(int id) {
		this._id = id;
	}


	public GpsPoint getGpsLocation() {
		return _GPS;
	}


	public void setGpsLocation(GpsPoint gpsLocation) {
		this._GPS = gpsLocation;
	}


	public Pixel getPixelLocation() {
		return _PixelLocation;
	}


	public void setPixelLocation(Pixel pixelLocation) {
		this._PixelLocation = pixelLocation;
	}


	public int getValue() {
		return _value;
	}


	public void setValue(int value) {
		this._value = value;
	}
}
