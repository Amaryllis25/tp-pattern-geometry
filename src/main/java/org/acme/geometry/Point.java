package org.acme.geometry;

public class Point implements Geometry{
	
    private Coordinate coordinate;

    //methods
    public Point() {
        this.coordinate = new Coordinate();
    }

    public Point(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    //getter
    public Coordinate getCoordinate() {
        return coordinate;
    }
    
    //override geometry methods
    @Override
    public String getType() {
        return "Point";
    }
    
    @Override
    public boolean isEmpty() {
        return Double.isNaN(coordinate.getX());
    }
    
}
