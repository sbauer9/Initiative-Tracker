package com.daniel.dnd.vo;

import java.util.Collections;

public class CharacterInitiative extends Initiative implements Comparable<Initiative>{

	private int currentInitiative;
	private int tieBreaker;
	private int permanentModifier;
	private int temporaryModifier;
	private int size;
	private boolean hasAdvantage;
	private boolean hasDisadvantage;
	private int roll;
	

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
	
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	@Override
	public String toString() {
		return "CharacterInitiative [name=" + getName() + ", currentInitiative=" + currentInitiative + ", roll="+roll+", tieBreaker="
				+ tieBreaker + ", permanentModifier=" + permanentModifier + ", temporaryModifier=" + temporaryModifier
				+ ", size=" + size + ", hasAdvantage=" + hasAdvantage + ", hasDisadvantage=" + hasDisadvantage + "]";
	}
	public int compareTo(Initiative arg0) {
		//System.out.println("compare "+name+" to "+arg0.getName());
		if(currentInitiative == arg0.getCurrentInitiative()) {
			if(arg0 instanceof CharacterInitiative) {
				CharacterInitiative carg0 = (CharacterInitiative)arg0;
			
				if(permanentModifier == carg0.getPermanentModifier()) {
					if(size == carg0.getSize()) {
						return 0;
					}
					else if (size < carg0.getSize()) return 1;
					return -1;
				}
				else if (permanentModifier < carg0.getPermanentModifier()) return 1;
				return -1;
			} else {
				return -1;
			}
		}
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
	
	@Override
	public void rollInitiative() {
		roll = rollDice(20);
		int initiative = roll+getPermanentModifier()+getSize()+getTemporaryModifier();
		setCurrentInitiative(initiative);

	}
	
	private int rollDice(int size) {
		if(hasAdvantage && !hasDisadvantage) {
			int d1 = (int)(Math. random()*size+1);
			int d2 = (int)(Math. random()*size+1);
			
			if(d1>d2) return d1;
			return d2;
		} else if(!hasAdvantage && hasDisadvantage) {
			int d1 = (int)(Math. random()*size+1);
			int d2 = (int)(Math. random()*size+1);
			
			if(d1<d2) return d1;
			return d2;
		} else {
			return (int)(Math. random()*size+1);
		}
	}
	
}
