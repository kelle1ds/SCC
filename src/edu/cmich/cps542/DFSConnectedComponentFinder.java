package edu.cmich.cps542;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DFSConnectedComponentFinder {

	public static void main(String[] args) {

		String edgeSpecifier = ("0-1,1-2,2-3,2-0,2-5,4-5,5-4,2-4");
		boolean directed = true;
		Graph g = new Graph(9,edgeSpecifier,directed);
		Integer[] labels = findConnectedComponentsWDFS(g);
	}

	/**
	 * Labels the connected components in a graph such that all
	 *   members of a connected component of the graph share the same
	 *   label.  Traverses graph in a depth-first manner.
	 *
	 * @param g the graph in which to identify connected components
	 * @return labels for each vertex in the graph denoting connected component membership
	 */
	public static Integer[] findConnectedComponentsWDFS(Graph g) {

		Integer[][] adjMatrix = g.getAdjMatrix();
		int size = adjMatrix.length;

		int transpose[][]=new int[size][size];  //transposed matrix

		//Code to transpose adjMatrix
		for(int i=0;i<size;i++) {
			for (int j = 0; j < size; j++) {
				transpose[i][j] = adjMatrix[j][i];
			}
		}

		//printMatrix(adjMatrix);  //method used to print a 2D matrix

		int componentID = 0;
		Integer[] componentMembership = new Integer[g.size()];

		Integer[] order = null;
		order = DFS.ProcessOrderInDFS(g);

		for(int i = 0; i< order.length;i++){
			System.out.println(order[i]);
		}

		int k = DFS.dfs(g,0, 0,order);

		for(int i = 0; i< order.length;i++){
			System.out.println(order[i]);
		}
		
		return componentMembership;
	}

	public static void printMatrix(Integer matrix[][]){
		for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
			for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(); //change line on console as row comes to end in the matrix.
		}
	}

	
}

