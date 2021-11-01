import java.util.ArrayList;

public class IncMatrixToAdjList {
	public static ArrayList<ArrayList<Integer>> convert(int[][] matrix) {
//		int len = matrix[0].length; //number of columns in row 0
									//depending on allocation of array, matrix[x].length will all be equal
		
		//create ArrayList
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(matrix[0].length);
		
		//create a new list for each vertex to store adjacent nodes
		for (int i = 0; i < matrix[0].length; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		//traverse incidence matrix column-wise and look for 1's
		for (int i = 0; i < matrix[0].length; i++) {
			int v1 = -1;
			int v2 = -1;
			for(int j = 0; j < matrix[0].length; j++) {
				if (matrix[j][i] == 1) {
					if (v1 == -1) {
						v1 = j;
					}
					else {
						v2 = j;
					}
				}
			}
			if (v2 != -1) {
				//add vertexes to their appropriate lists
				adjList.get(v1).add(v2);
				adjList.get(v2).add(v1);
			}
		}

		System.out.println(adjList);
		
		
		return adjList;
	}
	
	public static void printAdjList(ArrayList<ArrayList<Integer>> adjList) {
		System.out.println("Incidence Matrix to Adjacency List runs in O(n^2)");
		for (int i = 0; i < adjList.size(); i++) {
			System.out.print(i);
			
			for (Integer num: adjList.get(i)) {
				System.out.print("-> " + num);
			}
			
			System.out.println();
		}
	}
}
