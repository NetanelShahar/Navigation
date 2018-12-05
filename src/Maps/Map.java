package Maps;

import java.util.Arrays;

import javax.xml.ws.Endpoint;

import Coords.MyCoords;
import Geom.Point3D;

public class Map 
{
	
	private Point3D StartPoint ; 
	private Point3D EndPoint ; 
	private Pixel FrameSize ; 
	
	
	public Map()
	{
		
		StartPoint =  new Point3D(35.20234,32.10584,0); 
		EndPoint = new Point3D(35.21237,32.10193,0);
		FrameSize = new Pixel(1433, 642);
		StartPoint.GPS2Meter();
		EndPoint.GPS2Meter();
		
	}

	public static void main(String[] args) 
	{
		Map m = new Map();
		//		Point3D p = m.Pixel2GPSPoint( 800, 500);
		Point3D Point = new Point3D(35.21237,32.10193,0);
		Pixel p = m.GPSPoint2Pixel(Point);
				System.out.println(p);

	}


	public  Point3D Pixel2GPSPoint( double PixelXMove , double PixelYMove )
	{
		Pixel  p  =  Pixel2Meter(FrameSize.get_PixelX(), FrameSize.get_PixelY());
		PixelXMove = PixelXMove * p.get_PixelX(); 
		PixelYMove = PixelYMove * p.get_PixelY();
		Point3D result = new Point3D(PixelXMove + StartPoint.x(),PixelYMove + StartPoint.y(),0);
		result.Meter2GPS();
		return result ;
	}

	private Pixel Pixel2Meter(double PixelXSize , double PixelYSize )
	{

		
		double disX = EndPoint.x() - StartPoint.x() ;
		double disY = EndPoint.y() - StartPoint.y();
		double PixelAsMeterX = disX / PixelXSize ; 
		double PixelAsMeterY = disY / PixelYSize ;
		Pixel _Pixel = new Pixel(PixelAsMeterX, PixelAsMeterY);
		return _Pixel ;
	}

	public  Pixel GPSPoint2Pixel(Point3D Point)
	{
		Point.GPS2Meter();
		Pixel  Worth  =  Pixel2Meter(FrameSize.get_PixelX(), FrameSize.get_PixelY());
		double disX = Point.x() - StartPoint.x() ;
		double disY = Point.y() - StartPoint.y();
		double dx = disX / Worth.get_PixelX() ; 
		double dy = disY / Worth.get_PixelY() ; 
		Point.Meter2GPS();
		Pixel Pix = new Pixel(dx, dy);
		if(isVaildPixel(Pix)) 
		return Pix ; 
		else 
		{
			throw new RuntimeException("The Pixel is out of bounds");
		}
	}

	private boolean isVaildPixel(Pixel p)
	{
		Pixel PSubtract = FrameSize.Subtract(p) ;
		return PSubtract.get_PixelX() > 0 && PSubtract.get_PixelY() > 0;
	}


}
