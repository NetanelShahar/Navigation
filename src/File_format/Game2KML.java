package File_format;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import Game_objects.Fruit;
import Game_objects.Game;
import Game_objects.Packman;
import Maps.Map;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Icon;
import de.micromata.opengis.kml.v_2_2_0.IconStyle;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Style;
import de.micromata.opengis.kml.v_2_2_0.TimeSpan;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;

public class Game2KML {

	public Game game ; 

	public Game2KML(Game game ) {
		// TODO Auto-generated constructor stub
		this.game = game ; 
	}
	
	
	public void Game2KMLfunction() throws ParseException
	{

		Kml kml = new Kml();
		Document doc = kml.createAndSetDocument();
		

		for (int i = 0; i < 700; i++) {


			for (Packman it: game.packmans) { //The iterator runs on a csv file.
				Placemark p = doc.createAndAddPlacemark();
				p.withDescription("Mac: "  + "\nType: pacman")
				.withOpen(Boolean.TRUE).createAndSetPoint().
				addToCoordinates(it.WhereInTime(i,game.GameMap).getLon(),it.WhereInTime(i,game.GameMap).getLat());
				
				String time1 = MillisToString(StringToMillis(TimeNow())+i*1000);
				String time2 = MillisToString(StringToMillis(TimeNow())+(i+1)*1000);
				
				String[] aa=time1.split(" ");
				time1=aa[0]+"T"+aa[1]+"Z";
				
				String[] bb=time2.split(" ");
				time2=bb[0]+"T"+bb[1]+"Z";
		
				
				TimeSpan a=p.createAndSetTimeSpan();
				a.setBegin(time1);
				a.setEnd(time2);
				
				
			}

		}
		for (Fruit it: game.fruits) { //The iterator runs on a csv file.
			Placemark p = doc.createAndAddPlacemark();
			
			
			Icon ff =new Icon();
			ff.setHref("http://www.coal-ash.co.il/maps/sites/all/modules/coalash/icons/red.png");
			ff.setViewBoundScale(1);
			ff.setViewRefreshTime(1);
			ff.withRefreshInterval(1);
			IconStyle pp = new IconStyle();
			pp.setScale(1);
			pp.setHeading(1);
			pp.setColor("ff007db3");
			pp.setIcon(ff);
			p.createAndAddStyle().setIconStyle(pp);
			
			p.withDescription("Mac: "  + "\nType: fruit")
			.withOpen(Boolean.TRUE).createAndSetPoint().
			addToCoordinates(it.getGpsLocation().getLon(),it.getGpsLocation().getLat());
			
			
			String time1 = MillisToString(StringToMillis(TimeNow())+(long)(it.EatenTime)*1000);
			String[] aa=time1.split(" ");
			time1=aa[0]+"T"+aa[1]+"Z";
			
			TimeSpan a=p.createAndSetTimeSpan();
			a.setEnd(time1);
			


		}


		try {
			kml.marshal(new File("KmlRun.kml"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String TimeNow()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
	}
	public long StringToMillis(String TimeAsString) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		Date date = format.parse(TimeAsString.toString());
		long millis = date.getTime();
		return millis;
	}
	public String MillisToString(Long millis) 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date(millis));
	}


}