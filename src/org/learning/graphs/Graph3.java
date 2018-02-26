package org.learning.graphs;

import java.util.*;

public class Graph3 {

	private int V;
	private LinkedList<Integer> adj[];
	
	Graph3(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i =0 ; i < v; i++)
			adj[i] = new LinkedList<>();
	}
	
	void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	void topologicalUtil(int v, boolean visited[], Stack<Integer> s) {
		
		visited[v] = true;
		
		Iterator<Integer> i = adj[v].iterator();
		while(i.hasNext()) {
			
			int n = i.next();
			if(visited[n] == false) {
				topologicalUtil(n, visited, s);
			}	
		}
		s.add(v);
	}
	
	void topologicalSort() {
		
		boolean visited[] = new boolean[V];
		Stack<Integer> s = new Stack<>();
		
		for (int i = 0; i < V; i++)
            visited[i] = false;
		
		for(int i=0; i<V; i++)
			if(!visited[i])
				topologicalUtil(i, visited, s);
		
		while(!s.empty())
			System.out.println(s.pop() + " ");
	}
	public static void main(String[] args) {
		
		Graph3 g = new Graph3(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological " +
                           "sort of the given graph");
        g.topologicalSort();

	}

}
