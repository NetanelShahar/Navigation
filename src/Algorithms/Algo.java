package Algorithms;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.crypto.NodeSetData;

import Coords.MyCoords;
import Game_objects.Fruit;
import Game_objects.Packman;
import Game_objects.Path;

public class Algo {
	MyCoords Convert = new MyCoords();
	ComperByDis cbd = new ComperByDis();


	public ArrayList<Path> Short(ArrayList<Packman>  Pack, ArrayList<Fruit> Fruits)
	{
		ArrayList<Fruit> F = new ArrayList<>(Fruits);
		ArrayList<Node> Nodes = new ArrayList<Node>();
		Nodes = init(Nodes, Pack.get(0), Fruits);
		while(!F.isEmpty())
		{
			for (int j = 0; j < Pack.size(); j++) {
				for (int i =0 ; i < F.size(); i++) {
					Iterator<Node> it = Nodes.iterator();
					Nodes.set(3, element)
					it.next() = new Node(3 , Pack.get(i));
					
				}	
			}



		}

		return null  ; 

	}
	private ArrayList<Node> init(ArrayList<Node> Nodes ,Packman pac ,ArrayList<Fruit> fruits)
	{
		for (int i = 0; i < fruits.size(); i++)
		{
			Nodes.add(new Node(distance(pac, fruits.get(i)), pac));
		}
		
		return Nodes;
		
	}
	private double distance(Packman p , Fruit f )
	{
		return Convert.distance2d(p.getGpsLocation(), f.getGpsLocation()) ; 
	}
}
