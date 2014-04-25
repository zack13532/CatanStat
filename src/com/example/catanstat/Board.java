package com.example.catanstat;

public class Board {
	
    private Hex[][] hexes;
    private Edge[][] edges;
    private Vertex[][] vertices;

    public Board()
    {
    	hexes = new Hex[10][10];
    	edges = new Edge[22][22];
    	vertices = new Vertex[22][22];
    	
    	for(int i = 0; i < 22; i++){
        	for(int j = 0; j < 22; j++) {
	            edges[i][j] = new Edge(i,j);
	            vertices[i][j] = new Vertex(i,j);
        	}
        }
    	
        for(int i = 0; i < 10; i++){
        	for(int j = 0; j < 10; j++){
        		hexes[i][j] = new Hex(i,j);

	            int offset = i % 2;
	            
	            Vertex[] tempverts = {
	                    vertices[i][2*j+offset],
	                    vertices[i][2*j+1+offset],
	                    vertices[i][2*j+2+offset],
	                    vertices[i+1][2*j+offset],
	                    vertices[i+1][2*j+1+offset],
	                    vertices[i+1][2*j+2+offset]};
	            
	            hexes[i][j].setVertices(tempverts);
	            
	            Edge[] tempedges = {
                        edges[2*i][2*j+offset],
                        edges[2*i][2*j+1+offset],
                        edges[2*i+1][2*j+offset],
                        edges[2*i+1][2*j+2+offset],
                        edges[2*i+2][2*j+offset],
                        edges[2*i+2][2*j+1+offset]};
	            
	            hexes[i][j].setEdges(tempedges);
        	}
        }
        
    	for(int i = 0; i < 22; i++){
        	for(int j = 0; j < 22; j++) {
        		
        		int offset = i%2;
                int joffset = j%2;
        		
        		Edge[] tempedges = {
	        		edges[i*2][j],
	                edges[i*2+1][j],
	                edges[i*2-1][j]};
        		
                Hex[] temphexes = {
                	hexes[i-1][(j+offset)/2-1],
                    hexes[i-(1-joffset)*offset][(j-1)/2],
                    hexes[i][(j-offset)/2]};
        		
        		vertices[i][j].setEdges(tempedges);
        		vertices[i][j].setHexes(temphexes);
        		
        		Vertex[] tempverts = {
                        vertices[(i-offset)/2][j],
                        vertices[(i+offset)/2][j+1-offset]};
        		
        		//need to figure out edge transformations
        		
        		edges[i][j].setVertices(tempverts);
        	}
        }
    }
    /*
    public IEnumerable<Hex> GetNeighbors(Hex hex)
    {
        var x = hex.X; var y = hex.Y;
        var offset = x % 2 == 0? +1 : -1;
        return new []
        {
            Hexes[x,y+1],
            Hexes[x,y-1],
            Hexes[x+1,y],
            Hexes[x-1,y],
            Hexes[x+1,y+offset],
            Hexes[x-1,y+offset],
        };
    }
    public IEnumerable<Vertex> GetVertices(Hex hex)
    {
        var x = hex.X; var y = hex.Y;
        var offset = x % 2;
        return new[]
        {
            Vertices[x,2*y+offset],
            Vertices[x,2*y+1+offset],
            Vertices[x,2*y+2+offset],
            Vertices[x+1,2*y+offset],
            Vertices[x+1,2*y+1+offset],
            Vertices[x+1,2*y+2+offset],
        };
    }
    public IEnumerable<Edge> GetEdges(Hex hex)
    {
        var x = hex.X; var y = hex.Y;
        var offset = x % 2;
        return new[]
        {
            Edges[2*x,2*y+offset],
            Edges[2*x,2*y+1+offset],
            Edges[2*x+1,2*y+offset],
            Edges[2*x+1,2*y+2+offset],
            Edges[2*x+2,2*y+offset],
            Edges[2*x+2,2*y+1+offset],
        };
    }
    public IEnumerable<Vertex> GetEnds(Edge edge)
    {
        var x = edge.X; var y = edge.Y;
        if(x % 2 == 0)
            return new[]
            {
                Vertices[x/2,y],
                Vertices[x/2,y+1],
            };
        else
            return new[]
            {
                Vertices[(x-1)/2,y],
                Vertices[(x+1)/2,y],
            };
    }
    public IEnumerable<Edge> GetEdges(Vertex vertex)
    {
        var x = vertex.X; var y = vertex.Y;
        return new []
        {
            Edges[x*2,y],
            Edges[x*2+1,y],
            Edges[x*2-1,y],
        };
    }
    public IEnumerable<Hex> GetHexes(Vertex vertex)
    {
        var x = vertex.X; var y = vertex.Y;
        var xoffset = x % 2;
        var yoffset = y % 2;
        return new[]
        {
            Hexes[x-1,(y+xoffset)/2-1],
            Hexes[x-(1-yoffset)*xoffset,(y-1)/2],
            Hexes[x,(y-xoffset)/2],
        };
    }
    */
}