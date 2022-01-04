package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry{
	
    public String asText() {
        WktVisitor visitor = new WktVisitor();
		this.accept(visitor);
        return visitor.getResult();
    }

    @Override
    public abstract Geometry clone();
    
    @Override
    public Envelope getEnvelope() {

        EnvelopeBuilder builder = new EnvelopeBuilder();
        this.accept(builder);
        return builder.build();
    }
}
