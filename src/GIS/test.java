package GIS;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class test {
public static void main(String[] args) {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
	format.setTimeZone(TimeZone.getTimeZone("UTC"));

	Date date = format.parse(null);
	long millis = date.getTime();
    
}}
