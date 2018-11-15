package Coords;

import Geom.Point3D;

public class as {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyCoords a=new MyCoords();
		Point3D gps0=new Point3D(32.103315,35.209039,670);
		Point3D gps1=new Point3D(32.106352,35.205225,650);
		double e=a.distance3d(gps0, gps1);
	}

}
