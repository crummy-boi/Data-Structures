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
 * a class that extends to Exception and performs as a RuntimeException.
 * If called on, it calls on the super constructor Exception and passes that
 * an item was not found or a passed message
 * 
 * */
public class LinkedListException extends Exception	{
	
	public LinkedListException() {
		super("There is an error in the list");
	}
	
	/**
	 * calls on the super constructor Exception and passes the String
	 * message passed from an outside class
	 * */
	public LinkedListException(String message) {
		super(message);
	}
}
