package Algorithms;

import Game_objects.Fruit;
import Game_objects.Packman;

public class PackManNode 
{


	public Packman _pacman;
	public double time ;
	public Fruit fruit;
	public int fruitindex;
	
	public PackManNode(double time , Packman pacman , Fruit fruit ) 
	{
		this.fruit = fruit; 
		this.time = time ; 
		set_pacman(pacman);
	}
	public void init(Fruit f)
	{
		time = Double.MAX_VALUE;
		fruitindex = -1 ;
		fruit = f;
		
	}

	public Packman get_pacman() 
	{
		return _pacman;
	}
	private void set_pacman(Packman _pacman) 
	{
		this._pacman = _pacman;
	}

}
