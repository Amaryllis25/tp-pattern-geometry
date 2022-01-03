package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		// TODO
		Coordinate c = new Coordinate();
		Assert.assertEquals(Double.NaN, c.getX(), EPSILON);
		Assert.assertEquals(Double.NaN, c.getY(), EPSILON);
		Assert.assertTrue(c.isEmpty());
	}

	@Test
	public void testDefaultConstructor2(){
		Coordinate c = new Coordinate(1.1, 1.2);
		Assert.assertEquals(1.1, c.getX(), EPSILON);
		Assert.assertEquals(1.2, c.getY(), EPSILON);
		Assert.assertFalse(c.isEmpty());
	}
}
