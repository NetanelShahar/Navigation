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
/**
 * The class represent a Algorithm which receives a file which is a folder.
 * Searches for csv files in the given folder, recursively, and when the function finds a .csv file.
 * The function transforms it into a layer that represents the entire set of points given including the information about the points.
 * Then inserts the layer into the project and back again.
 * After that, the node returns the project. 
 * @author DanielAbergel
 *
 */
public class MultiCSV {

	public static File folder ;

	/**
	 * the constructor Receiving source path and make a file with this source path . 
	 * @param FolderSource represent the path source of the folder we want to search CSV Files.
	 */
	public MultiCSV(String FolderSource){
		// TODO Auto-generated constructor stub
		folder = new  File(FolderSource);
	}

/**
 * source : https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
 * Descreption is in the top of the class
 * @param folder represent the file folder 
 * @param Project represent the project that returns after the functions finish.
 * @return MyGISProject Project with all layers from the CSV Files 
 * @throws ParseException if there a wrong time format
 */
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


}
