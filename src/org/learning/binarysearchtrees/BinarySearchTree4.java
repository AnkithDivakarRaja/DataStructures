package org.learning.binarysearchtrees;

import org.learning.support.TreeNode;

public class BinarySearchTree4 {

	TreeNode findKthSmallest(TreeNode root, int k, int count) {
		
		if(root == null) return null;
		
		TreeNode left = findKthSmallest(root.getLeft(), k, count);
		if(left != null) return left;
		if(++count == k) return root;
		return findKthSmallest(root.getRight(), k, count);
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree3 t3 = new BinarySearchTree3();
		BinarySearchTree4 t4 = new BinarySearchTree4();
		
		int[] arr = {1,2,4,5,6,8,9,11,13,14,16,17};
		
		System.out.println(t4.findKthSmallest(t3.buildBST(arr, 0, arr.length - 1), 6, 0));
		
		

	}

}
