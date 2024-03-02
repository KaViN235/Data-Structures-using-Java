package binarytree;

import java.util.*;

public class BinarySearchTree {
	public static BinaryTree<Integer> inputlevelwise()
	{
		Scanner s = new Scanner(System.in);
		int rootdata = s.nextInt();
		if(rootdata == -1)
			return null;
		BinaryTree<Integer> root = new BinaryTree<>(rootdata);
		Queue<BinaryTree<Integer>> pending = new LinkedList<BinaryTree<Integer>>();
		pending.add(root);
		while(!pending.isEmpty())
		{
			BinaryTree<Integer> front = pending.poll();
			int rootleft = s.nextInt();
			if(rootleft != -1)
			{
				BinaryTree<Integer> left =new BinaryTree<>(rootleft);
				front.left = left;
				pending.add(left);
			}
			int rootright = s.nextInt();
			if(rootright != -1)
			{
				BinaryTree<Integer> right =new BinaryTree<>(rootright);
				front.right = right;
				pending.add(right);
			}
		}
		return root;
	}
	public static boolean BSTSearchData(BinaryTree<Integer> root,int search)
	{
		if(root == null)
		{
			return false;
		}
		if(root.data==search)
		{
			return true;
		}
		else if(search < root.data)
		{
			return BSTSearchData(root.left,search);
		}
		else
		{
			return BSTSearchData(root.right,search);
		}
	}
	public static void btwk1k2(BinaryTree<Integer> root,int k1,int k2) {
		if(root == null)
		{
			return; 
		}
//		if(root.data >= k1 && root.data <= k2)
//		{
//			System.out.println(root.data);
//		}
		if(root.data >= k1 && root.data <= k2) {
			btwk1k2(root.left,k1,k2);	
			System.out.print(root.data+" ");
			btwk1k2(root.right,k1,k2);
			
		}
		else if (root.data < k1) {
			btwk1k2(root.right,k1,k2);
		}
		else 
		{
			btwk1k2(root.left,k1,k2);
		}
	}
	public static BinaryTree<Integer> convertToBST(int[] a,int start,int end)
	{
		if(start > end)
		{
			return null;
		}
		int mid = start + (end-start)/2 ;
		BinaryTree<Integer> root = new BinaryTree<>(a[mid]);
		BinaryTree<Integer> rootleft = convertToBST(a,start,mid-1);
		BinaryTree<Integer> rootright = convertToBST(a,mid+1,end);
		root.left = rootleft;
		root.right = rootright;
		return root;
	}
	public static BinaryTree<Integer> constructBST(){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a[] = new int[n];
		for(int i=0;i<a.length;i++)
		{
			a[i] = s.nextInt();
		}
			return convertToBST(a,0,a.length-1);
	}
	public static void printPre(BinaryTree<Integer> root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.data+" ");
		if(root.left != null)
			printPre(root.left);
		if(root.right != null)
			printPre(root.right);
		
	}
		public static void print(BinaryTree<Integer> root) {
		
		if(root == null)
		{
			return;
		}
		String s = root.data +" :";
		if(root.left != null){
			s += "L" + root.left.data+",";
		}
		if(root.right != null){
			s += "R" + root.right.data; 
		}
		System.out.println(s);
		print(root.left);
		print(root.right);
	}
	public static IsBST isbst(BinaryTree<Integer> root)
	{
		if(root == null)
		{
			IsBST ans = new IsBST(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
					return ans;
		}
		IsBST left = isbst(root.left);
		IsBST right = isbst(root.right);
		int min = Math.min(root.data, Math.min(left.min, right.min));
		int max = Math.max(root.data, Math.max(left.max, right.max));
		boolean isbst = true;
		if(right.min < root.data)
			isbst = false;
		if(left.max >= root.data)
			isbst = false;
		if(!right.IsBst || !left.IsBst)
			isbst = false;
		IsBST ans = new IsBST(min,max,isbst);
		return ans;
	}
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
//		BinaryTree<Integer> root = inputlevelwise();
//		System.out.print("Enter the search data: ");
//		int search = s.nextInt();
//		int k1 = s.nextInt();
//		int k2 = s.nextInt();
//		btwk1k2(root,k1,k2);
//		System.out.println(BSTSearchData(root,search));
		BinaryTree<Integer> root = constructBST();
		printPre(root);
		System.out.println(isbst(root).IsBst);
//		print(root);
		
	}
	
}
