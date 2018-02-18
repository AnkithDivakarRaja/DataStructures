package org.learning.linkedList;

import org.learning.support.Node;

public class LinkedList3 {

	Node getStartofCycle(Node root) {
		
		Node tmp = root;
		
		Node slowPointer = root;
		Node fastPointer = root;
		
		while(fastPointer != null && fastPointer.getNext() != null) {
			
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();
			
			if(slowPointer == fastPointer) {
				
				slowPointer = tmp;
				
				while(slowPointer != fastPointer) {
					slowPointer = slowPointer.getNext();
					fastPointer = fastPointer.getNext();
				}
				
				return slowPointer;
			}
		}
		return null;
	}
	
	int cycleLength(Node root) {
		
		Node slowPointer = root;
		Node fastPointer = root;
		
		while(fastPointer != null && fastPointer.getNext() != null) {
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();
			
			if(slowPointer == fastPointer) {
				int length = 1;
				slowPointer = slowPointer.getNext();
				while(slowPointer != fastPointer) {
					slowPointer = slowPointer.getNext();
					length++;
				}
				return length;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
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
				
		LinkedList3 ls = new LinkedList3();
		
		Node start = ls.getStartofCycle(rootc);
		if(start != null) 
			System.out.println(start);
		else
			System.out.println("There is no loop");
		
		System.out.println("Length of the cycle is " + ls.cycleLength(rootc));
	}

}
