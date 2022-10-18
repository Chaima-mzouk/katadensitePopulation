package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * An implementation of a zone that contient a list of point interet
 * 
 * @author chaimmaa
 *
 */
public class Zone {

	private List<PointInteret> pointsInteres = new ArrayList();

	
	public Zone(DataFromCSV data) {
		this.pointsInteres = data.getDataPoint();
	}
	
	public int POIsInZone(double minLatitude, double minLongitude) {
		int numberOfZone = 0;
		for(PointInteret point : this.pointsInteres) {
			numberOfZone += point.isPointInZone(minLatitude, minLongitude);
		}
		return numberOfZone;
	}
	
	/**
	 * 
	 * get the max and min value of point
	 * 
	 * @param numberZone
	 * @return a map of string and double
	 */
	public Map<String, Double> zoneDense(int numberZone){
		
		Map<String, Double> zoneDenses = new HashMap<>();  
		
		TreeMap<Integer, PointInteret> densiteInZone = densiteInZone();
		
		List<PointInteret> points = pointDenses(numberZone, densiteInZone);
		
		for(PointInteret point : points ) {
			zoneDenses.put("minLat", point.getLatitude());
			zoneDenses.put("minLon", point.getLongitude());
		}

		return zoneDenses;
	}

	/*
	 * get the numberZone that have the max densite
	 * 
	 * @param numberZone
	 * @return
	 */
	public List<PointInteret> pointDenses(int numberZone, TreeMap<Integer, PointInteret> densiteInZone) {
		List<PointInteret> points = new ArrayList();
		
		for(int i=0; i< numberZone;i++) {
			
			//System.out.println(POIsInZone.pollLastEntry());
			PointInteret point = densiteInZone.pollLastEntry().getValue();
			points.add(point);
						
		}
		return points;
	}

	/**
	 * 
	 * Calculate densite of every point
	 * 
	 * @return
	 */
	public TreeMap<Integer, PointInteret> densiteInZone() {
		TreeMap<Integer, PointInteret> POIsInZone = new TreeMap<>();
		int densite = 0;

		for(PointInteret point : this.pointsInteres) {
			densite = this.POIsInZone(point.getLatitude(), point.getLongitude());
			
			POIsInZone.put(densite, point);

		}
		return POIsInZone;
		
	}
}
