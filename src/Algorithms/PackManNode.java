package Algorithms;

import Game_objects.Fruit;
import Game_objects.Packman;

/**
 * This class is a temporary class that the algorithm use to check path of each pacman to eat a fruit.
 * @author Netanel Ben-Isahar
 * @author daniel abargel
 *
 */
public class PackManNode 
{


	public Packman _pacman;
	public double time ;
	public Fruit fruit;
	public int fruitindex;


	/**
	 * The constructor setup the pacman, fruit and the time it takes for the pacman to eat the fruit.  
	 * @param time it takes for the pacman to eat the fruit.
	 * @param pacman that eat.
	 * @param fruit eaten.
	 */
	public PackManNode(double time , Packman pacman , Fruit fruit ) 
	{
		this.fruit = fruit; 
		this.time = time ; 
		set_pacman(pacman);
	}

	/**
	 * The function initializing the time, the fruit index and the fruit.
	 * @param f the fruit to initializing.
	 */
	public void init(Fruit f)
	{
		time = Double.MAX_VALUE;
		fruitindex = -1 ;
		fruit = f;

	}

	/**
	 * This function get the pacman.
	 * @return the pacman.
	 */
	public Packman get_pacman() 
	{
		return _pacman;
	}

	/**
	 * This function set up the pacman.
	 * @param _pacman the pacman we want to set up to.
	 */
	private void set_pacman(Packman _pacman) 
	{
		this._pacman = _pacman;
	}

}
