import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleLinkedListTester {

	@Test
	public void testConstructor1() {
		DoublyLinkedList<Integer> MyList = new DoublyLinkedList<Integer>();

		// checks prepend on empty list MyList
		assertEquals(0, MyList.size());
		MyList.prepend(6);
		assertEquals(1, MyList.size());
		assertEquals("[6]", MyList.toString());

		// checks prepend on nonempty MyList
		MyList.prepend(3);
		assertEquals(2, MyList.size());
		assertEquals("[3, 6]", MyList.toString());

		// checks append on empty MySecondList
		DoublyLinkedList<Integer> MySecondList = new DoublyLinkedList<Integer>();
		MySecondList.append(10);
		assertEquals(1, MySecondList.size());

		// checks append on nonempty MyList
		MyList.append(9);
		assertEquals(3, MyList.size());
		assertEquals("[3, 6, 9]", MyList.toString());

		// checks insertBefore on nonempty MyList
		MyList.insertBefore(1, MyList.getHead().successor());
		assertEquals("[3, 1, 6, 9]", MyList.toString());

		// checks insertBefore on nonempty MyList
		MyList.insertBefore(18, MyList.getHead());
		assertEquals("[18, 3, 1, 6, 9]", MyList.toString());

		// checks insertAfter on nonempty MyList
		MyList.insertAfter(27, MyList.getTail());
		assertEquals("[18, 3, 1, 6, 9, 27]", MyList.toString());

		// checks insertAfter on nonempty MyList
		MyList.insertAfter(12, MyList.getHead());
		assertEquals("[18, 12, 3, 1, 6, 9, 27]", MyList.toString());

		// checks remove on nonempty MyList
		MyList.remove(MyList.getHead().successor().successor().successor());
		assertEquals("[18, 12, 3, 6, 9, 27]", MyList.toString());

		// checks toString on nonempty MyList
		MyList.toString();
		assertEquals("[18, 12, 3, 6, 9, 27]", MyList.toString());

		// checks remove on nonempty MyList
		MyList.remove(MyList.getHead());
		assertEquals("[12, 3, 6, 9, 27]", MyList.toString());

		// checks remove on nonempty MyList
		MyList.remove(MyList.getTail());
		assertEquals("[12, 3, 6, 9]", MyList.toString());

		// checks toStringReverse on nonempty MyList
		MyList.toStringReverse();
		assertEquals("[9, 6, 3, 12]", MyList.toStringReverse());

		// checks remove on single MySecondList
		MySecondList.remove(MySecondList.getTail());
		assertEquals("[]",MySecondList.toString());
	}
}
