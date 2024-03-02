package graph;
import java.util.*;
import java.util.Scanner;

public class Edge implements Comparable<Edge>{
	int v1;
	int v2;
	int w;
	
	public int compareTo(Edge e) {
		
		return this.w - e.w;
	}

	public static int Parent(int v,int[] parent )
	{
		if(parent[v] == v)
			return parent[v];
		return Parent(parent[v],parent);
		
	}
	public static void kruskal(Edge[] input,int v)
	{
		Arrays.sort(input);
		int parent[] = new int[v+1];
		for(int i=0;i<=v;i++) {
			parent[i] = i; 
		}
		Edge result[] = new Edge[v-1];
		int count = 0;
		int i=0;
		while(count != v-1)
		{
			Edge currentEdge = input[i];
			int sourceParent = Parent(currentEdge.v1,parent);
			int DesParent = Parent(currentEdge.v2,parent);
			if(sourceParent != DesParent)
			{
				result[count] = currentEdge;
				count++;
				parent[sourceParent] = DesParent;
			}
			i++;
		}
		for(Edge j : result)
			System.out.println(j.v1+" "+j.v2+" "+j.w);
		
	}
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();
		Edge input[] = new Edge[e];
		for(int i=0;i<e;i++)
		{
			input[i] = new Edge();
			input[i].v1 = s.nextInt();
			input[i].v2 = s.nextInt();
			input[i].w = s.nextInt();
		}
		kruskal(input,v);
	 }
}

