package com.daniel.dnd.vo;

public class CharacterInitiative implements Comparable<CharacterInitiative>{

	private String name;
	private int currentInitiative;
	private int tieBreaker;
	private int permanentModifier;
	private int temporaryModifier;
	private int size;
	private boolean hasAdvantage;
	private boolean hasDisadvantage;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrentInitiative() {
		return currentInitiative;
	}
	public void setCurrentInitiative(int currentInitiative) {
		this.currentInitiative = currentInitiative;
	}
	public int getPermanentModifier() {
		return permanentModifier;
	}
	public void setPermanentModifier(int permanentModifier) {
		this.permanentModifier = permanentModifier;
	}
	public int getTemporaryModifier() {
		return temporaryModifier;
	}
	public void setTemporaryModifier(int temporaryModifier) {
		this.temporaryModifier = temporaryModifier;
	}
	public boolean isHasAdvantage() {
		return hasAdvantage;
	}
	public void setHasAdvantage(boolean hasAdvantage) {
		this.hasAdvantage = hasAdvantage;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public boolean isHasDisadvantage() {
		return hasDisadvantage;
	}
	public void setHasDisadvantage(boolean hasDisadvantage) {
		this.hasDisadvantage = hasDisadvantage;
	}

	@Override
	public String toString() {
		return "CharacterInitiative [name=" + name + ", currentInitiative=" + currentInitiative + ", tieBreaker="
				+ tieBreaker + ", permanentModifier=" + permanentModifier + ", temporaryModifier=" + temporaryModifier
				+ ", size=" + size + ", hasAdvantage=" + hasAdvantage + ", hasDisadvantage=" + hasDisadvantage + "]";
	}
	public int compareTo(CharacterInitiative arg0) {
		if(currentInitiative == arg0.getCurrentInitiative()) return 0;
		else if(currentInitiative < arg0.getCurrentInitiative()) return 1;
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
		return currentInitiative;
	}
	
	
}
