package Game_objects;

import java.io.IOException;

import Algorithms.ShortPathAlgorithm;
import File_format.CSV2Game;
import File_format.Game2CSV;
import Maps.Map;

public class Game {
	
	public Map GameMap;
	public Fruits fruits;
	public Packmans packmans;
	public CSV2Game Convert;
	public Game2CSV saving;
	public ShortPathAlgorithm algo;
	
	public Game(Map map) 
	{
		fruits = new Fruits();
		packmans = new Packmans();
		GameMap = map;
		
	}
	
//	public Game(Map map , String path) throws IOException
//	{
//		fruits = new Fruits();
//		packmans = new Packmans();
//		Convert = new CSV2Game(map,this,path);
//		GameMap = map;
//	}
	
	public void Csv2Game(String path) throws IOException 
	{
		
		CSV2Game newGame=new CSV2Game(this.GameMap,this,path);
		
	}
	public void Game2Csv() 
	{
		
	}

}
