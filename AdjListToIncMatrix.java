import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdjListToIncMatrix {

	public static int[][] convert(ArrayList<ArrayList<Integer>> adjList) {
		int n = adjList.size(); //vertices
		int m = getNumOfEdges(adjList); //edges
		
		int[][] incMatrix = new int[n][m];
		
		int[][] edgeList = getEdgeList1(adjList, m); //O(nm)
		int edgeNo = 0;
		for (int i = 0; i < m; i++) { //O(m)

			for (int j = 0; j < 2; j++) {
				int u = edgeList[i][j];
				incMatrix[u][edgeNo] = 1;
			}
			edgeNo++;
		}
		
		return incMatrix;
	}
	
	public static int getNumOfEdges(ArrayList<ArrayList<Integer>> adjList) {
		//get edges from adjacency list where e = (v1, v2) v1 < v2
		Set <Set<Integer>> edgeSet = new HashSet<Set<Integer>>();
		Set<Integer> tempTuple;
		
		for (int v1 = 0; v1 < adjList.size(); v1++) {	
			for (Integer v2: adjList.get(v1)) {
				if(v1 < v2) {
					tempTuple = new HashSet<Integer>();
					tempTuple.add(v1);
					tempTuple.add(v2);
					edgeSet.add(tempTuple);
				}
			}
		}
//		System.out.println("number of edges: " + edgeSet.size());
		return edgeSet.size();
	}
	
//	public static ArrayList<ArrayList<Integer>> getEdgeList(ArrayList<ArrayList<Integer>> adjList) {
//		ArrayList<ArrayList<Integer>> edgeList = new ArrayList<ArrayList<Integer>>();
//		ArrayList<Integer> vertices;
//		
//		for (int v1 = 0; v1 < adjList.size(); v1++) {
//			for (Integer v2: adjList.get(v1)) {
//				if(v1 < v2) {//make into set with no duplicate edges
//				vertices = new ArrayList<Integer>();
//				vertices.add(v1);
//				vertices.add(v2);
//				edgeList.add(vertices);
//				}//
//			}
//		}
//		
//		return edgeList;
//	}
	
	public static int[][] getEdgeList1(ArrayList<ArrayList<Integer>> adjList, int numOfEdges) {
		int[][] m = new int[numOfEdges][2];
		int row = 0;
		for (int v1 = 0; v1 < adjList.size(); v1++) { //O(n)
			
			for (Integer v2: adjList.get(v1)) { //O(m)
				
				int col = 0;
//				System.out.println("v1: " + v1 + " v2: " + v2);
				if (v1 < v2) {
					m[row][col++] = v1;
					m[row++][col] = v2;

				}
			}
		}
		return m;
	}
	
	//use to multidimensional array
	public static void printIncMatrix(int[][] m) {
		System.out.println("Adjacency List to Incidence Matrix runs in O(nm)");
		
		for (int[] x: m) {
            for (int y: x) {
                System.out.print(y + " ");
            }
  
            System.out.println();
        }
	}
	
	//use to print edge list as multidimensional array
	public static void printEdgeList(int[][]m, int numOfEdges) {
		
		for (int i = 0; i < numOfEdges; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(m[i][j] + " ");
            }
  
            System.out.println();
        }
	}
	
	//use for ArrayList
//	public static void printIncMatrix(int[][] incMatrix, int vertices, int edges) {
//		System.out.println("Adjacency List to Incidence Matrix runs in O(nm)");
//		
//		for(int i = 0; i < vertices; i++) {
//			for (int j = 0; j < edges; j++) {
//				System.out.print(incMatrix[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}
