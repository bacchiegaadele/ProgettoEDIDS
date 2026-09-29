package myAdapter;

import java.util.Vector;
import java.util.NoSuchElementException;

/**
 * Classe ListIterator implementa l'interfaccia HListIterator, derivata da HIterator.<br/>
 * Consente di accedere e di modificare la lista in modo bidirezionale, attraverso un cursore.<br/>
 * La classe è compatibile con CLDC 1.1 e la sua implementazione soddisfa le specifiche di J2SE 1.4.2.<br/>
 */
public class ListIterator implements HListIterator{
   //Variabili
   private int cursor;
   //Variabile last memorizza indice dell'ultimo elemento restituito e serve a sapere quale elemento può essere rimosso o modificato
   private int last = -1;
   private ListAdapter list;
   
   /**
     * Costruttore inizializza l'iteratore alla posizione specificata e la lista specificata da iterare.
     *
     * @param list la lista da iterare
     * @param index la posizione iniziale del cursore
     * @throws IndexOutOfBoundsException se l'indice è fuori dai limiti della lista
     */
   public ListIterator(ListAdapter list, int index){
      if (index < 0 || index > list.size())
         throw new IndexOutOfBoundsException();
      if (list == null)
         throw new NullPointerException();
      this.list = list;
      this.cursor = index;
   }
   
   
   //Metodi di HIterator
   
   /**
     * Metodo next restituisce l'elemento successivo nella lista.
     *
     * @return l'elemento successivo
     * @throws NoSuchElementException se non c'è un elemento successivo nella lista
     */
   public Object next(){
      if (!hasNext())
         throw new NoSuchElementException();
      last = cursor;
      return list.get(cursor++); 
   }
   
   /**
     * Metodo hasNext verifica se esiste almeno un elemento successivo nella lista.
     *
     * @return true se esiste un elemento successivo, false altrimenti
     */
   public boolean hasNext(){
      return list.size() > cursor;
   }
   
   /**
     * Metodo remove rimuove l'elemento della lista che è stato restituito per ultimo individuato attraverso la variabile last.
     *
     * @throws IllegalStateException se last vale -1, ovvero non è stato restituito nulla
     */
   public void remove(){
      if (last == -1)
         throw new IllegalStateException();
      list.remove(last);
      if (cursor > last)
         cursor--;
      last = -1;
   }
   
   
   //Metodi di HListIterator
   
   /**
    * Metodo nextIndex restituisce l'indice dell'elemento che dovrebbe essere ritornato invocando il metodo next che corrisponde al valore del cursore.
    *
    * @return cursor
    */
   public int nextIndex(){
      return cursor;
   }
   
   /**
    * Metodo previousIndex restituisce l'indice dell'elemento che dovrebbe essere ritornato invocando il metodo previous che corrisponde al valore del precedente di quello del cursore.
    *
    * @return prev il cursore decrementato di 1
    */
   public int previousIndex(){
      int prev = cursor - 1;
      return prev;
   }
   
   /**
     * Metodo previous restituisce l'elemento precedente nella lista.
     *
     * @return l'elemento precedente
     * @throws NoSuchElementException se non c'è un elemento precedente nella lista
     */
   public Object previous(){
      if (!hasPrevious())
         throw new NoSuchElementException();
      last = cursor--;
      return list.get(cursor);
   }
   
   /**
     * Metodo hasPrevious verifica se esiste almeno un elemento precedente nella lista.
     *
     * @return true se esiste un elemento precedente, false altrimenti
     */
   public boolean hasPrevious(){
      return cursor > 0;
   }
   
   /**
    * Metodo add inserisce l'elemento specificato nella lista prima dell'elemento che sarebbe restituito da next e dopo quello che sarebbe restituito da previous.
    *
    * @param o l'elemento da inserire
    * @throws NullPointerException se l'elemento da inserire è vuoto
    */
   public void add(Object o){
      if (o == null)
         throw new NullPointerException();
      list.add(cursor++, o);
      last = -1;
   }
   
   /**
    * Metodo set sostituisce l'elemento ritornato con next o previous con l'elemento specificato.
    *
    * @param o l'elemento con cui sostituire
    * @throws NullPointerException se l'elemento da inserire è vuoto
    * @throws IllegalStateException se last vale -1, ovvero non è stato restituito nulla
    */
   public void set(Object o){
      if (last == -1)
         throw new IllegalStateException();
      if (o == null)
         throw new NullPointerException();
      list.set(last, o);
   }
}
