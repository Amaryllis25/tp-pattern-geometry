package org.acme.geometry;

public class WktWriter {
	
	public WktWriter() {
	}
	
    public String write(Geometry geometry){
    	
        String wkt = "";

        if (geometry instanceof Point){
            Point point = (Point)geometry;
            if (point.isEmpty()) {
            	wkt = "POINT EMPTY";
            }
            else {
            	wkt = "POINT(" + point.getCoordinate().getX() + " " + point.getCoordinate().getY() + ")";
            }
        }
        else if (geometry instanceof LineString){
            LineString line = (LineString)geometry;
            if (line.isEmpty()) {
            	wkt = "LINESTRING EMPTY";
            }
            else {
                Point Point1 = line.getPointN(0);
                wkt = "LINESTRING(" + Point1.getCoordinate().getX() + " " + Point1.getCoordinate().getY();
                for (int i = 1; i < line.getNumPoints(); i++){
                    Point p = line.getPointN(i);
                    wkt += "," + p.getCoordinate().getX() + " " + p.getCoordinate().getY();
                }
                wkt += ")";
            }
        }
        else{
            throw new RuntimeException("geometry type not supported");
        }
        return wkt;
    }

}
