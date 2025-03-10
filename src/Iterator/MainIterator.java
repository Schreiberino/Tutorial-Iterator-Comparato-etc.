package Iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainIterator {

    public static void main(String[] args) {
        LinkedListMitIterator<String> list = new LinkedListMitIterator<String>();
        list.addValue("A");
        list.addValue("B");
        list.addValue("C");

        for(String Listelement : list) {
            System.out.println(Listelement);
        }

//        Iterator<String> iterator = list.iterator();
//
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }
}
