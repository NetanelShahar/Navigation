package Game_objects;

import java.util.ArrayList;
import java.util.Iterator;

public class Packmans extends ArrayList<Packman> {




	@Override
	public Iterator<Packman> iterator() {
		// TODO Auto-generated method stub
		return super.iterator();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		 StringBuilder StringB  = new StringBuilder();
		Iterator<Packman> it= this.iterator();
		 while(it.hasNext())
		 StringB.append(it.next().toString() + "\n");
		 
		return StringB.toString();
	}
	
	public static void main(String[] args) {
		StringBuilder S = new StringBuilder();
		S.append("HELLO WORLD ");
		S.append("HELLO WORLD ");
		S.append("HELLO WORLD ");
		S.append("HELLO WORLD ");
		
		System.out.println(S.toString());
	}
}
