package Linkedlist;

public class Lengthll {
	public static Node<Integer> createLinkedlist()
	{
		Node<Integer> n1 = new Node<>(10);
		Node<Integer> n2 = new Node<>(20);
		Node<Integer> n3 = new Node<>(30);
		Node<Integer> n4 = new Node<>(-1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		return n1;
	}
	public static void printLength(Node<Integer> head)
	{
		Node<Integer> temp = head;
		int count = 0;
		while(temp!=null)
		{
			if(temp.data == -1)
			{
				break;
			}
			count+=1;
			temp = temp.next;
		}
		System.out.println("count = "+count);
	}

	public static void main(String[] args)
	{
		Node<Integer> head = createLinkedlist();
		printLength(head);
	}

}
