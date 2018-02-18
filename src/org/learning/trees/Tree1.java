package org.learning.trees;

import java.util.LinkedList;
import java.util.Queue;

import org.learning.support.TreeNode;

public class Tree1 {

	public static void main(String[] args) {

		Tree1 t = new Tree1();
		
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
		
		t.levelOrderTraversal(root);
		System.out.println("reverse order");
		t.reverseLevelOrderTreversal(root);
	}

	void levelOrderTraversal(TreeNode root) {
		
		Queue<TreeNode> que = new LinkedList<>();
		
		que.add(root);
		que.add(null);
		while(!que.isEmpty()) {
			TreeNode tmp = que.poll();
			
			if(tmp != null) {
				if(tmp.getLeft() != null) que.add(tmp.getLeft());
				if(tmp.getRight() != null) que.add(tmp.getRight());
				
				System.out.print(tmp.getData());
			}else {
				System.out.println();
				if(!que.isEmpty())que.add(null);
			}
		}
	}
	
	void reverseLevelOrderTreversal(TreeNode root) {
		
		int h = height(root);
		
		for(int i = h - 1; i >= 0; i--) {
			levelPrint(root, i);
		}
		
	}
	
	void levelPrint(TreeNode root, int level) {
		
		if(level < 0 )
			return;
		else if(level == 0) {
			System.out.println(root.getData());
		}else {
			levelPrint(root.getLeft(), level - 1);
			levelPrint(root.getRight(), level - 1);
		}
	}
	
	int height(TreeNode root) {
		
		if(root == null) return 0;
		
		return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
	}
}
