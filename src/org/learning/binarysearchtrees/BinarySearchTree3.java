package org.learning.binarysearchtrees;

import org.learning.support.TreeNode;
import org.learning.trees.Tree1;

public class BinarySearchTree3 {

	
	TreeNode buildBST(int[] arr, int start, int end) {
		if(start > end) return null;
		
		TreeNode node = new TreeNode();
		
		if(start == end) {
			node.setData(arr[start]);
			node.setLeft(null);
			node.setRight(null);
		}else {
			int mid = (start + end)/2;
			
			node.setData(arr[mid]);
			node.setLeft(buildBST(arr, start, mid - 1));
			node.setRight(buildBST(arr, mid + 1, end));
		}
		
		return node;
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree3 t = new BinarySearchTree3();
		Tree1 helper = new Tree1();
		
		int[] arr = {1,2,4,5,6,8,9,11,13,14,16,17};
		
		helper.levelOrderTraversal(t.buildBST(arr, 0, arr.length - 1));
	}

}
