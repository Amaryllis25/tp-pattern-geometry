package org.acme.geometry;

public class EnvelopeBuilder implements GeometryVisitor{
	
    private Envelope envelope;

    public EnvelopeBuilder() {
        this.envelope = new Envelope();
    }
	
	public void insert(Coordinate coordinate) {
		if(this.envelope.isEmpty()) {
			this.envelope = new Envelope(coordinate, coordinate);
		}
		else {
			if(coordinate.getX() < this.envelope.getXmin()) {
				Coordinate topRight = new Coordinate(this.envelope.getXmax(),this.envelope.getYmax());
                if (this.envelope.getYmin() > coordinate.getY())
                {
                	this.envelope = new Envelope(coordinate, topRight);
                }
                else {
                    Coordinate bottomLeft = new Coordinate(coordinate.getX(),this.envelope.getYmin());
                    this.envelope = new Envelope(bottomLeft, topRight);
                }
			}
			else if (this.envelope.getYmin() > coordinate.getY()){
                Coordinate topRight = new Coordinate();
                Coordinate bottomLeft = new Coordinate(this.envelope.getXmin(), coordinate.getY());
                this.envelope = new Envelope(bottomLeft, topRight);
            }
			if(coordinate.getX() > this.envelope.getXmax()) {
                Coordinate bottomLeft = new Coordinate(this.envelope.getXmin(),this.envelope.getYmin());
                if (this.envelope.getYmax() < coordinate.getY())
                this.envelope = new Envelope(bottomLeft, coordinate);
                else {
                    Coordinate topRight = new Coordinate(coordinate.getX(),this.envelope.getYmax());
                    this.envelope = new Envelope(bottomLeft, topRight);
                }
			}
			else if (this.envelope.getYmax() < coordinate.getY()){
                Coordinate topRight = new Coordinate(this.envelope.getXmax(),coordinate.getY());
                Coordinate bottomLeft = new Coordinate(this.envelope.getXmin(), this.envelope.getYmin());
                this.envelope = new Envelope(bottomLeft, topRight);
            }
		}
	}
	
    public Envelope build(){
        return this.envelope;
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
