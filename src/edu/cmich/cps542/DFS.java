package edu.cmich.cps542;

public class DFS {

	/**
	 * Perform a DFS traversal of a graph.  The order in which the nodes are 
	 * processed is saved and returned.  Ties in the traversal are broken by
	 * numerical order (i.e., the vertex with the lower index is processed first)
	 * 
	 * @param g graph to be traversed
	 * @return the order in which each vertex was encountered during the DFS
	 */
	public static Integer[] ProcessOrderInDFS(Graph g) {

		int foundCount = 0;
		Integer[] processOrder = new Integer[g.size()]; 
		for(int i = 0; i < g.size(); i++) {
			processOrder[i] = 0;
		}

		for(int i = 0; i < g.size(); i++) {
			if(processOrder[i] == 0) {
				foundCount = dfs(g, i, foundCount, processOrder);
			}
		}

		return processOrder;
	}


	/**
	 * Performs a DFS starting at a given node.  
	 * @param g graph to be traversed
	 * @param v index for vertex from which a dfs will start (or continue). 
	 * @param foundCount number of vertices that have been processed thus far
	 * @param processOrder order in which each vertex has been processed 
	 *    or 0 if vertex has yet to be processed
	 * @return The current value of foundCount after it has been incremented 
	 *    by the number of nodes processed.
	 */
	public static int dfs(Graph g, int v, int foundCount, Integer[] processOrder) {

		Integer[] adjVector = null;

		foundCount++;
		processOrder[v] = foundCount;

		adjVector = g.getAdjVector(v);
		for(int i = 0; i < g.size(); i++) {
			if(adjVector[i] == 1 && processOrder[i] == 0) {
				foundCount = dfs(g, i, foundCount, processOrder);
			}
		}

		return foundCount;
	}
}
