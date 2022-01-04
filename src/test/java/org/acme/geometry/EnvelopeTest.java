package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor(){
		
		// TODO
		Envelope envelope = new Envelope();
		Assert.assertEquals(Double.NaN, envelope.getXmin(), EPSILON);
		Assert.assertEquals(Double.NaN, envelope.getYmin(), EPSILON);
		Assert.assertEquals(Double.NaN, envelope.getXmax(), EPSILON);
		Assert.assertEquals(Double.NaN, envelope.getYmax(), EPSILON);
	}
	
	@Test
	public void testDefaultConstructorXY(){
		
		Coordinate bottomLeft = new Coordinate(1.1, 1.2);
		Coordinate topRight = new Coordinate(6.23, 23.6);
		
		Envelope envelope = new Envelope(bottomLeft, topRight);
		
		Assert.assertEquals(1.1, envelope.getXmin(), EPSILON);
		Assert.assertEquals(1.2, envelope.getYmin(), EPSILON);
		Assert.assertEquals(6.23, envelope.getXmax(), EPSILON);
		Assert.assertEquals(23.6, envelope.getYmax(), EPSILON);
	}
	
	@Test
	public void testConstructorIsEmpty(){
		
		// TODO
		Coordinate bottomLeft = new Coordinate(1.1, 1.2);
		Coordinate topRight = new Coordinate();
		
		Envelope envelope = new Envelope(bottomLeft, topRight);
		
		Assert.assertTrue(envelope.isEmpty());
	}
	
	@Test
	public void testConstrutorNotEmpty() {		
		
		Coordinate bottomLeft = new Coordinate(1.1, 1.2);
		Coordinate topRight = new Coordinate(6.23, 23.6);
		
		Envelope envelope = new Envelope(bottomLeft, topRight);
		
		Assert.assertFalse(envelope.isEmpty());
	}
}
