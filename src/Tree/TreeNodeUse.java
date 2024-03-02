package Tree;

import java.util.Scanner;

import Queue.QueueEmptyException;
import Queue.QueueUsingLL;
public class TreeNodeUse {
	public static void postorder(TreeNode<Integer> root)
	{
		if(root == null) {
			return;
		}
		
		for(int i=0;i<root.children.size();i++)
		{
			postorder(root.children.get(i));
			
		}
		System.out.print(root.data+" ");
	}
	public static void preorder(TreeNode<Integer> root)
	{
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		for(int i=0;i<root.children.size();i++)
		{
			preorder(root.children.get(i));
		}
	}
	public static int countleaf(TreeNode<Integer> root)
	{
		int count = 0;
		if(root.children.size()==0)
		{
			return 1;
		}
		for(int i=0;i<root.children.size();i++)
		{
			count += countleaf(root.children.get(i));
		}
		return count;
	}
	public static void Kfind(TreeNode<Integer> root,int k) {
		if(k==0)
		{
			System.out.print(root.data+" ");
		}
		for(int i=0;i<root.children.size();i++) {
			Kfind(root.children.get(i),k-1); 
		}
	}
	
	public static int NodeHeight(TreeNode<Integer> root) {
		int height=1;
		for(int i=0;i<root.children.size();i++)
		{
			int count =1;
			count += NodeHeight(root.children.get(i));
			if(count > height)
			{
				height = count;
			}
			
		}
		return height;
	}
	public static int numNodes(TreeNode<Integer> root)
	{
		int count = 1;
		for(int i=0;i<root.children.size();i++) {
			count+= numNodes(root.children.get(i));
		}
		return count;
	}
	public static TreeNode<Integer> treeinput(Scanner s)
	{
		int n = s.nextInt();
		TreeNode<Integer> root = new TreeNode<>(n);
		int childcount = s.nextInt();
		for(int i=0;i<childcount;i++)
		{
			TreeNode<Integer> child = treeinput(s); 
			root.children.add(child);
		}
		return root;
	}
	public static TreeNode<Integer> treelevelwise() 
	{
			Scanner s = new Scanner(System.in);
			int data = s.nextInt();
			TreeNode<Integer> root = new TreeNode<>(data);
			QueueUsingLL<TreeNode<Integer>> pending = new QueueUsingLL<>();
			pending.enqueue(root);
			while(!pending.isEmpty())
			{
				try {
				TreeNode<Integer> frontNode = pending.dequeue();
				System.out.println("Number of children for " +frontNode.data+": ");
				int n = s.nextInt();
				for(int i=0;i<n;i++)
				{
					System.out.println("Enter "+(i+1)+"child of "+frontNode.data);
					int child= s.nextInt();
					TreeNode<Integer> newnode = new TreeNode<>(child);
					frontNode.children.add(newnode);
					pending.enqueue(newnode);
				}
				}
				catch(QueueEmptyException e)
				{
					return null;
				}
			}
			return root;
	}
	public static void treeprint(TreeNode<Integer> root)
	{
		System.out.print(root.data+" : ");
		for(int i=0;i<root.children.size();i++)
		{
			System.out.print(root.children.get(i).data+" ");
		}
		System.out.println();
		for(int i=0;i<root.children.size();i++)
		{
			treeprint(root.children.get(i));
		}
	}
	public static void printlevelwise(TreeNode<Integer> root)
	{
		QueueUsingLL<TreeNode<Integer>> pending =new QueueUsingLL<>();
		pending.enqueue(root);
		while(!pending.isEmpty())
		{
			try {
				TreeNode<Integer> frontNode = pending.dequeue();
			String s = frontNode.data + " :";
			for(int i=0;i<frontNode.children.size();i++)
			{
				s += frontNode.children.get(i).data + " ,";
				pending.enqueue(frontNode.children.get(i));
			}
			System.out.println(s);
			
			}
			catch(QueueEmptyException e)
			{
				return;
			}
			}
	}
	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		TreeNode<Integer> root =  treeinput(s);
		TreeNode<Integer> root = treelevelwise();
		printlevelwise(root);
//		preorder(root);
		postorder(root);
//		System.out.println(numNodes(root));
//		System.out.println(NodeHeight(root));
//		Kfind(root,2);
//		treeprint(root);
//		System.out.println(countleaf(root));
		
	}
}
