package org.learning.linkedList;

import org.learning.support.Node;

public class LinkedList4 {

	Node reverse(Node root) {
		
		Node prev = null;
		Node current = root;
		
		while(current != null) {
			Node next = current.getNext();
			
			current.setNext(prev);
			prev = current;
			current = next;
			
		}
		
		return prev;
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
		
		LinkedList4 ls = new LinkedList4();
		
		Node head = ls.reverse(root);
		
		System.out.println("Reversed List");
		while(head != null) {
			System.out.println(head);
			head = head.getNext();
		}
			
		
	}

}
