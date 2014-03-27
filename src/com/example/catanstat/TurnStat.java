package com.example.catanstat;

import java.util.Vector;

/**
 * 
 * @author Zack
 * @description Vector for representing the stored statistics
 * 				for a single turn for a single player
 */
public class TurnStat extends Vector<Integer> {
	
	private static final long serialVersionUID = 6683355534182892803L;

	//number of types of statistics to keep track of:
	//brick, ore, sheep, wood, wheat, # dev cards, knights used
	private static final int NUM_STATS = 7;
	
	//locations of each statistic in the vector
	private static final int BRICK_IDX = 0;
	private static final int ORE_IDX = 1;
	private static final int SHEEP_IDX = 2;
	private static final int WHEAT_IDX = 3;
	private static final int WOOD_IDX = 4;
	private static final int DEVCARDS_IDX = 5;
	private static final int KNIGHTS_IDX = 6;
	
	//constructor for creating a vector to represent stats
	public TurnStat() {
		
		//initialize the vector to be NUM_STATS size
		super(NUM_STATS);
	} //end default constructor
	
	/**
	 * 
	 * @return total number of resources gathered during the turn
	 */
	public int getTotalRes() {
		
		return this.getBrick() +
				this.getOre() +
				this.getSheep() +
				this.getWheat() +
				this.getWood();
	}
	
	/**
	 * 
	 * @return number of bricks gathered during the turn
	 */
	public int getBrick() {
		
		return this.get(BRICK_IDX);
	} //end getBrick method

	/**
	 * 
	 * @return number of ore gathered during the turn
	 */
	public int getOre() {
		
		return this.get(ORE_IDX);
	} //end getOre method

	/**
	 * 
	 * @return number of sheep gathered during the turn
	 */
	public int getSheep() {
		
		return this.get(SHEEP_IDX);
	} //end getSheep method

	/**
	 * 
	 * @return number of wheat gathered during the turn
	 */
	public int getWheat() {
		
		return this.get(WHEAT_IDX);
	} //end getWheat method

	/**
	 * 
	 * @return number of wood gathered during the turn
	 */
	public int getWood() {
		
		return this.get(WOOD_IDX);
	} //end getWood method

	/**
	 * 
	 * @return number of dev cards purchased during the turn
	 */
	public int getDevCards() {
		
		return this.get(DEVCARDS_IDX);
	} //end getDevCards method

	/**
	 * 
	 * @return whether or not a knight was used this turn
	 */
	public boolean getKnightUsed() {
		
		return this.get(KNIGHTS_IDX) != 0;
	} //end getKnightUsed method
	
} //end TurnStat class