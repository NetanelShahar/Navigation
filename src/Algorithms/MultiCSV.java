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

	public static File folder ;
	 
	public MultiCSV(String FolderSource){
		// TODO Auto-generated constructor stub
		folder = new  File(FolderSource);
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
					String line;

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
		Csv2kml c = new Csv2kml();
		MultiCSV m = new MultiCSV("C:\\Users\\נתנאל בן יששכר\\Desktop\\ssaas");
		MyGISProject p = new MyGISProject(); 
		 p = FileToObject(folder, p);
		 c.ObjectToKml(p);
	}

}
