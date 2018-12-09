package Algorithms;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.crypto.NodeSetData;

import Coords.MyCoords;
import Game_objects.Fruit;
import Game_objects.Packman;
import Game_objects.Path;
import Maps.Map;

public class Algo {
	MyCoords Convert = new MyCoords();
	ComperByDis cbd = new ComperByDis();
	Map map=new Map();


	public ArrayList<Path> Short(ArrayList<Packman> Packmans , ArrayList<Fruit> Fruits)
	{
		ArrayList<PackmanTOfruit> pacmanTOfruit=new ArrayList<PackmanTOfruit>();
		while(Fruits.size()!=0)
		{
			for(int i=0;i<Packmans.size();++i)
			{
				double dist_closestFruit=Convert.distance2d(Packmans.get(i).getGpsLocation(),Fruits.get(0).getGpsLocation())/Packmans.get(i).getSpeed();
				Fruit closestFruit=Fruits.get(0);
				for (int j=1;j<Fruits.size();++i)
				{
					double currentFruit=Convert.distance2d(Packmans.get(i).getGpsLocation(),Fruits.get(j).getGpsLocation())/Packmans.get(i).getSpeed();
					if(currentFruit<dist_closestFruit)
					{
						dist_closestFruit=currentFruit;
						closestFruit=Fruits.get(j);
					}
					
				}
				pacmanTOfruit.add(Packmans.get(i),closestFruit);
				
			}


		}


		return null;
	}













	//	public ArrayList<Path> Short(ArrayList<Packman>  Pack, ArrayList<Fruit> Fruits)
	//	{
	//		ArrayList<Fruit> F = new ArrayList<>(Fruits);
	//		ArrayList<Node> Nodes = new ArrayList<PackManNode>();
	//		Nodes = init(Nodes, Pack.get(0), Fruits);
	//		while(!F.isEmpty())
	//		{
	//			for (int j = 0; j < Pack.size(); j++) {
	//				for (int i =0 ; i < F.size(); i++) {
	//					Iterator<Node> it = Nodes.iterator();
	//					Nodes.set(3, element)
	//					it.next() = new Node(3 , Pack.get(i));
	//					
	//				}	
	//			}
	//
	//
	//
	//		}
	//
	//		return null  ; 
	//
	//	}
	//	private ArrayList<Node> init(ArrayList<Node> Nodes ,Packman pac ,ArrayList<Fruit> fruits)
	//	{
	//		for (int i = 0; i < fruits.size(); i++)
	//		{
	//			Nodes.add(new Node(distance(pac, fruits.get(i)), pac));
	//		}
	//		
	//		return Nodes;
	//		
	//	}
	//	private double distance(Packman p , Fruit f )
	//	{
	//		return Convert.distance2d(p.getGpsLocation(), f.getGpsLocation()) ; 
	//	}





}
