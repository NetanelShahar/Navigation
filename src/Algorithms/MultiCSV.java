package Algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import File_format.Csv2kml;
import GIS.GIS_project;
import GIS.MyGISElement;
import GIS.MyGISLayer;
import GIS.MyGISProject;

public class MultiCSV {
	
	public static File folder = new File("C:\\Users\\דניאל\\Desktop\\aaa");
	static MyGISProject _Project ;
	
	public MultiCSV() throws ParseException {
		_Project = new MyGISProject();
	}



	public static MyGISProject FileToObject(final File folder, MyGISProject Project) throws ParseException {
	
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				 System.out.println("Reading files under the folder "+folder.getAbsolutePath());
				FileToObject(fileEntry, Project);
			} else {
				
				System.out.println(fileEntry.getName());
				if(fileEntry.getName().contains(".csv"))
				{
			        String line = "";
			        String cvsSplitBy = ",";

			        try (BufferedReader br = new BufferedReader(new FileReader(fileEntry))) 
			        {
			        	MyGISLayer Layer = new MyGISLayer();
			        	br.readLine();
			        	br.readLine();
			            while ((line = br.readLine()) != null) 
			            {
			            	Layer.add(new MyGISElement(line));
			                			                
			            }
			            Project.add(Layer);
			            br.close();

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
     
		MultiCSV s = new MultiCSV();
		MyGISProject P =  FileToObject(folder,_Project);
		Csv2kml f = new Csv2kml();
		f.ObjectToKml(P);
	}

}
