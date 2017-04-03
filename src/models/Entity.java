package models;

import java.math.BigInteger;

public class Entity { //need to add address, group
	
	private BigInteger ID;
	private String name;
	
	public BigInteger getID() {
		return ID;
	}
	
	public void setID(BigInteger ID){
		this.ID = ID;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
