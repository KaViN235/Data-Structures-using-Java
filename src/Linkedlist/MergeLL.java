package Linkedlist;

import java.util.Scanner;

public class MergeLL {
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
	public static Node<Integer> mergeLL(Node<Integer> head1,Node<Integer> head2) {
		Node<Integer> head = null;
		Node<Integer> tail = null;
		if(head1.data < head2.data) {
			head = head1;
			tail = head1;
			head1=head1.next;
		}
		else {
			head = head2;
			tail = head2;
			head2=head2.next;
		}
		while(head1 !=null && head2 != null) {
			if(head1.data < head2.data) {
				tail.next = head1;
				tail = tail.next;
				head1 = head1.next;
			}
			else {
				tail.next = head2;
				tail = tail.next;
				head2 = head2.next;
				
			}
			if(head1!=null)
			{
				tail.next = head1; 
			}
			if(head2!=null)
			{
				tail.next = head2; 
			}
		}
			
			
		return head;
	}
	public static void main(String[] args) {
	
		Node<Integer> head1 = input();
		Node<Integer> head2 = input();
		Node<Integer> head = mergeLL(head1,head2);
		printLinkedlist(head);
		

	}

}
