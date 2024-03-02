package Linkedlist;

import java.util.Scanner;

public class Recursioninsert {
	public static  Node<Integer> input(int n)
	{
		Scanner s = new Scanner(System.in);
		Node<Integer> head =null,tail = null;
		while(n>0)
		{
			int data = s.nextInt();
			Node<Integer> currnode = new Node<Integer>(data);
			if(head == null)
			{
				head = currnode;
				tail = head;
			}
			else
			{
				tail.next = currnode;
				tail  = currnode;
			}
			n--;
		}
		return head;
	}
	public static void printLinkedlist(Node<Integer> head)
	{
		Node<Integer> temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	public static Node<Integer> insertr(Node<Integer> head,int elem,int pos)
	{
		if(pos ==0)
		{
			Node<Integer> newnode = new Node<Integer>(elem);
			newnode.next = head;
			return newnode;
		}
		else
		{
			head.next=insertr(head.next,elem,pos-1);
			return head;
		}
	}
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Node<Integer> head = input(n);
		int elem = s.nextInt();
		int pos = s.nextInt();
		insertr(head,elem,pos);
		printLinkedlist(head);

	}

}
