package Linkedlist;

import java.util.Scanner;

public class Mid_point {
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
	public static void midone(Node<Integer> head){
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		while(fast.next != null && fast.next.next != null ) {
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println(slow.data);
		
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Node<Integer> head = input(n);
		midone(head);
		
	}

}
