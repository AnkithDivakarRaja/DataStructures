package org.learning.trees;

import org.learning.support.TreeNode;

public class Tree3 {

	void allRootToLeafPath(TreeNode root , int[] path, int pathLength) {
		
		if(root == null) return;
		
		if(root.getLeft() == null && root.getRight() == null) {
			path[pathLength] = root.getData();
			for(int i : path)
				System.out.print(i);
			System.out.println();
		}else {
			path[pathLength] = root.getData();
			pathLength++;
			allRootToLeafPath(root.getLeft(), path, pathLength);
			allRootToLeafPath(root.getRight(), path, pathLength);
		}
	}
	
	public static void main(String[] args) {
		
		Tree3 t = new Tree3();
		
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
		
		t.allRootToLeafPath(root, new int[5], 0);
		
	}

}
