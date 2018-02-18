package org.learning.linkedList;

import org.learning.support.Node;

public class LinkedList1 {

	Node getNthLast(Node root, int n) {
		
		Node slowPointer = root;
		Node fastPointer = root;
		
		int i = 1;
		while(i <= n && fastPointer != null) {
			fastPointer = fastPointer.getNext();
			i++;
		}
		
		while(fastPointer != null) {
			fastPointer = fastPointer.getNext();
			slowPointer = slowPointer.getNext();
		}
		
		return slowPointer;
				
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(4);
		Node node1 = new Node(5);
		root.setNext(node1);
		Node node2 = new Node(3);
		node1.setNext(node2);
		Node node3 = new Node(8);
		node2.setNext(node3);
		Node node4 = new Node(6);
		node3.setNext(node4);
		
		System.out.println(new LinkedList1().getNthLast(root, 3));
		
	}

}
