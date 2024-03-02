package Linkedlist;
import java.util.Scanner;

public class PalindromeLL {
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
	public static void reverse(Node<Integer> head){
		if(head == null)
		{
			return;
		}
		else
		{
			reverse(head.next);
			System.out.print(head.data+" ");
		}
		
	}
	public static Node<Integer> reverseset(Node<Integer> head)
	{
		Node<Integer> prev = null;
		Node<Integer> fwd = null;
		Node<Integer> curr = head;
		while(curr != null)
		{
			fwd = curr.next;
			curr.next = prev;
			prev = curr;
			curr = fwd;
		}
		return prev;
	}
	
	public static boolean checkpalindrome(Node<Integer> head,int n)
	{
		Node<Integer> rev = reverseset(head);
		System.out.println(head + " " + head.next);
		System.out.println(rev + " " + rev.next);
		while(n/2 !=0)
			
		{
			if(head.data != rev.data)
			{
				return false;
			}
			head = head.next;
			rev = rev.next;
			n--;
		}
		return true;
	}

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Node<Integer> head = input(n);
//		checkpalindrome(head);
//		printLinkedlist(head);
//		reverse(head);
		System.out.println(checkpalindrome(head,n));
	}
}
