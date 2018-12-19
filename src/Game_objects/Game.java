package Game_objects;

import java.io.IOException;

import Algorithms.ShortPathAlgorithm;
import File_format.CSV2Game;
import File_format.Game2CSV;
import Maps.Map;

/**
 * 
 * @author Netanel Ben-Isahar
 * @author daniel abargel
 * this class is the game class that holds all of the game components.
 */
public class Game {
	
	
	public Map GameMap;
	public Fruits fruits;
	public Packmans packmans;
	public CSV2Game Convert;
	public Game2CSV saving;
	public ShortPathAlgorithm algo;
	
	/**
	 * this constructor builds the game.
	 * @param map represent the map.
	 */
	public Game(Map map) 
	{
		fruits = new Fruits();
		packmans = new Packmans();
		GameMap = map;
		
	}
	/**
	 * 
	 * @param path represent the path to the csv file that we want to open
	 * @throws IOException
	 */
	public void Csv2Game(String path) throws IOException 
	{
		
		CSV2Game newGame=new CSV2Game(this.GameMap,this,path);
		
	}
	public void Game2Csv() 
	{
		
	}

}
