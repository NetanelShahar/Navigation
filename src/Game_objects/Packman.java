package Game_objects;

import Geom.GpsPoint;
import Geom.Point3D;
import Maps.Pixel;
import Coords.MyCoords;

public class Packman {

	private int id;
	private GpsPoint gpsLocation;
	private Point3D XYZlocation;
	private Pixel pixelLocation;
	private int speed;
	private int radius;

	public Packman(int id,GpsPoint gpsLocation,int speed,int radius)
	{

		this.id=id;
		this.gpsLocation=gpsLocation;
		this.speed=speed;
		this.radius=radius;
		this.XYZlocation=new Point3D(gpsLocation.getLat(),gpsLocation.getLon(),gpsLocation.getAlt()).GPS2Meter();

	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public GpsPoint getGpsLocation() {
		return gpsLocation;
	}


	public void setGpsLocation(GpsPoint gpsLocation) {
		this.gpsLocation = gpsLocation;
	}


	public Pixel getPixelLocation() {
		return pixelLocation;
	}


	public void setPixelLocation(Pixel pixelLocation) {
		this.pixelLocation = pixelLocation;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getRadius() {
		return radius;
	}


	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Point3D getXYZlocation() {
		return XYZlocation;
	}

	public void setXYZlocation(Point3D xYZlocation) {
		XYZlocation = xYZlocation;
	}










}
