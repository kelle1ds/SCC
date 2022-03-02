package edu.cmich.cps542;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Strongly Connected Components Class
 * Used to take a String Edge Specifier and identify SSCs
 */
class StronglyConnectedComponents
{
    public static List<List> adjList;  //AdjList
    public static List<List> list2;  //Transposed AdjList
    public static Integer [] labels;  //Array for holding SSC labels
    public static int index = 1;  //used as labels for SSCs

    public static void main(String args[]) {
        //String edgeSpecifier = ("1-0,0-2,2-1,0-3,3-4");
        //int size = 5;
        //String edgeSpecifier = ("0-1,2-1");
        //int size = 3;
        String edgeSpecifier = ("0-1,1-2,2-0,2-3,1-4,2-5,4-5,5-4");
        int size = 6;
        boolean directed = true;
        Graph g = new Graph(size,edgeSpecifier,directed);
        stronglyConnected(g);
    }

    /** connected components
     * @param g  Input Graph as defined in the Graph class
     * @author kelle1ds
     */
    public static void stronglyConnected(Graph g) {
        Stack<Integer> stack = new Stack<>();  //Stack used throughout
        Integer[][] adjMatrix = g.getAdjMatrix();  //adjMatrix create from Graph object

        //adjList from adjMatrix method.  Returns a List<List<Integer>>
        adjList = adjList(g.getAdjMatrix());

        //Create Boolean Visited array and set all to false
        boolean [] visited = new boolean[adjMatrix.length];
        for(int i = 0; i < adjMatrix.length;i++){
            visited[i] = false;
        }

        //Iterate through indices and do a DFS on unvisited vertices
        for(int i = 0; i < adjMatrix.length;i++){
            if(!visited[i]){
                dfs1(i, visited, stack);
            }
        }
        ///End of first DFS

        //Transpose of graph
        Integer[][] trans = transpose(g);
        list2 = adjList(trans);  //transposed adjList.  list2 is public

        //Reset visited[] array to false
        for(int i = 0; i < adjMatrix.length;i++){
            visited[i] = false;
        }

        labels = new Integer[adjMatrix.length];  //keep track of ssc

        //Iterate through the stack ond group SSCs
        while(!stack.empty()){
            Integer v = stack.pop();  //pop the top off the stack, which was the last visited
            if(!visited[v]){
                System.out.println("Strongly Connected Components");
                dfs2(v, visited);
                System.out.println();  //Done with recurrence and end of SSC
                index++;  //increment label value for next SSC
            }
        }
    }

    /** Method used on forward adjList
     * @param v vertex to start search
     * @param visited  Visited array
     * @param stack Used to store finished vertices
     * @param list  The List associated with the respective index.
     */
    public static void dfs1(Integer v, boolean [] visited, Stack<Integer> stack) {

        visited[v] = true;  //vertex is visited

        // Iterate through the vertex's list
        for (int n : (Iterable<Integer>) adjList.get(v)) {
            if (!visited[n])  //if vertex has not been visited
                dfs1(n, visited, stack);  //recursion call
        }
        // push vertex to Stack
        stack.push(v);  //Push in order from the recursion the visited vertices.
    }

    /**
     * DFS method used on the transposed matrix
     * @param v Start Vertex
     * @param visited  Visited [] Array
     * @param list  List associated with Vertex
     */
    //public static void dfs2(Integer v,boolean [] visited, List<Integer> list, Integer [] order)
    public static void dfs2(Integer v,boolean [] visited)
    {
        // Current vertex is visited
        visited[v] = true;
        System.out.print(v + " ");
        labels[v] = index;

        // Recur for all the vertices adjacent to this vertex
        for (Integer k : (Iterable<Integer>) list2.get(v)) {
            if (!visited[k])
                dfs2(k, visited);
        }
    }

    /**
     * Function that returns a transpose of a graph
     * @param G  Graph object passed to function
     * @return 2D Integer matrix that is the transpose matrix
     */
    public static Integer[][] transpose(Graph g){
        Integer[][] adjMatrix = g.getAdjMatrix();  //Graph method
        int size = adjMatrix.length;

        Integer[][] transpose =new Integer[size][size];  //transposed matrix

        //Code to transpose adjMatrix
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++) {
                transpose[i][j] = adjMatrix[j][i];
            }
        }
        return transpose;
    }

    /** Method Used to create an adjList from an adjMatrix
     * @author kelle1ds
     * @param 2D array
     */
    public static List<List> adjList(Integer[][] m){
        List<List> adjList = new ArrayList<>();

        for(int i = 0; i < m.length; i++){
            List<Integer> list = new ArrayList<>();

            for(int j = 0; j < m.length; j++){
                if(m[i][j]==1){
                    list.add(j);
                }
            }
            adjList.add(list);
        }
        return adjList;
    }

}  //end of graph class


