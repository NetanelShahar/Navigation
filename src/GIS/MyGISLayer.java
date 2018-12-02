package GIS;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/**
 * This class represent a collection(Point) with data in the KML ( the collection is a HashSet).
 * the class The department has two fields:
 * META DATA(a MetaDataLayer class is an collection of points(elements)) and HashSet(GIS_Element)
 * @author DanielAbergel
 *
 */
public class MyGISLayer extends HashSet<GIS_element> implements GIS_layer{
	
	Meta_data metaDataLayer ; 
	
	/**
	 * The Constructor SETUP The Meta_Data . 
	 * @throws ParseException if there a wrong time format
	 */
	public MyGISLayer() throws ParseException 
	{
		metaDataLayer = new MetaDataLayer();
	}
	/**
	 * @return the Meta_Data collection  .
	 */
	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return metaDataLayer;
	}
	/**
	 * toString method.
	 */
	public String toString()
	{
		Iterator<GIS_element> it = this.iterator();
		String toString = "[\n"; 
		while(it.hasNext())
		{
			toString += it.next().toString() + "\n";
		}
		toString += "]";
		return toString;
	}

}
