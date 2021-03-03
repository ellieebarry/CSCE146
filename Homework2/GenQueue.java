package Homework03;
/* Created by Ellie Barry */


public class GenQueue <T>{
	// Instance variable
		public ListNode head;
		public ListNode tail;
		
		
		// Internal class for the objects that create a linked list
		private class ListNode{
			private ListNode link;
			private T data;

			// Default constructor
			public ListNode() {
				data =  null;
				link = null;
			}
			
			// Parameterized constructor
			public ListNode(T aData, ListNode aLink) {
				data = aData;
				link = aLink;
			}
		}
		
		
		public void LinkedListQueue() {
			head = tail = null;
		}
		
		// Adds data to the end of the queue
		public void enqueue(T aData) {
			
			ListNode newNode = new ListNode(aData, null);
			if(head == null) {
				head = tail = newNode;
				return;
			}
			tail.link = newNode;
			tail = newNode;
		}
		
		// Removes first element of data
		public T dequeue() {
			if(head == null) {
				return null;
			}
			T ret = head.data;
			head = head.link;
			return ret;
		}
		
		// Returns first object in the queue
		public T peek() {
			if(head == null) {
				return null;
			}
			return head.data;
		}
		
		// Prints out all elements in list
		public void print() {
			ListNode temp = head;
			while(temp != null) {
				System.out.println(temp.data);
				temp = temp.link;
			}
		}
		
}
