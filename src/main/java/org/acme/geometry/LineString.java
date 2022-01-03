package org.acme.geometry;

import java.util.List;
import java.util.ArrayList;

public class LineString implements Geometry{
	
    private List<Point> points;

    //methods
    public LineString() {
        this.points = new ArrayList<Point>();
    }

    public LineString(List<Point> points) {
        this.points = points;
    }
    
    //getters
    public int getNumPoints(){
        return points.size();
    }

    public Point getPointN(int n){
        return points.get(n);
    }
    
    //override geometry methods
    @Override
    public String getType() {
        return "LineString";
    }
	
    @Override
    public boolean isEmpty() {
        return this.points.isEmpty();
    }
}
