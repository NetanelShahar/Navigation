package Algorithms;

import java.util.Comparator;

import Game_objects.Packman;

public class ComperByDis implements Comparator<Node>{
	
	@Override
	public int compare(Node n1, Node n2)
	{
		if(n1.get_dis() > n2.get_dis())
			return 1;
		else if(n1.get_dis() == n2.get_dis())
			return 0;
		else
			return -1;
	}	
}

