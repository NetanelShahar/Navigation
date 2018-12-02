package GIS;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;
/**
 * This class represent a collection(Layers) with data in the KML ( the collection is a HashSet).
 * the class The department has two fields:
 * META DATA(a MetaDataLayer class is an collection of points(layers(points collection)) and HashSet(GIS_Layer)
 * @author DanielAbergel
 */
public class MyGISProject extends HashSet<GIS_layer>  implements GIS_project{
	
	Meta_data MetaDataProject;
	
	/**
	 * The Constructor SETUP The Meta_Data . 
	 * @throws ParseException if there a wrong time format
	 */
	public MyGISProject() throws ParseException {
		MetaDataProject = new MetaDataProject();
	}

	/**
	 * @return the Meta_Data collection  .
	 */
	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return MetaDataProject;
		
	}
	/**
	 * @return the Meta_Data collection  .
	 */
	public MetaDataProject getData()
	{
		return (GIS.MetaDataProject) MetaDataProject;
	}
	/**
	 * toString method.
	 */
	public String toString()
	{
		Iterator<GIS_layer> it = this.iterator();
		String toString = "{\n"; 
		while(it.hasNext())
		{
			toString += it.next().toString() + "\n";
		}
		toString += "}\n";
		return toString;
	}

}
