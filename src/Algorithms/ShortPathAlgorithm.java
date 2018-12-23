package Algorithms;

import java.io.IOException;
import java.util.ArrayList;

import Coords.MyCoords;
import File_format.CSV2Game;
import GUI.Line;
import Game_objects.Fruit;
import Game_objects.Game;
import Game_objects.Packman;
import Game_objects.Path;
import Geom.GpsPoint;
import Maps.Map;
/**
 * 
 * @author Netanel Ben-Isahar
 * @author daniel abargel
 * 
 * this class calculate the path of every pacman using this algorithm.
 */
public class ShortPathAlgorithm {

	static MyCoords Convert = new MyCoords();
	public Game game;

	/**
	 * this constructor using a game data for the algorithm.
	 * @param game represent the game.
	 */
	public ShortPathAlgorithm(Game game)
	{
		this.game=game;
	}

	/**
	 * this function calculate the fastest way to finish all of the fruits in game.
	 * @param game represent the game.
	 * @param map represent the map.
	 * @return a arraylist of path of every packman.
	 */
	public static ArrayList<Path> Short(Game game, Map map)
	{

		ArrayList<Path> Path = new ArrayList<Path>();
		ArrayList<Fruit> TempFruits = new ArrayList<Fruit>(game.fruits);
		if(!TempFruits.isEmpty() && !game.packmans.isEmpty()) {
			PackManNode Max = new PackManNode(Double.MAX_VALUE , game.packmans.get(0) , TempFruits.get(0));
			double time = 0 ; 
			while(!TempFruits.isEmpty())
			{
				for (int i = 0; i < game.packmans.size(); i++) {
					for (int j = 0; j < TempFruits.size(); j++) 
					{
						time = Time(game.packmans.get(i), TempFruits.get(j), map);
						if(time+game.packmans.get(i)._time < Max.time)
						{
							Max.time = time+game.packmans.get(i)._time;
							Max._pacman = game.packmans.get(i);
							Max.fruit = TempFruits.get(j);
							Max.fruitindex = j ; 
						}
						time = 0 ; 
					}
				}
				Max._pacman.path.Lines.add(new Line(Max._pacman.getPixelLocation(),Max.fruit.getPixelLocation(),game.GameMap));
				Max._pacman._time += Time(Max._pacman, Max.fruit, map);
				Max._pacman.setPixelLocation(TempFruits.get(Max.fruitindex).getPixelLocation(),game.GameMap);
				Max._pacman.setGpsLocation(new GpsPoint(map.Pixel2GPSPoint(Max._pacman.getPixelLocation().get_PixelX(), Max._pacman.getPixelLocation().get_PixelY())));
				Max.fruit.SetEatenTime(Max._pacman._time);
				TempFruits.remove(Max.fruitindex);
				if(!TempFruits.isEmpty())
					Max.init(TempFruits.get(0));

			}

			for (int i = 0; i < game.packmans.size(); i++)
			{
				Path.add(game.packmans.get(i).path);
			}
			ComparePackmanTime cpt = new ComparePackmanTime() ; 
			game.packmans.sort(cpt);
			if(game.packmans.size() > 0) System.out.println("The shortest time to eat all the fruits is : " +game.packmans.get(0)._time);
		}

		return Path ; 
	}
	/**
	 * this function calculate the time that takes to the packman to eat some fruit.
	 * @param p represent a packman.
	 * @param f represent s fruit.
	 * @param map represent a map.
	 * @return returns the time it takes to the packman to eat some fruit.
	 */
	private static double Time (Packman p , Fruit f , Map map)
	{
		double dist_closestFruit=Convert.distance2d(p.getGpsLocation(),f.getGpsLocation())/(p.getSpeed());
		return dist_closestFruit;
	}

}
