package Iterator;

import java.util.Iterator;

public class MainStringIterator {

    public static void main(String[] args) {

        LinkedListMitIteratorString<String> list = new LinkedListMitIteratorString();
        list.addValue("Haus");
        list.addValue("Banane");
        list.addValue("Apfel");

//        Iterator<String> iterator = list.iterator();
//
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        for(String a: list){
            System.out.println(a);
        }
    }}

//        for(String a: list){
//
//            System.out.println(a);
//        }
//    }

