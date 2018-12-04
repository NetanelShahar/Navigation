package Coords;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Geom.Point3D;

class MyCoordsTest {

	@Test
	void testAdd() {
		MyCoords p=new MyCoords();
		Point3D p1=new Point3D(32.103315,35.209039,670);
		Point3D p2=new Point3D(32.106352,35.205225,650);
		p1.add(p2);
		if (!p1.equals(new Point3D(64.209667,70.414264,1320.0)))
			fail("The point p2 and the point ans sould be equals");
	}
	@Test
	void testDistance2d() {
		MyCoords p=new MyCoords();
		Point3D p1=new Point3D(32.103315,35.209039,670);
		Point3D p2=new Point3D(32.106352,35.205225,650);
		double ans= p.distance2d(p1, p2);
		if (ans>493.06 || ans<493.05)
			fail("The distance 2D between the two points sould be 493.0523");
	}
	@Test

	void testDistance3d() {
		MyCoords p=new MyCoords();
		Point3D p1=new Point3D(32.103315,35.209039,670);
		Point3D p2=new Point3D(32.106352,35.205225,650);
		double ans= p.distance3d(p1, p2);
		if (ans>493.46 || ans<493.45)
			fail("The distance 3D between the two points sould be 493.4578");
	}

	@Test
	void testVector3D() {
		MyCoords p=new MyCoords();
		Point3D p1=new Point3D(32.103315,35.209039,670);
		Point3D p2=new Point3D(32.103315,35.209039,670);
		Point3D vec=new Point3D(0.0,0.0,0.0);
		Point3D ans= p.vector3D(p1, p2);
		if (!ans.equals(vec))
			fail("The point vec and the point ans should be the equals");
	}

	@Test
	void testAzimuth_elevation_dist() {
		MyCoords p=new MyCoords();
		Point3D p1=new Point3D(32.103315,35.209039,670);
		Point3D p2=new Point3D(32.106352,35.205225,650);
		double[] ans = p.azimuth_elevation_dist(p1, p2);
		double azi= ans[0];
		double elev= ans[1];
		System.out.println(azi);
		double dis= ans[2];
		if (azi!=313.23042032646896||elev!=-89.98603287888018)
			fail("The azimouth or the elevation or the distance are not correct");
		//
	}


	@Test
	void testIsValid_GPS_Point() {
		MyCoords p=new MyCoords();
		Point3D p1=new Point3D(32.106352,35.205225,650);
		if (!p.isValid_GPS_Point(p1))
			fail("This point gps sould be valid");
	}

}
