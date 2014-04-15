package com.example.catanstat;

public class Player {

		private String name;
		private StatMatrix stats;
		
		/**
		 * 
		 * @param name Player's name
		 */
		public Player(String name){
			
			this.name = name;
			this.stats = new StatMatrix();
		} //end default constructor
		
		/**
		 * 
		 * @return The Player's name
		 */
		public String getName() {
			
			return name;
		} //end getName method
		
		public String toString() {
			
			return getName();
		} //end toString method
		
		/**
		 * @description Updates player's StatMatrix by adding resources
		 * @param res Resource type to add
		 * @param amount Amount of resource to add
		 */
		public void giveResource(Resource res, int amount) {
			
			stats.addResource(res, amount);
		}
		
		/**
		 * @description Advances the StatMatrix object to record stats for the next turn
		 */
		public void nextTurn() {
			
			stats.add(new TurnStat());
		} //end nextTurn method
		
} //end Player class
