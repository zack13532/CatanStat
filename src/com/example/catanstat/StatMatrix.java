/**
 * 
 */
package com.example.catanstat;

import java.util.Vector;


/**
 * @author Zack
 *
 */
public class StatMatrix extends Vector<TurnStat> {

	private static final long serialVersionUID = 3154414777447794870L;
	
	//initial size of matrix, upper bound on most turns in 
	//an average game of Catan
	private static final int INIT_NUM_TURNS = 20;
	//increment the size by this amount if the
	//length of the game exceeds the current size of this matrix
	private static final int TURN_INCR = 5;
	
	public StatMatrix() {
		
		//initializes the vector
		super(INIT_NUM_TURNS, TURN_INCR);
	} //end default constructor
	
	/**
	 * 
	 * @param turn the turn number (1-indexed) to retrieve the statistics of
	 * @return the TurnStat object corresponding to the desired turn
	 */
	public TurnStat getTurn(int turn) {
		
		return this.get(turn - 1);
	} //end getTurn method

	/**
	 * 
	 * @return the total number of resources collected over all turns
	 */
	public int getTotalResources() {
		
		int total = 0;
		
		for(int i = 0 ; i < this.size() ; i++)
			total += this.get(i).getTotalRes();
		
		return total;
	} //end getTotalResources method
} //end StatMatrix class
