package Game_objects;

import java.util.ArrayList;
import java.util.Iterator;

public class Fruits extends ArrayList<Fruit>{
	
	
	@Override
	public Iterator<Fruit> iterator() {
		// TODO Auto-generated method stub
		return super.iterator();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		 StringBuilder StringB  = new StringBuilder();
		 Iterator<Fruit> it = this.iterator();
		 while(it.hasNext())
		 StringB.append(it.next().toString() + "\n");
		 return StringB.toString();
	}
	
}
