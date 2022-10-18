package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import main.DataFromCSV;
import main.Zone;

public class ZoneTest {
	String fileName;
	DataFromCSV data;
	private int input;
	private int expected;
	
	
	@Before
	public void init() {
		this.fileName = "donnee.csv";
		this.data = new DataFromCSV(fileName);
	}
	
	@Test
	public void testZone1() {
		Zone zone = new Zone(data);
		input = zone.POIsInZone(6.5, -7) ;
		expected = 2 ;
		assertEquals(input,expected);
	}
	
	
	@Test
	public void testZone2() {
		Zone zone = new Zone(data);
		input = zone.POIsInZone(0.1, -0.1) ;
		expected = 0 ;
		assertEquals(input,expected);
	}
	
	@Test
	public void testZone3() {
		Zone zone = new Zone(data);
		input = zone.POIsInZone(-2.3, 38.3) ;
		expected = 0 ;
		assertEquals(input,expected);
	}
}
