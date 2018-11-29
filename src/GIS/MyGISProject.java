package GIS;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;

public class MyGISProject extends HashSet<GIS_layer>  implements GIS_project{
	
	Meta_data MetaDataProject;
	
	public MyGISProject() throws ParseException {
		MetaDataProject = new MetaDataProject();
	}


	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return MetaDataProject;
	}
	
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
