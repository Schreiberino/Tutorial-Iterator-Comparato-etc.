package CustomLinkedList;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class LinkedListTest {

    @Test
    void testAddValue() {
        CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
        list.addValue(10);
        list.addValue(20);
        list.addValue(30);

        // Überprüfen, ob die Werte in der Liste enthalten sind
        assertTrue(list.contains(10), "Die Liste sollte 10 enthalten.");
        assertTrue(list.contains(20), "Die Liste sollte 20 enthalten.");
        assertTrue(list.contains(30), "Die Liste sollte 30 enthalten.");
        assertEquals(3, list.size(), "Die Größe der Liste sollte 3 sein.");
    }

    @Test
    void testRemoveValue() {
        CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
        list.addValue(10);
        list.addValue(20);
        list.addValue(30);

        // Werte entfernen und überprüfen
        list.removeValue(20);
        assertFalse(list.contains(20), "Die Liste sollte 20 nicht mehr enthalten.");
        assertTrue(list.contains(10), "Die Liste sollte 10 enthalten.");
        assertTrue(list.contains(30), "Die Liste sollte 30 enthalten.");
        assertEquals(2, list.size(), "Die Größe der Liste sollte 2 sein.");

        list.removeValue(10);
        assertFalse(list.contains(10), "Die Liste sollte 10 nicht mehr enthalten.");
        assertTrue(list.contains(30), "Die Liste sollte 30 enthalten.");
        assertEquals(1, list.size(), "Die Größe der Liste sollte 1 sein.");

        list.removeValue(30);
        assertFalse(list.contains(30), "Die Liste sollte 30 nicht mehr enthalten.");
        assertEquals(0, list.size(), "Die Größe der Liste sollte 0 sein.");
    }

    @Test
    void testRemoveNonExistingValueThrowsException() {
        CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
        list.addValue(10);
        list.addValue(20);

        assertThrows(NoSuchElementException.class, () -> list.removeValue(30),
                "Es sollte eine NoSuchElementException ausgelöst werden, wenn ein nicht vorhandener Wert entfernt wird.");
    }


    @Test
    void testContainsAfterOperations() {
        CustomLinkedList<String> list = new CustomLinkedList<String>();
        list.addValue("A");
        list.addValue("B");
        list.addValue("C");

        assertTrue(list.contains("A"), "Die Liste sollte A enthalten.");
        assertTrue(list.contains("B"), "Die Liste sollte B enthalten.");
        assertTrue(list.contains("C"), "Die Liste sollte C enthalten.");

        list.removeValue("B");
        assertFalse(list.contains("B"), "Die Liste sollte B nicht mehr enthalten.");
        assertTrue(list.contains("A"), "Die Liste sollte A enthalten.");
        assertTrue(list.contains("C"), "Die Liste sollte C enthalten.");
    }

    @Test
    void testSizeOnEmptyList() {
        CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
        assertEquals(0, list.size(), "Die Größe einer leeren Liste sollte 0 sein.");
    }

    @Test
    void testSizeAfterOperations() {
        CustomLinkedList<String> list = new CustomLinkedList<String >();
        list.addValue("X");
        list.addValue("Y");
        list.addValue("Z");

        assertEquals(3, list.size(), "Die Größe der Liste sollte 3 sein.");
        assertTrue(list.contains("X"), "Die Liste sollte X enthalten.");
        assertTrue(list.contains("Y"), "Die Liste sollte Y enthalten.");
        assertTrue(list.contains("Z"), "Die Liste sollte Z enthalten.");

        list.removeValue("Y");
        assertEquals(2, list.size(), "Die Größe der Liste sollte nach Entfernen eines Elements 2 sein.");
        assertFalse(list.contains("Y"), "Die Liste sollte Y nicht mehr enthalten.");

        list.removeValue("X");
        list.removeValue("Z");
        assertEquals(0, list.size(), "Die Größe der Liste sollte nach Entfernen aller Elemente 0 sein.");
    }

    @Test
    void testRemoveFromEmptyListThrowsException() {
        CustomLinkedList<Double> list = new CustomLinkedList<Double>();
        assertThrows(NoSuchElementException.class, () -> list.removeValue(10.5),
                "Es sollte eine NoSuchElementException ausgelöst werden, wenn aus einer leeren Liste entfernt wird.");
    }
}
