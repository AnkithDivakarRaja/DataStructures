package org.learning.trees;

import org.learning.support.*;

public class Tree4 {

	TreeNode root;
	TreeNode head;
	static TreeNode prev = null;
	
	void buildDLLfromBST(TreeNode node) {
		
		if(node == null) return;
		
		//Go to the left most node to find the head of the DLL
		buildDLLfromBST(node.getLeft());
		
		if(prev == null)
			head = node;
		else {
			node.setLeft(prev);
			prev.setRight(node);
		}
		prev = node;
		
		//Add  the right elements to the DLL
		buildDLLfromBST(node.getRight());
	}
	
	void printList(TreeNode node)
    {
        while (node != null) 
        {
            System.out.print(node.getData() + " ");
            node = node.getRight();
        }
    }
	
	public static void main(String[] args) {
		
		Tree4 t = new Tree4();
		
		t.root = new TreeNode(10);
		t.root.setLeft(new TreeNode(12));
		t.root.setRight(new TreeNode(15));
		t.root.getLeft().setLeft(new TreeNode(25));
		t.root.getLeft().setRight(new TreeNode(30));
		t.root.getRight().setLeft(new TreeNode(36));
		
		t.buildDLLfromBST(t.root);
		t.printList(t.head);
	}
}
