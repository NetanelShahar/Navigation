# PacmanNavigation![200px-pac_man svg](https://user-images.githubusercontent.com/44754325/49365224-e9cd5f00-f6ee-11e8-8a7b-4521bce0280f.png)

## Descreption

The project represents a game called Pacman Navigation, the game is performed on img of Google Earth. The course of the game: Choose a map location for Pacmans and fruits, then the goal of the Pacmans to eat the fruits in the shortest time (in terms of distance), the end of the game:
Will be displayed on the map any track that Packman has made
There is an example below the map.

### Algorithms 
In the algorithm package there is an algorithms:
- MultiCSV : algorithm that receives a project and target folder for scanning, scans it recursively, and once it reaches a CSV file, it creates a layer and adds it to the project.
- ShorthPathAlgorithm :The algorithm checks the shortest time for each Pacman, so at the end of the last Packman time all the fruits will be eaten (this is a greedy algorithm at the moment) .

### Coords 
The Coords package has the:
 #### mycoords class
  Represents a Class that allows us to perform calculations between GPS points such as:
  - Move a point with a vector
  - Calculates a vector between two points
  - Azimuth calculation, Elevation
  - Distance between two points
  ..
 
### File format 
The File format package has:
#### CSV2Kml class
The class has two functions:
- CSV2Kml function accepts a .csv file as a PATH,
And manually converts it to a .kml file.
- Object2Kml function accepts a project. Which inside it has layers and within layers there is information with points,
Then the function converts the points to the directions on the map (each route on the map represents a layer)
#### CSV2Game class
The class convert a CSV file to Game (Object in java) . 
#### Game2CSV class
The class create CSV File and insert the data from Game Object . 
#### Game2KML class
The class create KML file that run on Google Earth.
Running on Google Earth simulates a game like in gui in Java
### ExampleAfterRun (the Picture is from GoogleEarth , GIS CLASS ( not game) ) : 
![1](https://user-images.githubusercontent.com/44754325/49378919-90792600-f716-11e8-9697-6fd1778c0049.png)

### Geom 
Geom package represents shapes in space:
- GPSPoint: lat,long,alt (regular GPS Point ) 
- Point3D : can represents GPSPoint and vec .

### Gis package
This package represents a data structure that contains GPS points information:
- Meta_Data : represents Data according to class.
For example, in GIS_Element the data represents the information on the point such as color time, etc. (comprehensive documentation is found in the departments themselves, see doc folder).
Each point is reserved as an element which has information for each point such as: accuracy, name, etc.
- GIS_Element : Represents a GPS point of a map with information about the point.
- GIS_Layer : Represents a collection of points / directions on the map. (Similar to one csv file)
- GIS_Project : Represents a collection of layers / tracks on the map. (Similar to the folder of .csv files)
 #### ClassDiagram
![classd](https://user-images.githubusercontent.com/44754325/50738259-8d23ff00-11da-11e9-9f86-abfeec50958b.png)
 
 
### ExampleGameMap
![ariel1](https://user-images.githubusercontent.com/44754325/49361557-0b294d80-f6e5-11e8-90f0-a871b2571359.png)
### ExampleBeforeRun
![16](https://user-images.githubusercontent.com/44754325/50387581-72488980-0708-11e9-914f-c0835c6df1be.png)
### ExampleAfterRun
![17](https://user-images.githubusercontent.com/44754325/50387584-842a2c80-0708-11e9-95c0-a5d6c0b590b1.png)
### ExampleKmlRun
![18](https://user-images.githubusercontent.com/44754325/50387587-9ad08380-0708-11e9-8cb0-2c1ea3cc6bb4.png)
### Sorces

 - converting coordinates : https://stackoverflow.com/questions/1185408/converting-from-longitude-latitude-to-cartesian-coordinates  

- calculating 3D vector : https://stackoverflow.com/questions/41912407/calculate-a-vector-in-meter-from-two-gps-coordinates 

 - calculating distance : http://www.vias.org/comp_geometry/math_coord_convert_3d.htm

- how to convert csv to kml(from the resource) : http://convertcsv.com/csv-to-kml.htm 

- the idea of Azimuth : https://en.wikipedia.org/wiki/Azimuth 

