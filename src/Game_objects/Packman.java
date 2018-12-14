package Game_objects;

import Geom.GpsPoint;
import Geom.Point3D;
import Maps.Map;
import Maps.Pixel;
import Coords.MyCoords;

public class Packman {

	private int _id;
	public GpsPoint _GPS;
	private Point3D _GPSConvert;
	public Pixel _PixelLocation;
	private int _speed;
	private int _radius;
	public Path path;
	public double _time ; 
	

	public Packman(int id,GpsPoint GpsLocation,int speed,int radius ,Map map)
	{
		path = new Path();
		this._id=id;
		this._GPS=GpsLocation;
		this._speed=speed;
		this._radius=radius;
		_GPSConvert = new Point3D(GpsLocation.getLon(),GpsLocation.getLat(),GpsLocation.getAlt());
		this._PixelLocation = new Pixel(_GPSConvert, map);

	}
	public Packman(int id,Pixel PixelLocation,int speed,int radius,Map map)
	{
		path = new Path();
		this._id=id;
		this._PixelLocation=PixelLocation;
		this._GPSConvert = new Point3D(map.Pixel2GPSPoint(PixelLocation.get_PixelX(),PixelLocation.get_PixelY()));
		this._GPS = new GpsPoint(_GPSConvert);
		this._speed=speed;
		this._radius=radius;
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


		public int getSpeed() {
			return _speed;
		}


		public void setSpeed(int speed) {
			this._speed = speed;
		}


		public int getRadius() {
			return _radius;
		}


		public void setRadius(int radius) {
			this._radius = radius;
		}

		public Point3D GPSConvert() {
			return _GPSConvert;
		}

		public void GPSConvert(Point3D xYZlocation) {
			_GPSConvert = xYZlocation;
		}










	}
