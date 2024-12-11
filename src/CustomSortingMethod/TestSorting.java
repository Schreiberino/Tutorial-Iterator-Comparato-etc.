package CustomSortingMethod;

import Iterator.LinkedListMitIterator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class TestSorting {

    public static void main(String[] args) {


        // Teste Sorting mit Comparator
        LinkedListMitIterator<Maus> MäuseUnsortiert = new LinkedListMitIterator<Maus>();

        LinkedListMitIterator<Maus> MäuseSortiertmitMethode = new LinkedListMitIterator<Maus>();

        LinkedListMitIteratorUndComparable<MausComparable> MäuseSortiertVonGrundAuf = new LinkedListMitIteratorUndComparable<MausComparable>();


        // Ich befülle die Listen mit random Werten, um diese zu Testen
        for (int i = 1; i <= 10; i++) {
            String name = "Maus" + i;
            int alter = (int) (Math.random() * 10 + 1); // Alter zwischen 1 und 10
            MäuseUnsortiert.addValue(new Maus(name, alter));
            MäuseSortiertVonGrundAuf.addValue(new MausComparable(name, alter));
            MäuseSortiertmitMethode.addValue(new Maus(name, alter));

        }
        MäuseSortiertmitMethode = SortingMethod.BubbleSortCustomLinkedListComparator(MäuseSortiertmitMethode, new MausComparatorAlterAufsteigend());

        Iterator<Maus> MäuseUnsortiertIterator = MäuseUnsortiert.iterator();
        Iterator<Maus> MäuseSortiertMitMethodeIterator = MäuseSortiertmitMethode.iterator();
        Iterator<MausComparable> MäuseSortiertVonGrundAufIterator = MäuseSortiertVonGrundAuf.iterator();


        while (MäuseUnsortiertIterator.hasNext()) {

            System.out.println("Unsortiert: " + MäuseUnsortiertIterator.next().Alter);
            System.out.println("Sortiert von GrundAuf: " + MäuseSortiertVonGrundAufIterator.next().Alter);
            System.out.println("Sortiert mit Methode: " + MäuseSortiertMitMethodeIterator.next().Alter);
            System.out.println("---------------------------------");

        }


    }
}
