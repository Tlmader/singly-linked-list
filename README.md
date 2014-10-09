singlylinkedlist
================

This is an implementation of a generic linked list that is only singly linked. That is, each node only knows about the next node. Name it SinglyLinkedList. This list has a head and a tail node and does not keep track of its size. It implements the Iterable<T> interface, and it has an inner class that implements the Iterator<T> interface called SinglyLinkedListIterator. There is also an inner
class, Node, that defines the node objects.

This includes a method to find the Nth to last item in the singly-linked list. The list does not know nor provide a method to return its size.

####Class SinglyLinkedList

The linked list provides the following methods:

- public void add(T data)
- public void remove(Node<T> previous)
- public void clear()
- public T getNthToLast(int n)
- public SinglyLinkedListIterator iterator()

The method add() adds a new element to the end of the list. The method remove() removes the node that follows previous from the linked list. If a call to remove() attempts to remove the tail, remove() throws an IllegalStateException.

####Class SinglyLinkedListIterator

The iterator implements the following four methods:

- public boolean hasNext()
- public T next()
- public void remove()
- public void add(T element)

The iterator’s remove() removes the last element that was returned by next(). The iterator’s method add() adds the new element to the list before the next element returned by next(). If next() is called and there is no next element, next() throws a NoSuchElementException.

A JUnit test is included to test the program.
