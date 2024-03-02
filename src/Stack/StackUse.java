package Stack;
public class StackUse {

	public static void main(String[] args) throws StackfullException,StackemptyException{
//		StackArray stack = new StackArray();
		StackLL<Integer> stack = new StackLL<>();
	
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<arr.length;i++) {
			stack.push(arr[i]);
		}
		stack.top();
		for(int i=0;i<arr.length;i++) {
			System.out.print(stack.pop()+" ");
		}
//		System.out.println(stack.size()); 

	}

}
