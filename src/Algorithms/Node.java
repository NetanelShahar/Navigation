package Algorithms;

import Game_objects.Packman;

public class Node 
{

	private double _dis ; 
	private Packman _pacman;
	
	public Node(double dis , Packman pacman) 
	{
		
		set_dis(dis) ;
		set_pacman(pacman);
	}
	
	public double get_dis() 
	{
		return _dis;
	}
	private void set_dis(double _dis)
	{
		this._dis = _dis;
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
