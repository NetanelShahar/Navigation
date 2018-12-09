package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DrawingLines {
	
	 public static void main(String[] args) {

	        Dimension imgDim = new Dimension(200,200);
	        BufferedImage mazeImage = new BufferedImage(imgDim.width, imgDim.height, BufferedImage.TYPE_INT_RGB);


	        Graphics2D g2d = mazeImage.createGraphics();
	        g2d.setBackground(Color.WHITE);
	        g2d.fillRect(0, 0, imgDim.width, imgDim.height);
	        g2d.setColor(Color.BLACK);
	        BasicStroke bs = new BasicStroke(2);
	        g2d.setStroke(bs);
	        // draw the black vertical and horizontal lines
	        for(int i=0;i<21;i++){
	            // unless divided by some factor, these lines were being
	            // drawn outside the bound of the image..
	            g2d.drawLine((imgDim.width+2)/20*i, 0, (imgDim.width+2)/20*i,imgDim.height-1);
	            g2d.drawLine(0, (imgDim.height+2)/20*i, imgDim.width-1, (imgDim.height+2)/20*i);
	        }

	        ImageIcon ii = new ImageIcon(mazeImage);
	        JOptionPane.showMessageDialog(null, ii);
	    }

}
