package org.learning.linkedList;

import org.learning.support.Node;

public class LinkedList8 {

	static void unionIntersection(Node rootA, Node rootB) {
		
		Node intersectionH = new Node(0);
		Node unionH = new Node(0);
		Node intersection = intersectionH;
		Node union = unionH;
		Node tmp = rootB;
		Node tmp1 = rootA;
		
		while(rootA != null) {
			while(rootB != null) {
				
				if(rootA.getData() == rootB.getData()) {
					intersection.setNext(rootB);
					intersection = intersection.getNext();
				}else {
					union.setNext(rootB);
					union = union.getNext();
				}
				rootB = rootB.getNext();
			}
			rootB = tmp;
			rootA = rootA.getNext();
		}
		
		intersection.setNext( null);
		union.setNext(null);
		
		System.out.println("Intersection: ");
		while(intersectionH != null) {
			System.out.println(intersectionH.getData());
			intersectionH = intersectionH.getNext();
		}
		
		System.out.println("Union: ");
		while(tmp1 != null) {
			System.out.println(tmp1.getData());
			tmp1 = tmp1.getNext();
		}
		while(unionH != null) {
			System.out.println(unionH.getData());
			unionH = unionH.getNext();
		}
		
	}
	
	public static void main(String[] args) {
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
				
				
				//ListB
				Node rootB = new Node(4);
				Node node1B = new Node(5);
				rootB.setNext(node1B);
				Node node2B = new Node(0);
				node1B.setNext(node2B);
				Node node3B = new Node(7);
				node2B.setNext(node3B);
				node3B.setNext(null);
				
			unionIntersection(rootA, rootB);	
	}
	
}
