package Algorithms;
import java.util.Comparator;
import Game_objects.Fruit;
import Game_objects.Packman; 
/**
 * This class compare between the values of two fruits.
 * @author Netanel Ben-Isahar
 * @author daniel abargel
 *
 */
public class ComparePackmanTime implements Comparator<Packman>{

	@Override
	/**
	 * This function compare between the values of two fruit.
	 * @param s1 represent the first fruit.
	 * @param s2 represent the second fruit.
	 * @return 0 if the values are equals, -1 if the value of the first fruit is bigger and 1 otherwise.
	 */
	public int compare(Packman s1, Packman s2)
	{
		if(s1._time > s2._time)
			return -1;
		else if(s1._time == s2._time)
			return 0;
		else
			return 1;
	}
}
