package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor(){
		// TODO
		Point p = new Point();
		Assert.assertEquals(Double.NaN, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(Double.NaN, p.getCoordinate().getY(), EPSILON);
	}
	
    @Test
    public void testDefaultConstructor2() {
        Coordinate c = new Coordinate(1.1, 1.2);
        Point p = new Point(c);
        Assert.assertEquals(c, p.getCoordinate());
        Assert.assertFalse(p.isEmpty());
    }
    
    @Test
    public void testType() {
		Point p = new Point();
        Assert.assertEquals("Point", p.getType());
    }
}
