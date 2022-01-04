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
    public void testDefaultConstructorWithXY() {
        Coordinate c = new Coordinate(1.1, 1.2);
        Point p = new Point(c);
        Assert.assertEquals(c, p.getCoordinate());
    }
    
    @Test
    public void testType() {
		Point p = new Point();
        Assert.assertEquals("Point", p.getType());
    }
    
    @Test
    public void testConstructorNotEmpty() {
        Coordinate c = new Coordinate(1.1, 1.2);
        Point p = new Point(c);
        Assert.assertFalse(p.isEmpty());
    }
    
    @Test
    public void testConstructorIsEmpty() {
        Point p = new Point();
        Assert.assertTrue(p.isEmpty());
    }
    
    @Test
    public void testTranslateMethod() {
        Point p = SampleFactory.createPointO();
        p.translate(10, -1);
        Assert.assertEquals(11.1, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(0.2, p.getCoordinate().getY(), EPSILON);
		Assert.assertFalse(p.isEmpty());
    }

	@Test
	public void testCloneMethod() {

		Point Point1 = SampleFactory.createPointO();
		
		Point Point2 = Point1.clone();

		Assert.assertNotSame(Point1,Point2);
        Assert.assertEquals(1.1, Point2.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(1.2, Point2.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testCloneMethodWithTranslate() {
		
		Point Point1 = SampleFactory.createPointO();
		
		Point Point2 = Point1.clone();
		Point2.translate(10.0, -1);
		
		Assert.assertNotSame(Point1,Point2);
        Assert.assertEquals(11.1, Point2.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(0.2, Point2.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testMultipleClone() {
		
		Point Point1 = SampleFactory.createPointO();
		
		Point Point2 = Point1.clone();
		Point Point3 = Point2.clone();
		
		Assert.assertNotSame(Point1,Point2);
        Assert.assertEquals(Point1.getCoordinate().getX(), Point3.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(Point1.getCoordinate().getY(), Point3.getCoordinate().getY(), EPSILON);
	}
}
