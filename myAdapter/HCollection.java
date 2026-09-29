package myAdapter;
/**
 * Interfaccia HCollection rappresenta una collezione generica di oggetti.<br/>
 * Può o meno ammettere elementi duplicati e può avere o meno un ordinamento.<br/>
 * Viene usata e manipolata dove si desiderà la massima generalità.<br/>
 */
public interface HCollection{
   
   /**
    * Metodo add aggiunge alla lista l'elemento specificato come parametro, attraverso il metodo addElement di Vector.
    *
    * @param o oggetto da inserire
    * @return true se l'elemento viene inserito correttamente
    * @throws NullPointerException se l'elemento è vuoto
    */
   public boolean add(Object o);
   
   /**
    * Metodo addAll aggiunge alla lista tutti gli elementi della collezione specificata come parametro, utilizzando il metodo add tante volte quanti sono gli elementi.
    *
    * @param c collezione di oggetti da inserire
    * @return true se tutti gli elementi vengono inseriti correttamente
    * @throws NullPointerException se la collezione è vuota
    */
   public boolean addAll(HCollection c);
   
   /**
    * Metodo clear rimuove tutti gli elementi dalla lista attraverso il metodo removeAllElements di Vector.
    */
   public void clear();
   
   /**
    * Metodo contains verifica se l'elemento specificato come parametro è presente nella lista, attraverso il metodo contains di Vector.
    *
    * @param o oggetto da verificare
    * @return true se l'elemento è presente, false altrimenti
    * @throws NullPointerException se l'oggetto è vuoto
    */
   public boolean contains(Object o);
   
   /**
    * Metodo containsAll verifica se tutti gli elementi della collezione specificata come parametro sono presenti nella lista, attraverso il metodo contains chiamato tante volte quanti sono gli elementi.
    *
    * @param c collezione di oggetti da verificare
    * @return true se tutti gli elementi sono presenti, false altrimenti
    * @throws NullPointerException se la collezione è vuota
    */
   public boolean containsAll(HCollection c);
   
   /**
    * Metodo isEmpty verifica se la lista è vuota, attraverso il metodo isempty di Vector.
    *
    * @return true se la lista è vuota, false altrimenti
    */
   public boolean isEmpty();
   
   /**
    * Metodo iterator restituisce un iteratore sulla lista a partire dall'inizio.
    *
    * @return iteratore
    */
   public HIterator iterator();
   
   /**
    * Metodo remove rimuove l'elemento specificato come parametro dalla lista, attraverso il metodo removeElement di Vector.
    *
    * @param o oggetto da rimuovere
    * @return true se l'elemento viene rimosso, false altrimenti
    * @throws NullPointerException se l'oggetto è vuoto
    */
   public boolean remove(Object o);
   
   /**
    * Metodo removeAll rimuove tutti gli elementa della collezione specificata come parametro dalla lista, attraverso il metodo remove chiamato tante volte quanti sono gli elementi della collezione.
    *
    * @param c collezione di oggetti da rimuovere
    * @return true se tutti gli elementi vengono rimossi, false altrimenti
    * @throws NullPointerException se la collezione è vuota
    */
   public boolean removeAll(HCollection c);
   
   /**
    * Metodo retainAll mantiene solo gli elementi della lista che sono presenti anche nella collezione specificata, attraverso un ciclo in cui viene controllato se ogni elemento della lista è presente anche nella collezione, se così non fosse viene eliminato dalla lista.
    *
    * @param c collezione di oggetti da mantenere
    * @return true se gli elementi sono contenuti nella lista, false altrimenti
    * @throws NullPointerException se la collezione è vuota
    */
   public boolean retainAll(HCollection c);
   
   /**
    * Metodo size restituisce il numero di elementi nella collezione, attraverso il metodo size di Vector.
    *
    * @return la dimensione della lista
    */
   public int size();
   
   /**
    * Metodo toArray restituisce un array contente tutti gli elementi della lista.
    *
    * @return arr array con gli elementi della lista
    */
   public Object[] toArray();
   
   /**
    * Metodo toArray restituisce un array contente tutti gli elementi della lista usando l'array specificato come parametro se abbastanza grande, altrimenti crea e restituisce un nuovo array.
    *
    * @param a array da utilizzare
    * @return array con gli elementi della lista
    * @throws NullPointerException se l'array è null
    */
   public Object[] toArray(Object[] a);
   
   /**
   * Metodo equals compara l'oggetto specificato con la lista per uguaglianza.
   * Due liste sono uguali se sono entrambe liste e contengono gli stessi elementi.
   * 
   * @param o oggetto da comparare per uguaglianza con la lista
   * @return true se l'oggetto o e' uguale alla lista, false altrimenti 
   */
   public boolean equals(Object o);
   
   /**
     * Metodo hashCode ritorna l'hash code della collezione.
     * L'hash code di una collezione è la somma degli hash code dei suoi membri.
     * 
     * @return hashCode l'hash code della collezione
     */
   public int hashCode();
}
