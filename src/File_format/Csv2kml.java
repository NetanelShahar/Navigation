package File_format;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

import javax.sound.sampled.Line;

import Algorithms.MultiCSV;
import GIS.GIS_element;
import GIS.GIS_layer;
import GIS.MetaDataLayer;
import GIS.MyGISElement;
import GIS.MyGISLayer;
import GIS.MyGISProject;
/**
 * This class is a Format class There is 2 options to do a format:
 * CSV To Object To KML / CSV To KML Directly
 * in the format function ObjectToKml Each layer will be of a different color
 * @author DanielAbergel
 *
 */
public class Csv2kml {

	long UTC ; // time as long . 
	private int urlIndex=0; // Represents the color id of each layer
	private String [] urlArray= {"red","yellow","green"}; //Represents the color of each layer


	/**
	 * /**
	 * source : https://stackoverflow.com/questions/12081417/convert-utc-date-into-milliseconds
	 * The function takes time as String and covert the String to long 
	 * @param DateAndTime represent the time as String  
	 * @return the time as long 
	 * @throws ParseException if there a wrong time format
	 */
	private long DateToMilis(String dateAndTime) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date date = format.parse(dateAndTime);
		long millis = date.getTime();
		return millis;
	}

/**
 * The function takes a CSV file and Makes manual KML file
 * Then the function opens PlaceMark manually, and adds the data and the point COORDINATE.
 * The function closes the file and tries to create it with the name the function received, the file will be in the project folder 
 * @param csvFileAdress represent the Folder path of the CSV file
 * @param KmlFileName represent the output file name.
 * @throws IOException if there a input or output error
 * @throws ParseException if there a wrong time format
 */
	public void csvConvertToKml(String csvFileAdress,String KmlFileName) throws IOException, ParseException
	{


		BufferedReader br = new BufferedReader(new FileReader(csvFileAdress)); 
		String line=br.readLine();

		String kmlString=
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
						"<kml xmlns=\"http://www.opengis.net/kml/2.2\">"+"\n"
						+"<Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder>" + 
						"\n";

		line=br.readLine();
		line=br.readLine();
		while (line != null) 
		{

			kmlString=kmlString+kmlConvert(line.toString());
			
			urlIndex++;

			line = br.readLine();
		}
		br.close();
		kmlString=kmlString+"</Folder></Document>\n</kml>";
		System.out.println(kmlString);


		try {
			File file=new File(KmlFileName+".kml");

			if(!file.exists())
				file.createNewFile();

			PrintWriter pw=new PrintWriter(file);
			pw.print(kmlString);
			pw.close();
			System.out.println("done");
		}catch(IOException e)
		{
			e.printStackTrace();
		}

	}



/**
 * The function Receiving data as a String and make PlaceMark as a String and returns it 
 * @param PointandData represent the Data of the point . 
 * @return the PlaceMark of this point. 
 * @throws ParseException if there a wrong time format
 */
	public String kmlConvert(String PointandData) throws ParseException
	{
		//String[] arr=line.toString().split(",");
		String[] arr=PointandData.split(",");
		long time = DateToMilis(arr[3]);
		String str="<Placemark>\n"
				+ "<name>" +arr[1]+"</name>\n"
				+"<description><![CDATA[BSSID: <b>"+arr[0]+"</b><br/>Timestamp: <b>"+time+"</b><br/>Data: <b>"+ arr[3]+ "</b>]]" + "></description><styleUrl>#"+urlArray[urlIndex%urlArray.length]+"</styleUrl>\n"
				+"<Point><coordinates>"+arr[7]+","+arr[6]+","+arr[8]+"</coordinates></Point>\n"
				+"<time>"+arr[3]+"</time></Placemark>\n";

		return str;
	}
	/**
	 * The function Receiving data as a String and make PlaceMark as a String and returns it 
	 * this functions is build PlaceMark for the ObjectToKml function
	 * @param Data represent the Data as a String .
     * @throws ParseException if there a wrong time format
	 */
	private String PointToKml(String Data) throws ParseException
	{
		String[] arr=Data.split(",");
		long time = DateToMilis(arr[5]);
		String str="<Placemark>\n"
				+ "<name>" +arr[4]+"</name>\n"
				+"<description><![CDATA[BSSID: <b>"+arr[3]+"</b><br/>Timestamp: <b>"+time+"</b><br/>Data: <b>"+ arr[5]+ "</b>]]" + "></description><styleUrl>#"+urlArray[urlIndex%urlArray.length]+"</styleUrl>\n"
				+"<Point><coordinates>"+arr[1]+","+arr[0]+","+arr[2]+"</coordinates></Point>\n"
				+"<time>"+arr[5]+"</time></Placemark>\n";

		return str;
	}
	/**
	 * The function takes a GIS_Project Object and Makes manual KML file
     * Then the function opens PlaceMark manually, and adds the data and the point COORDINATE.
     * The function closes the file and tries to create it , the file will be in the project folder 
	 * @param Project represent a GIS_Project with GIS_Layers..
	 * @throws ParseException if there a wrong time format
	 */
	public void ObjectToKml(MyGISProject Project) throws ParseException
	{
		String KmlAsString = 
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
						"<kml xmlns=\"http://www.opengis.net/kml/2.2\">"+"\n"
						+"<Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder>\r\n" + 
						"\n"; 
		String toString = Project.toString();
		String[] ProjectAsString = toString.split("\n");
		int i = 1 ;
		while(!ProjectAsString[i].equals("}"))
		{
			if(ProjectAsString[i].equals("[") || ProjectAsString[i].equals("]")) 
				{
				i++;
				
			if(ProjectAsString[i].equals("[")) urlIndex++; 
				}	
			else
			{
				KmlAsString += PointToKml(ProjectAsString[i]);
				i++;
				
			}

		}
		KmlAsString+="</Folder></Document>\n</kml>";

		try {
			File file=new File("qqqqq"+".kml");

			if(!file.exists())
				file.createNewFile();

			PrintWriter pw=new PrintWriter(file);
			pw.print(KmlAsString);
			pw.close();
			System.out.println("done");
		}catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
