package org.learning.splaytree;

public interface Tree<T> {

	public void insert(T data);
	public Node<T> find(T data);
	public T getMin();
	public T getMax();
	public void inOrderTreversal();
	
}
