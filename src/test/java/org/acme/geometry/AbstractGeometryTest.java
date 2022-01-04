package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class AbstractGeometryTest {
	
	@Test
	public void testTextMethodPoint(){
		Point p = SampleFactory.createPointO();
		Assert.assertEquals("POINT(1.1 1.2)", p.asText());
	}
	
	@Test
	public void testTextMethodineString(){
		LineString lineString = SampleFactory.createLineStringOA();
		Assert.assertEquals("LINESTRING(1.1 1.2,6.23 23.6)", lineString.asText());
	}
}
