package timestamps.models;

import java.math.BigInteger;

public class Statistics {
	
	private BigInteger entityID;
	private long timestamp;
	private double temperature;
	private double hDDSpace;
	private double rAMLoad;
	
	public BigInteger getEntityID() {
		return entityID;
	}
	
	public void setEntityID(BigInteger entityID) {
		this.entityID = entityID;
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	public double gethDDSpace() {
		return hDDSpace;
	}
	
	public void sethDDSpace(double hDDSpace) {
		this.hDDSpace = hDDSpace;
	}
	
	public double getrAMLoad() {
		return rAMLoad;
	}
	
	public void setrAMLoad(double rOMLoad) {
		this.rAMLoad = rOMLoad;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
