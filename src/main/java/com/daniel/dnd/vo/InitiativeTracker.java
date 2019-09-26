package com.daniel.dnd.vo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.daniel.dnd.load.Loader;

public class InitiativeTracker {

	
	private List<Initiative> orderList;
	private int currentPosition;
	private Loader loader;
	
	public InitiativeTracker() {
		try {
			loader = new Loader();
			orderList = new ArrayList<Initiative>();
			orderList.addAll(loader.loadPlayers());
			orderList.addAll(loader.loadMonster());
			orderList.addAll(loader.loadLair());
			
			System.out.println("Loading:");
			printOrder();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Initiative> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Initiative> orderList) {
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
		for(Initiative character : orderList) {
			character.rollInitiative();
		}
		
		Collections.sort(orderList);
	}
	
	
	public Initiative getNext() {
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
	public Initiative getOnDeck() {
		if(currentPosition < orderList.size()) {
			return orderList.get(currentPosition);
		} else {
			return null;
		}
	}
	
	public void printOrder() {
		for(Initiative character : orderList) {
			System.out.println(character);
		}
	}
}
