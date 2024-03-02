package priority_Queue;

public class PriorityQueueUse {

	public static void main(String[] args) throws PriorityQueueException {
		Priority_Queue<Character> h = new Priority_Queue<>();
		h.insert('k', 5);
		h.insert('a', 2);
		h.insert('v', 3);
		h.insert('i', 1);
		h.insert('n', 4);
		while(!h.isEmpty())
		{
			System.out.println(h.getmin());
			h.removeMin();
		}
		
	}

}
