package Linkedlist;
//import java.util.Scanner;

public class compare {
	public static Node<Integer> createLinkedlist()
	{
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		Node<Integer> n4 = new Node<>(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		return n1;
	}
	public static void printlessthan(Node<Integer> head)
	{
		Node<Integer> temp = head;
		int count = 0;
		int i = temp.next.data;
		while(temp!=null)
		{
			count++;
			
			if(temp.data >temp.next.data)
			{
				break;
			}
			temp = temp.next;
		}
		System.out.println("count = "+count);
		System.out.println("i = "+i);
	}

	public static void main(String[] args)
	{
		Node<Integer> head = createLinkedlist();
		printlessthan(head);
	}
}
