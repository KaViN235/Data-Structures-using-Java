package Linkedlist;

import java.util.Scanner;

public class LinkedlistUse
{
	public static Node<Integer> insert(Node<Integer> head)
	{
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		int pos = s.nextInt();
		Node<Integer> curr = new Node<Integer>(data);
		Node<Integer> prev = head;
		if(pos == 0)
		{
			curr.next = head;
			head = curr;
			return head;
		}
		int n=0;
		while(n< pos -1 && prev.next != null)
		{
			prev = prev.next;
			n++;
		}
		curr.next = prev.next;
		prev.next = curr;
		return head;
		
	}
	public static  Node<Integer> input()
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
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
//				Node<Integer> tail = head;
//				
//				while(tail.next != null)
//				{
//					tail = tail.next;
//				}
				tail.next = currnode;
				tail  = currnode;
				
			}
			
			n--;
		}
		
		return head;
	}
	public static Node<Integer> createLinkedlist()
	{
		Node<Integer> n1 = new Node<>(10);
		Node<Integer> n2 = new Node<>(20);
		Node<Integer> n3 = new Node<>(30);
		Node<Integer> n4 = new Node<>(40);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		return n1;
	}
	public static void printLinkedlist(Node<Integer> head)
	{
//		System.out.println(head.data);
//		System.out.println(head.next.next.next.data);
		Node<Integer> temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static void main(String[] args)
	{
//		Node<Integer> head = createLinkedlist();
		Node<Integer> head = input();
		head =insert(head);
		printLinkedlist(head);
	}
}
