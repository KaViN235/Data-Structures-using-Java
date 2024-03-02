package priority_Queue;

import java.util.ArrayList;

public class Priority_Queue<T> {
	private  ArrayList<Element<T>> heap;
	public Priority_Queue()
	{
		heap = new ArrayList<>(); 
	}
	public void insert(T value,int priority)
	{
		Element<T> n = new Element<>(value,priority);
		heap.add(n);
		int childIndex = heap.size()-1;
		int parentIndex = (childIndex -1)/2;
		while(childIndex > 0)
		{
			if(heap.get(childIndex).priority<heap.get(parentIndex).priority )
			{
				Element<T> temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex,temp);
				childIndex = parentIndex;
				parentIndex = (childIndex -1)/2;
			}
			else{
				return;
			}
		}
	}
	public T getmin() throws PriorityQueueException{
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		return heap.get(0).value;
	}
	public T removeMin()
	{
		Element<T> send = heap.get(0);
		T ans = send.value;
		heap.set(0,heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int parentIndex = 0;
		int leftChildIndex = 2*parentIndex +1;
		int rightChildIndex = 2*parentIndex +2;
		while(leftChildIndex<heap.size())
		{
			int minPro = parentIndex;
			if(heap.get(leftChildIndex).priority  < heap.get(minPro).priority)
			{
				minPro = leftChildIndex;
			}
			if(rightChildIndex<heap.size() && heap.get(rightChildIndex).priority  < heap.get(minPro).priority)
			{
				minPro = rightChildIndex;
			}
			if(minPro == parentIndex) {
				break;
			}
			Element<T> temp = heap.get(minPro);
			heap.set(minPro, heap.get(parentIndex));
			heap.set(parentIndex,temp);
			parentIndex = minPro;
			leftChildIndex = 2*parentIndex +1;
			rightChildIndex = 2*parentIndex +2;
		}
		return ans;
		
		
	}
	public int size()
	{
		return heap.size();
		
	}
	public boolean isEmpty() 
	{
		return heap.size() == 0;
	}
	private  void inserthelper(int childIndex)
	{
		if(childIndex<=0)
		{
			return;
		}
		int parentIndex = (childIndex-1)/2;
		if(heap.get(childIndex).priority>heap.get(parentIndex).priority )
		{
			return;
		}
		Element<T> temp = heap.get(childIndex);
		heap.set(childIndex, heap.get(parentIndex));
		heap.set(parentIndex,temp);
		childIndex = parentIndex;
		inserthelper(childIndex);
		
	}
	public void insertRec(T value,int priority)
	{
		Element<T> n = new Element<>(value,priority);
		heap.add(n);
		int childIndex = heap.size()-1;
		inserthelper(childIndex);
	}	
}
