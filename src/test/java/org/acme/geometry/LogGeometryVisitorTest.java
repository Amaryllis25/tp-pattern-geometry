package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

public class LogGeometryVisitorTest {
	
    @Test
    public void testVisitPoint() throws UnsupportedEncodingException{
    	
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        Point p = SampleFactory.createPointO();
        p.accept(visitor);

        out.println("Je suis un point avec x=1.1 et y=1.2");
        String result = os.toString("UTF8");
        String[] results = result.split("\n");

        Assert.assertEquals(results[0], results[1]);
    }
    
    @Test
    public void testVisitLineString() throws UnsupportedEncodingException{
    	
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        LineString lineString = SampleFactory.createLineStringOABCD();
        lineString.accept(visitor);

        out.println("Je suis une polyligne définie par 5 point(s).");
        String result = os.toString("UTF8");
        String[] results = result.split("\n");

        Assert.assertEquals(results[0], results[1]);
    }
    
    @Test
    public void testVisitEmpty() throws UnsupportedEncodingException{
    	
    	ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor();
        
        LineString lineString = SampleFactory.createLineStringOABCD();
        lineString.accept(visitor);
        
        String result = os.toString("UTF8");
        
        Assert.assertEquals("", result);
    }

}
