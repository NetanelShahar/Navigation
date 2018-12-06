package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Game_objects.Fruit;
import Game_objects.Packman;
import Geom.GpsPoint;


public class Game {

	public ArrayList<Packman> packmanList;
	public ArrayList<Fruit> fruitList;

	public Game(String csvFileAdress) throws IOException
	{
		this.packmanList=new ArrayList<Packman>() ;
		this.fruitList=new ArrayList<Fruit>() ;
		resolveCsv(csvFileAdress);
	}
	public void resolveCsv(String csvFileAdress) throws IOException
	{

		BufferedReader br = new BufferedReader(new FileReader(csvFileAdress)); 
		String line=br.readLine();

		line=br.readLine();
		while (line != null) 
		{

			String stringLine=line.toString();

			line = br.readLine();
			pacmanORfruit(stringLine);
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	private void pacmanORfruit(String line)
	{
		String[] arr=line.split(",");
		if(arr[0].equals("P"))
		{
			buildTHEpacman(arr);
		}
		else
			buildTHEfruit(arr);

	}
	private void buildTHEpacman(String[] arr)
	{

		int id=Integer.parseInt(arr[1]);
		GpsPoint gpsLocation=new GpsPoint(Integer.parseInt(arr[2]),Integer.parseInt( arr[3]),Integer.parseInt( arr[4]));
		int speed=Integer.parseInt(arr[5]);
		int radius=Integer.parseInt(arr[6]);

		Packman temp=new Packman(id,gpsLocation,speed,radius);

		this.packmanList.add(temp);


	}
	private void buildTHEfruit(String[] arr)
	{
		int id=Integer.parseInt(arr[1]);
		GpsPoint gpsLocation=new GpsPoint(Integer.parseInt(arr[2]),Integer.parseInt( arr[3]),Integer.parseInt( arr[4]));
		int value=Integer.parseInt(arr[5]);

		Fruit temp=new Fruit(id,gpsLocation,value);

		this.fruitList.add(temp);

	}


}
