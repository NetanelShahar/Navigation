package GUI;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import File_format.CSV2Game;
import Game_objects.Fruit;
import Game_objects.Game;
import Game_objects.Packman;
import Maps.Map;
import Maps.Pixel;


public class MainWindow extends JFrame implements MouseListener
{


	Game game ; 
	ArrayList<Line> Lines ;
	ArrayList<Line> Lines1 ;
	boolean PacOrFruit  ;  // false = packman , true = fruit
	int x = -1;
	int y = -1;
	public BufferedImage PackManImage;
	public BufferedImage FruitImage;

	public MainWindow() 
	{
		initGUI();		
		this.addMouseListener(this); 
	}

	private void InitMenu() {

		MenuBar  menubar = new MenuBar ();
		Menu file = new Menu("File"); 
		Menu gameM = new Menu("Game");
		MenuItem load = new MenuItem("Load");
		MenuItem save = new MenuItem("Save");
		MenuItem clear = new MenuItem("Clear");
		MenuItem packmanM = new MenuItem("PackMan");
		MenuItem fruitM = new MenuItem("Fruit");
		MenuItem run = new MenuItem("Run");
		menubar.add(file);
		menubar.add(gameM);
		file.add(load);
		file.add(save);
		file.add(clear);
		gameM.add(packmanM);
		gameM.add(fruitM);
		gameM.add(run);
		this.setMenuBar(menubar);


		load.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					game.Convert=new CSV2Game(game.GameMap, game, "game_1543684662657.csv");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				repaint();



			}
		});
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


			}
		});
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


			}
		});
		packmanM.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PacOrFruit = false;

			}
		});
		fruitM.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PacOrFruit = true;

			}
		});
		run.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


			}
		});


	}

	private void initGUI() 
	{	
		InitMenu();
		Map GameMap = new Map();
		try {
			FruitImage = ImageIO.read(new File("Fruit.PNG"));
			PackManImage = ImageIO.read(new File("PackMan.PNG"));
			GameMap.myImage = ImageIO.read(new File("Ariel1.PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		game = new Game(GameMap);
		Lines=new ArrayList<Line>();
		Lines1 =new ArrayList<Line>();

	}




	public void paint(Graphics g)
	{

		g.drawImage(game.GameMap.myImage, -10, -10,this.getWidth(),this.getHeight(), this);
		game.GameMap.ChangeFrameSizePacman(new Pixel(this.getWidth(), this.getHeight()), game.packmans);
		game.GameMap.ChangeFrameSizeFruit(new Pixel(this.getWidth(), this.getHeight()), game.fruits);


		if(x!=-1 && y!=-1)
		{

			for (int i = 0; i < game.packmans.size(); i++) {

				g.drawImage(PackManImage,(int)game.packmans.get(i).getPixelLocation().get_PixelX()-20,(int)game.packmans.get(i).getPixelLocation().get_PixelY()-10,this);


				//				if(i!=game.packmans.size()-1)
				//					g.drawLine((int)Lines.get(i).start.get_PixelX(), (int)Lines.get(i).start.get_PixelY(),(int)Lines.get(i).end.get_PixelX(), (int)Lines.get(i).end.get_PixelY());
			}
			for (int i = 0; i < game.fruits.size(); i++) {

				g.drawImage(FruitImage,(int)game.fruits.get(i).getPixelLocation().get_PixelX()-20,(int)game.fruits.get(i).getPixelLocation().get_PixelY()-10,this);


				//				if(i!=game.packmans.size()-1)
				//					g.drawLine((int)Lines.get(i).start.get_PixelX(), (int)Lines.get(i).start.get_PixelY(),(int)Lines.get(i).end.get_PixelX(), (int)Lines.get(i).end.get_PixelY());
			}

		}

	}
	@Override
	public void mouseClicked(MouseEvent arg) {
		System.out.println("mouse Clicked");
		System.out.println("("+ arg.getX() + "," + arg.getY() +")");
		x = arg.getX();
		y = arg.getY();
		if(!PacOrFruit) {
			game.packmans.add(new Packman(0, new Pixel(x, y), 0, 0, game.GameMap));
			if(game.packmans.size()>1)
			{
				Lines.add(new Line(game.packmans.get(game.packmans.size()-2).getPixelLocation() , game.packmans.get(game.packmans.size()-1).getPixelLocation() ));
			}
		}else
		{
			game.fruits.add(new Fruit(0, new Pixel(x, y), 0, game.GameMap));
			if(game.fruits.size()>1)
			{
				Lines1.add(new Line(game.fruits.get(game.fruits.size()-2).getPixelLocation() , game.fruits.get(game.fruits.size()-1).getPixelLocation() ));
			}
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
