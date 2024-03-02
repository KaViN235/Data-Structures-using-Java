package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Adjacent_matrix {
	public static void dfthelper(int[][] a_m, int currentValue,boolean visited[]) 
	{
		visited[currentValue] = true;
		System.out.print(currentValue+" ");
		for(int i=0;i<a_m.length;i++)
		{
			if(a_m[currentValue][i] == 1 && visited[i]== false)
			dfthelper(a_m,i,visited);
		}
	}
	public static void dft(int[][] a_m) 
	{
		boolean[] visited = new boolean[a_m.length]; 
		dfthelper(a_m,0,visited);
	}
	public static void bft(int a_m[][])
	{
		boolean visited[] = new boolean[a_m.length];
		Queue<Integer> pending = new LinkedList<>();
		pending.add(0);
		visited[0] = true;
		while(!pending.isEmpty())
		{
			int currentVertex = pending.poll();
			System.out.print(currentVertex+" ");
			for(int i=0;i<a_m.length;i++)
			{
				if(a_m[currentVertex][i] == 1 && !visited[i])
				{
					pending.add(i);
					visited[i] = true;
				}
			}
			
		}
		
	}
	public static void dfsPathHelper(int[][] a_m,int s,int e,boolean find[],boolean[] visited)
	{
		visited[s] = true;
		if(find[0] || s==e)
		{
			find[0] = true;
		System.out.print(s+" ");
			return;
		}
		for(int i =0;i<a_m.length;i++)
		{
			if(a_m[s][i] == 1 && !visited[i] && !find[0]) {
			dfsPathHelper(a_m,i,e,find,visited );
			}
		}
		if(find[0])
		System.out.print(s+" ");
	
		
	}
	public static void dfsPath(int[][] a_m,int s,int e)
	{
		boolean visited[] = new boolean[a_m.length];
		boolean find[] = new boolean[1];
		dfsPathHelper(a_m,s,e,find,visited);
		
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();
		int a_m[][] = new int[v][v];
		for(int i=0;i<e;i++)
		{
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			a_m[v1][v2] = 1;
			a_m[v2][v1] = 1;
		}
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				System.out.print(a_m[i][j]+" ");
			}
		System.out.println();
		}
		dfsPath(a_m,0,2);
//		dft(a_m);
//		System.out.println();
//		bft(a_m);
	}

	

}
