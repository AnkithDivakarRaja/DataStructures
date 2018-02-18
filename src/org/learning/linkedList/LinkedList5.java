package org.learning.linkedList;

import java.util.Stack;

import org.learning.support.*;

public class LinkedList5 {

	Node getMergePoint(Node rootA, Node rootB) {
		
		Stack<Node> A = new Stack<>();
		Stack<Node> B = new Stack<>();
		
		while(rootA != null) {
			A.push(rootA);
			rootA = rootA.getNext();
		}
		
		while(rootB != null) {
			B.push(rootB);
			rootB = rootB.getNext();
		}
		
		Node tmpA = A.pop();
		Node tmpB = B.pop();

		while(tmpA == tmpB ) {
			tmpA = A.pop();
			tmpB = B.pop();
		}
		return tmpA.getNext();
	}
	
	Node getMergePointUsingLength(Node rootA, Node rootB) {
		
		int lenA = getLength(rootA);
		int lenB = getLength(rootB);
		
		int diff = lenA - lenB;
		
		if(diff > 0) {
			for(int i = 0; i<diff; i++) rootA = rootA.getNext();
		}else {
			for(int i = 0; i<Math.abs(diff); i++) rootB = rootB.getNext();
		}
		
		Node mergePt = null;
		while(rootA != rootB) {
			mergePt = rootA.getNext();
			rootA = rootA.getNext();
			rootB = rootB.getNext();
		}
		
		return mergePt;
	}
	
	int getLength(Node root) {
		int len = 0;
		
		while(root != null) {
			len++;
			root = root.getNext();
		}
		
		return len;
	}
	
	public static void main(String[] args) {
		
		//Commpon part
		Node root = new Node(7);
		Node node1 = new Node(5);
		root.setNext(node1);
		Node node2 = new Node(3);
		node1.setNext(node2);
		Node node3 = new Node(8);
		node2.setNext(node3);
		
		//List A
		Node rootA = new Node(4);
		Node node1A = new Node(5);
		rootA.setNext(node1A);
		Node node2A = new Node(3);
		node1A.setNext(node2A);
		Node node3A = new Node(8);
		node2A.setNext(node3A);
		Node node4A = new Node(6);
		node3A.setNext(node4A);
		node4A.setNext(root);
		
		//ListB
		Node rootB = new Node(4);
		Node node1B = new Node(5);
		rootB.setNext(node1B);
		Node node2B = new Node(3);
		node1B.setNext(node2B);
		Node node3B = new Node(8);
		node2B.setNext(node3B);
		node3B.setNext(root);

		LinkedList5 ls = new LinkedList5();
		
		System.out.println("The merge point is: ");
		System.out.println(ls.getMergePointUsingLength(rootA, rootB));
		
	}

}
