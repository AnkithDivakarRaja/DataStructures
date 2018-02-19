package org.learning.binarysearchtrees;

import org.learning.support.TreeNode;import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;

public class BinarySearchTree2 {

	TreeNode findLCA(TreeNode root, int data1, int data2) {
		
		if(root == null) return null;
		
		if(root.getData() == data1 || root.getData() == data2) return root;
		
		if(Math.max(data1, data2) < root.getData()) {
			return findLCA(root.getLeft(), data1, data2);
		}else if(Math.min(data1, data2) > root.getData()) {
			return findLCA(root.getRight(), data1, data2);
		}else {
			return root;
		}
	}
	
	boolean validateBST(TreeNode root, int max, int min) {
		if(root == null) return true;
		else
			return (root.getData() > min && root.getData() < max) && validateBST(root.getLeft(), root.getData(), min) && validateBST(root.getRight(), max, root.getData());
	}
	
	public static void main(String[] args) {

		BinarySearchTree2 t = new BinarySearchTree2();
		
		TreeNode root = new TreeNode(6);
		TreeNode inner1 = new TreeNode(4);
		TreeNode inner2 = new TreeNode(10);
		TreeNode leaf1 = new TreeNode(3);
		TreeNode leaf2 = new TreeNode(5);
		TreeNode leaf3 = new TreeNode(9);
		TreeNode leaf4 = new TreeNode(11);
		
		root.setLeft(inner1);
		root.setRight(inner2);
		inner1.setLeft(leaf1);
		inner1.setRight(leaf2);
		inner2.setLeft(leaf3);
		inner2.setRight(leaf4);
		
		System.out.println("Is a Valid Binary Search Tree : " + t.validateBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
		
		System.out.println("Least common Ancestor");
		System.out.println(t.findLCA(root, 9, 11).getData());
	}

}
