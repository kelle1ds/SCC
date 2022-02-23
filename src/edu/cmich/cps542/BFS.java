package edu.cmich.cps542;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	/**
	 * Perform a BFS traversal of a graph.  The order in which the nodes are 
	 * processed is saved and returned.  Ties in the traversal are broken by
	 * numerical order (i.e., the vertex with the lower index is processed first)
	 * 
	 * @param g graph to be traversed
	 * @return the order in which each vertex was encountered during the BFS
	 */
	public static Integer[] ProcessOrderInBFS(Graph g) {

		int foundCount = 1;
		Integer[] processOrder = new Integer[g.size()]; 
		for(int i = 0; i < g.size(); i++) {
			processOrder[i] = 0;
		}

		for(int i = 0; i < g.size(); i++) {
			if(processOrder[i] == 0) {
				foundCount = bfs(g, i, foundCount, processOrder);
			}
		}

		return processOrder;
	}


	/**
	 * Performs a BFS starting at a given node.  
	 * @param g graph to be traversed
	 * @param startVertex index for the starting point of traversal. 
	 * @param foundCount number of vertices that have been processed thus far
	 * @param processOrder order in which each vertex has been processed or 
	 *    0 if vertex has yet to be processed
	 * @return the current value of foundCount after it has been incremented 
	 *    by the number of vertices processed
	 * 
	 */
	public static int bfs(Graph g, int startVertex, int foundCount, Integer[] processOrder) {
		Queue<Integer> q = new LinkedList<Integer>();
		int currNode = 0;
		Integer[] adjVector = null;

		q.add(startVertex);
		processOrder[startVertex] = foundCount;

		foundCount++;

		while(!q.isEmpty()) {
			currNode = q.remove();
			adjVector = g.getAdjVector(currNode);
			for(int i = 0; i < g.size(); i++) {
				if(adjVector[i] == 1 && processOrder[i] == 0) {
					q.add(i);
					processOrder[i] = foundCount;

					foundCount++;
				}
			}

		}

		return foundCount;

	}

}
