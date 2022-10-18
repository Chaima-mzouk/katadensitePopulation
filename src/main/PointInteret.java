package main;

/**
 * 
 * An implementation of a point interet type.
 * 
 * @author chaimmaa
 *
 */
public class PointInteret {
	
	private String id;
	private double latitude;
	private double longitude;
	
	public PointInteret(String id, double latitude, double longitude) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * @return latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * @return longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	
	
	/**
	 * Test if a point exist in a zone
	 * @param minLatitude
	 * @param minLongitude
	 * @return 1 if exist else return 0
	 */
	public int isPointInZone(double minLatitude, double minLongitude) {
		if(this.latitude>minLatitude && this.longitude > minLongitude) {
			return 1;
		}
		return 0; 
	}
}
