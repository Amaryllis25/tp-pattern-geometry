package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    
    @Test
    public void testDefaultConstructorFact() {
    	
        LineString line = SampleFactory.createLineStringOA();

        Assert.assertEquals(2, line.getNumPoints());
        Assert.assertEquals(1.1, line.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(1.2, line.getPointN(0).getCoordinate().getY(), EPSILON);
        Assert.assertEquals(6.23, line.getPointN(1).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(23.6, line.getPointN(1).getCoordinate().getY(), EPSILON);
		Assert.assertFalse(line.isEmpty());
    }
    
    @Test
    public void testTranslate() {
    	
        LineString line = SampleFactory.createLineStringOA();
        line.translate(10, 10);
        
        Assert.assertEquals(11.1, line.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(11.2, line.getPointN(0).getCoordinate().getY(), EPSILON);
        Assert.assertEquals(16.23, line.getPointN(1).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(33.6, line.getPointN(1).getCoordinate().getY(), EPSILON);
		Assert.assertFalse(line.isEmpty());
    }
}
