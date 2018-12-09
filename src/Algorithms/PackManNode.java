package Algorithms;

import Game_objects.Packman;

public class PackManNode 
{

	private double _dis ; 
	private Packman _pacman;
	private double _time ; 
	
	public PackManNode(double dis , Packman pacman ) 
	{
		setTime(0);
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

	public double getTime() {
		return _time;
	}

	public void setTime(double time) {
		this._time = time;
	}
}
