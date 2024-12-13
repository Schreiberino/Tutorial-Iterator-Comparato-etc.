package ComparableComparator;

import Iterator.LinkedListMitIterator;

import java.util.Comparator;
import java.util.Iterator;

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

        Comparator<Maus> Customcomparator = (Maus1, Maus2) -> {
           if( Maus1.Alter < Maus2.Alter )
           {
               return -1;
           }
           return 1;
        };


        MäuseSortiertmitMethode = SortingMethod.BubbleSortCustomLinkedListComparator(MäuseSortiertmitMethode, Customcomparator);

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
