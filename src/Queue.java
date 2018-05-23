import java.util.LinkedList;

public class Queue<T> {

	
	public static void main(String[] args){
		
		LinkedList<Character> q = new LinkedList<Character>();
		q.push('R');
		q.push('a');
		q.push('c');
		q.push('e');
		//a.push('c');
		//a.push('a');
		q.push('r');
		System.out.println("Size : " + q.size());
		while(!q.isEmpty()) {
			System.out.println(q.pop());
		}
	}
}
