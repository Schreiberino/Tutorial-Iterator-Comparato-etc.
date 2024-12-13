package Streams;
import ComparableComparator.*;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Streams {

    public static void main(String[] args) {
        List<Maus> Mäuse2 = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            String name = "Maus" + i;
            int alter = (int) (Math.random() * 10 + 1); // Alter zwischen 1 und 10
            Mäuse2.add(new Maus(name, alter));


        }
        // bis hier hin habe ich eine Liste  an Maus Objekten

        //Ziel: Ich möchte eine Liste mit dem Alter der Mäuse

        List<Integer> AlterDerMäuse = new ArrayList<>();

        for(Maus maus : Mäuse2){

            AlterDerMäuse.add(maus.Alter);

        }

        // Oder ein Stream mit der Map funktion

        class MapFunktionOhneLambda implements Function<Maus, Integer> {


            @Override
            public Integer apply(Maus maus) {
                return maus.Alter;
            }
        }

        List<Integer> AlterDerMäuseStream = Mäuse2.stream().map((Maus) -> Maus.Alter )
                .toList();

        for(int i = 0;i< AlterDerMäuseStream.size();i++){
            System.out.println("Nicht Stream: " + AlterDerMäuse.get(i));
            System.out.println("Stream: " + AlterDerMäuseStream.get(i));
            System.out.println("---------------------------");
            System.out.println("---------------------------");
            System.out.println("---------------------------");


        }
    }
    }



