package Stack;

public class StackArray {
	private int data[];
	private int topIndex;
	public StackArray(){
		data= new int[2];
		topIndex = -1;
	}
	public StackArray(int size){
		data= new int[size];
		topIndex = -1;
	}
	private void doubleCapacity(){
		System.out.println("dc");
		int temp[] = data;
		data = new int[2*temp.length];
		for(int i=0;i<temp.length;i++) {
			data[i] = temp[i];
		}
		}
	public void push(int n) throws StackfullException  {
		if(topIndex == data.length-1){
			doubleCapacity();
		}
		
		topIndex +=1;
		data[topIndex] = n;
	}
	public int pop() throws StackemptyException {
		if(topIndex == -1){
			throw new StackemptyException(); 
		}
		int ele = data[topIndex];
		topIndex -=1;
		return ele;
	}
	public int top() throws StackemptyException {
		if(topIndex == -1){
			throw new StackemptyException();
		}
		return data[topIndex];
		
	}
	public boolean isEmpty()
	{
		return topIndex == -1;
	}
	public int size(){
		
		return topIndex+1;
	}
//	public void print(){
//		for(int i=0;i<data.length;i++) {
//			System.out.print(data[i]+" ");
//		}
//	}
	
}
