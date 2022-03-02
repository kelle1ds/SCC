package edu.cmich.cps542;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DFSConnectedComponentFinder {

	public static void main(String[] args) {

		String edgeSpecifier = ("0-1,1-2,1-9,2-3,2-4,4-5,4-6,6-7,7-8,9-10,10-11");
		int size = 12;
		boolean directed = true;
		Graph g = new Graph(size,edgeSpecifier,directed);

		System.out.println("Function count: " + count(g));
		System.out.println(topo(g));
	}

	public static ArrayList topo(Graph g){
		int[] inEdges = new int[g.size];
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> sortOrder = new ArrayList<Integer>();
		int basic = 0;
		for(int i = 0; i < inEdges.length; i++){
			inEdges[i] = 0;
			basic++;
		}
		for(int i = 0; i < inEdges.length;i++){
			g.getAdjList(i).stream().forEach((x) -> inEdges[x]++);
			basic++;
		}
		for(int i = 0; i < inEdges.length;i++){
			basic++;
			if(inEdges[i] == 0){
				q.add(i);   //Queue with sources
			}
		}
		System.out.println("For loops = " + basic);
		int basic2 = 0;
		while(!q.isEmpty()){
			int currVertex = q.remove();
			sortOrder.add(currVertex);
			ArrayList<Integer> adjList = g.getAdjList(currVertex);
			for(Integer adjVertex : adjList){
				inEdges[adjVertex]--;
				basic2++;
				if(inEdges[adjVertex] ==0){
					q.add(adjVertex);
				}
			}
		}
		System.out.println("While loops = " + basic2);

		return sortOrder;
	}

	public static int count(Graph g){
		int b = 3*g.size() + g.size()-1;
		return b;
	}






}

