package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor{
	
	private PrintStream out;
	
    public LogGeometryVisitor() {
        this.out = System.out;
    }
	
	public LogGeometryVisitor(PrintStream out) {
		this.out = out;
	}
	
	public void visit(Point point) {
		out.println("Je suis un point avec x=" + point.getCoordinate().getX() + " et y="+ point.getCoordinate().getY());
	}
	
	public void visit(LineString lineString) {
		out.println("Je suis une polyligne définie par"+ lineString.getNumPoints() + "point(s)");
	}

}
