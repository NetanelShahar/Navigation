package Maps;

import Geom.GpsPoint;
import Geom.Point3D;

public class Pixel {
	
	private double _PixelX;
	private double _PixelY;
	Map map ;
	
	public  Pixel(double PixelX , double PixelY){
		set_PixelX(PixelX);
		set_PixelY(PixelY);
	}

	public Pixel(Point3D xYZlocation) {
		map = new Map();
		Pixel temp = map.GPSPoint2Pixel(xYZlocation);
		set_PixelX(temp._PixelX);
		set_PixelY(temp._PixelY);
	}

	public double get_PixelX() {
		return _PixelX;
	}

	public void set_PixelX(double _PixelX) {
		this._PixelX = _PixelX;
	}

	public double get_PixelY() {
		return _PixelY;
	}

	public void set_PixelY(double _PixelY) {
		this._PixelY = _PixelY;
	}
	
	public Pixel Subtract(Pixel p)
	{
		return new Pixel(this._PixelX-p.get_PixelX(), this._PixelY-p.get_PixelY());
	}
	public Pixel Add(Pixel p)
	{
		return new Pixel(this._PixelX+p.get_PixelX(), this._PixelY+p.get_PixelY());
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this._PixelX  + " , " + this._PixelY;
	}
	
}
