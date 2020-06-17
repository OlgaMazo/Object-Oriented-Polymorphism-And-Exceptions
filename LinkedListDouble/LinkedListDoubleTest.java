import static org.junit.jupiter.api.Assertions.*;

import java.util.ListIterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListDoubleTest {

	@Test
	void test_LinkedListDouble_constructor() {
		LinkedListDouble list = new LinkedListDouble();
		assertEquals(list.toString(), "The list is empty");
	}
	
	@Test
	void test_LinkedListDouble_add_string_type() {
		
		LinkedListDouble<String> list = new LinkedListDouble<String>();
		ListIterator<String> iterator = list.listIterator();
		
		list.add("a");
		list.add("bb ccc");
		assertEquals(iterator.next().toString(), "a");
		assertEquals(iterator.next().toString(), "bb ccc");
		
		list.add("dddd");
		assertEquals(iterator.next().toString(), "dddd");
	}
	
	@Test
	void test_LinkedListDouble_add_integer_type() {
		
		LinkedListDouble<Integer> list = new LinkedListDouble<Integer>();
		ListIterator<Integer> iterator = list.listIterator();
		
		list.add(0);
		list.add(-1);
		assertEquals(iterator.next().toString(), "0");
		assertEquals(iterator.next().toString(), "-1");
		
		list.add(22);
		assertEquals(iterator.next().toString(), "22");
	}
	
	@Test
	void test_LinkedListDouble_add_double_type() {
		
		LinkedListDouble<Double> list = new LinkedListDouble<Double>();
		ListIterator<Double> iterator = list.listIterator();
		
		list.add(0.0);
		list.add(-1.123);
		assertEquals(iterator.next().toString(), "0.0");
		assertEquals(iterator.next().toString(), "-1.123");
		
		list.add(22.5);
		assertEquals(iterator.next().toString(), "22.5");
	}
	
	@Test
	void test_LinkedListDouble_add_character_type() {
		
		LinkedListDouble<Character> list = new LinkedListDouble<Character>();
		ListIterator<Character> iterator = list.listIterator();
		
		list.add('a');
		list.add('b');
		assertEquals(iterator.next().toString(), "a");
		assertEquals(iterator.next().toString(), "b");
		
		list.add('c');
		assertEquals(iterator.next().toString(), "c");
	}
	
	@Test
	void test_LinkedListDouble_add_boolean_type() {
		
		LinkedListDouble<Boolean> list = new LinkedListDouble<Boolean>();
		ListIterator<Boolean> iterator = list.listIterator();
		
		list.add(true);
		list.add(false);
		assertEquals(iterator.next().toString(), "true");
		assertEquals(iterator.next().toString(), "false");
		
		list.add(true);
		assertEquals(iterator.next().toString(), "true");
	}
	
	@Test
	void test_LinkedListDouble_toString_string_type() {
		
		LinkedListDouble<String> list = new LinkedListDouble<String>();
		
		list.add("a");
		assertEquals(list.toString(), "The list is:\nThe data is: a\n");
		
		list.add("bb ccc");
		assertEquals(list.toString(), "The list is:\nThe data is: a\nThe data is: bb ccc\n");
		
		list.add("dddd");
		assertEquals(list.toString(), "The list is:\nThe data is: a\nThe data is: bb ccc\nThe data is: dddd\n");
	}
	
	@Test
	void test_LinkedListDouble_toString_integer_type() {
		
		LinkedListDouble<Integer> list = new LinkedListDouble<Integer>();
		
		list.add(0);
		assertEquals(list.toString(), "The list is:\nThe data is: 0\n");
		
		list.add(-1);
		assertEquals(list.toString(), "The list is:\nThe data is: 0\nThe data is: -1\n");
		
		list.add(22);
		assertEquals(list.toString(), "The list is:\nThe data is: 0\nThe data is: -1\nThe data is: 22\n");
	}
	
	@Test
	void test_LinkedListDouble_toString_double_type() {
		
		LinkedListDouble<Double> list = new LinkedListDouble<Double>();
		
		list.add(0.0);
		assertEquals(list.toString(), "The list is:\nThe data is: 0.0\n");
		
		list.add(-1.123);
		assertEquals(list.toString(), "The list is:\nThe data is: 0.0\nThe data is: -1.123\n");
		
		list.add(22.5);
		assertEquals(list.toString(), "The list is:\nThe data is: 0.0\nThe data is: -1.123\nThe data is: 22.5\n");
	}
	
	@Test
	void test_LinkedListDouble_toString_character_type() {
		
		LinkedListDouble<Character> list = new LinkedListDouble<Character>();
		
		list.add('a');
		assertEquals(list.toString(), "The list is:\nThe data is: a\n");
		
		list.add('b');
		assertEquals(list.toString(), "The list is:\nThe data is: a\nThe data is: b\n");
		
		list.add('c');
		assertEquals(list.toString(), "The list is:\nThe data is: a\nThe data is: b\nThe data is: c\n");
	}
	
	@Test
	void test_LinkedListDouble_toString_boolean_type() {
		
		LinkedListDouble<Boolean> list = new LinkedListDouble<Boolean>();
		
		list.add(true);
		assertEquals(list.toString(), "The list is:\nThe data is: true\n");
		
		list.add(false);
		assertEquals(list.toString(), "The list is:\nThe data is: true\nThe data is: false\n");
		
		list.add(true);
		assertEquals(list.toString(), "The list is:\nThe data is: true\nThe data is: false\nThe data is: true\n");
	}
	
	@Test
	void test_LinkedListDouble_listIterator_hasNext_string_type() {
		
		LinkedListDouble<String> list = new LinkedListDouble<String>();
		ListIterator<String> listIterator = list.listIterator();
		
		assertFalse(listIterator.hasNext());
		
		list.add("a");
		assertTrue(listIterator.hasNext());
		listIterator.next();
		assertFalse(listIterator.hasNext());
		
		list.add("bb ccc");
		list.add("dddd");
		assertTrue(listIterator.hasNext());
		listIterator.next();
		assertTrue(listIterator.hasNext());
		listIterator.next();
		assertFalse(listIterator.hasNext());
	}
	
	@Test
	void test_LinkedListDouble_listIterator_next_integer_type() {
		
		LinkedListDouble<Integer> list = new LinkedListDouble<Integer>();
		ListIterator<Integer> listIterator = list.listIterator();
		
		list.add(0);
		assertEquals(listIterator.next().toString(), "0");
		
		list.add(-1);
		list.add(2);
		assertEquals(listIterator.next().toString(), "-1");
		
		list.add(-2);
		list.add(3);
		assertEquals(listIterator.next().toString(), "2");
		assertEquals(listIterator.next().toString(), "-2");
		assertEquals(listIterator.next().toString(), "3");
	}
	
	@Test
	void test_LinkedListDouble_listIterator_hasPrevious_string_type() {
		
		LinkedListDouble<String> list = new LinkedListDouble<String>();
		ListIterator<String> listIterator = list.listIterator();
		
		assertFalse(listIterator.hasPrevious());
		
		list.add("a");
		assertFalse(listIterator.hasPrevious());
		listIterator.next();
		assertFalse(listIterator.hasPrevious());
		
		list.add("bb ccc");
		listIterator.next();
		assertTrue(listIterator.hasPrevious());
		
		list.add("dddd");
		list.add("hh hh h");
		listIterator.next();
		assertTrue(listIterator.hasPrevious());
		listIterator.next();
		assertTrue(listIterator.hasPrevious());
	}
	
	@Test
	void test_LinkedListDouble_listIterator_previous_integer_type() {
		
		LinkedListDouble<Integer> list = new LinkedListDouble<Integer>();
		ListIterator<Integer> listIterator = list.listIterator();
		
		list.add(0);
		list.add(-1);
		listIterator.next();
		listIterator.next();
		assertEquals(listIterator.previous().toString(), "0");
		
		list.add(2);
		list.add(-2);
		list.add(3);
		listIterator.next();
		listIterator.next();
		listIterator.next();
		listIterator.next();
		assertEquals(listIterator.previous().toString(), "-2");
		assertEquals(listIterator.previous().toString(), "2");
		assertEquals(listIterator.previous().toString(), "-1");
	}
}
