package org.learning.linkedList;

import org.learning.support.Node;

public class LinkedList7 {

	static Node oddEven(Node root) {
		
		Node oddListH = new Node(0);
		Node evenListH = new Node(0);
		Node oddList = oddListH;
		Node evenList = evenListH;
		
		while(root != null) {
			if(root.getData() %2 != 0) {
				oddList.setNext(root);
				oddList = oddList.getNext();
			}else {
				evenList.setNext(root);
				evenList = evenList.getNext();
			}
			root = root.getNext();
		}
		evenList.setNext(null);
		oddList.setNext(evenListH.getNext());
		
		return oddListH.getNext();
		
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		Node node1 = new Node(2);
		root.setNext(node1);
		Node node2 = new Node(3);
		node1.setNext(node2);
		Node node3 = new Node(4);
		node2.setNext(node3);
		Node node4 = new Node(5);
		node3.setNext(node4);

		Node tmp = oddEven(root);
		while(tmp != null) {
			System.out.println(tmp.getData());
			tmp = tmp.getNext();
		}
	}

}
