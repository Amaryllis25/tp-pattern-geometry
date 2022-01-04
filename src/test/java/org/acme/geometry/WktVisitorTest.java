package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {

    @Test
    public void testVisitWithPointMethod(){
    	
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point(new Coordinate(1.1, 1.2));
		geometry.accept(visitor);
		
		Assert.assertEquals( "POINT(1.1 1.2)", visitor.getResult() );
    }
    
	@Test
	public void testVisitLineStringMethod() {
		
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = SampleFactory.createLineStringOA();
        geometry.accept(visitor);

		Assert.assertEquals( "LINESTRING(1.1 1.2,6.23 23.6)", visitor.getResult());
	}
	
    @Test
    public void testVisitWithNoPoint(){
    	
    	WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point();
		geometry.accept(visitor);

        Assert.assertEquals("POINT EMPTY", visitor.getResult());
    }
    
    @Test
    public void testVisitEmptyLineString(){
    	
    	WktVisitor visitor = new WktVisitor();
		Geometry geometry = new LineString();
		geometry.accept(visitor);

        Assert.assertEquals("LINESTRING EMPTY", visitor.getResult());
    }
}
