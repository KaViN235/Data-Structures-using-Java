package Queue;
import Linkedlist.Node;
public class QueueUsingLL<T> {
	private Node<T> front;
	private Node<T> rear;
	int size;
	
	public QueueUsingLL() {
		front = null;
		rear = null;
		size = 0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void enqueue(T elem) {
		size++;
		Node<T> newNode = new Node<>(elem);
		if(front == null)
		{
			front = newNode;
			rear = newNode;
			return;
		}
		rear.next = newNode;
		rear = newNode;
		
	}
	public T front() throws QueueEmptyException{
		if(front == null)
		{
			throw new QueueEmptyException();
		}
		return front.data;
	}
	public T dequeue() throws QueueEmptyException {
		if(front == null)
		{
			throw new QueueEmptyException();
		}
		 T ans = front.data;
		 front = front.next;
		 if(front == null) {
			 rear = null;
		 }
		 size--;
		 return ans; 
		 
	}
	

}
