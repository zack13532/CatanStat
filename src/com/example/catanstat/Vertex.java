package com.example.catanstat;

public class Vertex {
	
	private Player player; //owner of settlement on this vertex
	private int settle_type; //1 for settlement, 2 for city
	private Hex[] hexes; //the 3 hexes meeting at this vertex
	private Edge[] edges; //the 3 edges extending from this vertex
	
	private boolean isPort; //whether or not this vertex is a port
	private Resource port; //type of trading port if there is one
	
	//location in Vertex matrix
	private int x;
	private int y;
	
	public Vertex(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		hexes = new Hex[3];
		edges = new Edge[3];
	} //end default constructor
		
	public void setHexes(Hex[] hs){
		
		hexes = hs;
	}
	
	public void setEdges(Edge[] es){
		
		edges = es;
	}
	
	public void buildSettlement(Player p){
		
		player = p;
		settle_type = 1;
	}
	
	public void buildCity(){
		
		settle_type = 2;
	}
	
	public Player getPlayer() {
		
		return player;
	}
	
	public int getSettleType(){
		
		return settle_type;
	}
	
	public void giveResource(Resource res){
		
		if(player != null)
			player.giveResource(res, settle_type);
	}
}
