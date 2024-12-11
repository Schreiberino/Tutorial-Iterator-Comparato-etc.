package Iterator;

public class ListElement<T> {

    public T Value;

    public ListElement Next;

    public ListElement(T _value, ListElement _element){
        Value = _value;
        Next = _element;

    }

    public T getValue(){
        return Value;
    }

    public ListElement getNext(){
        return Next;
    }


}
