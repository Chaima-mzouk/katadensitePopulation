package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * An implementation of conversion data in file csv into list of point interet
 * 
 * @author chaimmaa
 *
 */
public class DataFromCSV {
	
	private List<PointInteret> dataPoint = new ArrayList();
	
	public DataFromCSV(String fileName) {
		Path pathToFile = Paths.get(fileName);

        try (BufferedReader buffer = Files.newBufferedReader(pathToFile))
        {

        	 String line = buffer.readLine();
        	 line = buffer.readLine();
            while (line != null) {
            	 String[] attributes = line.split(";");
            	 String id = attributes[0];
            	 double latitude = Double.parseDouble(attributes[1]);
            	 double longitude = Double.parseDouble(attributes[2]);
            	 PointInteret point = new PointInteret(id, latitude, longitude);
            	 this.dataPoint.add(point);
            	 line = buffer.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public List<PointInteret> getDataPoint() {
		return dataPoint;
	}
	
	
}
