package Iterator;


import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class TestsIterator {

    @Test
    void testIteratorOnEmptyList() {
        LinkedListMitIterator<String> list = new LinkedListMitIterator<String>();
        Iterator<String> iterator = list.iterator();

        // Test: hasNext should return false on an empty list
        assertFalse(iterator.hasNext(), "hasNext() sollte false bei einer leeren Liste zurückgeben.");

        // Test: next should throw NoSuchElementException on an empty list
        assertThrows(NoSuchElementException.class, iterator::next, "next() sollte eine NoSuchElementException werfen, wenn die Liste leer ist.");
    }

    @Test
    void testIteratorOnSingleElementList() {
        LinkedListMitIterator<String> list = new LinkedListMitIterator<String>();
        list.addValue("A");

        Iterator<String> iterator = list.iterator();

        // Test: hasNext should return true initially
        assertTrue(iterator.hasNext(), "hasNext() sollte true zurückgeben, wenn die Liste ein Element enthält.");

        // Test: next should return the single element
        assertEquals("A", iterator.next(), "next() sollte das einzige Element in der Liste zurückgeben.");

        // Test: hasNext should return false after retrieving the only element
        assertFalse(iterator.hasNext(), "hasNext() sollte false zurückgeben, nachdem das einzige Element iteriert wurde.");

        // Test: next should throw NoSuchElementException after all elements are iterated
        assertThrows(NoSuchElementException.class, iterator::next, "next() sollte eine NoSuchElementException werfen, wenn keine weiteren Elemente vorhanden sind.");
    }

    @Test
    void testIteratorOnMultipleElementsList() {
        LinkedListMitIterator<String> list = new LinkedListMitIterator<String>();
        list.addValue("A");
        list.addValue("B");
        list.addValue("C");

        Iterator<String> iterator = list.iterator();

        // Test: Iteration through the list
        assertTrue(iterator.hasNext(), "hasNext() sollte true zurückgeben, wenn Elemente vorhanden sind.");
        assertEquals("A", iterator.next(), "next() sollte das erste Element zurückgeben.");
        assertTrue(iterator.hasNext(), "hasNext() sollte true zurückgeben, bevor das zweite Element iteriert wird.");
        assertEquals("B", iterator.next(), "next() sollte das zweite Element zurückgeben.");
        assertTrue(iterator.hasNext(), "hasNext() sollte true zurückgeben, bevor das dritte Element iteriert wird.");
        assertEquals("C", iterator.next(), "next() sollte das dritte Element zurückgeben.");
        assertFalse(iterator.hasNext(), "hasNext() sollte false zurückgeben, nachdem alle Elemente iteriert wurden.");

        // Test: next should throw NoSuchElementException after all elements are iterated
        assertThrows(NoSuchElementException.class, iterator::next, "next() sollte eine NoSuchElementException werfen, wenn keine weiteren Elemente vorhanden sind.");
    }
}
