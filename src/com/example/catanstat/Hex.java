package com.example.catanstat;

import java.util.HashMap;

public class Hex implements Comparable {

	private boolean blocked; //true if a knight is one this space
	private int number; //dice roll number assigned to this space
	private Resource res_type; //the resource this hex contains
	private HashMap<Player, Integer> settlers; //players with settlements on the hex
										   //mapping to 1 or 2 depending on if
										   //if it's a settlement or city
	
	/**
	 * @description default constructor corresponds to a desert hex
	 */
	public Hex() {
		
		blocked = true;
		settlers = new HashMap<Player, Integer>(3);
	} //end default constructor
	
	/**
	 * 
	 * @param resource_type Type of the resource on the hex
	 * @param diceroll_number Number for dice roll associated with the hex
	 */
	public Hex(Resource resource_type, int diceroll_number) {
		
		blocked = false;
		res_type = resource_type;
		number = diceroll_number;
	} //end 2 param constructor
	
	/**
	 * 
	 * @param h The other hex object to compare to
	 * @return The difference in dice roll numbers of the hexes
	 */
	public int compareTo(Object otherHex) {
		
		Hex h = (Hex) otherHex;
		
		return this.number - h.number;
	} //end compareTo method
	
}
