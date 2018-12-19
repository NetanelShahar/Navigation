package Algorithms;
import java.util.Comparator;
import Game_objects.Fruit; 
/**
 * This class compare between the values of two fruits.
 * @author Netanel Ben-Isahar
 * @author daniel abargel
 *
 */
public class CompareFruits implements Comparator<Fruit>{

	@Override
	/**
	 * This function compare between the values of two fruit.
	 * @param s1 represent the first fruit.
	 * @param s2 represent the second fruit.
	 * @return 0 if the values are equals, -1 if the value of the first fruit is bigger and 1 otherwise.
	 */
	public int compare(Fruit s1, Fruit s2)
	{
		if(s1._value > s2._value)
			return -1;
		else if(s1._value == s2._value)
			return 0;
		else
			return 1;
	}
}
