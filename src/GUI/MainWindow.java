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

import Maps.Map;
import Maps.Pixel;


public class MainWindow extends JFrame implements MouseListener
{
	public Map GameMap ; 
	ArrayList<Pixel> Circles ; 
	ArrayList<Line> Lines ;
	public BufferedImage myLATERimage;
	//public LinesComponent lines = new LinesComponent(GameMap.myImage);

	public MainWindow() 
	{

		initGUI();		
		this.addMouseListener(this); 

		this.addComponentListener(new ComponentAdapter() 
		{
			public void componentResized(ComponentEvent componentEvent)
			{


				scaledImage(myLATERimage,componentEvent.getComponent().getWidth(), componentEvent.getComponent().getHeight());


			}
		});

	}

	private void initGUI() 
	{

		GameMap = new Map();
		Circles = new ArrayList<Pixel>();
		Lines=new ArrayList<Line>();
		try {
			GameMap.myImage = ImageIO.read(new File("Ariel1.PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			myLATERimage = ImageIO.read(new File("Ariel1.PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private void scaledImage(Image img,int w, int h)
	{
		BufferedImage resizedImage=new BufferedImage(w,h ,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2=resizedImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0, w, h, null);
		g2.dispose();

		GameMap.myImage=resizedImage;
		GameMap.ChangeFrameSize(new Pixel(GameMap.myImage.getWidth(), GameMap.myImage.getHeight()), Circles);
		this.repaint();

	}

	int x = -1;
	int y = -1;

	public void paint(Graphics g)
	{
		g.drawImage(GameMap.myImage, 0, 0, this);
		if(x!=-1 && y!=-1)
		{

			for (int i = 0; i < Circles.size(); i++) {
				g.fillOval((int)Circles.get(i).get_PixelX(), (int)Circles.get(i).get_PixelY(), 10	, 10);
				if(i!=Circles.size()-1)
					g.drawLine((int)Lines.get(i).start.get_PixelX(), (int)Lines.get(i).start.get_PixelY(),(int)Lines.get(i).end.get_PixelX(), (int)Lines.get(i).end.get_PixelY());

			}

		}

	}
	public double getXsize()
	{
		return GameMap.myImage.getWidth();
	}

	public double getYsize()
	{
		return GameMap.myImage.getHeight();
	}

	@Override
	public void mouseClicked(MouseEvent arg) {
		System.out.println("mouse Clicked");
		System.out.println("("+ arg.getX() + "," + arg.getY() +")");
		x = arg.getX();
		y = arg.getY();
		Circles.add(new Pixel(x, y));
		if(Circles.size()>1)
		{
			Lines.add(new Line((int)Circles.get(Circles.size()-2).get_PixelX(),(int)Circles.get(Circles.size()-2).get_PixelY(),x, y));
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

}
