package com.daniel.dnd.vo;

public abstract class Initiative implements Comparable<Initiative> {
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void rollInitiative();
	public abstract int  getCurrentInitiative();
	
}
