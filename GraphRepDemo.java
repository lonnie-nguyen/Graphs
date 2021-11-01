import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GraphRepDemo {

	public static void main(String[] args) {
		//Create an adjacency matrix of an undirected graph
		int[][] adjMatrix = {{0,1,1,1},
							{1,0,0,0},
							{1,0,0,1},
							{1,0,1,0}};
		
//		int[][] adjMatrix = {{0,1,0,0,1},
//							{1,0,1,1,1},
//							{0,1,0,1,0},
//							{0,1,1,0,1},
//							{1,1,0,1,0}};
		
		//create arraylist for use to store adjacency list
		//convert given adjacency matrix to adjacency list
		ArrayList<ArrayList<Integer>> adjList = AdjMatrixToAdjList.convert(adjMatrix);
		
		//print adjacency list
		AdjMatrixToAdjList.printAdjList(adjList);
		
		//get number of edges in undirected graph
		int numOfEdges =  AdjListToIncMatrix.getNumOfEdges(adjList);		
		
		//create multidimensional array to store incidence matrix
		//convert adjacency list to incidence matrix
		int[][] incMatrix = AdjListToIncMatrix.convert(adjList);
		
		//print incidence matrix
		AdjListToIncMatrix.printIncMatrix(incMatrix);
		
		//incidence matrix to adjacency list
		adjList = IncMatrixToAdjList.convert(incMatrix);
		
		IncMatrixToAdjList.printAdjList(adjList);
		
	}
}
