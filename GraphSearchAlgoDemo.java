import java.util.ArrayList;
import java.util.Dictionary;

public class GraphSearchAlgoDemo {

	public static void main(String[] args) {
		//create ArrayList to hold the vertices of the undirected graph
		ArrayList<Character> vList = new ArrayList<Character>();
		vList.add('A');
		vList.add('B');
		vList.add('C');
		vList.add('D');
		vList.add('E');
		vList.add('F');
		vList.add('G');
		vList.add('H');
		vList.add('I');
		vList.add('J');
		
		//Create empty graph
		Graph adjList = new Graph(vList);
		
		//add edges, ex. adds A-B and B-A
		//A
		adjList.addEdge('A', 'B');
		adjList.addEdge('A', 'D');
		adjList.addEdge('A', 'I');
		//B
		adjList.addEdge('B', 'C');
		adjList.addEdge('B', 'D');
		adjList.addEdge('B', 'E');
		//C
		adjList.addEdge('C', 'E');
		adjList.addEdge('C', 'F');
		//D
		adjList.addEdge('D', 'E');
		adjList.addEdge('D', 'G');
		//E
		adjList.addEdge('E', 'F');
		adjList.addEdge('E', 'G');
		adjList.addEdge('E', 'H');
		//F
		adjList.addEdge('F', 'H');
		//G
		adjList.addEdge('G', 'H');
		adjList.addEdge('G', 'I');
		adjList.addEdge('G', 'J');
		//H
		adjList.addEdge('H', 'J');
		//I
		adjList.addEdge('I', 'J');
		//J already added edges
		
		adjList.printGraph();
		
		Graph.BFS('A');
		Graph.DFS('A');
	}

}
