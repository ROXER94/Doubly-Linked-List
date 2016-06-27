/** An instance is a doubly linked list. */
public class DoublyLinkedList<E> {
	private ListNode head; // first node of linked list (null if none)
	private ListNode tail; // last node of linked list (null if none)
	private int size; // Number of values in linked list.

	/** Constructor: an empty linked list. */
	public DoublyLinkedList() {
	}

	/** Return the number of values in this list. */
	public int size() {
		return size;
	}

	/**
	 * Return the first node, the head, of the list (null if the list is empty).
	 */
	public ListNode getHead() {
		if (size == 0) {
			return null;
		}
		return head;
	}

	/** Return the last node, the tail, of the list (null if the list is empty). */
	public ListNode getTail() {
		if (size == 0) {
			return null;
		}
		return tail;
	}

	/**
	 * Return the value of node e of this list. Precondition: e must be a node
	 * of this list; it may not be null.
	 */
	public E valueOf(ListNode e) {
		return e.value;
	}

	/** add value e at the beginning of the list. */
	public void prepend(E e) {
		if (size == 0) {
			ListNode v = new ListNode(null, null, e);
			head = v;
			tail = v;
		} else {
			ListNode v = new ListNode(null, head, e);
			head.pred = v;
			head = v;
		}
		size++;
	}

	/** add value e at the end of the list. */
	public void append(E e) {
		if (size == 0) {
			ListNode v = new ListNode(null, null, e);
			head = v;
			tail = v;
		} else {
			ListNode v = new ListNode(tail, null, e);
			tail.succ = v;
			tail = v;
		}
		size++;
	}

	/**
	 * Insert value v in a new node before node e. Precondition: e must be an
	 * node of this list; it may not be null.
	 */
	public void insertBefore(E v, ListNode e) {
		ListNode a = new ListNode(e.predecessor(), e, v);
		if (e.predecessor() != null) {
			e.predecessor().succ = a;
		} else {
			head = a;
			e.pred = a;
		}
		size++;
	}

	/**
	 * Insert value v in a new node after node e. Precondition: e must be an
	 * node of this list; it may not be null.
	 */
	public void insertAfter(E v, ListNode e) {
		ListNode a = new ListNode(e, e.successor(), v);
		if (e.successor() == null) {
			e.succ = a;
			tail = a;
		} else {
			e.successor().pred = a;
			e.succ = a;
		}
		size++;
	}

	/**
	 * Remove node e from this list. Precondition: e must be an node of this
	 * list; it may not be null.
	 */
	public void remove(ListNode e) {
		if ((e == head) && (e == tail)) {
			head = null;
			tail = null;
			size--;
		} else if (e == tail) {
			e.predecessor().succ = null;
			tail = e.pred;
			e.pred = null;
			size--;
		} else if (e == head) {
			e.successor().pred = null;
			head = e.succ;
			e.succ = null;
			size--;
		} else {
			e.predecessor().succ = e.successor();
			e.successor().pred = e.predecessor();
			e.pred = null;
			e.succ = null;
			size--;
		}
	}

	/**
	 * Return a representation of this list: its values, with adjacent ones
	 * separated by ", ", "[" at the beginning, and "]" at the end. <br>
	 *
	 * E.g. for the list containing 6 3 8 in that order, return "[6, 3, 8]".
	 */
	public String toString() {
		String s = "";
		ListNode i = head;
		while (i != null) {
			s = s + i.value.toString() + ", ";
			i = i.succ;
		}
		if (s.length() >= 2) {
			s = s.substring(0, s.length() - 2);
		}
		return "[" + s + "]";
	}

	/**
	 * Return a representation of this list: its values in reverse, with
	 * adjacent ones separated by ", ", "[" at the beginning, and "]" at the
	 * end. <br>
	 *
	 * E.g. for the list containing 6 3 8 in that order, return "[8, 3, 6]".
	 */
	public String toStringReverse() {
		String s = "";
		ListNode i = tail;
		while (i != null) {
			s = s + i.value.toString() + ", ";
			i = i.pred;
		}
		s = s.substring(0, s.length() - 2);
		return "[" + s + "]";
	}

	/*********************/

	/** An instance is a node of this list. */
	public class ListNode {
		/** Predecessor of this node on the list (null if the list is empty). */
		private ListNode pred;

		/** The value of this node. */
		private E value;

		/** Successor of this node on the list. (null if the list is empty). */
		private ListNode succ;

		/**
		 * Constructor: an instance with predecessor p (p can be null),
		 * successor s (s can be null), and value v.
		 */
		private ListNode(ListNode p, ListNode s, E v) {
			pred = p;
			succ = s;
			value = v;
		}

		/** Return the value of this node. */
		public E getValue() {
			return value;
		}

		/**
		 * Return the predecessor of this node in the list (null if this node is
		 * the first node of this list).
		 */
		public ListNode predecessor() {
			return pred;
		}

		/**
		 * Return the successor of this node in the list (null if this node is
		 * the last node of this list).
		 */
		public ListNode successor() {
			return succ;
		}
	}
}
