package org.learning.avltree;

public class AVLTree<T> implements Tree<T>{

	private Node root; 
	
	@Override
	public void insert(T data) {
		// TODO Auto-generated method stub
		
	}

	public int height(Node node) {
		if(node == null) return -1;
		
		return node.getHeight();
		
	}
	
	@Override
	public void traverse() {
		
		if(root == null) return;
		
		inOrderTreversal(root);
	}

	private void inOrderTreversal(Node root) {
		
		if(root.getLeftNode() != null)
			inOrderTreversal(root.getLeftNode());
		
		System.out.print(root.getData() + "-->");
		
		if(root.getRightNode() != null)
			inOrderTreversal(root.getRightNode());
		
	}

}
