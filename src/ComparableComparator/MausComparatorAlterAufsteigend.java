package ComparableComparator;

import java.util.Comparator;

public class MausComparatorAlterAufsteigend implements Comparator<Maus> {

    @Override
    public int compare(Maus o1, Maus o2) {

        if(o1.Alter>o2.Alter){
            return 1;

        }
        return -1;

    }
}
