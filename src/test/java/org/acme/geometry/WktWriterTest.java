package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktWriterTest {

	@Test
	public void testWriteMethodWithEmptyPoint() {
		
		WktWriter wkt = new WktWriter();
		Point p = new Point();
		
		String str = wkt.write(p);
		
		Assert.assertEquals("POINT EMPTY", str);
	}
	
	
	@Test
	public void testWriteLineEmptyString() {
		
		WktWriter wkt = new WktWriter();
		LineString line = new LineString();
		
		String str = wkt.write(line);
		
		Assert.assertEquals("LINESTRING EMPTY",str);
	}
	
	@Test
	public void testWriteMethodPoint() {

		WktWriter wkt = new WktWriter();
		Point p = SampleFactory.createPointO();
		
		String str = wkt.write(p);
		
		Assert.assertEquals("POINT(1.1 1.2)", str);
	}
	
	@Test
	public void testWriteMethodLinestring() {

		WktWriter wkt = new WktWriter();
		
		LineString line = SampleFactory.createLineStringOA();
		
		String str = wkt.write(line);
				
		Assert.assertEquals("LINESTRING(1.1 1.2,6.23 23.6)", str);
	}
}