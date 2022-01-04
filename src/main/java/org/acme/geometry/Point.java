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
    
    @Override
    public void translate(double dx, double dy) {
        double X = this.coordinate.getX() + dx;
        double Y = this.coordinate.getY() + dy;
        this.coordinate = new Coordinate(X, Y);
    }
    
	@Override
	public Point clone() {
		return new Point (new Coordinate(this.coordinate.getX(),this.coordinate.getY()));
	}
}
