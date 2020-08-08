import java.util.*;

public class DFS {
	
	// Creates the linkedList that will contain the vertices of the graph
	public LinkedList<String> linkedList = new LinkedList<String>();
	
	// Creates the ArrayList that will contain the start and end times for each vertex
	public ArrayList<String> vertexTimes = new ArrayList<String>();
	
	// Global variable for time
	public static int TIME = 0;
		
	// Creates a DFS object 
	static DFS dfs = new DFS();
	
	
	public static void main(String[] args) {
		
// GRAPH 1
		
		// Prints the Graph
		System.out.println("G_1 = { (a,b), (a,c), (a,d), (b,d), (c,d), (d,e), (e,g), (f,e) }");
		
		// Creates the nodes of graph 1
		Node a = new Node();
		a.name = "a";
		
		Node b = new Node();
		b.name = "b";
		
		Node c = new Node();
		c.name = "c";
		
		Node d = new Node();
		d.name = "d";
		
		Node e = new Node();
		e.name = "e";
		
		Node f = new Node();
		f.name = "f";
		
		Node g = new Node();
		g.name = "g";
		
		// Creates the adjacency list of each node and adds its neighbors
		ArrayList<Node> a_Adjacent = new ArrayList<Node>();
		a_Adjacent.add(b);
		a_Adjacent.add(c);
		a_Adjacent.add(d);
		a.setAdjacent(a_Adjacent);
		
		ArrayList<Node> b_Adjacent = new ArrayList<Node>();
		b_Adjacent.add(d);
		b.setAdjacent(b_Adjacent);
		
		ArrayList<Node> c_Adjacent = new ArrayList<Node>();
		c_Adjacent.add(d);
		c.setAdjacent(c_Adjacent);
		
		ArrayList<Node> d_Adjacent = new ArrayList<Node>();
		d_Adjacent.add(e);
		d.setAdjacent(d_Adjacent);

		ArrayList<Node> e_Adjacent = new ArrayList<Node>();
		e_Adjacent.add(g);
		e.setAdjacent(e_Adjacent);
		
		ArrayList<Node> f_Adjacent = new ArrayList<Node>();
		f_Adjacent.add(e);
		f.setAdjacent(f_Adjacent);
		
		// Adds each vertex into an ArrayList 
		ArrayList<Node> Vertices1 = new ArrayList<Node>();
		Vertices1.add(a);
		Vertices1.add(b);
		Vertices1.add(c);
		Vertices1.add(d);
		Vertices1.add(e);
		Vertices1.add(f);
		Vertices1.add(g);
		
		// Call DFS for graph 1
		dfs.DFS(Vertices1);
		
// GRAPH 2
		
		// Prints out the graph
		System.out.println("G_2 = { (a,b), (a,c), (b,c), (b,d), (b,e), (c,e), (d,f), (e,b), (e,d), (f,e) }");
		
		// Creates the nodes for the graph 2
		Node a2 = new Node();
		a2.name = "a";
		
		Node b2 = new Node();
		b2.name = "b";
		
		Node c2 = new Node();
		c2.name = "c";
		
		Node d2 = new Node();
		d2.name = "d";
		
		Node e2 = new Node();
		e2.name = "e";
		
		Node f2 = new Node();
		f2.name = "f";
		
		// Creates the adjacency list of each node in graph 2
		ArrayList<Node> a_Adjacent2 = new ArrayList<Node>();
		a_Adjacent2.add(a2);
		a_Adjacent2.add(c2);
		a2.setAdjacent(a_Adjacent2);
		
		ArrayList<Node> b_Adjacent2 = new ArrayList<Node>();
		b_Adjacent2.add(c2);
		b_Adjacent2.add(d2);
		b_Adjacent2.add(e2);
		b2.setAdjacent(b_Adjacent2);
		
		ArrayList<Node> c_Adjacent2 = new ArrayList<Node>();
		c_Adjacent2.add(e2);
		c2.setAdjacent(c_Adjacent2);
		
		ArrayList<Node> d_Adjacent2 = new ArrayList<Node>();
		d_Adjacent2.add(f2);
		d2.setAdjacent(d_Adjacent2);
		
		ArrayList<Node> e_Adjacent2 = new ArrayList<Node>();
		e_Adjacent2.add(b2);
		e_Adjacent2.add(d2);
		e2.setAdjacent(e_Adjacent2);
		
		ArrayList<Node> f_Adjacent2 = new ArrayList<Node>();
		f_Adjacent2.add(e2);
		f2.setAdjacent(f_Adjacent2);
		
		// Creates an ArrayList for the list of vertices for graph 2
		ArrayList<Node> Vertices2 = new ArrayList<Node>();
		Vertices2.add(a2);
		Vertices2.add(b2);
		Vertices2.add(c2);
		Vertices2.add(d2);
		Vertices2.add(e2);
		Vertices2.add(f2);

		// Call DFS for the graph 2
		dfs.DFS(Vertices2);	
		
	}
	
	// DFS Method
	public void DFS(ArrayList<Node> Vertices) {
				
		// Iterate through each vertex in the list of vertices
		for (Node vertex : Vertices) {
			
			// Checks if the vertex has already been explored then call DFS_Visit
			if (vertex.parent == null) {
				vertex.parent = vertex;
				dfs.DFS_Visit(vertex);
			}
		}
		
		// Creates an ArrayList to store the names of each vertex from the LinkedList
		ArrayList<String> vertexNames = new ArrayList<String>();
		int counter = 0;
		for (String name : linkedList) {
			vertexNames.add(counter, name);
			counter++;
		}
		
		// Reverse the names of the vertices
		Collections.reverse(vertexNames);
		
		// Prints out the vertices in topological order
		System.out.println("The names of each vertex in topological order: " + vertexNames.toString());
		
		// Reverses the start and end times for each of the vertices
		Collections.reverse(vertexTimes);
		
		// Prints out the start and end times in topological order
		System.out.println("The start and end times for each vertex in topological order: " + vertexTimes.toString() + "\n"); 
	}
	
	// DFS_Visit Method
	public void DFS_Visit(Node vertex) {
		
		// String to store the start and end time for each vertex
		String StartnEndTimes = "";
		
		// Increment global variable TIME
		TIME++;
		
		// Set the start time for each vertex when reached
		vertex.startTime = TIME;
		
		// Visit each of the neighbors for the passed in vertex
		for (Node neighbors : vertex.adjacent) {
			
			// If the neighbors  start time is 0 then visit it 
			if (neighbors.startTime == 0) {
				neighbors.parent = vertex;
				DFS_Visit(neighbors);
				
			// If neighbors end time is 0 then cycle has been detected and end the program
			} else if (neighbors.endTime == 0) {
				System.out.println("Cycle detected, topological sort is impossible. ");
				System.exit(0);
			}
						
		}	

		// Increment global variable TIME
		TIME++;
		
		// Set the end time for each vertex when it finishes
		vertex.endTime = TIME;
		
		// Insert the vertex into a linked list as it finishes
		linkedList.add(vertex.name);
		
		// Adds the name of the vertex with its start and end time when it finishes
		StartnEndTimes = vertex.name + ": " + vertex.startTime + "/" + vertex.endTime;
		
		// Adds the Start and End times into the ArrayList
		vertexTimes.add(StartnEndTimes);
	
	}
}

// Justin Calma CECS 328 - 14 F 8 AM - 12:45 PM