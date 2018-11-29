package GIS;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class MyGISLayer extends HashSet<GIS_element> implements GIS_layer{
	
	Meta_data metaDataLayer ; 
	
	public MyGISLayer() throws ParseException 
	{
		metaDataLayer = new MetaDataLayer();
	}
	
	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return metaDataLayer;
	}
	
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
