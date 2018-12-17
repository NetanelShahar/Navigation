package Algorithms;
import java.util.Comparator;
import Game_objects.Fruit; 
public class CompareFruits implements Comparator<Fruit>{

	@Override
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
