package Linkedlist;
import java.util.Scanner;
class DoubleNode{
	Node<Integer> head;
	Node<Integer> tail;
	}
public class Reverse {
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
	public static Node<Integer> reverse(Node<Integer> head)
	{
		Node<Integer> revhead;
		Node<Integer> tail;
		if(head == null || head.next == null) 
		{
			return head;
		}
			revhead=reverse(head.next);
			tail = revhead;
			while(tail.next!=null){
				tail = tail.next;
			}
			tail.next = head;
			head.next = null;
			return revhead;
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
	public static DoubleNode reversebetter(Node<Integer> head)
	{
		DoubleNode ans;
		if(head == null || head.next == null)
		{
			ans = new DoubleNode();
			ans.head = head;
			ans.tail = head;
			return ans;
		}
		DoubleNode smallans = reversebetter(head.next);
	    smallans.tail.next = head;
	    smallans.tail = head;
	    smallans.tail.next = null;
	    return smallans;
		
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Node<Integer> head = input(n);
//		head = reverse(head);
		DoubleNode  sa = reversebetter(head);
		printLinkedlist(sa.head); 

	}

}
