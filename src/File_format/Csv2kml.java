package File_format;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.sound.sampled.Line;

public class Csv2kml {

	public void csvConvertToKml(String csvFileAdress,String KmlFileName) throws IOException
	{
		

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\דניאל\\Desktop\\WigleWifi_20171203085618.csv")); 
		String line=br.readLine();

		String kmlString=
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">"+"\n"
				+"<Document><Folder>\n";
		//String [] arr=line.toString().split(",");
		line=br.readLine();///maybe i lose an important(first) line
		line=br.readLine();
		while (line != null) //maybe adding &&!line.isempty
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
	public String kmlConvert(String s)
	{
		//String[] arr=line.toString().split(",");
		String[] arr=s.split(",");
		String str="<Placemark>\n"
				+ "<name>"+"<![CDATA[" +arr[1]+ "]]>"+"</name>\n"
				+"<description>"+arr[10]+"</description>\n"
				+"<Point><coordinates>"+arr[7]+","+arr[6]+","+arr[8]+"</coordinates></Point>\n"
				+"<time>"+arr[3]+"</time></Placemark>\n";
		
		return str;
	}

}






