/**
 * Implements a singly-linked list.
 * Includes an iterator.
 * @author Ted Mader
 * @date 9/18/2014
 **/
 
import java.lang.Iterable;
import java.util.Iterator;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Iterable<T> {
	private Node<T> head, tail, node, position;

	public SinglyLinkedList() {
	}
	
	public void add(T data) {
		node = new Node<T>(data, null);
		if (head == null) { // If no head exists
			// System.out.println("SLL.add(): head == null");
			head = node;
			tail = head;
		} else {
			// System.out.println("SLL.add(): head != null");
			tail.next = node; // Links tail to new node
			tail = node;
			if (head.next == null) {
				head.next = tail;
			}
		}
		// System.out.println("Head: " + head.data + "Tail: " + tail.data);
	}
	
	public void remove(Node<T> previous) {
		if (previous.next == null) {
			throw new IllegalStateException();
		}
		previous.next = previous.next.next; // Links previous to its next node's next node, thus removing the previous's next node
	}
	
	public void clear() {
		head = null;
		tail = null;
	}
	
	public T getNthToLast(int n) { // I blame Redmann!
		node = head;
		position = tail;
		for (int i = 0; i < n - 1; i++) { // Loop n times to find nth to last
			node = head;
			while (node.next != position) { // Until node.next equals position
				node = node.next;
			}
			position = node; // Set new position
		}
		// System.out.println("SLL.getNthToLast() return: " + node.data);
		return node.data;
	}
	
	public SinglyLinkedListIterator iterator() {
		return new SinglyLinkedListIterator();
	}

	class Node<T> {
		public T data;
		public Node<T> next;
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
		
	class SinglyLinkedListIterator implements Iterator<T> {
		private Node<T> position, previous;

		public SinglyLinkedListIterator() {
			position = new Node<T>(null, head);
		}

		public boolean hasNext() {
			if (position == null) {
				// System.out.println("SSLIterator.hasNext(): position == null");
				return head != null;
			} else {
				return position.next != null;
			}
		}	

		public T next() {
			if (!hasNext()) { // Throws exception if no next data
				// System.out.println("SSLIterator.next(): NoSuchElementExcepton");
				throw new NoSuchElementException();
			}
			previous = position;
			position = position.next;
			// System.out.println("Data returned:" + position.data);
			return position.data;
		}

		public void remove() {
			if (position == null || position.data == null) {
				throw new IllegalStateException();
			} else {
				previous.next = position.next;
			}
			position = previous;
		}

		public void add(T data) {
			Node<T> node = new Node<T>(data, null); // Creates new node
			if (head == null) { // If no head exists
				head = node;
			}
			if (position.next != null) {
				node.next = position.next; // Links new node to position's next node
			} else {
				tail = node;
			}
			position.next = node; // Links the node at position to new node
		}
	}
}