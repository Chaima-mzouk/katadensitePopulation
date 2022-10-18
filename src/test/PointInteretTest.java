package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.PointInteret;

class PointInteretTest {

	private PointInteret pointInteret ;
	private int input;
	private int expected;

	
	 
	@Test
	void testId1() {
		pointInteret = new PointInteret("id1", -48.6, -37.7);
		input = pointInteret.isPointInZone(6.5, -7) ;
		expected = 0 ;
		assertEquals(input,expected);
	}

	@Test
	void testId5() {
		pointInteret = new PointInteret("id5", 6.8, -6.9);
		input = pointInteret.isPointInZone(6.5, -7) ;
		expected = 1 ;
		assertEquals(input,expected);
	}
	
	@Test
	void testId6() {
		pointInteret = new PointInteret("id6", -2.5, 38.3);
		input = pointInteret.isPointInZone(6.5, -7) ;
		expected = 0 ;
		assertEquals(input,expected);
	}
	
	@Test
	void testGetLat() {
		pointInteret = new PointInteret("id5", 6.8, -6.9);
		Double input = pointInteret.getLatitude();
		Double expected = 6.8 ;
		assertEquals(input,expected);
	}
	
	@Test
	void testGetLon() {
		pointInteret = new PointInteret("id6", -2.5, 38.3);
		double input = pointInteret.getLongitude() ;
		double expected = 38.3 ;
		assertEquals(input,expected);
	}
}
