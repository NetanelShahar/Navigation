package GUI;

import javax.swing.JFrame;


public class Main 
{
	public static void main(String[] args)
	{
		MainWindow window = new MainWindow();
		window.setVisible(true);
		window.setSize(window.myImage.getWidth()+12,window.myImage.getHeight()+110);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
