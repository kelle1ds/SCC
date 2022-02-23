package edu.cmich.cps542;

public class DFSConnectedComponentFinder {

	/** 
	 * Labels the connected components in a graph such that all 
	 *   members of a connected component of the graph share the same
	 *   label.  Traverses graph in a depth-first manner.
	 * 
	 * @param g the graph in which to identify connected components
	 * @return labels for each vertex in the graph denoting connected component membership
	 */

	public static void main(String[] args) {
		int size = 9;
		String edgeSpecifier = ("0-1,1-2,2-3,3-0,2-4,4-5,5-6,6-4,7-6,7-8");

		boolean directed = true;
		Graph g = new Graph(size,edgeSpecifier,directed);
		Integer[] order = null;
		order = BFS.ProcessOrderInBFS(g);

		Integer[][] adjMatrix = g.getAdjMatrix();

		int transpose[][]=new int[size][size];
		//Code to transpose a matrix
		for(int i=0;i<size;i++) {
			for (int j = 0; j < size; j++) {
				transpose[i][j] = adjMatrix[j][i];
			}
		}

		for(int i = 0; i < size;i++){
			for(int j = 0; j < size; j++)
				System.out.println(transpose[i][j] + " " + adjMatrix[i][j]);
		}

	}

	public static Integer[] findConnectedComponentsWDFS(Graph g) {

		int componentID = 0;
		Integer[] componentMembership = new Integer[g.size()]; 

		
		return componentMembership;
	}

	
}
