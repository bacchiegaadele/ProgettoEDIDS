package myAdapter;
/**
 * Interfaccia HIterator rappresenta un modo per iterare in modo sequenziale gli elementi di una collezione.<br/>
 */
public interface HIterator{
   
   /**
     * Metodo next restituisce l'elemento successivo nella lista.
     *
     * @return l'elemento successivo
     */
   public Object next();
   
   /**
     * Metodo hasNext verifica se esiste almeno un elemento successivo nella lista.
     *
     * @return true se esiste un elemento successivo, false altrimenti
     */
   public boolean hasNext();
   
   /**
     * Metodo remove rimuove l'elemento della lista che è stato restituito per ultimo individuato attraverso la variabile last.
     *
     * @throws IllegalStateException se last vale -1, ovvero non è stato restituito nulla
     */
   public void remove();
}
