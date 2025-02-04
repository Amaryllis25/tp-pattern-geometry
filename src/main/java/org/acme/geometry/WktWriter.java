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
            	wkt = "POINT(" + writerCoordinate(point.getCoordinate()) +")";
            }
        }
        else if (geometry instanceof LineString){
            LineString lineString = (LineString)geometry;
            if (lineString.isEmpty()) {
            	wkt = "LINESTRING EMPTY";
            }
            else {
                Point Point1 = lineString.getPointN(0);
                wkt = "LINESTRING(" + Point1.getCoordinate().getX() + " " + Point1.getCoordinate().getY();
                for (int i = 1; i < lineString.getNumPoints(); i++){
                    wkt += "," + writerCoordinate(lineString.getPointN(i).getCoordinate());
                }
                wkt += ")";
            }
        }
        else{
            throw new RuntimeException("geometry type not supported");
        }
        return wkt;
    }
    
	public static String writerCoordinate(Coordinate coordinate) {
		return coordinate.getX() + " " + coordinate.getY();
	}

}