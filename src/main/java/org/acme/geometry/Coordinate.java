package org.acme.geometry;

public class Coordinate {
	
	private final double x;
	private final double y;

	//getter
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
    
    //method coordinate
    public Coordinate() {
        this.x = Double.NaN;
        this.y = Double.NaN;
    	}
    
    public Coordinate(double x, double y) {
    	this.x = x;
    	this.y = y;
    	}
    
    public boolean isEmpty(){
        return Double.isNaN(x);
    }
}
