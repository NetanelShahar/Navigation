package File_format;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Game_objects.Fruit;
import Game_objects.Packman;

public class Game2CSV {
	
	ArrayList<Packman> packmanList;
	ArrayList<Fruit> fruitList;
	String csv;
	
	public Game2CSV(ArrayList<Packman> packmanList,ArrayList<Fruit> fruitList)
	{
		this.packmanList=packmanList;
		this.fruitList=fruitList;
		
		String type;
		String id;
		String lat;
		String lon;
		String alt;
		String speedORweight;
		String radius;
		
		csv="Type,id,Lat,Lon,Alt,Speed/Weight,Radius,3,12\n";
		
		for(int i=0;i<packmanList.size();++i)
		{
			type="P,";
			id=""+i+",";
//			lat=""+packmanList.get(i)._GPS.getLat()+",";
//			lon=""+packmanList.get(i)._GPS.getLon()+",";
			lat=""+packmanList.get(i)._GPS.getLon()+",";
			lon=""+packmanList.get(i)._GPS.getLat()+",";
			alt=""+packmanList.get(i)._GPS.getAlt()+",";
			speedORweight=""+packmanList.get(i).getSpeed()+",";
			radius=""+packmanList.get(i).getSpeed()+",";
			csv+=type+id+lat+lon+alt+speedORweight+radius+",\n";
			
		}
//		lat=""+packmanList.get(i)._GPS.getLon()+",";
//		lon=""+packmanList.get(i)._GPS.getLat()+",";
//		lat=""+fruitList.get(i)._GPS.getLon()+",";
//		lon=""+fruitList.get(i)._GPS.getLat()+",";
		for(int i=0;i<fruitList.size();++i)
		{
			type="F,";
			id=""+i+",";
//			lat=""+fruitList.get(i)._GPS.getLat()+",";
//			lon=""+fruitList.get(i)._GPS.getLon()+",";
			lat=""+fruitList.get(i)._GPS.getLon()+",";
			lon=""+fruitList.get(i)._GPS.getLat()+",";
			alt=""+fruitList.get(i)._GPS.getAlt()+",";
			speedORweight=""+fruitList.get(i).getValue()+",";
			csv+=type+id+lat+lon+alt+speedORweight+",,\n";
			
			
		}
		try {
			File file=new File("letsTRY"+".csv");

			if(!file.exists())
				file.createNewFile();

			System.out.println(csv);
			
			PrintWriter pw=new PrintWriter(file);
			pw.print(csv);
			pw.close();
			System.out.println("done");
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
