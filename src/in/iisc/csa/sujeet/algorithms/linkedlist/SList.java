package in.iisc.csa.sujeet.algorithms.linkedlist;

public class SList {
	Node head;

	static class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public SList() {
		super();
		head = null;
	}

	public Node getHead() {
		return head;
	}

	public void insertAtFront(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void insertAtBack(int value) {

		if (head == null) {
			head = new Node(value);
		} else {
			Node tmp = head;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = new Node(value);
		}
	}

	public void reverse() {
		Node prev, curr, next;
		if (head == null)
			return;
		prev = null;
		curr = head;
		next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	private void printReverseUtil(Node node) {
		if (node == null)
			return;
		printReverseUtil(node.next);
		System.out.println(node.value);
	}

	public void printReverse() {
		printReverseUtil(head);
	}

	public void print() {
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp.value);
			tmp = tmp.next;
		}

	}

	public static void main(String[] args) {
		SList list = new SList();
		list.insertAtBack(10);
		list.insertAtBack(20);
		list.insertAtBack(30);
		list.insertAtFront(0);
		list.insertAtFront(90);
		// list.printList();
		// list.reverse();
		// list.print();
		list.printReverse();
	}
}
