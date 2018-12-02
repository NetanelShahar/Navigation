package GIS;

import java.text.ParseException;

import Geom.Geom_element;
import Geom.Point3D;
import Geom.GpsPoint;

public class MyGISElement implements GIS_element {
	
	GpsPoint GPS ;
	Meta_data Meta_dataElement;
	
	public MyGISElement(String ElementAsString) throws ParseException
	{
		String[] CSVSplit = ElementAsString.split(",");
		GPS = new GpsPoint(Double.parseDouble(CSVSplit[6]), Double.parseDouble(CSVSplit[7]), Double.parseDouble(CSVSplit[8]));
		Meta_dataElement = new MetaDataElement(CSVSplit[3], CSVSplit[1], CSVSplit[10], CSVSplit[0], CSVSplit[9]);
	}
	public GpsPoint GPS() {
		return GPS;
	}
	@Override
	public Geom_element getGeom() {
		return GPS;
	}

	@Override
	public Meta_data getData() {
		return Meta_dataElement;
	}

	@Override
	public void translate(Point3D vec)
	{
		
	}
	public String toString() {
		return GPS.toString() + "," + Meta_dataElement.toString();
	}

}
