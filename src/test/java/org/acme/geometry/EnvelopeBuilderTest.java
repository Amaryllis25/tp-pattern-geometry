package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeBuilderTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(new Coordinate(1.1, 1.2));
		builder.insert(new Coordinate(6.23, 23.6));
		builder.insert(new Coordinate(0.0, 0.0));
		Envelope envelope = builder.build();
		
        Assert.assertEquals(0.0, envelope.getXmin(), EPSILON);
        Assert.assertEquals(0.0, envelope.getYmin(), EPSILON);
        Assert.assertEquals(6.23, envelope.getXmax(), EPSILON);
        Assert.assertEquals(23.6, envelope.getYmax(), EPSILON);
	}

	@Test
	public void testConstructorNotEmpty() {
		
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(new Coordinate(1.1, 1.2));
		builder.insert(new Coordinate(6.23, 23.6));
		builder.insert(new Coordinate(0.0, 0.0));
		Envelope envelope = builder.build();
		
        Assert.assertFalse(envelope.isEmpty());
	}
	
	
	@Test
	public void testConstructorIsEmpty() {
		
		EnvelopeBuilder builder = new EnvelopeBuilder();
		Envelope envelope = builder.build();
		
        Assert.assertTrue(envelope.isEmpty());
	}
}