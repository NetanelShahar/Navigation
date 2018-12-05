package Game_objects;

import Geom.GpsPoint;
import Maps.Pixel;

public class Packman {
	
	private int id;
	private GpsPoint gpsLocation;
	private Pixel pixelLocation;
	private int speed;
	private int radius;
	
	
	public Packman(int id,GpsPoint gpsLocation,int speed,int radius)
	{
		this.id=id;
		this.gpsLocation=gpsLocation;
		this.speed=speed;
		this.radius=radius;

	}
	
	
	
	
	
	
}
