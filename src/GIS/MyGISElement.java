package GIS;

import java.text.ParseException;

import Geom.Geom_element;
import Geom.Point3D;
import Geom.GpsPoint;
/**
 * This class represent a Point with data in the KML.
 * the class The department has two fields:
   GPS(Point:lat,lon,alt) and META DATA(type,acc,Mac,timeAndDate .. ) 
 * @author DanielAbergel
 *
 */
public class MyGISElement implements GIS_element {
	
	GpsPoint GPS ;
	Meta_data Meta_dataElement;
	/**
	 * The Constructor SETUP The GPS point and Meta_Data . 
	 * @param ElementAsString represent the a String with the Point and data .
	 * @throws ParseException if there a wrong time format
	 */
	public MyGISElement(String ElementAsString) throws ParseException
	{
		String[] CSVSplit = ElementAsString.split(",");
		GPS = new GpsPoint(Double.parseDouble(CSVSplit[6]), Double.parseDouble(CSVSplit[7]), Double.parseDouble(CSVSplit[8]));
		Meta_dataElement = new MetaDataElement(CSVSplit[3], CSVSplit[1], CSVSplit[10], CSVSplit[0], CSVSplit[9]);
	}
	/**
	 * @return the GPS Point of the Current element
	 */
	public GpsPoint GPS() {
		return GPS;
	}
	/**
	 * @return the GPS Point of the Current element
	 */
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
	/**
	 * toString method.
	 */
	public String toString() {
		return GPS.toString() + "," + Meta_dataElement.toString();
	}

}
