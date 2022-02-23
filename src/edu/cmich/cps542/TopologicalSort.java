package edu.cmich.cps542;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

	public static void main(String[] args) {
		Graph dag1 = new Graph(6, "1-3,1-4,1-5,5-0,5-2,0-2", true);
		System.out.println(topologicalSort(dag1));
	}

	public static ArrayList<Integer> topologicalSort(Graph dag) {
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> sortOrder = new ArrayList<Integer>();
		
		int[] inEdgeCounts = new int[dag.size()];
		for(int i = 0; i < inEdgeCounts.length; i++) {
			inEdgeCounts[i] = 0;
		}
		for(int i = 0; i < inEdgeCounts.length; i++) {
			dag.getAdjList(i).stream().forEach((x) -> inEdgeCounts[x]++);
		}
		
		// Identify sources
		for(int i = 0; i < inEdgeCounts.length; i++) {
			if(inEdgeCounts[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int currVertex = q.remove();
			sortOrder.add(currVertex);
			ArrayList<Integer> adjList = dag.getAdjList(currVertex);
			
			// Remove edges for this node
			for(Integer adjVertex: adjList) {
				inEdgeCounts[adjVertex]--;

				if(inEdgeCounts[adjVertex] == 0) {
					q.add(adjVertex);
				}
			}
		}
		
		return sortOrder;
	}
}
