package Coords;
import Coords.MyCoords;
import Geom.Point3D;

public class as {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyCoords a=new MyCoords();
		Point3D gps0=new Point3D(32.103315,35.209039,670);
		Point3D gps1=new Point3D(32.106352,35.205225,650);

//		Point3D gps0=new Point3D(100,170,1.5);
//		Point3D gps1=new Point3D(150,120,1.6);

		//		Point3D e=a.vector3D(gps0, gps1);
		//		System.out.println(e.toString());
		double[] b =a.azimuth_elevation_dist(gps0, gps1);

		//b=azimuth_elevation_dist(gps0,gps1);
		

	}
}

