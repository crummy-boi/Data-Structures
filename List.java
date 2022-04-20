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
 * A class that takes in an Object or/and index to test the behaviour of
 * LinkedLists. It inserts and removes(deletes) elements of each list. The methods and
 * properties in List are inherited by its sub classes Stack and Queue to perform
 * their respective data structure like-behaviours (Stack or Queue) of a LinkedList.
 * Also, this class appends elements at the end of list, find index of an element,
 * and find equality of each list.
 * 
 * */
public class List {
	
	/*initialise the start of the link.*/
	private Node head;
	
	/*no-arg constructor that sets the start of link as null.
	 * To be altered to an element later*/
	public List() {
		this.head = null;
	}
	
	/**
	 * an inner class to be used in the List class as to traverse a list
	 * */
	private class Node{
		/*to carry the element in the node*/
		private Object data;
		/*to traverse through the list*/
		private Node next;
		/*set the data as the passed object and next to null. 
		 * Will traverse data in a list*/
		private Node(Object data){
			this.data = data;
			this.next = null;
		}
		
	}
	
	/**
	 * a method that adds a new node with the passed element into the passed index
	 * of the list. It performs other cases where there is unusual about the passed
	 * object or index. If the list is empty, add value to the head. If the index is
	 * zero, insert passed value to the beginning of the list. If the list has one
	 * element, insert value into the node after head. Method returns the list with
	 * the inserted element at its specified index
	 * 
	 * @throws LinkedListException if the index is negative, exceeds size of list,
	 * and anything other errors
	 * */
	public void insert(Object next, int index) throws LinkedListException{
		/*if the index is negative, throw LinkedListException that prints
		 * the error of having a negative index*/
		if(index < 0) {
			throw new LinkedListException("Index is negative");
		}
		/*if the list is empty, have the head contain the passed element and make
		 * the node after the head a null*/
		if(head == null) {
			head = new Node(next);
			head.next = null;
		}
		/*if the index is zero, make the head carry the passed element and make
		 * the node after the head carry the element of the previous head. In short,
		 * insert the passed element into the head and shift the previous head
		 * element to the next node*/
		else if(index == 0) {
			Node temp = head;
 		   	head = new Node(next);
 		   	head.next = temp;
		}
		/*if the list only contains one element and index does not exceed list size,
		 * insert the passed element into the node after the head*/
		else if((head.next == null) && !(index >= size())) {
			head.next = new Node(next);
		}
		/*if the index is over the size of the list, throw LinkedListException
		 * that prints the error of exceeding the list*/
		else if(index >= size()) {
			throw new LinkedListException("Index exceeds list");
		}
		/*if the data is not empty, more than one element, and is valid, link the new node
		 * with the passed element into its respective index of the list*/
		else {
			/*to set the node of the head*/
			Node current = head;
			/*to know where the position of the Node current is. To be used to "break" or
			 * get out of a normal traverse to link to the passed element of its the index*/
			int position = 0;
			/*while the list is not empty and the position of current is before the
			 * targeted index, traverse through the list and increment the position
			 * as normal*/
			while(current != null && position != index - 1) {	
				current = current.next;
				position++;
			}
			/*to be used to link to the node after the index with the initial elements*/
			Node after = current.next;
			/*a new node with the passed element*/
			Node newNode = new Node(next);
			/*sets the link to the new node with the passed elements*/
			current.next = newNode;
			/*set the link to the saved node*/
			newNode.next = after;

		}

	}
	
	/**
	 * a method that removes a node at the passed index of the list. It performs other
	 * cases where there is unusual about the passed index or list. If the index is
	 * zero, skip the head and return the next node. Method returns the list of
	 * remaining nodes of a deleted list
	 * 
	 * @throws LinkedListException if the index is negative, index exceeds size of list,
	 * list is empty, and anything other errors
	 * */
	public Object remove(int index) throws LinkedListException{
		/*if the list is empty, throw a LinkedListException that prints the
		 * error of having a empty list*/
		if(head == null) {
			throw new LinkedListException("List is empty");
		}
		/*if the index is negative, throw a LinkedListException that prints
		 * the error of having a negative index*/
		if(index < 0) {
			throw new LinkedListException("Index is negative");
		}
		/*if the node in the zero is removed, skip the head and return the
		 * next node, which is the new head*/
		if(index == 0) {
			head = head.next;
			return head;
		}
		/*if the index is over the size of the list, throw LinkedListException
		 * that prints the error of exceeding the list*/
		if(index >= size()) {
			throw new LinkedListException("Index exceeds list");
		}
		/*if the data is not empty, more than one element, and is valid, remove the node
		 * in the indicated index of the list and return the remaining nodes*/
		else {
			/*to set the node after the head*/
			Node current = head.next;
			/*to set the node in the head*/
			Node prev = head;
			/*to know where the position of the Node current is. To be used to "break" or
			 * get out of a normal traverse to remove to the node in the passed index*/
			int count = 0;
			/*while the list is not empty and the position of current is before the
			 * targeted index, traverse through the list and increment the position
			 * as normal*/
			while(current != null && count != index - 1) {		
				prev = prev.next;
				current = current.next;
				count++;
			}
			/*to skip the node of the indicated index. To make the next node to
			 * the node after the previous node*/
			prev.next = current.next;
			/*returns the remaining nodes in the deleted list*/
			return head;
		}
				
	}
	
	/**
	 * return size of the list
	 * */
	public int size() {
		int countSize = 0;
		Node current = this.head;
		/*counts the list before it reaches null.
		 * Returns the size of the list*/
		while(current != null) {
			countSize++;
			current = current.next;
		}
		return countSize;
	}
	
	/**
	 * To store and return each element as a String to the main
	 * */
	@Override
	public String toString() {
		String output = "";
		Node current = head;
		while(current != null) {
			output += current.data;
			current = current.next;
		}
		return output;
		
	}
	
	/**
	 * to return true if the list is empty.
	 * return false if not empty
	 * */
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		return false;
		
	}
	
	/**
	 * returns index of passed Object by traversing through the list.
	 * if the passed Object is not found in the list, it returns -1
	 * */
	public int indexOf(Object target) {
		int count = 0;
		Node current = head;
		/*return the index if the data matches the target before null.
		 * increment index for each loop. returns -1 if the target
		 * is not found before null*/
		while(current != null) {
			if(current.data.equals(target)) {
				return count;
			}
			count++;
			current = current.next;
		}
		return -1;
	}

	/**
	 * links the new node to the end of the list. Performs different cases
	 * if the list is empty or has only one element
	 * */
	public void append(Object obj) {
		/*if the list is empty, have the head contain the passed element and make
		 * the node after the head a null*/
		if(head == null) {
			head = new Node(obj);
			head.next = null;
		}
		/*if the list only contains one element, insert the passed element into the
		 * node after the head*/
		else if(head.next == null) {
			head.next = new Node(obj);
		}
		/*if list is not empty and has more than one element, traverse the list before
		 * the last node and link to a new last node with the passed element*/
		else {
			/*to set the node of the head*/
			Node current = head;
			/*while the next node is not null, traverse through the list*/
			while(current.next != null) {
				current = current.next;
			}
			/*if the last node is null, set the passed element in the last node*/
			if(current.next == null) {
				current.next = new Node(obj);
			}
		}
		
	}
	
	/**
	 * Deletes the node in the passed index and returns the remaining nodes from
	 * the deleted list. Performs the same behaviour as the remove method, its
	 * parameters are passed to the remove method. Returns the remaining
	 * nodes of a deleted list from the remove method
	 * 
	 * @throws LinkedListException any error occurrence in the remove method
	 * */
	public Object delete(int index) throws LinkedListException{
		return remove(index);
	}
	
	/**
	 * to return true if two Lists are compared to be matched
	 * by each element/data and size of list. returns false if both
	 * Lists are compared to be false
	 * */
	@Override
	public boolean equals(Object other) {
		/*if the passed object is null or not the same instance as the List class,
		 * return false*/
		if(other == null || !(other instanceof List)) {
			return false;
		}
		/*a new List that contains the other object*/
		List that = (List) other;
		/*return false of the size of the two lists are different*/
		if(size() != that.size()) {
			return false;
		}
		Node current = this.head;
		Node otherCurrent = that.head;
		/*while both lists are not null, the elements in each of their nodes are
		 * compared to check if they match or not*/
		while(current != null && otherCurrent != null) {
			/*if both data do not match, return false*/
			if(!(current.data.equals(otherCurrent.data))) {
				return false;
			}
			/*if both lists are not null and their data are the same, go to their next
			 * nodes and traverse the list*/
			current = current.next;
			otherCurrent = otherCurrent.next;
		}
		/*return true if nodes in both lists match until they reach null*/
		return true;
	}
	
	/** 
	 * A main that calls validTests() to test the behaviour of a LinkedList and
	 * expectionTests() to test how the list handles many cases with exceptions
	 * 
	 * @throws LinkedListException if there are any errors in validTests or/and
	 * exceptionTests for testing lists
	 * */
	public static void main(String[] args) throws LinkedListException{
		/*test valid cases of a list*/
		validTests();
		/*test bad cases of a list. Uncomment this test later when the user wants
		 * to test exception cases*/
		//exceptionTests();
		
	}
	
	/** 
	 * To call the valid tests of the list. Calls the appendRemoveTests method to
	 * start to test several methods to behave like a list.
	 * 
	 * @throws LinkedListException if there are any errors in validTests for testing lists
	 * */
	public static void validTests()throws LinkedListException{
		appendRemoveTests();
	}
	
	/** 
	 * Initial appendRemoveTests():
	 * @author Rob Nash. He created an incomplete version of this method.
	 * 
	 * Modified appendRemoveTests():
	 * @author Nuranissa Sofia Abdul Wahid
	 * 
	 * A method that tests the append and remove(delete) methods with the lists.
	 * It adds a passed element at the end of the list with the append method. It deletes
	 * a element at a specific index with the delete method. Calls the insertTests method
	 * to pass the altered lists to test for inserts, indexOf, and isEmpty
	 * 
	 * @throws LinkedListException if there are any errors in appendRemoveTests for testing lists
	 * with the append method and/or delete(remove) method
	 * */
	public static void appendRemoveTests()throws LinkedListException{
		/*initialised for further testing the behaviour of a LinkedList*/
		List empty = new List();
		List one = new List();
		List multiple = new List();
		/*adds passed elements at the end of the lists*/
		one.append(5);
		multiple.append(10);
		multiple.append (20);
		multiple.append (30);
		/*prints lists with the appended elements*/
		System.out.println("Empty: "+empty);
		System.out.println("One: "+one);
		System.out.println("Multiple: "+ multiple);	
		
		/*deletes nodes at the passed index in the lists*/
		one.delete(0);
		multiple.delete(1);
		/*prints lists with the remaining nodes after deletion*/
		System.out.println("\nOne (upon remove): "+one);
		System.out.println("Multiple (upon remove): "+ multiple);
		
		/*adds passed elements at the end of the lists*/
		one.append(600);
		multiple.append(2020);
		/*prints lists with the appended elements*/
		System.out.println("\nOne (on append):"+one);
		System.out.println("Multiple(on append):"+ multiple);
		/*prints size or nodes of the lists*/
		System.out.println("\nEmpty size: "+empty.size());
		System.out.println("One size: "+one.size());
		System.out.println("Multiple size: "+ multiple.size());
		
		/*calls insertTests and passes its lists into the method for further testing.
		 * This will test for inserts, get indexes, check if the list is empty*/
		insertEmptyTests(empty, one, multiple);
	
	}
	
	/** 
	 * 
	 * A method that tests the insert, indexOf, and isEmpty methods with the passed
	 * lists. It inserts a passed element at the passed index of the list with the insert method.
	 * It gets the index of a element with the getIndex method. Checks if the lists are empty
	 * Calls the equalsTests method to pass the altered lists to test for matching two lists
	 * 
	 * @throws LinkedListException if there are any errors in insertEmptyTests for testing lists
	 * with the insert method
	 * */
	public static void insertEmptyTests(List empty, List one, List multiple)throws LinkedListException{
		/*inserts passed elements at the passed index of the list*/
		empty.insert(2.4, 0);
		one.insert("eggs", 0);
		multiple.insert("beans", 2);
		/*prints lists with the inserted elements*/
		System.out.println("\nEmpty (on insert):"+empty);
		System.out.println("One (on insert):"+one);
		System.out.println("Multiple(on insert):"+ multiple);
		
		/*prints the index of specified elements in the lists.
		 * if the element does not exist, it prints -1*/
		System.out.println("\nEmpty: Index of goose: "+multiple.indexOf("goose"));
		System.out.println("One: Index of eggs: "+one.indexOf("eggs"));
		System.out.println("Multiple: Index of 2020: "+multiple.indexOf(2020));
		
		/*checks on if the list is empty and prints true if it is empty.
		 * Prints false if it is not empty*/
		System.out.println("\nIs Empty empty? " + empty.isEmpty());
		System.out.println("Is One empty? " + one.isEmpty());
		System.out.println("Is Multiple empty? " + multiple.isEmpty());
		
		/*calls insertTests and passes its lists into the method for further testing.
		 * This will test for check if two lists are equal to each other*/
		equalsTests(empty, one, multiple);
		
	}
	
	/** 
	 * 
	 * A method that tests the equals and size methods with the passed lists
	 * It inserts a passed element at the passed index of the list with the insert method.
	 * It gets the index of a element with the getIndex method. Checks and compares two lists
	 *  for equality.
	 * 
	 * @throws LinkedListException if there are any errors in equalsTests for testing lists
	 * with the append, size, and equals methods
	 * */
	public static void equalsTests(List empty, List one, List multiple)throws LinkedListException{
		/*checks on if two lists match (in size, elements, and instances) and
		 * prints true if they do match. Prints false if they do not match.
		 * Since List one and List multiple do not have the same elements and size
		 * this should print false*/
		System.out.println("\nAre One and Multiple equal? " + one.equals(multiple));
		/* Since List empty and List multiple do not have the same elements and size
		 * this should print false*/
		System.out.println("Are Empty and Multiple equal? " + empty.equals(multiple));
		
		/*a new list to check equality with another list*/
		List two = new List();
		/*adds passed elements at the end of the lists. The passed elements
		 * are the same as the current element as List one*/
		two.append("eggs");
		two.append(600);
		/*print the new list*/
		System.out.println("\nOne: "+ one.toString());
		System.out.println("Two: "+ two.toString());
		/*Since List one and list two have the same elements, size, and instances,
		 * this should print true*/
		System.out.println("Are One and Two equal? " + one.equals(two));
		
		/*prints size or nodes of the lists*/
		System.out.println("\nEmpty size: "+empty.size());
		System.out.println("One size: "+one.size());
		System.out.println("Two size: "+ two.size());
		System.out.println("Multiple size: "+ multiple.size());
		
	}
	
	/**
	 * A method that tests with the List methods that would result in a
	 * LinkedListException. To test any special cases that might be encountered
	 * due to the complexity of the code (like in general)
	 * 
	 * Uncomment this method in the main method first to test out the error
	 * Then uncomment/comment each (//, not /*) line of code to test out each case
	 * 
	 * @throws LinkedListException if there are any errors in exceptionTests for testing lists
	 * with the append, delete(remove),and insert methods (and just with list)
	 * */
	public static void exceptionTests() throws LinkedListException{
		/*initialised for further testing the behaviour of a bad LinkedList*/
		List badList1 = new List();
		List badList2 = new List();
		/*this is for some variety*/
		badList2.append(3.69);
		/*Will throw a LinkedListException if the user tries to delete a node
		 * from an empty list*/
		badList1.delete(1);
		System.out.println("Deleting an empty list:"+badList1);
		/*Will throw a LinkedListException if the user tries to delete a node
		 * at a negative index in a list*/
	//	badList2.delete(-3);
	//	System.out.println("Deleting at a negative index:"+badList2);
		/*Will throw a LinkedListException if the user tries to insert a node
		 * at an index past the list size*/
	//	badList2.insert("tacos", 5);
	//	System.out.println("Inserting past the list size:"+badList2);
		/*Will throw a LinkedListException if the user tries to insert a node
		 * at a negative index in the list*/
	//	badList1.insert("more tacos", -1);
	//	System.out.println("Inserting at a negative index:"+badList1);
		
	 }


}
