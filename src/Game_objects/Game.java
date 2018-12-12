package Game_objects;

import java.io.IOException;

import File_format.CSV2Game;
import Maps.Map;

public class Game {
	
	public Map GameMap;
	public Fruits fruits;
	public Packmans packmans;
	private CSV2Game Convert;
	
	public Game(Map map) 
	{
		fruits = new Fruits();
		packmans = new Packmans();
		GameMap = map;
	}
	public Game(Map map , String path) throws IOException
	{
		fruits = new Fruits();
		packmans = new Packmans();
		Convert = new CSV2Game(map,this,path);
		GameMap = map;
	}
	
	public void Game2Csv() 
	{
		
	}

}
