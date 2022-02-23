package edu.cmich.cps542;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BFSTest {

	@Test 
	public void ProcessOrderInBFSTest1() {
		Graph g = new Graph(5, "1-2, 2-3, 3-4, 4-0");
		Integer[] order = null;
		
		order = BFS.ProcessOrderInBFS(g);
		 
		Integer[] expectedOutput = {1, 5, 4, 3, 2};
		assertArrayEquals(expectedOutput, order, () -> "Vertices should have been encountered in a different order.");
			
	}

	@Test 
	public void ProcessOrderInBFSTest2() {
		Graph g = new Graph(9, "0-1,0-2,1-3,1-4,2-3,2-4,3-8,5-6,6-7");
		Integer[] order = null;
		
		order = BFS.ProcessOrderInBFS(g);
		 
		
		Integer[] expectedOrder = {1, 2, 3, 4, 5, 7, 8, 9, 6};
		assertArrayEquals(expectedOrder, order, 
				() -> "Vertices should have been encountered in a different order.");
	}

	@Test 
	public void ProcessOrderInBFSTest3() {
		Graph g = new Graph(9, "0-5,0-7,5-8,5-6,8-3,8-4,7-1,7-2");
		Integer[] order = null;
		
		order = BFS.ProcessOrderInBFS(g);

		Integer[] expectedOrder = {1, 6, 7, 8, 9, 2, 4, 3, 5};		
		assertArrayEquals(expectedOrder, order, 
				() -> "Vertices should have been encountered in a different order.");
	}

}
