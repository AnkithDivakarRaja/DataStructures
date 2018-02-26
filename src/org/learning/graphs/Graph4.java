package org.learning.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph4 {

	private int V;
	private LinkedList<Integer> adj[];
	
	Graph4(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i =0 ; i < v; i++)
			adj[i] = new LinkedList<>();
	}
	
	void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	void shortestPath(int v) {
		LinkedList<Integer> queue = new LinkedList<>();
		int pathCost[] = new int[V];
		int prevNode[] = new int[V];
		
		for(int i=0; i<V; i++) {
			pathCost[i] = 0;
			prevNode[i] = i;
		}
		
		queue.add(v);
		while(!queue.isEmpty()) {
			
			int s = queue.poll();
			Iterator<Integer> i = adj[s].iterator();
			while(i.hasNext()) {
				
				int next = i.next();
				if(pathCost[next] == 0) {
					pathCost[next] = pathCost[s] + 1; 
					prevNode[next] = s;
					
					queue.add(next);
				}
			}
		}
		
		for(int i=0; i<V; i++) {
			System.out.println("Node " + i + ": " + pathCost[i] + " from " + prevNode[i]);
		}
 	}
	
	public static void main(String[] args) {
		
		Graph4 g = new Graph4(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Shortest path from 0");
        System.out.println();
        g.shortestPath(0);
	}

}
