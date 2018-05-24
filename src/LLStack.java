
/**
 * This class will use Nodes to form a linked list. It implements the LIFO
 * (Last In First Out) methodology to reverse the input string.
 *
 **/

public class LLStack {

	private Node head;	

	public LLStack( ) {
		head = null;
	}
	/************************/
	/*BEGIN NODE INNER CLASS*/
	/************************/
	private class Node  {
		private Object data;
		private Node next;

		/*
		 * 
		 * 
		 * */
		public Node(){
			data = null;
			next = null;
		}

		/*
		 * 
		 * 
		 * */
		public Node (Object newData, Node nextLink) {
			data = newData;
			next = nextLink;
		}
	} //end Node class
	
	/*****************************/
	/*BEING LLSTACK CLASS METHODS*/
	/*****************************/
	
	/*
	 * <h4>Description:</h4><br><p>
	 * 
	 * </p> 
	 * 
	 * @param itemData
	 * */
	public void addToStart(Object itemData) {
		head = new Node(itemData, head);
	}
	/*
	 * <h4>Description:</h4><br><p>Removes the head node and returns true if the list contains at
	 * least one node. Returns false if the list is empty.
	 * </p>
	 * 
	 */
	public boolean deleteHead( ) {
		if(head != null){
			head = head.next;
			return true;
		}else{
			return false;
		}
	}

	/*
	 * Returns the size of linked list by traversing the list
	 */
	public int size() {		
		int count = 0;
		Node currentNodePosition = head;
		while(currentNodePosition != null){
			count++;
			currentNodePosition = currentNodePosition.next;
		}
		return count;
	}

	/*
	 * 
	 * 
	 * */
	public boolean contains(Object item) {
		return (findData(item)) != null;
	}

	/*
	 * <h4>Description:</h4><br>
	 * <p>
	 * Finds the first node containing the target item, and returns a
	 * reference to that node. Return null if target not found.
	 * </p>
	 * 
	 * @param target
	 * @see contains(Object item){}
	 */
	private Node findData(Object target) {
		Node current = head;
		Object itemAtPosition;
		while (current != null) {
			itemAtPosition = current.data;

			if (itemAtPosition.equals(target))
				return current;
			current = current.next;
		}
		return null; //item not found, position is null
	}


	public void outputList( ) {
		Node current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	public String toString() {
		String retValue = "";
		Node current = head;

		while(current != null) {
			retValue += current.data.toString() + " ";
			current = current.next;
		}
		return retValue;
	}

	/*
	 * <h4>Description:</h4><br>
	 * <p> 
	 * </p>
	 * 
	 * */
	public boolean isEmpty( ) {
		return (head == null);
	}

	public void clear( ) {
		head = null;
	}
	/*
	 * <h4>Description:</h4><br>
	 * <p>For two lists to be equal they must contain the same data items in
	 * the same order. The equals method of T is used to compare data items.
	 * </p>
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;

		else if(!(otherObject instanceof LLStack))
			return false;

		else {
			LLStack otherList = (LLStack)otherObject;
			if (size( )!= otherList.size( ))
				return false;
			Node position = head;
			Node otherPosition = otherList.head;
			while (position != null) {
				if (!(position.data.equals(otherPosition.data)))
					return false;
				position = position.next;
				otherPosition = otherPosition.next;
			}
			return true; //objects are equivalent
		}
	}

	/**************************************/
	/*BEING DRIVER (NO MODIFICATIONS MADE)*/
	/**************************************/
	public static void main(String[] args) {

		// input data for testing
		String target = "Somethings!";
		String palindrome = "a man a plan canal panama";

		LLStack list = new LLStack( );
		// objects to be added to list
		Object object1 = (Character) target.charAt(4);
		Object object2 = (Character) target.charAt(1);
		Object object3 = (Character) target.charAt(2);
		Object object4 = (Character) target.charAt(9);
		Object object20 = (Character) target.charAt(6);  // will not be added to list

		// add 4 objects to our linked list
		list.addToStart(object1);
		list.addToStart(object2);
		list.addToStart(object3);
		list.addToStart(object4);

		// make sure all are added
		System.out.println("My list has " + list.size( ) + " nodes.");
		// display the newly created list
		list.outputList( );
		System.out.println("toString = " + list.toString());

		// test findData() here
		Node itemFound = list.findData(object1); 
		System.out.println("Item found: " + itemFound.data);

		// Test contains() here
		if (list.contains(object1))
			System.out.println("Object1 found.");
		else
			System.out.println("There is NO object1.");

		if (list.contains(object20))
			System.out.println("Object20 found.");
		else
			System.out.println("There is NO object20.");

		// Creating a new linked list by iteration using different input   
		LLStack linkedList = new LLStack();

		for(int i = 0; i < palindrome.length(); i++) {
			Object object = (Character) palindrome.charAt(i);
			linkedList.addToStart(object);
		}
		// Display your list now
		linkedList.outputList();

		// More tests; size() and is Empty()
		System.out.println("This time my list has " + linkedList.size( ) + " nodes.");
		System.out.println("Is our linkedList empty? " + linkedList.isEmpty());

		// Creating an Object of different class to compare with Character class
		Object mismatchObject = (Integer) Character.getNumericValue(target.charAt(0));

		boolean areEqual = linkedList.equals(mismatchObject);
		System.out.println("Are the 2 objects equal? " + areEqual);

		boolean areEqualAgain = linkedList.equals(linkedList);
		System.out.println("Are the 2 objects equal? " + areEqualAgain);

		// test deleteHead()   
		list.deleteHead( );
		if (list.contains(object4))
			System.out.println("Object4 found.");
		else
			System.out.println("Object4 has been deleted!");
		while (list.deleteHead( ));            //Empty loop body
		System.out.println("Start of list:");
		list.outputList( );
		System.out.println("End of list.");


		System.out.println("In the begining linkedList has " + linkedList.size() + " nodes");
		linkedList.clear();

		System.out.println("After testing clear(), linkedList has " + linkedList.size() + " nodes");
	}

}