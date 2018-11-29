package Algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import GIS.GIS_project;
import GIS.MyGISElement;
import GIS.MyGISLayer;
import GIS.MyGISProject;

public class MultiCSV {
	
	public static File folder = new File("C:\\Users\\דניאל\\Desktop");
	static MyGISProject _Project ;
	
	public MultiCSV() throws ParseException {
		_Project = new MyGISProject();
	}



	public static MyGISProject listFilesForFolder1(final File folder, MyGISProject Project) throws ParseException {
	
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				 System.out.println("Reading files under the folder "+folder.getAbsolutePath());
				listFilesForFolder1(fileEntry, Project);
			} else {
				
				System.out.println(fileEntry.getName());
				if(fileEntry.getName().contains(".csv"))
				{
			        String line = "";
			        String cvsSplitBy = ",";

			        try (BufferedReader br = new BufferedReader(new FileReader(fileEntry))) 
			        {
			        	MyGISLayer Layer = new MyGISLayer();
			            while ((line = br.readLine()) != null) 
			            {
			            	Layer.add(new MyGISElement(line));
			                			                
			            }
			            Project.add(Layer);

			        } catch (IOException e) 
			        {
			            e.printStackTrace();
			        }
				}
				
			}
		}
		return Project;
	}
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("Reading files under the folder "+ folder.getAbsolutePath());
      //  listFilesForFolder(folder);
		GIS_project P =  listFilesForFolder1(folder,_Project);
		System.out.println(P);
	}

}
