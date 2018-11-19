package Coords;
import Geom.Point3D;

public class MyCoords implements coords_converter  {
	final int earth_r=6371000;
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		// TODO Auto-generated method stub
		Point3D temp=new Point3D(gps.sphericalTOcartesian());
		temp.add(local_vector_in_meter);
		return temp;
	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub

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

		double xy_distance=Math.sqrt(Math.pow(x_meter, 2)+Math.pow(y_meter, 2));

		return Math.sqrt(Math.pow(xy_distance, 2)+Math.pow(diff_z, 2));
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		double b = earth_r + gps1.z();
		double c = earth_r + gps0.z();

		double b2 = b*b;
		double c2 = c*c;
		double bc2 = 2*b*c;

		// Longitudinal calculations
		double alpha = gps1.x() - gps0.x();
		// Conversion to radian
		alpha = alpha * Math.PI / 180;
		// Small-angle approximation
		double cos = 1 - alpha*alpha/2; //Math.cos(alpha);
		// Use the law of cosines / Al Kashi theorem
		double x        = Math.sqrt(b2 + c2 - bc2*cos);

		// Repeat for latitudinal calculations
		alpha = gps1.y() - gps0.y();
		alpha = alpha * Math.PI / 180;
		cos = 1 - alpha*alpha/2; //Math.cos(alpha);
		double y = Math.sqrt(b2 + c2 - bc2*cos);

		// Obtain vertical difference, too
		double z = gps1.z() - gps0.z();

		return new Point3D(x, y, z);
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		//	//	 TODO Auto-generated method stub
		//				Point3D temp0=new Point3D(gps0.sphericalTOcartesian());
		//				Point3D temp1=new Point3D(gps1.sphericalTOcartesian());
		double [] arr=new double[3];
		//		double distance =Math.sqrt(Math.pow(temp1.x()-temp0.x(), 2)+Math.pow(temp1.y()-temp0.y(), 2)+Math.pow(temp1.z()-temp0.z(), 2));
		//		System.out.println(distance);
		//		double plunge=Math.toDegrees(Math.asin((temp1.z()-temp0.z())/distance));
		//		System.out.println(plunge);
		//		double azimuth=Math.toDegrees(Math.atan2(temp1.x()-temp0.x(),temp1.y()-temp0.y()));
		//		System.out.println(azimuth);
		double dy=gps1.x()-gps0.x();
		double dx=gps1.y()-gps0.y();
		double alpha=Math.abs(Math.atan(dy/dx)*(180/Math.PI));
		
		double azimuth;
		if(dx<0&&dy<0)
			azimuth=180+alpha;
		else if(dx<0&&dy>0)
			azimuth=180-alpha;
		else if(dx>0&&dy<0)
			azimuth=360-alpha;
		else
			azimuth=alpha;
		System.out.println(azimuth);

		return arr;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		// TODO Auto-generated method stub
		return false;
	}


}
