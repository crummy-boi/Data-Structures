/**
 * Name: Nuranissa Sofia Abdul Wahid
 * CSS 143 A
 * Assignment: DataSturctures, LinkedList version. To test
 * the FIFO of Queues, LIFO of Stacks, and inserts and removes
 * of LinkedLists
 * 
 */
package linkedList;

/**
 * @author Nuranissa Sofia Abdul Wahid
 * 
 * A class that behaves like a stack by using methods push and pop. It
 * retains the methods of its superclass List. It passes its objects into
 * the push and pop method, which are called to the insert and remove methods
 * in List. It prints the objects in a stack manner.
 * 
 */
public class Stack extends List{
	
	/** 
	 * it pushes the passed Object into stack as an element of a node by
	 * calling the insert method in the superclass List. It inserts
	 * the passed object to the beginning of the list
	 * 
	 * @throws LinkedListException any error occurrence in the insert method
	 * */
	public void push(Object obj) throws LinkedListException{
		super.insert(obj, 0);
	}

	/**
	 * it pops (or removes) nodes from the beginning of the list by calling the
	 * remove method in the superclass List. It returns the remaining node from
	 * the popped (or removed) stack
	 * 
	 * @throws LinkedListException any error occurrence in the remove method
	 * */
	public Object pop() throws LinkedListException{
		return super.remove(0);
	}
	
	/**
	 * Overrides the insert method in superclass List. Its Object parameter are
	 * passed to the push method. This is to properly perform a push (insert) method
	 * of a stack
	 * 
	 * @throws LinkedListException any error occurrence in the push method
	 * */
	@Override
	public void insert(Object obj, int index) throws LinkedListException{
		push(obj);
	}
	
	/**
	 * Overrides the remove method in superclass List. No parameters are passed
	 * to the pop method. This is to properly perform a pop (remove) method
	 * of a stack. Returns the the remaining node from the popped (or removed) list
	 * 
	 * @throws LinkedListException any error occurrence in the pop method
	 * */
	@Override
	public Object remove(int index) throws LinkedListException{
		return pop();
	}

	/**
	 * A main that calls to test the behaviour of a Stack and
	 * expectionTests() to test how the stack handles many cases with exceptions
	 * 
	 * @throws LinkedListException if there are any errors in validTests or/and
	 * exceptionTests for testing stacks
	 * */
	public static void main(String[] args) throws LinkedListException{
		/*test valid cases of a stack*/
		validTests();
		/*test bad cases of a stack. Uncomment this test later when the user wants
		 * to test exception cases*/
		//exceptionTests();
	}
	
	/** 
	 * To call the valid tests of the stack. Calls the pushTests method to
	 * start to test several methods to behave like a stack.
	 * 
	 * @throws LinkedListException if there are any errors in validTests for testing stacks
	 * */
	public static void validTests() throws LinkedListException{
		pushTests();
	}
	
	/** 
	 * A method that tests the push(insert) methods with the stacks.
	 * It adds a passed element at the beginning of the stacks with the push(insert)
	 * method. Also tests if stacks are equal and empty. Calls the popTests method
	 * to pass the altered stacks to test for popping(removing) elements of a stack
	 * 
	 * @throws LinkedListException if there are any errors in pushTests for testing stacks
	 * with the push (insert) method
	 * */
	public static void pushTests() throws LinkedListException{
		/*initialised for further testing the behaviour of a stack*/
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		/*insert passed Objects into push method through push or insert*/
		stack1.push('3');
		stack1.push("nut");
		stack1.insert(4,0);
		stack2.insert(2.2,0);
		/*print the stacks*/
		System.out.println("Stack1: "+stack1);
		System.out.println("Stack2: "+stack2);
		/*checks on if two stacks match (in size, elements, and instances) and
		 * prints true if they do match. Prints false if they do not match.
		 * Since stack1 and stack2 do not have the same elements/data and size
		 * this should print false*/
		System.out.println("\nAre Stack1 and Stack2 equal? " + stack1.equals(stack2));
		/*prints size or nodes of the stacks*/
		System.out.println("Stack1 size: "+stack1.size());
		System.out.println("Stack2 size: "+stack2.size());
		/*checks on if the stack is empty and prints true if it is empty.
		 * Prints false if it is not empty. Should print false*/
		System.out.println("Is Stack1 empty? " + stack1.isEmpty());
		System.out.println("Is Stack2 empty? " + stack2.isEmpty());
		
		/*calls popTests and passes its stacks into the method for further testing.
		 * This will test for popping, check if the stack is empty and equal*/
		popTests(stack1, stack2);
	}
	
	/** 
	 * A method that tests the pop(remove) methods with the stacks.
	 * It removes a passed element from the beginning of the stack with the pop(remove)
	 * method. Also tests if stacks are equal and empty.
	 * 
	 * @throws LinkedListException if there are any errors in popTests for testing stacks
	 * with the pop (remove) method
	 * */
	public static void popTests(Stack stack1, Stack stack2) throws LinkedListException{
		/*print the stack to see how it pops*/
		System.out.println("\nInitial Stack1: "+stack1);
		/*pops the stack until its empty and prints the remaining nodes as it pops*/
		while(!stack1.isEmpty()) {
			System.out.println("Popping");
			stack1.pop();
			System.out.println("Stack1 remaining " + stack1);
		}
		/*print the stack to see how it pops*/
		System.out.println("\nInitial Stack2: "+stack2);
		/*pops the stack until its empty and prints the remaining nodes as it pops*/
		System.out.println("Popping");
		stack2.remove(0);
		System.out.println("Stack2 remaining " + stack2);
		/*Should return true since the stacks are empty*/
		System.out.println("\nIs stack1 empty? " + stack1.isEmpty());
		System.out.println("Is stack2 empty? " + stack2.isEmpty());
		/*Since stack1 and stack2 are both empty, this should print true*/
		System.out.println("\nAre Stack1 and Stack2 equal? " + stack1.equals(stack2));
		/*prints size or nodes of the stacks*/
		System.out.println("Stack1 size: "+stack1.size());
		System.out.println("Stack2 size: "+stack2.size());
		
	}
	
	/**
	 * A method that tests with the Stack methods that would result in a
	 * LinkedListException. To test any special cases that might be encountered
	 * due to the complexity of the code (like in general)
	 * 
	 * Uncomment this method in the main method first to test out the error
	 * 
	 * @throws LinkedListException if there are any errors in exceptionTests for
	 * testing stacks with the pop(remove) method
	 * */
	public static void exceptionTests() throws LinkedListException{
		/*initialised for further testing the behaviour of a bad stack*/
		Stack badStack = new Stack();
		/*Will throw a LinkedListException if the user tries to delete a node
		 * from an empty stack*/
		badStack.pop();
		System.out.println("Deleting an empty stack:"+badStack);
	}
	

}
