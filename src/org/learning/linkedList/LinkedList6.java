package org.learning.linkedList;

import org.learning.support.Node;

public class LinkedList6 {

	Node mergeList(Node rootA, Node rootB) {
		
		if(rootA == null) return rootB;
		if(rootB == null) return rootA;
		
		Node head = null;
		
		if(rootA.getData() >= rootB.getData()) {
			head = rootB;
			head.setNext(mergeList(rootA, rootB.getNext()));
			
		}else {
			head = rootA;
			head.setNext(mergeList(rootA.getNext(), rootB));
		}
		
		return head;
	}
	
	Node mergeListIterative(Node rootA, Node rootB) {
		
		Node head = new Node(0);
		Node tmp = head;
		
		while(rootA != null && rootB != null) {
			if(rootA.getData() < rootB.getData()) {
				tmp.setNext(rootA);
				rootA = rootA.getNext();
			}else {
				tmp.setNext(rootB);
				rootB = rootB.getNext();
			}
		}
		
		if(rootA != null ) 
			tmp.setNext(rootA);
		if(rootB != null ) 
			tmp.setNext(rootB);
		
		return tmp.getNext();
	}
	
	public static void main(String[] args) {
		//List A
		Node rootA = new Node(1);
		Node node1A = new Node(3);
		rootA.setNext(node1A);
		Node node2A = new Node(5);
		node1A.setNext(node2A);
		Node node3A = new Node(7);
		node2A.setNext(node3A);
		Node node4A = new Node(9);
		node3A.setNext(node4A);
		

		// ListB
		Node rootB = new Node(2);
		Node node1B = new Node(4);
		rootB.setNext(node1B);
		Node node2B = new Node(6);
		node1B.setNext(node2B);
		Node node3B = new Node(8);
		node2B.setNext(node3B);
		
		LinkedList6 ls = new LinkedList6();
		
		Node merged = ls.mergeListIterative(rootA, rootB);
		
		while(merged != null) {
			System.out.println(merged);
			merged = merged.getNext();
		}
		
	}
	
}
