package mathByteEvaluator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
	private int n;          // stack size
	private Node firstNode;     // stack top

	// helper linked list class -> allows stack to be constructed with pointers to and from stack elements.
	private class Node {
		private T T;
		private Node next;
	}

	//stack initializer
	public Stack() {
		firstNode = null;
		n = 0;
	}

	//Boolean to check whether stack is empty.
	public boolean isEmpty() {
		return firstNode == null;
	}

	//returns number of Ts in stack
	public Integer size() {
		return n;
	}

	//add T to stack
	public void push(T T) {
		Node prevFirst = firstNode;
		firstNode = new Node();
		firstNode.T = T;
		firstNode.next = prevFirst;
		n++;
	}

	//removes and returns T most recently added to stack
	public T pop() {
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		T T = firstNode.T;        // save T to return
		firstNode = firstNode.next;            // delete first node
		n--;
		return T;                   // return the saved T
	}


	//returns most recently added T in stack.
	public T peek() {
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		return firstNode.T;
	}

	/**
	 * appends all values in this stack into a single string
	 * 
	 * @return String containing all values in this stack separated by spaces.
	 */

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (T T : this) {
			s.append(T);
			s.append(' ');
		}
		return s.toString();
	}
	

	/**
	 * Returns an iterator to this stack that iterates through the Ts in LIFO order.
	 *
	 * @return an iterator to this stack that iterates through the Ts in LIFO order
	 */
	public Iterator<T> iterator()  { return new ListIterator();  }

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator implements Iterator<T> {
		private Node current = firstNode;
		public boolean hasNext()  { return current != null;                     }
		public void remove()      { throw new UnsupportedOperationException();  }

		public T next() {
			if (hasNext() != true) throw new NoSuchElementException();
			T T = current.T;
			current = current.next; 
			return T;
		}
	}

}