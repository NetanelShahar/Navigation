package Coords;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Geom.Point3D;

class MyCoordsTest {

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testDistance3d()
	{
		MyCoords a=new MyCoords();
		Point3D gps0=new Point3D(32.103315,35.209039,670);
		Point3D gps1=new Point3D(32.106352,35.205225,650);
		
		if(a.distance3d(gps0, gps1)!=493.0523318324134)
			fail("Not yet implemented");
	}

	@Test
	void testVector3D() {
		fail("Not yet implemented");
	}

	@Test
	void testAzimuth_elevation_dist() {
		fail("Not yet implemented");
	}

	@Test
	void testIsValid_GPS_Point() {
		fail("Not yet implemented");
	}

}
