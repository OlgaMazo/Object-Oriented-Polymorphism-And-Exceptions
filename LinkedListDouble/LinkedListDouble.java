import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * This class represents generic bidirectional linked list
 * We can add item to the list and get a string presentation of the list
 * @author Olga and Daniel
 */
public class LinkedListDouble<T> {

	private NodeDouble head;
	private NodeDouble tail;
	private NodeDouble current = null;

	/**
	 * LinkedListDouble
	 * LinkedListDouble constructor
	 */
	public LinkedListDouble() {

		head = tail = null;
	}
	
	/**
	 * add
	 * add item to the end of the list
	 * @param item - the element that we will add
	 */
	public void add(T item) {

		//if head is null - the element that we add is the first one
		if (head == null) {
			head = new NodeDouble(item);
			//if there is one element - the head and the tail are the same
			tail = head;

		//add the element to the end of the list
		} else {
			NodeDouble new_node = new NodeDouble(item);
			new_node.previous = tail;
			tail.next = new_node;
			tail = new_node;
		}
	}

	/**
	 * toString
	 * @return - string presentation of the list
	 */
	public String toString() {
		
		//if head is null there is no list
		if(head == null)
			return "The list is empty";

		//in this variable we save the list elements
		String list_info = "The list is:\n";
		NodeDouble temp = head;

		//go through all the elements of the list
		while (temp != null) {
			list_info = list_info + temp.toString();
			temp = temp.next;
		}

		//return the list presentation
		return list_info;
	}

	/**
	 * listIterator
	 * In this function we have a generic anonymous class 
	 * This class can return the next and the previous organ,
	 * and to return if there are next and previous organ in the list
	 * @return - a listIterator
	 */
	public ListIterator<T> listIterator() {
		
		//the object of listiterator that we will return
		ListIterator<T> iterator = new ListIterator<T>() {

			/**
			 * next
			 * if there is next element in the list the function will return it
			 * @return - the next element in the list 
			 */
			public T next() {

				//if we didn't use the iterator yet - it points to the organ before the start of the list
				//so the next element is the head
				if (current == null && head != null) {
					current = head;
					return (T) current.data;
				}
				//check if there is next element
				if (hasNext()) {

					//put in data the next element
					T data = (T) current.next.data;
					//promotion the current to the next
					current = current.next;
				
					return data;
				//if there is no next element - throw NoSuchElementException exception	
				} else
					throw new NoSuchElementException();
			}

			/**
			 * hasNext
			 * check if there is next element
			 * @return - true if there is next element, otherwise - false
			 */
			public boolean hasNext() {
				
				//if we didn't use the iterator yet and the head isn't null - the next is the head
				if(current == null && head != null) 
					return true;
				
				//if current is not points to the organ before the start of the list, check if it have next 
				else if(current != null)
					return current.next != null;
				
				//there is no next
				return false;
			}

			/**
			 * previous
			 * if there is previous element in the list the function will return it
			 * @return - true if there is previous element, otherwise - false
			 */
			public T previous() {
				
				//check if there is previous element
				if (hasPrevious()) {
					//put in data the previous element
					T data = (T) current.previous.data;
					current = current.previous;
					return data;

				//there is no previous element - throw NoSuchElementException exception	
				} else
					throw new NoSuchElementException();
			}

			/**
			 * hasPrevious
			 * check if there is previous element
			 * @return - true if there is previous element, otherwise - false
			 */
			public boolean hasPrevious() {
				
				//if the current is not points to the organ before the start of the list, check if if have previous
				if (current != null)
					return current.previous != null;

				//there is no previous
				return false;
			}

			@Override
			public int nextIndex() {
				throw new UnsupportedOperationException();
			}

			@Override
			public int previousIndex() {
				throw new UnsupportedOperationException();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

			@Override
			public void set(Object e) {
				throw new UnsupportedOperationException();
			}

			@Override
			public void add(Object e) {
				throw new UnsupportedOperationException();
			}
		};
		return iterator;
	}

	/**
	 * This class represent private inner class of LinkedListDouble<T>
	 * it can return string presentation of one node
	 */
	private class NodeDouble<T> {

		T data;
		NodeDouble next;
		NodeDouble previous;

		/**
		 * NodeDouble
		 * NodeDouble constructor
		 * @param data - create new node with the data
		 */
		public NodeDouble(T data) {

			this.data = data;
			next = previous = null;
		}

		/**
		 * toString
		 * @return - string presentation of one node
		 */
		public String toString() {
			return "The data is: " + data + "\n";
		}
	}
}
