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
 * A class that behaves like a queue by using methods enqueue and dequeue. It
 * retains the methods of its superclass List. It passes its objects into
 * the enqueue and dequeue method, which are called to the insert and remove
 * methods in List. It prints the objects in a queue manner.
 * 
 */
public class Queue extends List{
	
	/** 
	 * it enqueues (or inserts) the passed Object into queue as an element of
	 * a node by calling the insert method in the superclass List. It inserts
	 * the passed object to the beginning of the list
	 * 
	 * @throws LinkedListException any error occurrence in the insert method
	 * */
	public void enqueue(Object obj) throws LinkedListException{
		super.insert(obj, 0);
	}
	
	/**
	 * it dequeues (or removes) nodes from the end of the list by calling the
	 * remove method in the superclass List. It returns the remaining node from
	 * the dequeued (or removed) list
	 * 
	 * @throws LinkedListException any error occurrence in the remove method
	 * */
	public Object dequeue(int index) throws LinkedListException{
		return super.remove(size() - 1);
	}
	
	/**
	 * Overrides the insert method in superclass List. Its Object parameter are
	 * passed to the enqueue method. This is to properly perform a enqueue (insert) method
	 * of a queue
	 * 
	 * @throws LinkedListException any error occurrence in the enqueue method
	 * */
	@Override
	public void insert(Object obj, int index) throws LinkedListException{
		enqueue(obj);
	}
	
	/**
	 * Overrides the remove method in superclass List. No parameters are passed
	 * to the dequeue method. This is to properly perform a dequeue (remove) method
	 * of a queue. Returns the the remaining node from the dequeued (or removed) list
	 * 
	 * @throws LinkedListException any error occurrence in the dequeue method
	 * */
	@Override
	public Object remove(int index) throws LinkedListException{
		return dequeue(size() - 1);
	}
	
	/** 
	 * A main that calls validTests() to test the behaviour of a Queue and
	 * expectionTests() to test how the queue handles many cases with exceptions
	 * 
	 * @throws LinkedListException if there are any errors in validTests or/and
	 * exceptionTests for testing queues
	 * */
	public static void main(String[] args) throws LinkedListException{
		/*test valid cases of a queue*/
		validTests();
		/*test bad cases of a queue. Uncomment this test later when the user wants
		 * to test exception cases*/
		//exceptionTests();
	}
	
	/** 
	 * To call the valid tests of the queue. Calls the enqueueTests method to
	 * start to test several methods to behave like a queue.
	 * 
	 * @throws LinkedListException if there are any errors in validTests for testing queues
	 * */
	public static void validTests() throws LinkedListException{
		enqueueTests();
	}
	
	/** 
	 * A method that tests the enqueue(insert) methods with the queues.
	 * It adds a passed element at the beginning of the queues with the enqueue(insert)
	 * method. Also tests if queues are equal and empty. Calls the dequeueTests method
	 * to pass the altered queues to test for dequeuing (removing) elements of a queue
	 * 
	 * @throws LinkedListException if there are any errors in enqueueTests for testing queues
	 * with the enqueue (insert) method
	 * */
	public static void enqueueTests() throws LinkedListException{
		/*initialised for further testing the behaviour of a queue*/
		Queue queue1 = new Queue();
		Queue queue2 = new Queue();
		/*passed Objects into pop method through pop or insert*/
		queue1.enqueue("trees");
		queue1.enqueue('b');
		queue1.enqueue(54);
		queue1.insert(67.98, 0);
		queue2.insert('b', 0);
		/*print the queues*/
		System.out.println("Queue1: "+queue1);
		System.out.println("Queue2: "+queue2);
		/*checks on if two queues match (in size, elements, and instances) and
		 * prints true if they do match. Prints false if they do not match.
		 * Since queue1 and queue2 do not have all matching elements/data
		 * and size, this should print false*/
		System.out.println("\nAre Queue1 and Queue2 equal? " + queue1.equals(queue2));
		/*prints size or nodes of the queues*/
		System.out.println("Queue1 size: "+queue1.size());
		System.out.println("Queue2 size: "+queue2.size());
		/*checks on if the queue is empty and prints true if it is empty.
		 * Prints false if it is not empty. Should print false*/
		System.out.println("Is Queue1 empty? " + queue1.isEmpty());
		System.out.println("Is Queue2 empty? " + queue2.isEmpty());
		
		/*calls dequeueTests and passes its queues into the method for further testing.
		 * This will test for dequeuing, check if the queue is empty and equal*/
		dequeueTests(queue1, queue2);
		
	}
	
	/** 
	 * A method that tests the dequeue(remove) methods with the queues.
	 * It removes a passed element from the end of the queue with the dequeue(remove)
	 * method. Also tests if queues are equal and empty.
	 * 
	 * @throws LinkedListException if there are any errors in enqueueTests for testing queues
	 * with the dequeue (remove) method
	 * */
	public static void dequeueTests(Queue queue1, Queue queue2) throws LinkedListException{
		/*print the queue to see how it dequeues*/
		System.out.println("\nInitial Queue1: "+queue1);
		/*dequeues the queue until its empty and prints the remaining nodes as it dequeues*/
		while(!queue1.isEmpty()) {
			System.out.println("Dequeuing");
			queue1.dequeue(0);
			System.out.println("Queue1 remaining " + queue1);
		}
		/*print the queue to see how it dequeues*/
		System.out.println("\nInitial Stack2: "+queue2);
		/*dequeues the queue until its empty and prints the remaining nodes as it dequeues*/
		System.out.println("Dequeuing");
		queue2.remove(0);
		System.out.println("Queue2 remaining " + queue2);
		/*Should return true since the queues are empty*/
		System.out.println("\nIs Queue1 empty? " + queue1.isEmpty());
		System.out.println("Is Queue2 empty? " + queue2.isEmpty());
		/*Since queue1 and queue2 are both empty, this should print true*/
		System.out.println("\nAre Queue1 and Queue2 equal? " + queue1.equals(queue2));
		/*prints size or nodes of the queues*/
		System.out.println("Queue1 size: "+queue1.size());
		System.out.println("Queue2 size: "+queue2.size());
		
	}
	
	/**
	 * A method that tests with the Queue methods that would result in a
	 * LinkedListException. To test any special case that might be encountered
	 * due to the complexity of the code (like in general)
	 * 
	 * Uncomment this method in the main method first to test out the error
	 * 
	 * @throws LinkedListException if there are any errors in exceptionTests for testing queues
	 * with the dequeue(remove) method
	 * */
	public static void exceptionTests() throws LinkedListException{
		/*initialised for further testing the behaviour of a bad queue*/
		Queue badQueue = new Queue();
		/*Will throw a LinkedListException if the user tries to delete a node
		 * from an empty queue*/
		badQueue.dequeue(0);
		System.out.println("Deleting an empty queue:"+badQueue);
	}


}
