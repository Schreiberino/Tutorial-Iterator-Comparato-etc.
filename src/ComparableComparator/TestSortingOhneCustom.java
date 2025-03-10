package ComparableComparator;

import java.util.*;

public class TestSortingOhneCustom {


    public static void main(String[] args) {

        List<String> Obst = new ArrayList<>();
        Obst.add("Banane");
        Obst.add("Apfel");
        Obst.add("Mandarine");

        for (String a :Obst){
            System.out.println(a);
        }
        System.out.println("****************");
        Collections.sort(Obst);

        for (String a :Obst){
            System.out.println(a);
        }
        System.out.println("****************");


        Map<String, Integer> Maxi = new HashMap<>();

        List<MausComparable> MausComparableList = new ArrayList<MausComparable>();

        List<Maus> MausOhneComparableList =new ArrayList<Maus>();

        for (int i = 1; i <= 10; i++) {
            String name = "Maus" + i;
            int alter = (int) (Math.random() * 10 + 1); // Alter zwischen 1 und 10
            MausComparableList.add(new MausComparable(name, alter));
            MausOhneComparableList.add(new Maus(name, alter));
        }

        //Unsortierte Ausgabe
        for(int i = 0;i < MausComparableList.size();i++){

            System.out.println("Ohne Comparable Wert "  + ": " +  MausOhneComparableList.get(i).Alter );
            System.out.println("Mit Comparable Wert " +": " +  MausComparableList.get(i).Alter );
            System.out.println("------------------------");
        }

        System.out.println("Ende Der Ausgabe unsortiert!");
        System.out.println("******************");



        Collections.sort(MausComparableList);

        //Collections.sort(MausOhneComparable);



        for(int i = 0;i < MausComparableList.size();i++){

            System.out.println("Ohne Comparable Wert " + ": "  +  MausOhneComparableList.get(i).Alter );
            System.out.println("Mit Comparable Wert " + ": " +  MausComparableList.get(i).Alter );
            System.out.println("------------------------");
        }

        System.out.println("Ende Der Ausgabe sortiert mit comparable!");
        System.out.println("******************");


        Comparator<Maus> Customcomparator = (Maus1, Maus2) -> {
            if( Maus1.Alter > Maus2.Alter )
            {
                return 1;
            }
            return -1;
        };

        MausOhneComparableList.sort(Customcomparator);

        for(int i = 0;i < MausComparableList.size();i++){

            System.out.println("Ohne Comparable Wert " +": " +  MausOhneComparableList.get(i).Alter );
            System.out.println("Mit Comparable Wert " + " " + MausComparableList.get(i).Alter );
            System.out.println("------------------------");
        }

        System.out.println("Ende Der Ausgabe sortiert mit comparable und comparator!");
        System.out.println("******************");



    }
}
