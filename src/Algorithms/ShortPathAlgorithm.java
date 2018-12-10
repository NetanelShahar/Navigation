package Algorithms;

import java.io.IOException;
import java.util.ArrayList;

import Coords.MyCoords;
import File_format.CSV2Game;
import GUI.Line;
import Game_objects.Fruit;
import Game_objects.Packman;
import Game_objects.Path;
import Maps.Map;

public class ShortPathAlgorithm {
	static MyCoords Convert = new MyCoords();
	
	public static ArrayList<Path> Short(ArrayList<Packman> packs , ArrayList<Fruit> Fruits, Map map)
	{
		ArrayList<Path> Path = new ArrayList<Path>();
		PackManNode Max = new PackManNode(Double.MAX_VALUE , packs.get(0) , Fruits.get(0));
		double time = 0 ; 
		while(!Fruits.isEmpty())
		{
			for (int i = 0; i < packs.size(); i++) {
				for (int j = 0; j < Fruits.size(); j++) 
				{
					time = Time(packs.get(i), Fruits.get(j), map);
					if(time+packs.get(i)._time < Max.time)
					{
						Max.time = time+packs.get(i)._time;
						Max._pacman = packs.get(i);
						Max.fruit = Fruits.get(j);
						Max.fruitindex = j ; 
					}
					time = 0 ; 
				}
			}
			Max._pacman.path.Lines.add(new Line(Max._pacman.getPixelLocation(),Max.fruit.getPixelLocation()));
			Max._pacman._time += Time(Max._pacman, Max.fruit, map);
			Max._pacman.setPixelLocation(Fruits.get(Max.fruitindex).getPixelLocation());
			Fruits.remove(Max.fruitindex);
			if(!Fruits.isEmpty())
			Max.init(Fruits.get(0));
		}
		for (int i = 0; i < packs.size(); i++)
		{
			Path.add(packs.get(i).path);
			System.out.println();
		}
		
		
		
		
		return Path ; 
	}
	
	private static double Time (Packman p , Fruit f , Map map)
	{
		double dist_closestFruit=Convert.distance2d(p.getGpsLocation(),f.getGpsLocation())/p.getSpeed();
		return dist_closestFruit;
	}
	
	public static void main(String[] args) throws IOException 
	{
		Map m = new Map();
		CSV2Game g = new CSV2Game("C:\\Users\\דניאל\\Desktop\\מדעי המחשב\\מונחה עצמים\\Ex2-4\\Ex3\\data\\game_1543684662657.csv",m);
		
		ArrayList<Path> path = Short(g.packmanList, g.fruitList, m);
		
		for (int i = 0; i < path.size(); i++) {
			System.out.println(path.get(i));
		}
 
	}
}
