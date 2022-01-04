package org.acme.geometry;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class EnvelopeBuilder implements GeometryVisitor{
	
    private Envelope envelope;
    
    private List<Double> xVals;
    private List<Double> yVals;

    public EnvelopeBuilder() {
        this.xVals = new ArrayList<Double>();
        this.yVals = new ArrayList<Double>();
    }
    
    public List<Double> getXValues() {
        return this.xVals;
    }

    public List<Double> getYValues() {
        return this.yVals;
    }

    public void insert(Coordinate coordinate) {
        this.xVals.add(coordinate.getX());
        this.yVals.add(coordinate.getY());
    }
	
    public Envelope build() {
    	if((xVals.size() == yVals.size()) && xVals.size()>0) {
    		double xmin = Collections.min(xVals);
    		double xmax = Collections.max(xVals);

    		double ymin = Collections.min(yVals);
    		double ymax = Collections.max(yVals);

    		Coordinate bottomLeft = new Coordinate(xmin, ymin);
    		Coordinate topRight = new Coordinate(xmax, ymax);
    		return new Envelope(bottomLeft, topRight);
    	}
    	else {
    		return new Envelope();
    	}
    }
    
    @Override
    public void visit(Point point) {
        this.insert(point.getCoordinate());
    }

    @Override
    public void visit(LineString lineString) {
        for(int i=0; i < lineString.getNumPoints(); ++i) {
            this.insert(lineString.getPointN(i).getCoordinate());
        }
    }
	
}
