package GUI;

import Coords.MyCoords;
import Geom.GpsPoint;
import Geom.Point3D;
import Maps.Map;
import Maps.Pixel;

public class Line {
	private GpsPoint startGPS ; 
	public Pixel start;
	public Pixel end;
	private GpsPoint endGPS ;
	private  MyCoords Convert;
	
	public Line(int start_x,int start_y,int end_x,int end_y)
	{
		this.start=new Pixel(start_x, start_y);
		this.end=new Pixel(end_x, end_y);
		Convert = new MyCoords();
		
	}
	public Line(Pixel start , Pixel end , Map map )
	{
		this.startGPS = new GpsPoint(map.Pixel2GPSPoint(start.get_PixelX(), start.get_PixelY()));
		this.start = start ; 
		this.end =  end ; 
		this.endGPS = new GpsPoint(map.Pixel2GPSPoint(end.get_PixelX(), end.get_PixelY()));
		Convert = new MyCoords();
	}

	public Pixel getStart() {
		return start;
	}

	public void setStartR( Map map ) {
		this.start = map.GPSPoint2Pixel(new Point3D(this.startGPS));
	}
	
	public Pixel getEnd() {
		return end;
	}

	public void setEndR( Map map) {
		this.end =  map.GPSPoint2Pixel(new Point3D(this.endGPS));
	}
	
	public double distance() 
	{
		return Convert.distance2d(startGPS, endGPS);
	}
	public Point3D Verctor()
	{
		return Convert.vector3D(new Point3D(startGPS), new Point3D(endGPS));
	}
	public Point3D getGpsStart()
	{
		return new Point3D(startGPS);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return start.toString() + " --> " + end.toString();
	}

}
