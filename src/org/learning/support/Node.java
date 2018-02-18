package org.learning.support;

public class Node {

	public Node(){
		
	}
	
	public Node(int data){
		this.data = data;
	}
	
	int data;
	Node next;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString() {
		return "Node data: " + data;
	}
}
