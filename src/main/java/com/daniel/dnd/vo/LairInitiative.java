package com.daniel.dnd.vo;

public class LairInitiative extends Initiative implements Comparable<Initiative> {

	public int initiative;
	
	
	
	public int getInitiative() {
		return initiative;
	}



	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}


	@Override
	public int getCurrentInitiative() {
		return initiative;
	}



	@Override
	public void rollInitiative() {
		// do nothing
		
	}
	
	public int compareTo(Initiative arg0) {
		if(initiative == arg0.getCurrentInitiative()) {
			if(arg0 instanceof CharacterInitiative) {
				return 1;
			} else {
				return 0;
			}
		}
		else if(initiative < arg0.getCurrentInitiative()) return 1;
		else return -1;
		
	}
	
	public boolean equals(Object o) {
		if(o instanceof CharacterInitiative) {
			if(compareTo((CharacterInitiative)o) == 0) {
				return true;
			}
		}
		return false;
	}
	

	@Override
	public int hashCode() {
		return initiative;
	}



	@Override
	public String toString() {
		return "LairInitiative [name=" + getName() + ", initiative=" + initiative + "]";
	}
	
	

}
