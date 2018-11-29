package GIS;

import Geom.Geom_element;
import Geom.Point3D;
import Geom.GpsPoint;

public class MyGISElement implements GIS_element {
	GpsPoint GPS ;
	MyMetaData Meta_dataElement;
	

	@Override
	public Geom_element getGeom() {
		return GPS;
	}

	@Override
	public Meta_data getData() {
		return Meta_dataElement;
	}

	@Override
	public void translate(Point3D vec) {
		
	}

}
