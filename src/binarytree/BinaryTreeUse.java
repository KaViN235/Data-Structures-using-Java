package binarytree;
import java.util.*;

public class BinaryTreeUse{ 
	public static int sum(BinaryTree<Integer> root)
	{
		if(root == null)
		{
			return 0;
		}
		int rootleft = sum(root.left);
		int rootright = sum(root.right);
		
			return root.data + rootleft + rootright;
	}
	public static int count(BinaryTree<Integer> root)
	{
		if(root == null)
		{
			return 0;
		}
		int leftnodes = count(root.left);
		int rightnodes = count(root.right);
		return 1+leftnodes+rightnodes; 
	}
	public static BinaryTree<Integer> takeinputBetter(boolean isroot,int parentdata,boolean isleft,Scanner s)
	{
		if(isroot)
		{
		System.out.println("Enter the root data: ");
		}
		else if(isleft)
		{
			System.out.println("Enter the left child of "+parentdata);
		}
		else {
			System.out.println("Enter the right child of "+parentdata);
		}
//		Scanner s = new Scanner(System.in);
		int rootdata = s.nextInt();
		if(rootdata == -1)
		{
			return null;
		}
		BinaryTree<Integer> root = new BinaryTree<>(rootdata);
		BinaryTree<Integer> rootleft = takeinputBetter(false,rootdata,true,s);
		BinaryTree<Integer> rootright= takeinputBetter(false,rootdata,false,s);
		root.left= rootleft;
		root.right = rootright;
		return root;
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
	public static void printT(BinaryTree<Integer> root)
	{
		if(root == null)
		{
			return;
		}
		if(root.left != null)
			printT(root.left);
		System.out.print(root.data+" ");
		if(root.right != null)
			printT(root.right);
		
	}
	public static BinaryTree<Integer> removeLeaf(BinaryTree<Integer> root)
	{
		if(root == null)
		{
			return null;
		}
		if(root.left == null && root.right ==null )
		{
			return root=null;
		}
		root.left =removeLeaf(root.left);
		root.right= removeLeaf(root.right);
		return root;
	}
	public static int height(BinaryTree<Integer> root) 
	{
		if(root == null)
		{
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		return 1 + Math.max(left, right);
		
	}
	public static Boolean isBalanced(BinaryTree<Integer> root)
	{
		if(root==null)
		{
			return true;
		}
		int leftheight = height(root.left);
		int rightheight = height(root.right);
		if(Math.abs(leftheight-rightheight)> 1)
		{
			return false;
		}
		Boolean isleftbalanced = isBalanced(root.left);
		Boolean isrightbalanced = isBalanced(root.right);
		
		return isleftbalanced &&isrightbalanced;	
	}
	public static BalancedTreeReturn isBalancedBetter(BinaryTree<Integer> root)
	{
		if(root==null)
		{
			BalancedTreeReturn ans = new BalancedTreeReturn();
			ans.height = 0;
			ans.isBalanced = true;
			return ans;
		}
		BalancedTreeReturn left = isBalancedBetter(root.left);
		BalancedTreeReturn right = isBalancedBetter(root.right);
		int height = 1 + Math.max(left.height, right.height);
		boolean isbal = true;
		if(Math.abs(left.height- right.height)>1)
		{
			isbal = false;
		}
		if(!left.isBalanced || !right.isBalanced)
		{
			isbal = false;
		}
		BalancedTreeReturn ans = new BalancedTreeReturn();
		ans.height = height;
		ans.isBalanced = isbal;
		return ans;
		
	}
	public static int diameter(BinaryTree<Integer> root)
	{
		if(root == null)
		{
			return 0;
		}
		int d =height(root.left) + height(root.right);
		int dl =diameter(root.left);
		int dr =diameter(root.right);
		return Math.max(d,Math.max(dl, dr));
	}
	public static BinaryTree<Integer> inputlevewise()
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
	
	public static void printlevelwise(BinaryTree<Integer> root)
	{
		if(root == null)
		{
			return;
		}
		
		Queue<BinaryTree<Integer>> pending = new LinkedList<BinaryTree<Integer>>();
		pending.add(root);
		while(!pending.isEmpty())
		{
			BinaryTree<Integer> front = pending.poll();
			System.out.print(front.data+" :");
			if(front.left !=null)
			{
				System.out.print("L"+front.left.data+" ");
				pending.add(front.left);
			}
			if(front.right !=null)
			{
				System.out.print("R"+front.right.data);
				pending.add(front.right);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
//		BinaryTree<Integer> root = new BinaryTree<>(1);
//		BinaryTree<Integer> rootleft = new BinaryTree<>(2);
//		BinaryTree<Integer> rootright = new BinaryTree<>(3);
//		root.left = rootleft;
//		root.right = rootright;
//		BinaryTree<Integer> twosright = new BinaryTree<>(4);
//		BinaryTree<Integer> threesleft = new BinaryTree<>(5);
//		rootleft.right = twosright;
//		rootright.left = threesleft;
//		BinaryTree<Integer> root = takeinputBetter(true,0,true,s);
		BinaryTree<Integer> root = inputlevewise();
		printT(root);
//		removeLeaf(root);
//		System.out.println(isBalancedBetter(root).isBalanced);
//		System.out.println(diameter(root));
//		System.out.println();
//		 printlevelwise(root);
//		print(root);
//		System.out.println(sum(root));1 2 -1 4 -1 -1 3 5 -1 -1 -11 2 -1 4 -1 -1 3 5 -1 -1 -1
		
		
		
	}

}
