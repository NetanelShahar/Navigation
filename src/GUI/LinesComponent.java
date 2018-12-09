package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.crypto.Cipher;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Maps.Pixel;
////////////https://stackoverflow.com/questions/5801734/how-to-draw-lines-in-java
public class LinesComponent extends JComponent{


	BufferedImage myImage;
	private final LinkedList<Line> lines = new LinkedList<Line>();


	public LinesComponent(BufferedImage myImage)
	{

		this.myImage=myImage;

		this.setPreferredSize(new Dimension(myImage.getWidth(), myImage.getHeight()));
		//		///testFrame.getContentPane().add(comp, BorderLayout.CENTER);

		//		for(int i=0;i<Circles.size()-1;++i)
		//		{
		//			Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
		//			this.addLine((int)Circles.get(i).get_PixelX(),(int)Circles.get(i).get_PixelY(),(int)Circles.get(i+1).get_PixelX(),(int)Circles.get(i+1).get_PixelY(),randomColor);
		//		}
	}

	private static class Line{
		final int x1; 
		final int y1;
		final int x2;
		final int y2;   
		final Color color;

		public Line(int x1, int y1, int x2, int y2, Color color) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.color = color;
		}               
	}



	public void addLine(int x1, int x2, int x3, int x4) {
		addLine(x1, x2, x3, x4, Color.black);
	}

	public void addLine(int x1, int x2, int x3, int x4, Color color) {
		lines.add(new Line(x1,x2,x3,x4, color));        
		repaint();
	}

	public void clearLines() {
		lines.clear();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Line line : lines) {
			g.setColor(line.color);
			g.drawLine(line.x1, line.y1, line.x2, line.y2);
		}
	}

}