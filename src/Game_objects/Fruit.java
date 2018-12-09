package Game_objects;

import Geom.GpsPoint;
import Geom.Point3D;
import Maps.Map;
import Maps.Pixel;

public class Fruit {

	private int id;
	private GpsPoint gpsLocation;
	private Point3D XYZlocation;
	private Pixel pixelLocation;
	public Point3D p ; 
	
	public Fruit(int id,GpsPoint gpsLocation,int value)
	{
		this.id=id;
		this.gpsLocation=gpsLocation;
		this.value=value;
		p = new Point3D(gpsLocation.getLon(),gpsLocation.getLat(),gpsLocation.getAlt());
		
		this.XYZlocation=new Point3D(gpsLocation.getLat(),gpsLocation.getLon(),gpsLocation.getAlt()).GPS2Meter();
		this.pixelLocation = new Pixel(p);
	}
	public Fruit(int id,Pixel pixelLocation,int value)
	{
		Map map=new Map();
		this.id=id;
		this.pixelLocation=pixelLocation;
		this.value=value;
		this.gpsLocation=new GpsPoint(map.Pixel2GPSPoint(pixelLocation.get_PixelX(),pixelLocation.get_PixelY()).x(),map.Pixel2GPSPoint(pixelLocation.get_PixelX(),pixelLocation.get_PixelY()).y(),0);

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
