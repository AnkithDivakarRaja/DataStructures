package org.learning.graphs;

import java.util.*;

public class Graph2 {

	private int V;
	private LinkedList<Integer> adj[];
	
	Graph2(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i =0 ; i < v; i++)
			adj[i] = new LinkedList<>();
	}
	
	void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	void BFS(int v) {
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[v] = true; 
		queue.add(v);
		
		while(!queue.isEmpty()) {
			int s = queue.poll();
			System.out.println(s + " ");
			
			Iterator<Integer> i = adj[s].iterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}	
			}
		}
	}
	
	public static void main(String[] args) {
		
		Graph2 g = new Graph2(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.BFS(2);
	}

}
