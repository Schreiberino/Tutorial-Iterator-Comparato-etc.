package ComparableComparator;

import Iterator.LinkedListMitIterator;
import Iterator.ListElement;

import java.util.Comparator;

public class SortingMethod {




    public static <T> LinkedListMitIterator BubbleSortCustomLinkedListComparator(LinkedListMitIterator Liste, Comparator CustomComparator){

        boolean swappedSomething = true;

        while (swappedSomething) {
            swappedSomething = false;
            ListElement Durchzähler = Liste.Front;

            while (Durchzähler.Next!=null){

                ListElement next = Durchzähler.getNext();

                // Vergleich der aktuellen Elemente
                if (CustomComparator.compare(Durchzähler.getValue(), next.getValue()) < 0) {
                    // Tausche die Elemente, wenn das aktuelle Element größer als das nächste ist
                    T tempValue = (T) Durchzähler.getValue();
                    Durchzähler.Value = next.getValue();
                    next.Value = tempValue;

                    // Setze swappedSomething auf true, um den äußeren Loop fortzusetzen
                    swappedSomething = true;
                }
                Durchzähler = Durchzähler.getNext();

            }


        }

        return Liste;


    }
}
