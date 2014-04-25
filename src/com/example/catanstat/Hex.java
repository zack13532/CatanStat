package com.example.catanstat;

public class Hex implements Comparable<Hex> {

	private boolean blocked; //true if a knight is one this space
	private int number; //dice roll number assigned to this space
	private Resource res_type; //the resource this hex contains
	private Vertex[] vertices; //vertices at the corner of the hex
	private Edge[] edges; //edges of the hex
	
	//location in Hex matrix
	private int x;
	private int y;
	
	/**
	 * @description default constructor corresponds to a desert hex
	 */
	public Hex(int x, int y) {
		
		this.x = x;
		this.y = y;
		blocked = true;
	} //end default constructor
	
	public void setVertices(Vertex[] vs){
		
		vertices = vs;
	}

	public void setEdges(Edge[] es){
		
		edges = es;
	}
	
	public void setBlocked(){
		
		blocked = true;
	}
	
	public void setType(Resource resource_type){
		
		res_type = resource_type;
	}

	public void setDiceroll(int diceroll_number){
		
		number = diceroll_number;
	}
	
	/**
	 * 
	 * @param h The other hex object to compare to
	 * @return The difference in dice roll numbers of the hexes
	 */
	public int compareTo(Hex otherHex) {
		
		Hex h = (Hex) otherHex;
		
		return this.number - h.number;
	} //end compareTo method
	
	/**
	 * @description Updates players' StatMatrix objects if the dice roll would
	 * 				cause this hex to distribute resources
	 */
	public void giveResources() {
		
		for(int i=0 ; i<6 ; i++){
			
			vertices[i].giveResource(res_type);
		}
	}
	
}
