package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class SampleFactory {

    public static Point createPointO(){
        return new Point(new Coordinate(1.1, 1.2));
    }

    public static Point createPointA(){
        return new Point(new Coordinate(6.23, 23.6));
    }
    
	public static Point createPointB() {
		return new Point(new Coordinate(12.0, 24.0));
	}
	
	public static Point createPointC() {
		return new Point(new Coordinate(25.0, 13.0));
	}
	
	public static Point createPointD() {
		return new Point(new Coordinate(0.1, 0.4));
	}
	
    public static LineString createLineStringOA(){
        List<Point> points = new ArrayList<Point>();
        points.add(createPointO());
        points.add(createPointA());
        return new LineString(points);
    }
    
	public static LineString createLineStringOABCD() {
		List<Point> points = new ArrayList<Point>();
		points.add(createPointO());
		points.add(createPointA());
		points.add(createPointB());
		points.add(createPointC());
		points.add(createPointD());
		return new LineString(points);
	}
}
