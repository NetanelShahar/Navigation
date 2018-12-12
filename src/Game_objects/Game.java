package Game_objects;

import java.io.IOException;

import File_format.CSV2Game;
import Maps.Map;

public class Game {
	
	public Map GameMap;
	public Fruits fruits;
	public Packmans packmans;
	public CSV2Game Convert;
	
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
		
		CSV2Game newGame=new CSV2Game(this.GameMap,this,"game_1543684662657.csv");
		
	}
	public void Game2Csv() 
	{
		
	}

}
