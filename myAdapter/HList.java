package myAdapter;
/**
 * Interfaccia HList estende l'interfaccia HCollection, quindi eredita tutti i suoi costruttori e metodi, e rappresenta una collection ordinata.<br/>
 * Utente avrà il controllo di ogni elemento inserito nella lista, potrà accedere ad ogni elemento attraverso un indice (index), posizione nella lista.<br/>
 */
public interface HList extends HCollection{
   
   /**
    * Metodo add aggiunge alla lista l'elemento specificato come parametro alla posizione dell'indice specificato.
    *
    * @param index indice
    * @param o oggetto da inserire
    * @throws NullPointerException se l'elemento è vuoto
    * @throws IndexOutOfBoundsException se l'indice non è valido
    */
   public void add(int index, Object o);
   
   /**
    * Metodo addAll aggiunge alla lista tutti gli elementi della collezione specificata come paramentro alla posizione dell'indice specificato.
    *
    * @param index indice
    * @param c collezione di oggetti da inserire
    * @return true se gli elementi vengono inseriti correttamente
    * @throws NullPointerException se la collezione è vuota
    * @throws IndexOutOfBoundsException se l'indice non è valido
    */
   public boolean addAll(int index, HCollection c);
   
   /**
    * Metodo remove rimuove l'elemento specificato come parametro dalla lista alla posizione dell'indice specificato.
    *
    * @param index indice dove rimuove
    * @return rem l'elemento rimosso
    * @throws IndexOutOfBoundsException se l'indice non è valido
    */
   public Object remove(int index);
   
   /**
    * Metodo get ritorna l'elemento specificato come parametro dalla lista alla posizione dell'indice specificato.
    *
    * @param index indice alla posizione dell'elemento da ritornare
    * @return l'elemento all'indice
    * @throws IndexOutOfBoundsException se l'indice non è valido
    */
   public Object get(int index);
   
   /**
    * Metodo set sostituisce l'elemento della lista in posizione corrispondente all'indice specificato con l'elemento specificato.
    *
    * @param index indice alla posizione dell'elemento da sostituire
    * @param o elemento sostituto
    * @return precedente elemento all'indice
    * @throws NullPointerException se l'elemento è vuoto
    * @throws IndexOutOfBoundsException se l'indice non è valido
    */
   public Object set(int index, Object o);
   
   /**
    * Metodo indexOf restituisce l'indice della prima occorrenza dell'elemento specificato, o ritorna -1 se l'elemento non è presente nella lista.
    *
    * @param o oggetto
    * @return indice dell'oggetto se è presente, -1 altrimenti
    * @throws NullPointerException se l'elemento è vuoto
    */
   public int indexOf(Object o);
   
   /**
    * Metodo lastIndexOf restituisce l'indice dell'ultima occorrenza dell'elemento specificato, o ritorna -1 se l'elemento non è presente nella lista.
    *
    * @param o oggetto
    * @return indice dell'oggetto se è presente, -1 altrimenti
    * @throws NullPointerException se l'elemento è vuoto
    */
   public int lastIndexOf(Object o);
   
   /**
    * Metodo listIterator restituisce un iteratore sulla lista a partire dall'inizio.
    *
    * @return iteratore
    */
   public HListIterator listIterator();
   
   /**
    * Metodo iterator restituisce un iteratore sulla lista a partire dall'indice specificato come parametro.
    *
    * @param index indice
    * @return iteratore
    * @throws IndexOutOfBoundsException se l'indice non è valido
    */
   public HListIterator listIterator(int index);
   
   /**
    * Metodo subList restituisce una porzione della lista compresa tra l'indice iniziale specificato (incluso) e l'indice finale specificato (escluso).
    *
    * @param fromIndex indice inziale
    * @param toIndex indice finale
    * @return iteratore
    * @throws IndexOutOfBoundsException se l'indice non è valido
    */
   public HList subList(int fromIndex, int toIndex);
}
