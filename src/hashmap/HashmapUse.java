package hashmap;

import java.util.HashMap;

public class HashmapUse {

	public static void main(String[] args) {
		HashMap<String,Integer> h = new HashMap<>();
		h.put("e", 0);
		h.put("d", 1);
		h.put("c", 2);
		h.put("b", 3);
		h.put("a", 4);
		System.out.println(h.getOrDefault("b",-1));
		
		
	}

}
