package CustomSortingMethod;

public class MausComparable implements Comparable<MausComparable> {

    int Alter;
    String Name;

    public MausComparable(String _name, int _alter){
        Alter = _alter;
        Name = _name;


    }


    @Override
    public int compareTo(MausComparable o) {
        if(o.Alter< Alter){
            return -1;
        }


        return +1;
    }
}
