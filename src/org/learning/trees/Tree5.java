package org.learning.trees;

import org.learning.support.TreeNode;

public class Tree5 {

	int counter = 0;
	
	public static void main(String[] args) {
		
		Tree5 t = new Tree5();
		
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(6);
		root.setLeft(left);
		root.setRight(right);
		TreeNode leftLeft = new TreeNode(1);
		TreeNode leftRight = new TreeNode(3);
		left.setLeft(leftLeft);
		left.setRight(leftRight);
		TreeNode rightLeft = new TreeNode(5);
		TreeNode rightRight = new TreeNode(7);
		right.setLeft(rightLeft);
		right.setRight(rightRight);
		
		t.kthSmallest(root, 5);

	}
	
	
	void kthSmallest(TreeNode root, int k) {
		
		if(root != null) {
			kthSmallest(root.getLeft(), k);
			counter++;
			if(counter == k) System.out.println(root.getData());
			kthSmallest(root.getRight(), k);
		}
	}

}
