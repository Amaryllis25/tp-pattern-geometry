package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
	
	public static final double EPSILON = 1.0e-15;
	
    @Test
    public void testDefaultConstructor() {
        LineString line = new LineString();
        Assert.assertEquals(0, line.getNumPoints());
        Assert.assertTrue(line.isEmpty());
    }
    
    @Test
    public void testDefaultConstructor2() {
        List<Point> points = new ArrayList<Point>();
        Coordinate c = new Coordinate(1.1, 1.2);
        Point p = new Point(c);
        points.add(p);

        LineString line = new LineString(points);
        Assert.assertEquals(p, line.getPointN(0));
		Assert.assertFalse(line.isEmpty());
    }
    
    @Test
    public void testType() {
    	LineString line = new LineString();
    	Assert.assertEquals("LineString", line.getType());
    }
    
    @Test
    public void testConstructorSizeAdd() {
        List<Point> points = new ArrayList<Point>();
        Coordinate c = new Coordinate(1.1, 1.2);
        Coordinate c2 = new Coordinate(1.3, 1.4);
        
        Point p = new Point(c);
        Point p2 = new Point(c2);
        
        points.add(p);
        points.add(p2);

        LineString line = new LineString(points);
        Assert.assertEquals(2, line.getNumPoints());
		Assert.assertFalse(line.isEmpty());
    }
    
}
