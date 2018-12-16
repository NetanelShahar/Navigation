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

public class ShortPathAlgorithm {
	static MyCoords Convert = new MyCoords();
	public Game game;

	public ShortPathAlgorithm(Game game)
	{
		this.game=game;
	}
	public static ArrayList<Path> Short(Game game, Map map)
	{
		for (int i = 0; i < game.packmans.size(); i++) {
			game.fruits.add(new Fruit(0, game.packmans.get(i)._PixelLocation, 0, game.GameMap));
		}
		ArrayList<Path> Path = new ArrayList<Path>();
		ArrayList<Fruit> FruitsA = new ArrayList<>(game.fruits);
		if(!FruitsA.isEmpty() && !game.packmans.isEmpty()) {
			PackManNode Max = new PackManNode(Double.MAX_VALUE , game.packmans.get(0) , FruitsA.get(0));
			double time = 0 ; 
			while(!FruitsA.isEmpty())
			{
				for (int i = 0; i < game.packmans.size(); i++) {
					for (int j = 0; j < FruitsA.size(); j++) 
					{
						time = Time(game.packmans.get(i), FruitsA.get(j), map);
						if(time+game.packmans.get(i)._time < Max.time)
						{
							Max.time = time+game.packmans.get(i)._time;
							Max._pacman = game.packmans.get(i);
							Max.fruit = FruitsA.get(j);
							Max.fruitindex = j ; 
						}
						time = 0 ; 
					}
				}
				Max._pacman.path.Lines.add(new Line(Max._pacman.getPixelLocation(),Max.fruit.getPixelLocation()));
				Max._pacman._time += Time(Max._pacman, Max.fruit, map);
				Max._pacman.setPixelLocation(FruitsA.get(Max.fruitindex).getPixelLocation(),game.GameMap);
				Max._pacman.setGpsLocation(new GpsPoint(map.Pixel2GPSPoint(Max._pacman.getPixelLocation().get_PixelX(), Max._pacman.getPixelLocation().get_PixelY())));
				FruitsA.remove(Max.fruitindex);
				if(!FruitsA.isEmpty())
					Max.init(game.fruits.get(0));
				
			}
			for (int i = 0; i < game.packmans.size(); i++)
			{
				Path.add(game.packmans.get(i).path);
			}
		}

		return Path ; 
	}

	private static double Time (Packman p , Fruit f , Map map)
	{
		double dist_closestFruit=Convert.distance2d(p.getGpsLocation(),f.getGpsLocation())/(p.getSpeed());
		return dist_closestFruit;
	}

}
