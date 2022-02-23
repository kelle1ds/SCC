package edu.cmich.cps542;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BFSExtractTreeTest {

	@Test 
	public void ExtractTreeWBFSTest1() {
		Graph g = new Graph(5, "1-2, 2-3, 3-4, 4-0");
		Integer[] parents = null;
		
		parents = BFSExtractTree.ExtractTreeWBFS(g);
		 
		Integer[] expectedOutput = {0, 2, 3, 4, 0};
		assertArrayEquals(expectedOutput, parents);
	}
	
	@Test 
	public void ExtractTreeWBFSTest2() {
		Graph g = new Graph(9, "0-1,0-2,1-3,1-4,2-3,2-4,3-8,5-6,6-7");

		Integer[] parents = null;
		
		parents = BFSExtractTree.ExtractTreeWBFS(g);
		 
		Integer[] expectedOutput = {0, 0, 0, 1, 1, 5, 5, 6, 3};
		assertArrayEquals(expectedOutput, parents);

	}

	@Test 
	public void ExtractTreeWBFSTest3() {
		Graph g = new Graph(9, "0-5,0-7,5-8,5-6,8-3,8-4,7-1,7-2,0-4,1-2");
 
		Integer[] parents = null;
		
		parents = BFSExtractTree.ExtractTreeWBFS(g);
		 
		Integer[] expectedOutput = {0, 7, 7, 8, 0, 0, 5, 0, 4};
		assertArrayEquals(expectedOutput, parents);
	
	}

}
