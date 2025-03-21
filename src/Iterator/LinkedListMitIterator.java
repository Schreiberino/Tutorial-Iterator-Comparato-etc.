package Iterator;

import CustomLinkedList.ILinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListMitIterator<T> implements ILinkedList<T>,Iterable<T> {

    public ListElement<T> Front =null;
    public ListElement<T> Back=null;

    @Override
    public Iterator<T> iterator() {
        return new CustomIteratorLinkedList();
    }




    @Override
    public void removeValue(T _valueRemove) throws NoSuchElementException {

       //Fall: Liste hat keinen Wert
        if(Front==null){
            throw new NoSuchElementException("Die Liste enthält keine Werte!");


        }

        // Fall: Liste hat genau einen Wert
      if(Front == Back){
          Front = null;
          Back = null;
          return;
      }

      // Liste hat mehr als 1 Wert
        ListElement<T> _durchzähler = Front;

      //Der Wert der entfernt werden soll ist am Anfang der Liste
        if(_durchzähler.Value == _valueRemove){
            Front = Front.Next;
            return;
        }



      // Durch diesen loop wird der erste Wert geskippt, deswegen muss dieser vorher gecheckt werden. Er checkt aber alle anderen Werte.
       while(_durchzähler.getNext()!=null){

           ListElement Links = _durchzähler;
           ListElement Mitte = _durchzähler.getNext();
           ListElement Rechts = _durchzähler.getNext().getNext();




           // Element wurde gefunden und ist in der Liste
           if(Mitte.getValue()== _valueRemove){
               //Fall: Der value der entfernt werden muss ist das Ende der Liste
               if(_durchzähler.getNext().getNext()==null){
                   Links.Next = null;
               }
               //Fall: der Wert ist irgendwo in der Liste
               else {
                   Links.Next=Rechts;

               }

               return;
           }

           _durchzähler = _durchzähler.Next;


       }

       // wenn wir soweit gekommen sind ohne ein element erreicht zu haben, sind alle Wert miteinander verglichen worde. Die liste hat diesen Wert also nicht.
       throw new NoSuchElementException("Die Liste hat keine Element mit dem Wert " + _valueRemove);



    }

    @Override
    public void addValue(T _value) {
        // Fall: Die Liste ist leer
        if(Front ==null){
            Front = new ListElement<T>(_value,null);
            Back = Front;
            return;
        }


       //Fall: Die Liste hat mindestens 1 Wert
        Back.Next = new ListElement<>(_value,null);
        Back = Back.Next;
        return;

    }

    @Override
    public boolean contains (T _value) {

        if(Front == null){
            return false;
        }

        ListElement<T> _durchzähler = Front;
        while(_durchzähler!=null){

            if(_durchzähler.Value == _value){
                return true;
            }
            _durchzähler = _durchzähler.Next;
        }
        return false;


    }


    @Override
    public int size() {

        int _size = 0;
        if(Front == null){
            return _size;
        }

        ListElement<T> _durchzähler = Front;
        while(_durchzähler!=null){
            _size++;
            _durchzähler = _durchzähler.getNext();
        }
        return _size;

    }


    private class CustomIteratorLinkedList implements Iterator<T>{

        ListElement Durchzähler;

        public CustomIteratorLinkedList() {
            Durchzähler = Front;
        }


        @Override
        public boolean hasNext() {
            return Durchzähler != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Keine weiteren Elemente in der Liste vorhanden!");
            }

            T Returnvalue = (T) Durchzähler.Value;
            Durchzähler = Durchzähler.Next;
            return Returnvalue ;
        }


    }

}
