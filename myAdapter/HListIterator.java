package myAdapter;
/**
 * Interfaccia HListIterator estende l'interfaccia HIterator e consente di accedere alla lista in modo bidirezionale.<br/>
 */
public interface HListIterator extends HIterator{
   
   /**
    * Metodo nextIndex restituisce l'indice dell'elemento che dovrebbe essere ritornato invocando il metodo next che corrisponde al valore del cursore.
    *
    * @return cursor
    */
   public int nextIndex();
   
   /**
    * Metodo previousIndex restituisce l'indice dell'elemento che dovrebbe essere ritornato invocando il metodo previous che corrisponde al valore del precedente di quello del cursore.
    *
    * @return prev il cursore decrementato di 1
    */
   public int previousIndex();
   
   /**
     * Metodo previous restituisce l'elemento precedente nella lista.
     *
     * @return l'elemento precedente
     */
   public Object previous();
   
   /**
     * Metodo hasPrevious verifica se esiste almeno un elemento precedente nella lista.
     *
     * @return true se esiste un elemento precedente, false altrimenti
     */
   public boolean hasPrevious();
   
   /**
    * Metodo add inserisce l'elemento specificato nella lista prima dell'elemento che sarebbe restituito da next e dopo quello che sarebbe restituito da previous.
    *
    * @param o l'elemento da inserire
    * @throws NullPointerException se l'elemento da inserire è vuoto
    */
   public void add(Object o);
   
   /**
    * Metodo set sostituisce l'elemento ritornato con next o previous con l'elemento specificato.
    *
    * @param o l'elemento con cui sostituire
    * @throws NullPointerException se l'elemento da inserire è vuoto
    * @throws IllegalStateException se last vale -1, ovvero non è stato restituito nulla
    */
   public void set(Object o);
}
