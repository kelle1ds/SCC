package edu.cmich.cps542;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BFSTreeCheckerTest {

	@Test 
	public void IsGraphATreeTest1() {
		Graph g = new Graph(5, "1-2, 2-3, 3-4, 4-0");
		boolean isATree = false;
		
		isATree = BFSTreeChecker.isGraphATree(g);
		 
		assertEquals(isATree, true);

			
	}
	
	@Test 
	public void IsGraphATreeTest2() {
		Graph g = new Graph(9, "0-1,0-2,1-3,1-4,2-3,2-4,3-8,5-6,6-7");

		boolean isATree = false;
		
		isATree = BFSTreeChecker.isGraphATree(g);
		 
		assertEquals(isATree, false);
	
		
	}

	@Test 
	public void IsGraphATreeTest3() {
		Graph g = new Graph(9, "0-5,0-7,5-8,5-6,8-3,8-4,7-1,7-2");
 
		boolean isATree = false;
		
		isATree = BFSTreeChecker.isGraphATree(g);
		 
		assertEquals(isATree, true);
		
			
	}

}
