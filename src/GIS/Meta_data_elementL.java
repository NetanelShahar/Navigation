package GIS;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import Geom.Point3D;

public class Meta_data_elementL implements Meta_data{

	@Override
	public long getUTC() {
		 Date date = new Date();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		    Date gmt = new Date(sdf.format(date));
		    return gmt;
		return 0;
	}

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}

}
