package Game_objects;

import java.util.ArrayList;

import GUI.Line;

public class Path {
	
	public ArrayList<Line> Lines ; 
	
	public Path() 
	{
		// TODO Auto-generated constructor stub
		Lines = new ArrayList<Line> ();
	}
	
	@Override
	public String toString() {
		String toString = "";
		for (int i = 0; i < Lines.size(); i++) {
			toString += " --> " +Lines.get(i).toString();
		}
		return toString;
	}
	

}
