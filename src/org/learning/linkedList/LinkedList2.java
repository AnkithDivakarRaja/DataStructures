package org.learning.linkedList;

import java.util.Hashtable;

import org.learning.support.Node;

public class LinkedList2 {

	//Using floyd's method
	boolean hasCycle(Node root) {
		
		Node slowPointer = root;
		Node fastPointer = root;
		
		while(fastPointer != null && fastPointer.getNext() != null) {
			
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();
			
			if(slowPointer == fastPointer) return true;
			
		}
		
		return false;
	}
	
	//Using hashTable
	boolean hasCycleHashTable(Node root) {
		
		Hashtable<Node , Integer> ht = new Hashtable<>();
		
		while(root != null) {
			if(ht.containsKey(root))
				return true;
			else
				ht.put(root, root.getData());
			
			root = root.getNext();
		}
		return false;
	}
	
	public static void main(String[] args) {
		//Without cycle
		Node root = new Node(4);
		Node node1 = new Node(5);
		root.setNext(node1);
		Node node2 = new Node(3);
		node1.setNext(node2);
		Node node3 = new Node(8);
		node2.setNext(node3);
		Node node4 = new Node(6);
		node3.setNext(node4);
		
		//With cycle
		Node rootc = new Node(4);
		Node node1c = new Node(5);
		rootc.setNext(node1c);
		Node node2c = new Node(3);
		node1c.setNext(node2c);
		Node node3c = new Node(8);
		node2c.setNext(node3c);
		Node node4c = new Node(6);
		node3c.setNext(node4c);
		node4c.setNext(node2c);
		
		LinkedList2 ls = new LinkedList2();

		if(ls.hasCycle(rootc))
			System.out.println("The list has cycle");
		else
			System.out.println("The list has no cycle");
		
		if(ls.hasCycleHashTable(root))
			System.out.println("The list has cycle");
		else
			System.out.println("The list has no cycle");
		
	}

}
