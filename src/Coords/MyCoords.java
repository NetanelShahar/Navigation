package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter  {

	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		int earth_r=6371000;
		double lon_norm=Math.cos(gps0.x()*(Math.PI/180));
		System.out.println(lon_norm);

		gps0=new Point3D(32.103315,35.209039,670);
		gps1=new Point3D(32.106352,35.205225,650);
		
		double diff_x=gps1.x()-gps0.x();
		double diff_y=gps1.y()-gps0.y();
		double diff_z=gps1.z()-gps0.z();
		
		double diff_rad_x=diff_x*(Math.PI/180);
		double diff_rad_y=diff_y*(Math.PI/180);
		
		double x_meter=Math.sin(diff_rad_x)*earth_r;
		double y_meter=Math.sin(diff_rad_y)*earth_r*lon_norm;
		
		double xy_distance=Math.sqrt(x_meter*x_meter+y_meter*y_meter);
		
		return xy_distance;
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		// TODO Auto-generated method stub
		return false;
	}

}
