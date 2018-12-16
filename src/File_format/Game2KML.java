package File_format;

import Game_objects.Game;
import Game_objects.Packman;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

public class Game2KML {

	Game game ; 
	
	public Game2KML(Game game) {
		// TODO Auto-generated constructor stub
		this.game =game ; 
	}
	
	public void Game2KMLfunction()
	{
		Kml kml = new Kml();
	  Document doc = kml.createAndSetDocument();
		for (Packman it: game.packmans) { //The iterator runs on a csv file.
			Placemark p = doc.createAndAddPlacemark();
			p.withDescription("Mac: "  + "\nType: pacman")
			.withOpen(Boolean.TRUE).createAndSetPoint().
			addToCoordinates(it.getGpsLocation()Location().x(),it.getLocation().y());
//		}

	}
}
