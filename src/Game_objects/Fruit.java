package Game_objects;

import Geom.GpsPoint;
import Geom.Point3D;
import Maps.Pixel;

public class Fruit {

	private int id;
	private GpsPoint gpsLocation;
	private Point3D XYZlocation;
	private Pixel pixelLocation;
	
	public Fruit(int id,GpsPoint gpsLocation,int value)
	{
		this.id=id;
		this.gpsLocation=gpsLocation;
		this.value=value;
		this.XYZlocation=new Point3D(gpsLocation.getLat(),gpsLocation.getLon(),gpsLocation.getAlt()).GPS2Meter();

	}
	
	public Point3D getXYZlocation() {
		return XYZlocation;
	}

	public void setXYZlocation(Point3D xYZlocation) {
		XYZlocation = xYZlocation;
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


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	private int value;


	

}
