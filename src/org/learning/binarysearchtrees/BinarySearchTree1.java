package org.learning.binarysearchtrees;

import org.learning.support.TreeNode;

public class BinarySearchTree1 {

	TreeNode insert(TreeNode root, int data) {
		
		if(root == null) {
			TreeNode tmp = new TreeNode();
			tmp.setData(data);
		}else {
			if(root.getData() < data) {
				root.setRight(insert(root.getRight(), data));
			}else {
				root.setLeft(insert(root.getLeft(), data));
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree1 t = new BinarySearchTree1();
		
		TreeNode root = new TreeNode(7);
		TreeNode inner1 = new TreeNode(6);
		TreeNode inner2 = new TreeNode(5);
		TreeNode leaf1 = new TreeNode(4);
		TreeNode leaf2 = new TreeNode(3);
		TreeNode leaf3 = new TreeNode(2);
		TreeNode leaf4 = new TreeNode(1);
		
		root.setLeft(inner1);
		root.setRight(inner2);
		inner1.setLeft(leaf1);
		inner1.setRight(leaf2);
		inner2.setLeft(leaf3);
		inner2.setRight(leaf4);
		
		t.insert(root, 8);
	}
	
}
