package Homework02;

/**
 * Created by Ellie Barry 
 */

import java.util.Iterator;

public class GenLinkedList<T> { // Generic linked list of type T

	private class ListNode {// Internal classes

		// Instance variables
		private ListNode link;
		private T data;

		// Constructor
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	// Instance variables
	private ListNode head; // Points to first element
	private ListNode curr; // Current node of interest used externally
	private ListNode prev; // One node behind current

	// Default constructor
	public GenLinkedList() {
		head = curr = prev = null;
	}

	// Inserts data at the end of the linked list
	public void insert(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if (head == null) {
			head = curr = newNode;
			return;
		}
		ListNode temp = head;
		// Equivalent of the for loop for an array
		while (temp.link != null) {
			temp = temp.link;
		}
		temp.link = newNode;
	}

	// Inserts data after current
	public void insertAfterCurrent(T aData) {
		// Can't insert if there is nothing at current
		if (curr == null) {
			return;
		}
		ListNode newNode = new ListNode(aData, curr.link);
		if (curr != null && prev == null) { // at the head
			head.link = newNode; // curr.link = newNode;
		} else if (curr != null && prev != null) { // If it's in the middle
			curr.link = newNode;
		}

	}

	// Prints out the linked list
	public void print() {
		for (ListNode temp = head; temp != null; temp = temp.link) {
			System.out.println(temp.data);
		}
	}

	// Gets current ListNode
	public T getCurrent() {
		if (curr == null)
			return null;
		return curr.data;
	}

	// Sets current ListNode
	public void setCurrent(T aData) {
		if (curr == null) {
			return;
		}
		curr.data = aData;
	}

	// Moves the pointer for current forward a ListNode
	public void goToNext() {
		if (curr == null)
			return;
		prev = curr;
		curr = curr.link;
	}
	
	// Resets the current 
		public void reset()
		{
			curr = head;
			prev = null;
		}
		

	// Resets current to the head
	public void resetCurrent() {
		if(head != null)
			curr = head;
	}

	// Checks to see if current is null
	public boolean moreToIterate() {
		return curr != null;
	}

	// Deletes the current ListNode
	public void deleteCurrent() {
		if (curr == null)
			return;
		if (curr == head) {
			head = head.link; // curr = curr.link
			return;
		}
		prev.link = curr.link; // Points over top of current
		curr = curr.link;

	}

	// Deletes the ListNode that contains the data entered by the user
	public void delete(T aData) {
		ListNode temp = head;
		while (temp != null) {
			if (temp.link.data.equals(aData)) {
				temp.link = temp.link.link;
				break;
			}
			temp = temp.link;
		}
	}

	// Checks to see if the Linked List has another ListNode after current
	public boolean hasNext() {
		return curr != null;
	}

	// Returns boolean about if date entered is already in the list
	public boolean contains(T aData) {
		ListNode temp = head;
		while (temp != null) {
			if (temp.data.equals(aData)) {
				return true;
			}
			temp = temp.link;
		}
		return false;
	}

}
