package Queue;

public class QueueUsingArray {
	private int data[];
	private int front;
	private int rear;
	private int size;
	public QueueUsingArray() {
		data = new int[10];
		front = -1;
		rear = -1;
		size =0;
		
	}
	public void doublecapacity(){
		int temp[] = data;
		int data[]= new int[temp.length*2];
		for(int i =0;i<temp.length;i++) {
			data[i] = temp[i];
		}
		
	}
	public int size() {
		return size;
	}
	public void enqueue(int n) {
		if(size== data.length) {
			doublecapacity();
		}
		if(front == -1) {
			front = 0;
		}
	    data[++rear] = n;
		size++;
	}
	public int front() throws QueueEmptyException {
		if(front == -1) {
			throw new QueueEmptyException();
		}
		return data[front];
	}
	public int dequeue(int n) throws QueueEmptyException {
		if(size == 0) {
				throw new QueueEmptyException();
		}
		int temp = data[front];
		front++;
		size--;
		if(size == 0)
		{
			front = -1;
			rear = -1;
		}
		return temp; 
	}
	public boolean isEmpty() {
		return size == 0;
	}
	

}
