package com.example.catanstat;


/**
 * 
 * @author Zack
 * @description Array for representing the stored statistics
 * 				for a single turn for a single player
 */
public class TurnStat {
	
	//number of types of statistics to keep track of:
	//brick, ore, sheep, wood, wheat, total resources, # dev cards, knights used
	private static final int NUM_STATS = 8;
	
	//locations of each statistic in the vector
	private static final int BRICK_IDX = Resource.BRICK.ordinal();
	private static final int ORE_IDX = Resource.ORE.ordinal();
	private static final int SHEEP_IDX = Resource.SHEEP.ordinal();
	private static final int WHEAT_IDX = Resource.WHEAT.ordinal();
	private static final int WOOD_IDX = Resource.WOOD.ordinal();
	private static final int TOTAL_RES_IDX = 5;
	private static final int DEVCARDS_IDX = 6;
	private static final int KNIGHTS_IDX = 7;
	
	//actual array of statistics
	private int[] statArray;
	
	//constructor for creating a vector to represent stats
	public TurnStat() {
		
		//initialize the array to be NUM_STATS size
		statArray = new int[NUM_STATS];
	} //end default constructor
	
	/**
	 * 
	 * @return total number of resources gathered during the turn
	 */
	public int getTotalRes() {
		
		return statArray[TOTAL_RES_IDX];
	}
	
	/**
	 * 
	 * @return number of bricks gathered during the turn
	 */
	public int getBrick() {
		
		return statArray[BRICK_IDX];
	} //end getBrick method

	/**
	 * 
	 * @return number of ore gathered during the turn
	 */
	public int getOre() {
		
		return statArray[ORE_IDX];
	} //end getOre method

	/**
	 * 
	 * @return number of sheep gathered during the turn
	 */
	public int getSheep() {
		
		return statArray[SHEEP_IDX];
	} //end getSheep method

	/**
	 * 
	 * @return number of wheat gathered during the turn
	 */
	public int getWheat() {
		
		return statArray[WHEAT_IDX];
	} //end getWheat method

	/**
	 * 
	 * @return number of wood gathered during the turn
	 */
	public int getWood() {
		
		return statArray[WOOD_IDX];
	} //end getWood method

	/**
	 * 
	 * @return number of dev cards purchased during the turn
	 */
	public int getDevCards() {
		
		return statArray[DEVCARDS_IDX];
	} //end getDevCards method

	/**
	 * 
	 * @return whether or not a knight was used this turn
	 */
	public boolean getKnightUsed() {
		
		return statArray[KNIGHTS_IDX] != 0;
	} //end getKnightUsed method
	
	/**
	 * 
	 * @param res Resource type to add
	 * @param amount Amount of resource to add
	 */
	public void addResource(Resource res, int amount) {
		
		statArray[res.ordinal()] += amount;
	} //end addResource method
	
} //end TurnStat class