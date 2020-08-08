import java.util.ArrayList;

public class Node {

	// Fields for the Node class
	public Node parent;
	public ArrayList<Node> adjacent; 
	public String name;
	public int startTime;
	public int endTime;
	
	// Constructor 
	public Node() {
		this.parent = null;
		this.adjacent = new ArrayList<Node>();
		this.name = "";
		this.startTime = 0;
		this.endTime = 0;
	}
	
	// Sets the adjacency list for the given vertex
	public void setAdjacent(ArrayList<Node> adjacent) {
		this.adjacent = adjacent;
	}
	
}

// Justin Calma CECS 328 - 14 F 8 AM - 12:45 PM