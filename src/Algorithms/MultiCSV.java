package Algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MultiCSV {
	public static File folder = new File("C:\\Users\\דניאל\\Desktop");
	static String temp = "";
	public ArrayList<String> arr ;




	public static void listFilesForFolder1(final File folder) {
	
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				 System.out.println("Reading files under the folder "+folder.getAbsolutePath());
				listFilesForFolder1(fileEntry);
			} else {
				
				System.out.println(fileEntry.getName());
				if(fileEntry.getName().contains(".csv"))
				{
				    
			        String line = "";
			        String cvsSplitBy = ",";

			        try (BufferedReader br = new BufferedReader(new FileReader(fileEntry))) 
			        {
			            while ((line = br.readLine()) != null) 
			            {
			                String[] userInfo = line.split(cvsSplitBy);

			         
			            }

			        } catch (IOException e) 
			        {
			            e.printStackTrace();
			        }
				}
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Reading files under the folder "+ folder.getAbsolutePath());
      //  listFilesForFolder(folder);
		listFilesForFolder1(folder);
	}

}
