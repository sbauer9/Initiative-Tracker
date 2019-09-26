package com.daniel.dnd;

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
    	
    }
}
