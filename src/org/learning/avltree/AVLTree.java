package org.learning.avltree;

public class AVLTree<T extends Comparable<T>> implements Tree<T>{

	private Node<T> root; 
	
	private Node<T> rightRotation(Node<T> node) {
		
		System.out.println("Right rotation on Node " + node);
		
		Node<T> tmpLeft = node.getLeftNode();
		Node<T> tmp = tmpLeft.getRightNode();
		
		tmpLeft.setRightNode(node);
		node.setLeftNode(tmp);
		
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
		tmpLeft.setHeight(Math.max(height(tmpLeft.getLeftNode()), height(tmpLeft.getRightNode())) + 1);
		
		return tmpLeft;
	}
	
	private Node<T> leftRotation(Node<T> node) {
		
		System.out.println("Left rotation on Node " + node);
		
		Node<T> tmpRight = node.getRightNode();
		Node<T> tmp = tmpRight.getLeftNode();
		
		tmpRight.setLeftNode(node);
		node.setLeftNode(tmp);
		
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
		tmpRight.setHeight(Math.max(height(tmpRight.getLeftNode()), height(tmpRight.getRightNode())) + 1);
		
		return tmpRight;
	}
	
	@Override
	public void insert(T data) {
		
		root = insert(root, data);
		
	}

	private Node<T> insert(Node<T> node, T data){
		
		if(node == null) 
			return new Node<T>(data);
		
		if(data.compareTo(node.getData()) < 0) {
			insert(node.getLeftNode(), data);
		}else {
			insert(node.getRightNode(), data);
		}
		
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1 );
		
		node = settleViolation(data, node);
		
		return node;
	}
	
	private Node<T> settleViolation(T data, Node<T> node) {
		
		int balance = getBalance(node);
		
		//left-left
		if(balance > 1 && data.compareTo(node.getLeftNode().getData()) < 0) {
			return rightRotation(node);
		}
		
		//right-right
		if(balance < -1 && data.compareTo(node.getRightNode().getData()) > 0) {
			return leftRotation(node);
		}
		
		//left-right
		if(balance > 1 && data.compareTo(node.getLeftNode().getData()) > 0) {
			node.setLeftNode(leftRotation(node.getLeftNode()));
			return rightRotation(node);
		}
		
		//right-left
		if(balance < -1 && data.compareTo(node.getRightNode().getData()) < 0) {
			node.setRightNode(rightRotation(node.getRightNode()));
			return leftRotation(node);
		}
		
		return node;
	}

	private int height(Node<T> node) {
		if(node == null) return -1;
		
		return node.getHeight();
		
	}
	
	private int getBalance(Node<T> node) {
		
		if(node == null) return 0;
		
		return (height(node.getLeftNode()) - height(node.getRightNode()));
	}
	
	@Override
	public void traverse() {
		
		if(root == null) return;
		
		inOrderTreversal(root);
	}

	private void inOrderTreversal(Node<T> root) {
		
		if(root.getLeftNode() != null)
			inOrderTreversal(root.getLeftNode());
		
		System.out.print(root.getData() + "-->");
		
		if(root.getRightNode() != null)
			inOrderTreversal(root.getRightNode());
		
	}

}
