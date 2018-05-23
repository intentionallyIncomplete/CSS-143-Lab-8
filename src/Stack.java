public class Stack<T>{

	public static void main(String[] args) {

		Stack<Character> a = new Stack<Character>();
		a.push('R');
		a.push('a');
		a.push('c');
		a.push('e');
		//a.push('c');
		//a.push('a');
		a.push('r');
		System.out.println("Size : " + a.size());
		while(!a.isEmpty()) {
			System.out.println(a.pop());
		}
	}
}