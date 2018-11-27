package GIS;

import Geom.Geom_element;
import Geom.Point3D;
import Geom.GpsPoint;

public class GIS_elementL implements GIS_element {
	GpsPoint GPS ;
	Meta_data_elementL Meta_dataElement;
	

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
