package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Game_objects.Fruit;
import Game_objects.Game;
import Game_objects.Packman;
import Geom.GpsPoint;
import Maps.Map;


public class CSV2Game {

	public Game _game ;

	public CSV2Game(Map map , Game game , String path) throws IOException
	{
		this._game = game ; 
		resolveCsv(path, map);
	}
	public Game resolveCsv(String csvFileAdress , Map map) throws IOException
	{

		BufferedReader br = new BufferedReader(new FileReader(csvFileAdress)); 
		String line=br.readLine();

		line=br.readLine();
		while (line != null) 
		{

			String stringLine=line.toString();

			line = br.readLine();
			
			pacmanORfruit(stringLine , map);
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return _game;

	}
	private void pacmanORfruit(String line,Map map)
	{
		String[] arr=line.split(",");
		if(arr[0].equals("P"))
		{
			buildTHEpacman(arr , map);
		}
		else
			buildTHEfruit(arr, map);

	}
	private void buildTHEpacman(String[] arr, Map map)
	{

		int id=Integer.parseInt(arr[1]);
		GpsPoint gpsLocation=new GpsPoint(Double.parseDouble(arr[2]),Double.parseDouble( arr[3]),Double.parseDouble( arr[4]));
		int speed=Integer.parseInt(arr[5]);
		int radius=Integer.parseInt(arr[6]);

		Packman temp=new Packman(id,gpsLocation,speed,radius,map);

		this._game.packmans.add(temp);


	}
	private void buildTHEfruit(String[] arr, Map map)
	{
		int id=Integer.parseInt(arr[1]);
		GpsPoint gpsLocation=new GpsPoint(Double.parseDouble(arr[2]),Double.parseDouble( arr[3]),Double.parseDouble( arr[4]));
		int value=Integer.parseInt(arr[5]);

		Fruit temp=new Fruit(id,gpsLocation,value,map);

		this._game.fruits.add(temp);

	}


}
