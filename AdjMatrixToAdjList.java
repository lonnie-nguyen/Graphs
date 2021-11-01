import java.util.ArrayList;

public class AdjMatrixToAdjList {
	
	public static ArrayList<ArrayList<Integer>> convert(int[][] matrix) {
		
		int len = matrix[0].length; //number of columns in row 0
									//depending on allocation of array, matrix[x].length will all be equal
		
		//create ArrayList
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(len);
		
		//create a new list for each vertex to store adjacent nodes
		for (int i = 0; i < len; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < matrix.length; i++) { //matrix.length is number of rows
			for (int j = 0; j < len; j++) { //len = number of columns in row 0
				if (matrix[i][j] == 1) {
					adjList.get(i).add(j);
				}
			}
		}
		
		return adjList;
	}
	
	public static void printAdjList(ArrayList<ArrayList<Integer>> adjList) {
		System.out.println("Adjacency Matrix to Adjacency List runs in O(n^2)");
		for (int i = 0; i < adjList.size(); i++) {
			System.out.print(i);
			
			for (Integer num: adjList.get(i)) {
				System.out.print("-> " + num);
			}
			
			System.out.println();
		}
	}

}
