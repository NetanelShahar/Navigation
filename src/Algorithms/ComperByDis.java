package Algorithms;

import java.util.Comparator;

import Game_objects.Packman;

public class ComperByDis implements Comparator<PackManNode>{
	
	@Override
	public int compare(PackManNode n1, PackManNode n2)
	{
		if(n1.get_dis() > n2.get_dis())
			return 1;
		else if(n1.get_dis() == n2.get_dis())
			return 0;
		else
			return -1;
	}	
}

