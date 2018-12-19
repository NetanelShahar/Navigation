package File_format;

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
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

public class Game2KML {

	static Game game ; 
	
	public Game2KML() {
		// TODO Auto-generated constructor stub
		Map map = new Map();
		this.game =new Game(map); ; 
	}

	public void Game2KMLfunction()
	{
		
		Kml kml = new Kml();
		Document doc = kml.createAndSetDocument();
		for (Packman it: game.packmans) { //The iterator runs on a csv file.
			Placemark p = doc.createAndAddPlacemark();
			p.withDescription("Mac: "  + "\nType: pacman")
			.withOpen(Boolean.TRUE).createAndSetPoint().
			addToCoordinates(it.getGpsLocation().getLon(),it.getGpsLocation().getLat());
		
			
		}
		for (Fruit it: game.fruits) { //The iterator runs on a csv file.
			Placemark p = doc.createAndAddPlacemark();
			p.withDescription("Mac: "  + "\nType: pacman")
			.withOpen(Boolean.TRUE).createAndSetPoint().
			addToCoordinates(it.getGpsLocation().getLon(),it.getGpsLocation().getLat());
		
			
		}
		try {
			kml.marshal(new File("C:\\Users\\דניאל\\eclipse-workspace\\Navigation\\k.kml"));
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
	
	public static void main(String[] args) throws IOException {
		Game2KML g = new Game2KML();
		CSV2Game K = new CSV2Game(game.GameMap,game,"C:\\Users\\דניאל\\Desktop\\game_1543685769754.csv" );
		g.Game2KMLfunction();
		
	}
}