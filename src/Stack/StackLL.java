package Stack;

import Linkedlist.Node;

public class StackLL<T> {
	private Node<T> head;
	private int size;
	public StackLL(){
		head =null;
		size =0;
	}
	public int  size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	public void push(T n)
	{
		Node<T> newnode = new Node<T>(n);
		newnode.next= head;
		head = newnode;
		size++;
	}
	public T top() throws StackemptyException{
		if (size == 0){
			throw new StackemptyException();
		}
		return head.data;
	}
	public T pop() throws StackemptyException{
		if (size == 0){
			throw new StackemptyException();
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
	

}
