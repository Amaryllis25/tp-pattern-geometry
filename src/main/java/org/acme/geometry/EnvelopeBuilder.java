package org.acme.geometry;

public class EnvelopeBuilder {
	
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
                Coordinate bottomLeft = new Coordinate(coordinate.getX(),this.envelope.getYmin());      
                this.envelope = new Envelope(bottomLeft, topRight);
			}
			else if (this.envelope.getYmin() > coordinate.getY()){
                Coordinate topRight = new Coordinate(this.envelope.getXmax(),this.envelope.getYmax());
                Coordinate bottomLeft = new Coordinate(this.envelope.getXmin(), coordinate.getY());
                this.envelope = new Envelope(bottomLeft, topRight);
            }
			if(coordinate.getX() > this.envelope.getXmax()) {
				Coordinate topRight = new Coordinate(coordinate.getX(),this.envelope.getYmax());
                Coordinate bottomLeft = new Coordinate(this.envelope.getXmin(),this.envelope.getYmin());
                this.envelope = new Envelope(bottomLeft, topRight);
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
	
}
