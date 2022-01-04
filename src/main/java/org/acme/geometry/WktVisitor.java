package org.acme.geometry;

public class WktVisitor implements GeometryVisitor{
	
    private StringBuilder buffer;

    public WktVisitor() {
        this.buffer = new StringBuilder();
    }
    
    public String getResult(){
        return buffer.toString();
    }
    
	public static String writerCoordinate(Coordinate coordinate) {
		return coordinate.getX() + " " + coordinate.getY();
	}

    @Override
    public void visit(Point point) {
        if (point.isEmpty()) {
        	this.buffer.append("POINT EMPTY");
        }
        else {
        	this.buffer.append("POINT(" + writerCoordinate(point.getCoordinate()) +")");
        }
    }

    @Override
    public void visit(LineString lineString) {
        if (lineString.isEmpty()) {
        	this.buffer.append("LINESTRING EMPTY");
        }
        else {
            Point point1 = lineString.getPointN(0);
            this.buffer.append("LINESTRING(" + point1.getCoordinate().getX() + " " + point1.getCoordinate().getY());
            
            for (int i = 1; i < lineString.getNumPoints(); i++){
                this.buffer.append("," + writerCoordinate(lineString.getPointN(i).getCoordinate()));
            }
            
            this.buffer.append(")");
        }
    }
   
}
