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

}
