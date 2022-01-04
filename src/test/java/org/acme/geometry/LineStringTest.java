package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LineStringTest {
	
	public static final double EPSILON = 1.0e-15;
	
    @Test
    public void testDefaultConstructor() {
    	
        LineString lineString = new LineString();
        
        Assert.assertEquals(0, lineString.getNumPoints());
    }
    
    @Test
    public void testDefaultConstructor2() {
    	
        List<Point> points = new ArrayList<Point>();
        
        Point p = SampleFactory.createPointO();
        points.add(p);

        LineString lineString = new LineString(points);
        
        Assert.assertEquals(p, lineString.getPointN(0));
    }
    
    @Test
    public void testType() {
    	LineString lineString = new LineString();
    	Assert.assertEquals("LineString", lineString.getType());
    }
    
    @Test
    public void testConstructorIsEmpty() {
    	
    	LineString lineString = new LineString();

		Assert.assertTrue(lineString.isEmpty());
    }
    
    @Test
    public void testConstructorNotEmpty() {
    	
    	LineString lineString = SampleFactory.createLineStringOA();

        Assert.assertEquals(2, lineString.getNumPoints());
		Assert.assertFalse(lineString.isEmpty());
    }
    
    @Test
    public void testDefaultConstructorFact() {
    	
        LineString lineString = SampleFactory.createLineStringOA();

        Assert.assertEquals(2, lineString.getNumPoints());
        Assert.assertEquals(1.1, lineString.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(1.2, lineString.getPointN(0).getCoordinate().getY(), EPSILON);
        Assert.assertEquals(6.23, lineString.getPointN(1).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(23.6, lineString.getPointN(1).getCoordinate().getY(), EPSILON);
		Assert.assertFalse(lineString.isEmpty());
    }
    
    @Test
    public void testTranslate() {
    	
        LineString lineString = SampleFactory.createLineStringOA();
        lineString.translate(10, 10);
        
        Assert.assertEquals(11.1, lineString.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(11.2, lineString.getPointN(0).getCoordinate().getY(), EPSILON);
        Assert.assertEquals(16.23, lineString.getPointN(1).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(33.6, lineString.getPointN(1).getCoordinate().getY(), EPSILON);
		Assert.assertFalse(lineString.isEmpty());
    }
    
	@Test
	public void testCloneMethod() {
		
		LineString lineString1 = SampleFactory.createLineStringOA();
		
		LineString lineString2 = lineString1.clone();
		
		Assert.assertNotSame(lineString1, lineString2);
		Assert.assertEquals(lineString1.getPointN(0).getCoordinate().getX(), lineString2.getPointN(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(lineString1.getPointN(0).getCoordinate().getY(), lineString2.getPointN(0).getCoordinate().getY(), EPSILON);
		Assert.assertEquals(lineString1.getPointN(1).getCoordinate().getX(), lineString2.getPointN(1).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(lineString1.getPointN(1).getCoordinate().getY(), lineString2.getPointN(1).getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testCloneMethodWithTranslate() {
		
		LineString lineString1 = SampleFactory.createLineStringOA();
		
		LineString lineString2 = lineString1.clone();
		
		lineString2.translate(10, -1);
		
		Assert.assertNotSame(lineString1, lineString2);
		Assert.assertNotSame(lineString1.getPointN(0).getCoordinate().getX(), lineString2.getPointN(0).getCoordinate().getX());
		Assert.assertNotSame(lineString1.getPointN(0).getCoordinate().getY(), lineString2.getPointN(0).getCoordinate().getY());
		Assert.assertEquals(16.23, lineString2.getPointN(1).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(22.6, lineString2.getPointN(1).getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testGetEnvelopeMethod() {

		LineString lineString = SampleFactory.createLineStringOABCD();
		Envelope envelope = lineString.getEnvelope();
		
		Assert.assertEquals(0.1, envelope.getXmin(), EPSILON);
		Assert.assertEquals(0.4, envelope.getYmin(), EPSILON);
		Assert.assertEquals(25, envelope.getXmax(), EPSILON);
		Assert.assertEquals(24, envelope.getYmax(), EPSILON);
	}
}
