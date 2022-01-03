package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor(){
		// TODO
		Point p = new Point();
		Assert.assertEquals(0.0, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(0.0, p.getCoordinate().getY(), EPSILON);
	}
	
    @Test
    public void testDefaultConstructor2() {
        Coordinate c = new Coordinate(1.1, 1.2);
        Point p = new Point(c);
        Assert.assertEquals(c, p.getCoordinate());
    }
}
