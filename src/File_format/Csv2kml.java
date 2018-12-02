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

public class Csv2kml {

	long UTC ; 



	private long DateToMilis(String dateAndTime) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date date = format.parse(dateAndTime);
		long millis = date.getTime();
		return millis;
	}


	public void csvConvertToKml(String csvFileAdress,String KmlFileName) throws IOException, ParseException
	{


		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\דניאל\\Desktop\\WigleWifi_20171201110209.csv")); 
		String line=br.readLine();

		String kmlString=
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
						"<kml xmlns=\"http://www.opengis.net/kml/2.2\">"+"\n"
						+"<Document><Folder>\n";
		
		line=br.readLine();
		line=br.readLine();
		while (line != null) 
		{

			kmlString=kmlString+kmlConvert(line.toString());
			//			kmlString=kmlString+line.toString()+"\n";

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



	
	public String kmlConvert(String s) throws ParseException
	{
		//String[] arr=line.toString().split(",");
		String[] arr=s.split(",");
		long time = DateToMilis(arr[3]);
		String str="<Placemark>\n"
				+ "<name>" +arr[1]+"</name>\n"
				+"<description><![CDATA[BSSID: <b>"+arr[0]+"</b><br/>Timestamp: <b>"+time+"</b><br/>Data: <b>"+ arr[3]+ "</b>]]" + "></description>\n"
				+"<Point><coordinates>"+arr[7]+","+arr[6]+","+arr[8]+"</coordinates></Point>\n"
				+"<time>"+arr[3]+"</time></Placemark>\n";

		return str;
	}

	private String PointToKml(String Data) throws ParseException
	{
		String[] arr=Data.split(",");
		long time = DateToMilis(arr[5]);
		String str="<Placemark>\n"
				+ "<name>" +arr[4]+"</name>\n"
				+"<description><![CDATA[BSSID: <b>"+arr[3]+"</b><br/>Timestamp: <b>"+time+"</b><br/>Data: <b>"+ arr[5]+ "</b>]]" + "></description>\n"
				+"<Point><coordinates>"+arr[1]+","+arr[0]+","+arr[2]+"</coordinates></Point>\n"
				+"<time>"+arr[5]+"</time></Placemark>\n";

		return str;
	}
	public void ObjectToKml(MyGISProject Project) throws ParseException
	{
		String KmlAsString = 
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
						"<kml xmlns=\"http://www.opengis.net/kml/2.2\">"+"\n"
						+"<Document><Folder>\n"; 
		String toString = Project.toString();
		String[] ProjectAsString = toString.split("\n");
		int i = 1 ;
		while(!ProjectAsString[i].equals("}"))
		{
			if(ProjectAsString[i].equals("[") || ProjectAsString[i].equals("]")) i++;
			else
			{
				KmlAsString += PointToKml(ProjectAsString[i]);
				i++;
			}

		}
		KmlAsString+="</Folder></Document>\n</kml>";
		//	System.out.println(KmlAsString);

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






