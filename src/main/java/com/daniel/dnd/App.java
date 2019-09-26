package com.daniel.dnd;

import java.util.Scanner;

import com.daniel.dnd.vo.Initiative;
import com.daniel.dnd.vo.InitiativeTracker;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	InitiativeTracker tracker = new InitiativeTracker();
    	tracker.rollInitiative();
    	System.out.println("Order 1");
    	tracker.printOrder();
    	
    	tracker.rollInitiative();
    	System.out.println("Order 2");
    	tracker.printOrder();
    	
    	runEncounter(tracker);
    	
    }
    
    public static void runEncounter(InitiativeTracker tracker) {
    	System.out.println();
    	
    	System.out.println("Fight");
    	while(true) {
	    	Scanner in = new Scanner(System.in);
	    	displayNext(tracker);
	    	in.nextLine();
    	}
    	
    	
    }
    
    public static void displayNext(InitiativeTracker tracker) {
    	System.out.println(tracker.getNext());
    	Initiative ondeck = tracker.getOnDeck();
    	if(ondeck == null) {
    		System.out.println("End of initiative order");
    	} else {
    		System.out.println("Ondeck ="+ondeck);
    	}
    }
}
