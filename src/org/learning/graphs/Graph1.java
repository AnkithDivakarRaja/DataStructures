package org.learning.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph1 {

	private int V;
	private LinkedList<Integer> adj[];
	
	Graph1(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i =0 ; i < v; i++)
			adj[i] = new LinkedList<>();
	}
	
	void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	void DFSUtil(int v, boolean visited[]) {
		
		visited[v] = true;
		System.out.println(v + " ");
		
		Iterator<Integer> i = adj[v].iterator();
		while(i.hasNext()) {
			
			int n = i.next();
			if(visited[n] == false) {
				DFSUtil(n, visited);
			}
		}
	}
	
	void DFS(int v) {
		boolean visited[] = new boolean[V];
		for(int i=0; i<V; i++)
			if(!visited[i])
				DFSUtil(v, visited);
	}
	
	public static void main(String[] args) {
		
		Graph1 g = new Graph1(4);
		 
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal");
 
        g.DFS(2);
	}

}
