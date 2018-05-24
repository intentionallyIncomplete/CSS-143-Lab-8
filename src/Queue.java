import java.util.LinkedList;

public class Queue {


	public static void main(String[] args){

		LinkedList<Character> q = new LinkedList<Character>();
		q.push('R');
		q.push('a');
		q.push('c');
		q.push('e');
		q.push('c');
		q.push('a');
		q.push('r');
		System.out.println("Size : " + q.size());
		while(!q.isEmpty()) {
			System.out.println(q.pop());
		}
	}

	/*
	 * 
	 * 
	 * */
	class Node{
		/*
		 * @param Object
		 * @param Node
		 * */
		Object data = null;
		Node next = null;

		/*
		 * 
		 * 
		 * */
		public Node(Object d, Node n){
			data = d;
			next = n;
		}
	}
}
