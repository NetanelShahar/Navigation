package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class testing {

	public static void main(String[] args) throws IOException {
		//		// TODO Auto-generated method stub
		
//		try {
//		File file=new File("zaz.kml");
//		
//		if(!file.exists())
//			file.createNewFile();
//		
//		PrintWriter pw=new PrintWriter(file);
//		pw.println("bla blah jah");
//		pw.print(1000);
//		pw.close();
//		System.out.println("done");
//		}catch(IOException e)
//		{
//			e.printStackTrace();
//		}
		
		Csv2kml a=new Csv2kml();
		a.csvConvertToKml("‪C:\\Users\\דניאל\\Desktop\\מדעי המחשב\\מונחה עצמי\\מטלה 2 מונחה\\Ex2\\data\\WigleWifi_20171203085618.csv","hope");
		
		
//		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\׳ ׳×׳ ׳�׳� ׳‘׳� ׳™׳©׳©׳›׳¨\\Desktop\\example\\WigleWifi_20171201110209.csv"));
//		br.close();
	}

	

	

}
