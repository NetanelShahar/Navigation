package Game;

import java.util.Arrays;

import Geom.Point3D;

public class Map 
{

	public static void main(String[] args) 
	{
		Point3D P0 = new Point3D(35.20234,32.10584,0);
		Point3D P1 = new Point3D(35.21237,32.10193,0);
		P0.GPS2Meter();
		P1.GPS2Meter();
		double disX = P1.x() - P0.x() ;
		double disY = P1.y() - P0.y();
		double PixelsizeX  =1433 ; 
		double PixelsizeY = 642 ;
		double PixelAsMeterX = disX / PixelsizeX ; 
		double PixelAsMeterY = disY / PixelsizeY ;
		Point3D p = Calculate1(500, 500, PixelAsMeterX, PixelAsMeterY, P0);
		System.out.println(p);

		//		
		//		double y1 = 32.10584;
		//		double x1 = 35.20234;
		//		double x2 = 35.21237;
		//		double y2 = 32.10193;
		//		
		//		double[] xy1arr =  GPS2Meter(x1, y1);
		//		double[] xy2arr =  GPS2Meter(x2, y2);
		//		double disX = xy2arr[0] - xy1arr[0];
		//		double disY = xy2arr[1] - xy1arr[1];
		//		double PixelsizeX  =1433 ; 
		//		double PixelsizeY = 642 ;
		//		double PixelAsMeterX = disX / PixelsizeX ; 
		//		double PixelAsMeterY = disY / PixelsizeY ;
		//		double[] h = Calculate(500, 642, PixelAsMeterX, PixelAsMeterY, xy1arr);
		//		System.out.println(Arrays.toString(h));
		//		System.out.println(Arrays.toString(Meter2GPS(h[0], h[1])));




	}
	
	
	public static Point3D Calculate1(double PixelX , double PixelY , double PixelAsMeterX ,double PixelAsMeterY , Point3D p)
	{
		PixelX = PixelX * PixelAsMeterX ; 
		PixelY = PixelY * PixelAsMeterY;
		p = new Point3D(PixelX + p.x(),PixelY + p.y(),0);
		p.Meter2GPS();
		return p ;
	}
	public static double[] Calculate(double x , double y , double PixelAsMeterX ,double PixelAsMeterY , double[]  xy0arr)
	{
		double X = x *PixelAsMeterX ; 
		double Y = y * PixelAsMeterY;
		double[] h = new double[2];
		h[0] = xy0arr[0] + X; 
		h[1] = xy0arr[1] + Y;

		return h ;
	}

	public static double[] Meter2GPS(double _x , double _y)
	{
		_x=_x/6371000;
		_y=(_y/6371000)/0.847091174;
		_x=Math.asin(_x);
		_y=Math.asin(_y);
		_x=Math.toDegrees(_x);
		_y=Math.toDegrees(_y);
		double[] h = new double[2];
		h[0] = _x ; 
		h[1] = _y;
		return h ;
	}

	public static double[] GPS2Meter(double _x , double _y)
	{
		_x=Math.toRadians(_x);// X From GPS To Rad
		_y=Math.toRadians(_y);// Y From GPS To Rad
		_x=Math.sin(_x)*6371000;
		_y=Math.sin(_y)*6371000*0.847091174;
		double[] h = new double[2];
		h[0] = _x ; 
		h[1] = _y;
		return h ;
	}
}
