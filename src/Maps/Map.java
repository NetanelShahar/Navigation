package Maps;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.xml.ws.Endpoint;

import Coords.MyCoords;
import Game_objects.Packman;
import Geom.Point3D;

public class Map 
{

	private Point3D StartPoint ; 
	private Point3D EndPoint ; 
	private Pixel FrameSize ; 
	public BufferedImage myImage;


	public Map()
	{
		StartPoint =  new Point3D(35.20234,32.10584,0); 
		EndPoint = new Point3D(35.21237,32.10193,0);
		FrameSize = new Pixel(1433, 642);
		StartPoint.GPS2Meter();
		EndPoint.GPS2Meter();
		try {
			myImage = ImageIO.read(new File("Ariel1.PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
//			throw new RuntimeException("The Pixel is out of bounds");
		} 
		return Pix ; 
	}

	private boolean isVaildPixel(Pixel p)
	{
		Pixel PSubtract = FrameSize.Subtract(p) ;
		return PSubtract.get_PixelX() > 0 && PSubtract.get_PixelY() > 0;
	}
	public void ChangeFrameSize(Pixel p , ArrayList<Packman> arr )
	{
		ArrayList<Point3D> change = new ArrayList<Point3D>();
		for (int i = 0; i < arr.size(); i++) {
			change.add(Pixel2GPSPoint(arr.get(i)._PixelLocation.get_PixelX(), arr.get(i)._PixelLocation.get_PixelY()));
		}
		FrameSize.set_PixelX(p.get_PixelX());
		FrameSize.set_PixelY(p.get_PixelY());
		for (int i = 0; i < arr.size(); i++) {
			Pixel temp = GPSPoint2Pixel(change.get(i));
			arr.get(i)._PixelLocation.set_PixelX(temp.get_PixelX());
			arr.get(i)._PixelLocation.set_PixelY(temp.get_PixelY());
			
		}	
	}
}
