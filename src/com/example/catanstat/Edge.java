package com.example.catanstat;

public class Edge {
	
	private Player player; //owner of road on this edge, null for no road
	private Hex[] hexes; //the two hexes the edge borders
	private Vertex[] vertices; //the two vertices at the ends of the edge
	
	//location in Edge matrix
	private int x;
	private int y;
	
	public Edge(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		hexes = new Hex[2];
		vertices = new Vertex[2];
	} //end default constructor
		
	public void setHexes(Hex[] hs){

		hexes = hs;
	}
	
	public void setVertices(Vertex[] vs){
		
		vertices = vs;
	}
	
	public void buildRoad(Player p){
		
		player = p;
	}
	
	public Player getPlayer() {
		
		return player;
	}
}
