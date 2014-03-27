package com.example.catanstat;

public class Player {

		private String name;
		private StatMatrix stats;
		
		public Player(String name){
			
			this.name = name;
			this.stats = new StatMatrix();
		}
}
