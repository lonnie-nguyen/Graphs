import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class Graph {
	//global
	public static HashMap<Character, LinkedList<Character>> adjList = new HashMap<>();
	
	//constructor
	public Graph(ArrayList<Character> v) {
		for (int i = 0; i < v.size(); i++) {
			Character vertex = v.get(i);
			LinkedList<Character> aList = new LinkedList<>();
			adjList.put(vertex, aList); //associates value (aList) with key (vertex)
		}
	}
	
	//add edges to graph (adjacency list)
	public void addEdge(Character u, Character v) {
		LinkedList<Character> aList;
		aList = adjList.get(u);
		aList.add(v);
		adjList.put(u, aList);
		
		aList = adjList.get(v);
		aList.add(u);
		adjList.put(v, aList);
	}
	
	public void printGraph() {
		System.out.println("Adjacency list: ");
        Set<Character> keySet = adjList.keySet();
        
        for (Character key: keySet) {
        	LinkedList<Character> value = adjList.get(key);
        	System.out.println(key + " : " + value);
        }
        System.out.println();
    }
	
	public static void BFS(char startV) {
		Queue<Character> q = new ArrayDeque<>(); //create a queue to store neighbors
		HashSet<Character> visitedV = new HashSet<>(); //create a set that keeps track of visited vertices
		
		q.add(startV); //add start vertex to queue
		
		System.out.print("BFS: ");
		
		while(!q.isEmpty()) {
			Character vertex = q.poll(); //poll() retrieves and removes head of the queue
			
			//check if vertex has been visited
			if (!visitedV.contains(vertex)) {
				System.out.print(vertex + " ");
				
				visitedV.add(vertex); // add the vertex to the set of visited vertices
				q.addAll(adjList.get(vertex)); //add all neighbors of the vertex we are looking at to the queue
			}
		}
		System.out.println();
	}
	
	public static void DFS(char startV) {
		Stack<Character> s = new Stack<>(); //create a stack to store nodes that are being traversed
		HashSet<Character> visitedV = new HashSet<>(); //create a set that keeps track of visited vertices
		
		s.push(startV); //push starting vertex into the stack
		
		System.out.print("DFS: ");
		
		while (!s.empty()) {
//			startV = s.peek();
			char vertex = s.pop(); // pop item from the stack
			
			//check if stack contains more than one instance of the vertex.
			//only need to print popped item if it has not been visited.
			if (!visitedV.contains(vertex)) {
				System.out.print(vertex + " ");
				visitedV.add(vertex); //add the vertex to the set of visited vertices
			}
			
			//create an iterator which iterates the linked list in reverse sequential order
			Iterator<Character> iter = adjList.get(vertex).descendingIterator();
			
			while (iter.hasNext()) {
				char v = iter.next();
				
				//checks to see the vertices are already in the visited set
				if (!visitedV.contains(v)) {
					s.push(v);
				}
			}
		}
		System.out.println();
	}
	
	public void DFShelper(Stack<Character> s, HashSet<Character> visitedV, char v) {
		
	}
}
