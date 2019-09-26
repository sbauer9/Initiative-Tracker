package com.daniel.dnd.vo;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.daniel.dnd.load.Loader;

public class InitiativeTracker {

	
	private List<CharacterInitiative> orderList;
	private int currentPosition;
	private Loader loader;
	
	public InitiativeTracker() {
		try {
			loader = new Loader();
			orderList = loader.loadPlayers();
			orderList.addAll(loader.loadMonster());
			
			System.out.println("Loading:");
			printOrder();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<CharacterInitiative> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<CharacterInitiative> orderList) {
		this.orderList = orderList;
	}
	public int getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	public void rollInitiative() {
		currentPosition = 0;
		for(CharacterInitiative character : orderList) {
			int roll = rollDice(20, character.isHasAdvantage(), character.isHasDisadvantage());
			character.setRoll(roll);
			int initiative = roll+character.getPermanentModifier()+character.getSize()+
					character.getTemporaryModifier();
			character.setCurrentInitiative(initiative);
		}
		
		Collections.sort(orderList);
	}
	
	private int rollDice(int size, boolean advantage, boolean disadvanatge) {
		if(advantage && !disadvanatge) {
			int d1 = (int)(Math. random()*size+1);
			int d2 = (int)(Math. random()*size+1);
			
			if(d1>d2) return d1;
			return d2;
		} else if(!advantage && disadvanatge) {
			int d1 = (int)(Math. random()*size+1);
			int d2 = (int)(Math. random()*size+1);
			
			if(d1<d2) return d1;
			return d2;
		} else {
			return (int)(Math. random()*size+1);
		}
	}
	
	public CharacterInitiative getNext() {
		if(currentPosition < orderList.size()) {
			return orderList.get(currentPosition++);
		} else {
			rollInitiative();
			currentPosition = 0;
			return getNext();
		}
	}
	
	/**
	 * Returns null when current character is last in the Initiative order
	 * @return CharacterInitiative that is next
	 */
	public CharacterInitiative getOnDeck() {
		if(currentPosition < orderList.size()) {
			return orderList.get(currentPosition);
		} else {
			return null;
		}
	}
	
	public void printOrder() {
		for(CharacterInitiative character : orderList) {
			System.out.println(character);
		}
	}
}
