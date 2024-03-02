package Linkedlist;

import java.util.Scanner;

public class Sampletry {
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
	public static Node<Integer> insert(Node<Integer> head,int ele,int pos)

	{
		Node<Integer> newone = new Node<Integer>(ele);
		if(pos == 0 )
		{
			newone.next = head;
			return newone;
		}
		head.next=insert(head.next,ele,pos-1);
		return head;
	}
	public static int findNode(Node<Integer> head,int find){
		if(head == null)
		{
			return -1;
		}
		if(head.data == find)
		{
			return 0;
		}
		int i =findNode(head.next,find);
		if(i==-1) {
			return -1;
		}
//		System.out.println(i);
		return ++i;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Node<Integer> head = input(n);
		int find = s.nextInt();
//		findNode(head,find);
//		printLinkedlist(head);
		System.out.println(findNode(head,find));

	}

}
