package GUI;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Game_objects.Game;
import Game_objects.Packman;
import Maps.Map;
import Maps.Pixel;


public class MainWindow extends JFrame implements MouseListener
{


	Game game ; 
	ArrayList<Line> Lines ;
	int x = -1;
	int y = -1;


	public BufferedImage PackManImage;


	public MainWindow() 
	{
		initGUI();		
		this.addMouseListener(this); 
	}

	private void initGUI() 
	{	
		Map GameMap = new Map();
		try {
			PackManImage = ImageIO.read(new File("PackMan.PNG"));
			GameMap.myImage = ImageIO.read(new File("Ariel1.PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		game = new Game(GameMap);
		Lines=new ArrayList<Line>();
	
	}




	public void paint(Graphics g)
	{

		g.drawImage(game.GameMap.myImage, 0, 0,this.getWidth(),this.getHeight(), this);
		game.GameMap.ChangeFrameSize(new Pixel(this.getWidth(), this.getHeight()), game.packmans);



		if(x!=-1 && y!=-1)
		{

			for (int i = 0; i < game.packmans.size(); i++) {

				g.drawImage(PackManImage,(int)game.packmans.get(i).getPixelLocation().get_PixelX()-20,(int)game.packmans.get(i).getPixelLocation().get_PixelY()-10,this);
				if(i!=game.packmans.size()-1)
					g.drawLine((int)Lines.get(i).start.get_PixelX(), (int)Lines.get(i).start.get_PixelY(),(int)Lines.get(i).end.get_PixelX(), (int)Lines.get(i).end.get_PixelY());
			}

		}

	}

	@Override
	public void mouseClicked(MouseEvent arg) {
		System.out.println("mouse Clicked");
		System.out.println("("+ arg.getX() + "," + arg.getY() +")");
		x = arg.getX();
		y = arg.getY();
		game.packmans.add(new Packman(0, new Pixel(x, y), 0, 0, game.GameMap));
		if(game.packmans.size()>1)
		{
			Lines.add(new Line(game.packmans.get(game.packmans.size()-2).getPixelLocation() , game.packmans.get(game.packmans.size()-1).getPixelLocation() ));
		}

		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("mouse entered");

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public double getXsize()
	{
		return game.GameMap.myImage.getWidth();
	}

	public double getYsize()
	{
		return game.GameMap.myImage.getHeight();
	}

}
