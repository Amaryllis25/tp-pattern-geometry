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

    public static LineString createLineStringOA(){
        List<Point> points = new ArrayList<Point>();
        points.add(createPointO());
        points.add(createPointA());
        return new LineString(points);
    }
}
