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
    }
    
    @Test
    public void testDefaultConstructor2() {
    	
        List<Point> points = new ArrayList<Point>();
        
        Point p = SampleFactory.createPointO();
        points.add(p);

        LineString line = new LineString(points);
        
        Assert.assertEquals(p, line.getPointN(0));
    }
    
    @Test
    public void testType() {
    	LineString line = new LineString();
    	Assert.assertEquals("LineString", line.getType());
    }
    
    @Test
    public void testConstructorIsEmpty() {
    	
    	LineString line = new LineString();

		Assert.assertTrue(line.isEmpty());
    }
    
    @Test
    public void testConstructorNotEmpty() {
    	
    	LineString line = SampleFactory.createLineStringOA();

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
    
	@Test
	public void testCloneMethod() {
		
		LineString line1 = SampleFactory.createLineStringOA();
		
		LineString line2 = line1.clone();
		
		Assert.assertNotSame(line1, line2);
		Assert.assertEquals(line1.getPointN(0).getCoordinate().getX(), line2.getPointN(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(line1.getPointN(0).getCoordinate().getY(), line2.getPointN(0).getCoordinate().getY(), EPSILON);
		Assert.assertEquals(line1.getPointN(1).getCoordinate().getX(), line2.getPointN(1).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(line1.getPointN(1).getCoordinate().getY(), line2.getPointN(1).getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testCloneMethodWithTranslate() {
		
		LineString line1 = SampleFactory.createLineStringOA();
		
		LineString line2 = line1.clone();
		
		line2.translate(10, -1);
		
		Assert.assertNotSame(line1, line2);
		Assert.assertNotSame(line1.getPointN(0).getCoordinate().getX(), line2.getPointN(0).getCoordinate().getX());
		Assert.assertNotSame(line1.getPointN(0).getCoordinate().getY(), line2.getPointN(0).getCoordinate().getY());
		Assert.assertEquals(16.23, line2.getPointN(1).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(22.6, line2.getPointN(1).getCoordinate().getY(), EPSILON);
	}
}
