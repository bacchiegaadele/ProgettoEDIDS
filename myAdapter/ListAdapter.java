package myAdapter;

import java.util.Vector;

/**
 * Classe ListAdapter implementa l'interfaccia HList, derivata da HCollection.<br/>
 * L'Adapter utilizza Vector come adaptee.<br/>
 * Permette operazioni di accesso, modifica e iterazione su una lista di oggetti.<br/>
 * La classe è compatibile con CLDC 1.1 e la sua implementazione soddisfa le specifiche di J2SE 1.4.2.<br/>
 */
public class ListAdapter implements HList{
   //Variabile vec è un vettore della classe Vector
   private Vector vec;
   
   //Costruttori
   
   /**
     * Costruttore inizializza il vettore vec invocando il costruttore di default di Vector.
     */
   public ListAdapter(){
      this.vec = new Vector();
   }
   
   /**
     * Costruttore inizializza il vettore vec con gli elementi della collezione specificata come parametro, creando un vettore inizialmente vuoto e poi aggiungendo uno ad uno gli elementi della collezione.
     *
     * @param c collezione di oggetti
     * @throws NullPointerException se la collezione specificata è vuota
     */
   public ListAdapter(HCollection c){
      if (c == null)
         throw new NullPointerException();
      this.vec = new Vector();
      HIterator i = c.iterator();
      while (i.hasNext())
         this.vec.addElement(i.next());
   }
   
   /**
     * Costruttore inizializza il vettore vec invocando il costruttore di vector che richiede come parametro un intero che rappresenterà la dimensione del vettore.
     *
     * @param capacity capacità di vec
     * @throws IllegalArgumentException se il valore della capacità è negativo
     */
   public ListAdapter(int capacity){
      if (capacity < 0)
         throw new IllegalArgumentException();
      this.vec = new Vector(capacity);
   }
   
   //Metodi di HCollection
   
   /**
    * Metodo size restituisce il numero di elementi nella collezione, attraverso il metodo size di Vector.
    *
    * @return la dimensione della lista
    */
   public int size(){
      return vec.size();
   }
   
   /**
    * Metodo isEmpty verifica se la lista è vuota, attraverso il metodo isempty di Vector.
    *
    * @return true se la lista è vuota, false altrimenti
    */
   public boolean isEmpty(){
      return vec.isEmpty();
   }
   
   /**
    * Metodo add aggiunge alla lista l'elemento specificato come parametro, attraverso il metodo addElement di Vector.
    *
    * @param o oggetto da inserire
    * @return true se l'elemento viene inserito correttamente
    * @throws NullPointerException se l'elemento è vuoto
    */
   public boolean add(Object o){
      if (o == null)
         throw new NullPointerException();
      vec.addElement(o);
      return true;
   }
   
   /**
    * Metodo addAll aggiunge alla lista tutti gli elementi della collezione specificata come parametro, utilizzando il metodo add tante volte quanti sono gli elementi.
    *
    * @param c collezione di oggetti da inserire
    * @return true se tutti gli elementi vengono inseriti correttamente
    * @throws NullPointerException se la collezione è vuota
    */
   public boolean addAll(HCollection c){
      if (c == null)
         throw new NullPointerException();
      HIterator iter = c.iterator();
      boolean b = false;
      while (iter.hasNext()){
         if(add(iter.next())==true)
            b = true;
      }
      return b;
   }
   
   /**
    * Metodo clear rimuove tutti gli elementi dalla lista attraverso il metodo removeAllElements di Vector.
    */
   public void clear(){
      vec.removeAllElements();
   }
   
   /**
    * Metodo contains verifica se l'elemento specificato come parametro è presente nella lista, attraverso il metodo contains di Vector.
    *
    * @param o oggetto da verificare
    * @return true se l'elemento è presente, false altrimenti
    * @throws NullPointerException se l'oggetto è vuoto
    */
   public boolean contains(Object o){
      if (o == null)
         throw new NullPointerException();
      return vec.contains(o);
   }
   
   /**
    * Metodo containsAll verifica se tutti gli elementi della collezione specificata come parametro sono presenti nella lista, attraverso il metodo contains chiamato tante volte quanti sono gli elementi.
    *
    * @param c collezione di oggetti da verificare
    * @return true se tutti gli elementi sono presenti, false altrimenti
    * @throws NullPointerException se la collezione è vuota
    */
   public boolean containsAll(HCollection c){
      if (c == null)
         throw new NullPointerException();
      HIterator iter = c.iterator();
      while (iter.hasNext()){
         if(contains(iter.next())==false)
            return false;
      }
      return true;
   }
   
   /**
    * Metodo iterator restituisce un iteratore sulla lista a partire dall'inizio.
    *
    * @return iteratore
    */
   public HIterator iterator(){
      return new ListIterator(this, 0);
   }
   
   /**
    * Metodo remove rimuove l'elemento specificato come parametro dalla lista, attraverso il metodo removeElement di Vector.
    *
    * @param o oggetto da rimuovere
    * @return true se l'elemento viene rimosso, false altrimenti
    * @throws NullPointerException se l'oggetto è vuoto
    */
   public boolean remove(Object o){
      if (o == null)
         throw new NullPointerException();
      return vec.removeElement(o);
   }
   
   /**
    * Metodo removeAll rimuove tutti gli elementa della collezione specificata come parametro dalla lista, attraverso il metodo remove chiamato tante volte quanti sono gli elementi della collezione.
    *
    * @param c collezione di oggetti da rimuovere
    * @return true se tutti gli elementi vengono rimossi, false altrimenti
    * @throws NullPointerException se la collezione è vuota
    */
   public boolean removeAll(HCollection c){
      if (c == null)
         throw new NullPointerException();
      HIterator iter = c.iterator();
      boolean b = false;
      while (iter.hasNext()){
         if(remove(iter.next())==true)
            b = true;
      }
      return b;
   }
   
   /**
    * Metodo retainAll mantiene solo gli elementi della lista che sono presenti anche nella collezione specificata, attraverso un ciclo in cui viene controllato se ogni elemento della lista è presente anche nella collezione, se così non fosse viene eliminato dalla lista.
    *
    * @param c collezione di oggetti da mantenere
    * @return true se gli elementi sono contenuti nella lista, false altrimenti
    * @throws NullPointerException se la collezione è vuota
    */
   public boolean retainAll(HCollection c){
      if (c == null)
         throw new NullPointerException();
      boolean b = false;
      for (int i=0; i < vec.size(); i++){
         Object o = vec.elementAt(i);
         if(c.contains(o)==false){
            b = true;
            vec.removeElementAt(i);
            i--;
         }
      }
      return b;
   }
   
   /**
    * Metodo toArray restituisce un array contente tutti gli elementi della lista.
    *
    * @return arr array con gli elementi della lista
    */
   public Object[] toArray() {
      Object[] arr = new Object[vec.size()];
      vec.copyInto(arr);
      return arr;
   }
   
   /**
    * Metodo toArray restituisce un array contente tutti gli elementi della lista usando l'array specificato come parametro se abbastanza grande, altrimenti crea e restituisce un nuovo array.
    *
    * @param arr array da utilizzare
    * @return array con gli elementi della lista
    * @throws NullPointerException se l'array è null
    */
   public Object[] toArray(Object[] arr) {
      if (arr == null)
         throw new NullPointerException();
      if (vec.size() > arr.length){
         Object[] newArr = new Object[vec.size()];
         vec.copyInto(newArr);
         return newArr;
      }
      else{
         vec.copyInto(arr);
         for (int i = vec.size(); i < arr.length; i++)
            arr[i] = null;
         return arr;
      }
   }
   
   /**
   * Metodo equals compara l'oggetto specificato con la lista per uguaglianza.
   * Due liste sono uguali se sono entrambe liste e contengono gli stessi elementi.
   * 
   * @param o oggetto da comparare per uguaglianza con la lista
   * @return true se l'oggetto o e' uguale alla lista, false altrimenti 
   */
   public boolean equals(Object o){
      if(o == this)
         return true;
      if(!(o instanceof HList))
         return false;
      HList newList = (HList) o;
      if(this.size() != newList.size())
         return false;
      HIterator iter1 = this.iterator();
      HIterator iter2 = newList.iterator();
      while(iter1.hasNext() && iter2.hasNext()){
         Object o1 = iter1.next();
         Object o2 = iter2.next();
         if(o1 == null){
            if(o2 != null)
               return false;
         }
         else{
            if(!o1.equals(o2))
               return false;
         }
      }
      return true;
   }
   
   /**
     * Metodo hashCode ritorna l'hash code della collezione.
     * L'hash code di una collezione è la somma degli hash code dei suoi membri.
     * 
     * @return hashCode l'hash code della collezione
     */
    public int hashCode(){
        int hashCode = 0;
        HIterator it = iterator();
        while(it.hasNext()){
            hashCode += it.next().hashCode();
        }
        return hashCode;
    }
    
   
   //Metodi HList
   
   /**
    * Metodo add aggiunge alla lista l'elemento specificato come parametro alla posizione dell'indice specificato.
    *
    * @param index indice
    * @param o oggetto da inserire
    * @throws NullPointerException se l'elemento è vuoto
    * @throws IndexOutOfBoundsException se l'indice non è valido
    */
   public void add(int index, Object o){
      if (index < 0 || index > vec.size())
         throw new IndexOutOfBoundsException();
      if (o == null)
         throw new NullPointerException();
      vec.insertElementAt(o, index);
   }
   
   /**
    * Metodo addAll aggiunge alla lista tutti gli elementi della collezione specificata come paramentro alla posizione dell'indice specificato.
    *
    * @param index indice
    * @param c collezione di oggetti da inserire
    * @return true se gli elementi vengono inseriti correttamente
    * @throws NullPointerException se la collezione è vuota
    * @throws IndexOutOfBoundsException se l'indice non è valido
    */
   public boolean addAll(int index, HCollection c){
      if (index < 0 || index > vec.size())
         throw new IndexOutOfBoundsException();
      if (c == null)
         throw new NullPointerException();
      HIterator iter = c.iterator();
      boolean b = false;
      while (iter.hasNext()){
         Object o = iter.next();
         add(index++, o);
         b = true;
      }
      return b;
   }
   
   /**
    * Metodo remove rimuove l'elemento specificato come parametro dalla lista alla posizione dell'indice specificato.
    *
    * @param index indice dove rimuove
    * @return rem l'elemento rimosso
    * @throws IndexOutOfBoundsException se l'indice non è valido
    */
   public Object remove(int index){
      if (index < 0 || index >= vec.size())
         throw new IndexOutOfBoundsException();
      Object rem = vec.elementAt(index);
      vec.removeElementAt(index);
      return rem;
   }
   
   /**
    * Metodo get ritorna l'elemento specificato come parametro dalla lista alla posizione dell'indice specificato.
    *
    * @param index indice alla posizione dell'elemento da ritornare
    * @return l'elemento all'indice
    * @throws IndexOutOfBoundsException se l'indice non è valido
    */
   public Object get(int index){
      if (index < 0 || index >= vec.size())
         throw new IndexOutOfBoundsException();
      return vec.elementAt(index);
   }
   
   /**
    * Metodo set sostituisce l'elemento della lista in posizione corrispondente all'indice specificato con l'elemento specificato.
    *
    * @param index indice alla posizione dell'elemento da sostituire
    * @param o elemento sostituto
    * @return precedente elemento all'indice
    * @throws NullPointerException se l'elemento è vuoto
    * @throws IndexOutOfBoundsException se l'indice non è valido
    */
   public Object set(int index, Object o){
      if (index < 0 || index >= vec.size())
         throw new IndexOutOfBoundsException();
      if (o == null)
         throw new NullPointerException();
      Object oldElem = vec.elementAt(index);
      vec.setElementAt(o, index);
      return oldElem;
   }
   
   /**
    * Metodo indexOf restituisce l'indice della prima occorrenza dell'elemento specificato, o ritorna -1 se l'elemento non è presente nella lista.
    *
    * @param o oggetto
    * @return indice dell'oggetto se è presente, -1 altrimenti
    * @throws NullPointerException se l'elemento è vuoto
    */
   public int indexOf(Object o){
      if (o == null)
         throw new NullPointerException();
      return vec.indexOf(o);
   }
   
   /**
    * Metodo lastIndexOf restituisce l'indice dell'ultima occorrenza dell'elemento specificato, o ritorna -1 se l'elemento non è presente nella lista.
    *
    * @param o oggetto
    * @return indice dell'oggetto se è presente, -1 altrimenti
    * @throws NullPointerException se l'elemento è vuoto
    */
   public int lastIndexOf(Object o){
      if (o == null)
         throw new NullPointerException();
      return vec.lastIndexOf(o);
   }
   
   /**
    * Metodo listIterator restituisce un iteratore sulla lista a partire dall'inizio.
    *
    * @return iteratore
    */
   public HListIterator listIterator(){
      return new ListIterator(this, 0);
   }
   
   /**
    * Metodo iterator restituisce un iteratore sulla lista a partire dall'indice specificato come parametro.
    *
    * @param index indice
    * @return iteratore
    * @throws IndexOutOfBoundsException se l'indice non è valido
    */
   public HListIterator listIterator(int index){
      if (index < 0 || index > vec.size())
         throw new IndexOutOfBoundsException();
      return new ListIterator(this, index);
   }
   
   /**
    * Metodo subList restituisce una porzione della lista compresa tra l'indice iniziale specificato (incluso) e l'indice finale specificato (escluso).
    *
    * @param fromIndex indice inziale
    * @param toIndex indice finale
    * @return iteratore
    * @throws IndexOutOfBoundsException se l'indice non è valido
    */
   public HList subList(int fromIndex, int toIndex){
      if (fromIndex < 0 || toIndex > vec.size() || fromIndex > toIndex)
         throw new IndexOutOfBoundsException();
      ListAdapter subL = new ListAdapter();
      for (int i = fromIndex; i < toIndex; i++) {
         subL.add(get(i));
      }
      return subL;
   }
}
