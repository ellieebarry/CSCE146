/*
 * Created by Ellie Barry
 */


import java.util.LinkedList;
import java.util.Queue;


public class AdjMatrixGraph {

	// Instance variables
	public static final int DEF_SIZE = 5;
	private String[][] adjMatrix;
	// Letters for the matrix
	public String letters = "RAHJMYUWWKRXNFMQGEEBEOAPE";
	
	// Creates a 5x5 matrix
	public AdjMatrixGraph() {
		init(DEF_SIZE);
	}

	// Sets the matrix up by going through each coordinate and setting it equal to the next letter in the set string
	private void init(int size) {
		int count = 0;
		if(size <= 0)
			init(DEF_SIZE);
		adjMatrix = new String[size][size];
		for(int i = 0; i <adjMatrix.length; i++) {
			for(int j = 0; j < adjMatrix.length; j++) {
				adjMatrix[i][j] = letters.substring(count, count +1);
				count++;
			}
		}
	}
	
	
	public void addEdge(int toVert, int fromVert, String w) {
		if(!isValid(toVert) || !isValid(fromVert))
			return;
		adjMatrix[toVert][fromVert] = w;
	}
	
	
	private boolean isValid(int index){
		return index <= 0 && index < adjMatrix.length;
	}
	
	
	public void print() {
		for(int i = 0; i <adjMatrix.length;i++) {
			System.out.println();
			for(int j = 0; j <adjMatrix.length;j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
		}
	}
	
	private LinkedList<Integer> markedList = new LinkedList<Integer>();
	// Calls the private printDFS method
	public void printDFS() {
		markedList.clear();
		printDFS(0);
	}
	
	// Recursive method, pre-order traversal applied to a graph called depth first search
	private void printDFS(int index) {
		System.out.println(index);
		markedList.add(index);
		for(int i = 0; i <adjMatrix.length;i++) {
			if(adjMatrix[index][i] != " " && !markedList.contains(i)) {
				printDFS(i);
			}
		}
	}
	
	
	Queue<Integer> vQ = new LinkedList<Integer>();
	// Bredth first search
	public void printBFS(int index) {
		if(!isValid(index)) {
			return;
		}
		markedList.clear();
		vQ.clear();
		vQ.add(index);
		System.out.println(index);
		while(!vQ.isEmpty()) {
			int currI = vQ.remove();
			markedList.add(currI);
			for(int i = 0; i < adjMatrix.length; i++) {
				if(!markedList.contains(currI) && !vQ.contains(currI) && adjMatrix[currI][i] != " ") {
					System.out.println(i);
					vQ.add(i);
				}	
			}
		}
	}
	
	
}
