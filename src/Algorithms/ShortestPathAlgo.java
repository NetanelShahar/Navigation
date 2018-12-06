package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import Coords.MyCoords;
import Game_objects.Fruit;
import Game_objects.Packman;

public class ShortestPathAlgo {

	ArrayList<Packman> packmanList;
	ArrayList<Fruit> fruitList;

	public ShortestPathAlgo(ArrayList<Packman> packmanList,ArrayList<Fruit> fruitList)
	{
		this.packmanList=packmanList;
		this.fruitList=fruitList;
		ShortestPath(this);
	}

	public void ShortestPath(ShortestPathAlgo situation)
	{
		MyCoords coords=new MyCoords();

		double[][] table=new double[packmanList.size()][fruitList.size()];

		for(int i=0;i<packmanList.size();++i)
		{
			for(int j=0;j<fruitList.size();++j)
			{

				table[i][j]=coords.distance2d(this.packmanList.get(i).getXYZlocation(), this.fruitList.get(j).getXYZlocation())/(double)this.packmanList.get(i).getSpeed();     

			}
			Arrays.sort(table[i]);
		}
		 
		
		
	}






}
