package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class Intersection {
	public static ArrayList<Integer> intersection(int[] a1, int[] a2) {
		HashMap<Integer,Integer> in = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<>();
		for( int i : a1)
			in.put(i, in.getOrDefault(i, 0)+1);
		for(int i: a2)
		{
			if(in.containsKey(i) && in.get(i)>0)
			{
				ans.add(i);
				in.put(i,in.getOrDefault(i,0)-1);
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		int a1[] = {2,6,8,5,4,2};
		int a2[] = {2,3,4,2};
		ArrayList<Integer> a = intersection(a1,a2);
		System.out.println(a);

	}

	
}
