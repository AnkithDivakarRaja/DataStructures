package org.learning.trees;

import org.learning.support.TreeNode;

public class Tree2 {

	public static void main(String[] args) {
	
		Tree2 t = new Tree2();
		
		TreeNode root = new TreeNode(1);
		TreeNode inner1 = new TreeNode(2);
		TreeNode inner2 = new TreeNode(3);
		TreeNode leaf1 = new TreeNode(4);
		TreeNode leaf2 = new TreeNode(5);
		TreeNode leaf3 = new TreeNode(6);
		TreeNode leaf4 = new TreeNode(7);
		
		root.setLeft(inner1);
		root.setRight(inner2);
		inner1.setLeft(leaf1);
		inner1.setRight(leaf2);
		inner2.setLeft(leaf3);
		inner2.setRight(leaf4);

		System.out.println("Max element in Tree is " + t.maxBinaryTree(root));
		System.out.println("Size of the Tree is " + t.size(root));
		System.out.println("Find element 4 in Tree " + t.findBinaryTree(root, 4));
	}
	
	int maxBinaryTree(TreeNode root) {
		
		int max = Integer.MIN_VALUE;
		
		if(root != null) {
			
			int leftMax = maxBinaryTree(root.getLeft());
			int rightMax = maxBinaryTree(root.getRight());
			
			if(leftMax > rightMax) {
				max = leftMax;
			}else {
				max = rightMax;
			}
			
			if(root.getData() > max) max = root.getData();
		}
		return max;
	}
	
	boolean findBinaryTree(TreeNode root, int element) {
		
		if(root != null) {
			
			if(root.getData() == element) 
				return true;
			else
				return findBinaryTree(root.getLeft(), element) || findBinaryTree(root.getRight(), element);
		}
		return false;
	}

	
	int size(TreeNode root) {
		
		int leftCount = (root.getLeft() != null)? size(root.getLeft()):0;
		int rightCount = (root.getRight() != null)? size(root.getRight()):0;
		
		return 1 + leftCount + rightCount;
				
	}
	
}
