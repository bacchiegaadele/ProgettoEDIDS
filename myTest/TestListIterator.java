package myTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.util.*;
import myAdapter.*;

/**
 * Test suite per la classe {@link myAdapter.ListIterator}, che implementa {@link myAdapter.HIterator} e {@link myAdapter.HListIterator}.<br/>
 * 
 * Summary:<br/>
 * Verifica il corretto funzionamento dei metodi di un iteratore di una {@link myAdapter.HList} implementata da {@link myAdapter.ListAdapter}.
 * <br/>
 *
 * Design:<br/>
 * Si utilizzano JUnit 4.13.2, hamcrest-core-1.3.<br/>
 * La test suite include test cases per verificare il corretto e completo funzionamento dei metodi {@code hasNext()}, {@code next()}, e {@code remove()} di HIterator su ListAdapter vuoti e non.<br/>
 * Inoltre include test cases per verificare il corretto e completo funzionamento dei metodi {@code hasPrevious()}, {@code previous()}, {@code nextIndex()}, {@code previousIndex()}, {@code add(Object o)}, e {@code set(Object o)} di HListIterator su ListAdapter vuoti e non.<br/>
 * Si suppongono funzionanti i metodi di {@link myAdapter.ListAdapter}, di cui viene fornita un'istanza.<br/>
 * Prima di ogni test case si popola la lista con 4 elementi e si collega un iteratore.<br/>
 * Nella descrizione dei diversi testCase, e' implicita l'esecuzione della funzione setUp annotata con @Before e che suppongono testati e funzionanti i metodi {@link myAdapter.ListAdapter#add(Object o) add}, {@link myAdapter.ListAdapter#listIterator() listIterator} usati per la funzione setUp.<br/>
 */

public class TestListIterator{

   //Variabili
   private HList list;
   private HListIterator it;

	/**
	 * Metodo di setup: prima di ogni test istanzio una lista nuova con 5 elementi e relativo iteratore
	 */
	@Before
	public void setUp(){
		System.out.println("Istanzio una lista nuova e relativo iteratore");
		list = new ListAdapter();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		it = list.listIterator();
	}
	
	//TEST SU NEXT
	/**
    * Test del metodo {@link myAdapter.ListIterator#next() next} su una lista con 4 elementi.
    * <br/>
    * @s.ummary Verifica che il metodo {@code next()} ritorna correttamente gli elementi della lista e lancia {@link NoSuchElementException} se iterato oltre la fine dell'iteratore della lista.
    * <br/>
    * @d.esign Si vuole analizzare il comportamento di {@code next()} su una lista fatta di piu' elementi gia' prima della sua chiamata. Verifico che restituisca tutti gli elementi della lista come sono stati salvati. Verifico che lanci {@code NoSuchElementException} se iterato oltre la fine dell'iteratore.
    * <br/>
    * @d.escription Si suppongono testati e funzionanti il metodo {@code hasNext()}, {@link myAdapter.ListAdapter#size() size}, {@link myAdapter.ListAdapter#contains(Object o) contains}, e poi:<br/>
    * 1. Si verifica che ogni elemento letto dall'iteratore appartenga alla lista.<br/>
    * 2. Si verifica che il numero di elementi letti sia lo stesso del numero di elementi della lista.<br/>
    * 3. Si chiama next() alla fine della lista per verificare il lancio di NoSuchElementException.<br/>
    * 
    * @p.recond La lista ha 4 elementi e l'iteratore e' stato posizionato all'inizio della lista<br/>
    * 
    * @p.ostcond La lista e' rimasta invariata<br/>
    * 
    * @r.esult {@code next()} deve restuire gli elementi della lista e lanciare {@code NoSuchElementException} quando si cerca di iterarlo oltre la fine della lista.<br/>
    */
   @Test (expected = NoSuchElementException.class)
   public void testNext1(){
      int i = 0;
      while(it.hasNext()){
         i += 1;
         String nextElem = (String)it.next();
         assertTrue("Controllo che l'elemento "+ nextElem + " appartiene alla lista", list.contains(nextElem));
      }
      assertEquals("La dimensione della lista non è 4", i, list.size());
      it.next();
   }

   /**
    * Test del metodo {@link myAdapter.ListIterator#next() next} su una lista vuota.
    * <br/>
    * @s.ummary Verifica che il metodo {@code next()} lancia {@link NoSuchElementException} quando la lista da leggere e' vuota.
    * <br/>
    * @d.esign Si vuole analizzare il comportamento di {@code next()} quando chiamato su una lista vuota.
    * <br/>
    * @d.escription Si suppone testato e funzionante il metodo {@link myAdapter.ListAdapter#clear() clear}, e poi:<br/>
    * 1. Si svuota la lista.<br/>
    * 2. Si fa puntare l'iteratore alla lista vuota.<br/>
    * 3. Si chiama next() per verificare il lancio di NoSuchElementException sulla lista vuota.<br/>
    * 
    * @p.recond La lista ha 4 elementi e l'iteratore e' stato posizionato all'inizio della lista<br/>
    * 
    * @p.ostcond La lista e' vuota e il suo iteratore e' posizionato all'inizio di tale lista.<br/>
    * 
    * @r.esult {@code next()} deve lanciare {@code NoSuchElementException} se lista da leggere e' vuota.<br/>
    */
   @Test (expected = NoSuchElementException.class)
   public void testNext2(){
      list.clear();
      it = list.listIterator();
      it.next();
   }
	
	//TEST SU HASNEXT
	/**
    * Test del metodo {@link myAdapter.ListIterator#hasNext() hasNext} su una lista con 4 elementi.
    * <br/>
    * @s.ummary Verifica che il metodo {@code hasNext()} ritorna correttamente {@code true} quando ci sono elementi successivi nella lista, {@code false} altrimenti.
    * 
    * @d.esign Si vuole analizzare il comportamento di {@code hasNext()} su un lista fatta da 4 elementi, quindi il metodo restituirà {@code true}). La chiamata di {@code hasNext()} su un'altra lista vuota o il cui iteratore ha percorso tutti gli elementi ci si aspetta ritorni {@code false}. Ci si aspetta che la chiamata al metodo non comporti modifiche ne' alla lista ne' all'iteratore.
    * <br/>
    * @d.escription Si suppongono testati e funzionanti il metodo {@code next()}, {@link myAdapter.ListAdapter#size() size}, {@link myAdapter.ListAdapter#contains(Object o) contains}, e poi:<br/>
    * 1. Si verifica che hasNext() ritorni true.<br/>
    * 2. Si fa scorrere l'iteratore finche' ha oggetti da leggere.<br/>
    * 3. Si verifica che hasNext() ritorni false.<br/>
    * 4. Si crea una nuova lista vuota e si verifica che hasNext() ritorni false.<br/>
    * 5. Si verifica che la lista letta dall'iteratore non sia stata modificato.<br/>
    * 
    * @p.recond La lista ha 4 elementi e l'iteratore e' stato posizionato all'inizio della lista<br/>
    * 
    * @p.ostcond La lista e' rimasta invariata e l'iteratore e' stato posizionato su una nuova lista vuota<br/>
    * 
    * @r.esult {@code hasNext()} deve restuire {@code true} quando l'iteratore possiede ancora elementi da leggere, {@code false} quando non ci sono piu' elementi da leggere.<br/>
    */
   @Test
   public void testHasNext(){
      assertTrue("Non ci sono altri elementi nella lista", it.hasNext());
      while(it.hasNext())
         it.next();
      assertFalse("Ci sono altri elementi nella lista", it.hasNext());
      HList list2 = new ListAdapter();
      it = list2.listIterator();
      assertFalse("Ci sono altri elementi in una lista vuota", it.hasNext());
      assertEquals("La lista non contiene 4 elementi", 4, list.size());
      assertTrue("La lista non contiene A, B, C, D", list.contains("A") && list.contains("B") && list.contains("C") && list.contains("D"));
   }
   
	//TEST SU REMOVE
   /**
    * Test del metodo {@link myAdapter.ListIterator#remove() remove} su una lista con 4 elementi.
    * <br/>
    * @s.ummary Verifica che il metodo {@code remove()} rimuove correttamente l'ultimo elemento restituito da {@code next()} aggiornando in modo appropriato la lista.
    * <br/>
    * @d.esign Si vuole analizzare che il comportamento di {@code remove()} si appoggi in modo adeguato al metodo {@link myAdapter.ListAdapter#remove(int index) remove} per la rimozione dell'ultimo elemento restituito da {@code next()}.
    * <br/>
    * @d.escription Si suppongono funzionanti i metodi {@code next()}, {@link myAdapter.ListAdapter#remove(int index) remove}, {@link myAdapter.ListAdapter#contains(Object o) contains}, {@link myAdapter.ListAdapter#size() size}, e poi:<br/>
    * 1. Si chiama next() per far avanzare l'iteratore e si salva il risultato ottenuto.<br/>
    * 2. Salvo il numero di elementi della lista letto dall'iteratore, {@code 4}.<br/>
    * 3. Si chiama remove() e si verifica che l'elemento precedentemente restituito sia stato rimosso dalla lista.<br/>
    * 4. Si verifica che la dimensione della lista sia diminuita di 1, {@code 3}.<br/>
    * 
    * @p.recond La lista ha 4 elementi e l'iteratore e' stato posizionato all'inizio della lista<br/>
    * 
    * @p.ostcond La lista ha 3 elementi<br/>
    * 
    * @r.esult {@code remove()} deve rimuovere correttamente l'elemento ritornato da {@code next()} e aggiornare la dimensione della lista che legge, non ritorna nulla.<br/>
    */
   @Test
   public void testRemove(){
      String nextElem = (String)it.next();
      int n = list.size();
      it.remove();
      assertFalse("L'elemento "+ nextElem + " non appartiene piu' alla lista", list.contains(nextElem));
      assertEquals("La dimensione della lista non è 3", n-1, list.size());
   }
	
	//TEST SU NEXTINDEX
	/**
    * Test del metodo {@link myAdapter.ListIterator#nextIndex() nextIndex} su una lista con 4 elementi.
    * <br/>
    * @s.ummary Verifica che il metodo {@code nextIndex()} restituisca correttamente l'indice dell'elemento che dovrebbe essere ritornato invocando il metodo {@code next()}.
    * <br/>
    * @d.esign Si vuole analizzare che il comportamento di {@code nextIndex()} si appoggi in modo adeguato al cursore dell'iteratore per la restituzione dell'indice dell'elemento che dovrebbe essere ritornato invocando il metodo {@code next()}.
    * <br/>
    * @d.escription Si suppone funzionante il metodo {@code next()}, e poi:<br/>
    * 1. Si chiama nextIndex() sull'iteratore della lista e si verifica che il valore ritornato corrisponda al cursore, il quale partirà da 0.<br/>
    * 2. Si chiama next() sull'iteratore per passare all'elemento successivo della lista.<br/>
    * 3. Si ripetono i punti 1. e 2. finchè non arrivo alla fine della lista.<br/>
    * 
    * @p.recond La lista ha 4 elementi e l'iteratore e' stato posizionato all'inizio della lista<br/>
    * 
    * @p.ostcond La lista e' rimasta invariata<br/>
    * 
    * @r.esult {@code nextIndex()} deve restituire correttamente l'indice dell'elemento ritornato da {@code next()}.<br/>
    */
	@Test
	public void testNextIndex(){
      assertEquals("0", 0, it.nextIndex());
      it.next();
      assertEquals("1", 1, it.nextIndex());
      it.next();
      assertEquals("2", 2, it.nextIndex());
      it.next();
      assertEquals("3", 3, it.nextIndex());
   }
	
	//TEST SU PREVIOUSINDEX
	/**
    * Test del metodo {@link myAdapter.ListIterator#previousIndex() previousIndex} su una lista con 4 elementi.
    * <br/>
    * @s.ummary Verifica che il metodo {@code previousIndex()} restituisca correttamente l'indice dell'elemento che dovrebbe essere ritornato invocando il metodo {@code previous()}.
    * <br/>
    * @d.esign Si vuole analizzare che il comportamento di {@code previousIndex()} si appoggi in modo adeguato al cursore dell'iteratore per la restituzione dell'indice dell'elemento che dovrebbe essere ritornato invocando il metodo {@code previous()}.
    * <br/>
    * @d.escription Si suppone funzionante il metodo {@code previous()}, e poi:<br/>
    * 1. Si fa puntare l'iteratore alla fine della lista con il metodo {@code listIterator(int index)} di HList.
    * 2. Si chiama previousIndex() sull'iteratore e si verifica che il valore ritornato corrisponda al cursore decrementato di 1, il quale partirà da 2.<br/>
    * 3. Si chiama previous() sull'iteratore per passare all'elemento precedente della lista.<br/>
    * 4. Si ripetono i punti 2. e 3. finchè non arrivo all'inizio della lista.<br/>
    * 
    * @p.recond La lista ha 4 elementi e l'iteratore e' stato posizionato all'inizio della lista<br/>
    * 
    * @p.ostcond La lista e' rimasta invariata<br/>
    * 
    * @r.esult {@code previousIndex()} deve restituire correttamente l'indice dell'elemento ritornato da {@code previous()}.<br/>
    */
	@Test
	public void testPreviousIndex(){
      it = list.listIterator(3);
      assertEquals("2", 2, it.previousIndex());
      it.previous();
      assertEquals("1", 1, it.previousIndex());
      it.previous();
      assertEquals("0", 0, it.previousIndex());
   }
   
	//TEST SU PREVIOUS
	/**
    * Test del metodo {@link myAdapter.ListIterator#previous() previous} su una lista con 4 elementi.
    * <br/>
    * @s.ummary Verifica che il metodo {@code previous()} ritorna correttamente gli elementi della lista e lancia {@link NoSuchElementException} se iterato oltre l'inizio dell'iteratore della lista.
    * <br/>
    * @d.esign Si vuole analizzare il comportamento di {@code previous()} su una lista fatta di piu' elementi gia' prima della sua chiamata. Verifico che restituisca tutti gli elementi della lista come sono stati salvati. Verifico che lanci {@code NoSuchElementException} se iterata oltre l'inizio dell'iteratore.
    * <br/>
    * @d.escription Si suppongono testati e funzionanti il metodo {@code hasPrevious()}, {@link myAdapter.ListAdapter#size() size}, {@link myAdapter.ListAdapter#contains(Object o) contains}, e poi:<br/>
    * 1. Si fa puntare l'iteratore all'ultimo elemento della lista.<br/>
    * 2. Si verifica che ogni elemento letto dall'iteratore appartenga alla lista.<br/>
    * 3. Si verifica che il numero di elementi letti sia lo stesso del numero di elementi della lista.<br/>
    * 4. Si chiama previous() all'inizio della lista per verificare il lancio di NoSuchElementException.<br/>
    * 
    * @p.recond La lista ha 4 elementi e l'iteratore e' stato posizionato all'inizio della lista<br/>
    * 
    * @p.ostcond La lista e' rimasta invariata<br/>
    * 
    * @r.esult {@code previous()} deve restuire gli elementi della lista e lanciare {@code NoSuchElementException} quando si cerca di iterarlo oltre l'inizio della lista.<br/>
    */
   @Test (expected = NoSuchElementException.class)
   public void testPrevious1(){
      it = list.listIterator(4);
      int i = 0;
      while(it.hasPrevious()){
         i += 1;
         String prevElem = (String)it.previous();
         assertTrue("Controllo che l'elemento "+ prevElem + " appartiene alla lista", list.contains(prevElem));
      }
      assertEquals("La dimensione della lista non è 4", i, list.size());
      it.previous();
   }

   /**
    * Test del metodo {@link myAdapter.ListIterator#previous() previous} su una lista vuota.
    * <br/>
    * @s.ummary Verifica che il metodo {@code previous()} lancia {@link NoSuchElementException} quando la lista da leggere e' vuota.
    * <br/>
    * @d.esign Si vuole analizzare il comportamento di {@code previous()}  quando chiamato su una lista vuota.
    * <br/>
    * @d.escription Si suppone testato e funzionante il metodo {@link myAdapter.ListAdapter#clear() clear}, e poi:<br/>
    * 1. Si svuota la lista.<br/>
    * 2. Si fa puntare l'iteratore alla lista vuota.<br/>
    * 3. Si chiama previous() per verificare il lancio di NoSuchElementException sulla lista vuota.<br/>
    * 
    * @p.recond La lista ha 4 elementi e l'iteratore e' stato posizionato all'inizio della lista<br/>
    * 
    * @p.ostcond La lista e' vuota e il suo iteratore e' posizionato all'inizio di tale lista<br/>
    * 
    * @r.esult {@code previous()} deve lanciare {@code NoSuchElementException} se lista da leggere e' vuota.<br/>
    */
   @Test (expected = NoSuchElementException.class)
   public void testPrevious2(){
      list.clear();
      it = list.listIterator();
      it.previous();
   }
	
	//TEST SU HASPREVIOUS
	/**
    * Test del metodo {@link myAdapter.ListIterator#hasPrevious() hasPrevious} su una lista con 4 elementi.
    * <br/>
    * @s.ummary Verifica che il metodo {@code hasPrevious()} ritorna correttamente {@code true} quando ci sono elementi precedenti nellla lista, {@code false} altrimenti.
    * <br/>
    * @d.esign Si vuole analizzare il comportamento di {@code hasPrevious()} su un lista fatta da 4 elementi, quindi il metodo restituirà {@code true}). La chiamata di {@code hasNext()} su un'altra lista vuota o il cui iteratore ha percorso tutti gli elementi all'indietro ci si aspetta ritorni {@code false}. Ci si aspetta che la chiamata al metodo non comporti modifiche ne' alla lista ne' all'iteratore.
    * <br/>
    * @d.escription Si suppongono testati e funzionanti il metodo {@code previous()}, {@link myAdapter.ListAdapter#size() size}, {@link myAdapter.ListAdapter#contains(Object o) contains}, e poi:<br/>
    * 1. Si collega l'iteratore all'ultimo elemento della lista.<br/>
    * 2. Si verifica che hasPrevious() ritorni true.<br/>
    * 3. Si fa scorrere l'iteratore all'indietro finche' ha oggetti da leggere.<br/>
    * 4. Si verifica che hasPrevious() ritorni false.<br/>
    * 5. Si crea una nuova lista vuota e si verifica che hasPrevious() ritorni false.<br/>
    * 6. Si verifica che la lista letta dall'iteratore non sia stata modificato.<br/>
    * 
    * @p.recond La lista ha 4 elementi e l'iteratore e' stato posizionato all'inizio della lista<br/>
    * 
    * @p.ostcond La lista e' rimasta invariata e l'iteratore e' stato posizionato prima alla fine della lista e poi su una nuova lista vuota<br/>
    * 
    * @r.esult {@code hasPrevious()} deve restuire {@code true} quando l'iteratore possiede elementi precedenti da leggere, {@code false} quando non ci sono piu' elementi precedenti da leggere.<br/>
    */
   @Test
   public void testHasPrevious(){
      it = list.listIterator(3);
      assertTrue("Non ci sono elementi precedenti nella lista", it.hasPrevious());
      while(it.hasPrevious())
         it.previous();
      assertFalse("Ci sono elementi precedenti nella lista", it.hasPrevious());
      HList list2 = new ListAdapter();
      it = list2.listIterator();
      assertFalse("Ci sono elementi precedenti in una lista vuota", it.hasPrevious());
      assertEquals("La lista non contiene 4 elementi", 4, list.size());
      assertTrue("La lista non contiene A, B, C, D", list.contains("A") && list.contains("B") && list.contains("C") && list.contains("D"));
   }
	
	//TEST SU ADD
	/**
    * Test del metodo {@link myAdapter.ListIterator#add(Object o) add} nel caso di argomento {@code null}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code add(Object o)} lancia {@link NullPointerException} se fornito un argomento {@code null}.
    * <br/>
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code add(Object o)} nel caso di argomento {@code null} venga correttamente lanciata l'eccezione {@link NullPointerException}.    
    * <br/>
    * @d.escription Si esegue direttamente il metodo add fornendo come argomento null e si verifica che venga lanciata un'eccezione NullPointerException.
    * <br/>
    * @p.recond La lista ha 4 elementi
    * <br/>
    * @p.ostcond La lista rimane invariata
    * <br/>
    * @r.esult {@code add(Object o)} deve lanciare {@link NullPointerException} se chiamata con argomento {@code null}.<br/>
    */
   @Test(expected = NullPointerException.class)
   public void testAdd1(){
      it.add(null);
   }
   
   /**
    * Test del metodo {@link myAdapter.ListIterator#add(Object o) add} su una lista di 4 elementi nel caso in cui come parametro l'oggetto non sia {@code null}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code add(Object o)} inserisca l'elemento specificato nella lista prima dell'elemento che sarebbe restituito da {@code next()} e dopo quello che sarebbe restituito da {@code previous()}.
    * <br/>
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code add(Object o)} nel caso di argomento non {@code null} venga correttamente aggiunto l'elemento specificato fra gli oggetti di {@code next()} e {@code previous()}.    
    * <br/>
    * @d.escription Si suppongono testati e funzionanti i metodi {@code next()}, {@code nextIndex()}, {@code previousIndex()}, {@code get()} di HList, e poi:<br/>
    * 1. Si scorre l'iteratore all'elemento successivo al primo della lista con il metodo {@code next()}.<br/>
    * 2. Si verifica che i metodi {@code nextIndex()} e {@code previousIndex()} ritornino gli indici correttamente.<br/>
    * 3. Si aggiunge un elemento alla lista tramite il metodo {@code add(Object o)} invocato sull'iteratore della lista.<br/>
    * 4. Si verifica che la lista aggiornata sia corretta utilizzando il metodo {@code get(int index)} di HList sulla lista.<br/>
    * 
    * @p.recond La lista ha 4 elementi
    * <br/>
    * @p.ostcond La lista ha 5 elementi
    * <br/>
    * @r.esult {@code add(Object o)} deve aggiungere l'oggetto specificato fra gli oggetti di {@code next()} e {@code previous()}.<br/>
    */
	@Test
	public void testAdd2(){
      it.next();
      assertEquals("Indice precedente non è 0", 0, it.previousIndex());
      assertEquals("Indice successivo non è 1", 1, it.nextIndex());
      it.add("L");
      assertTrue("Primo elemento della lista non è A", list.get(0)=="A");
      assertTrue("Secondo elemento della lista non è L", list.get(1)=="L");
      assertTrue("Terzo elemento della lista non è B", list.get(2)=="B");
      assertTrue("Quarto elemento della lista non è C", list.get(3)=="C");
      assertTrue("Quinto elemento della lista non è D", list.get(4)=="D");
   }
	
	//TEST SU SET
	/**
    * Test del metodo {@link myAdapter.ListIterator#set(Object o) set} nel caso di argomento {@code null}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code set(Object o)} lancia {@link NullPointerException} se fornito un argomento {@code null}.
    * <br/>
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code set(Object o)} nel caso di argomento {@code null} venga correttamente lanciata l'eccezione {@link NullPointerException}.    
    * <br/>
    * @d.escription Si esegue direttamente il metodo set fornendo come argomento null e si verifica che venga lanciata un'eccezione NullPointerException.
    * <br/>
    * @p.recond La lista ha 4 elementi.
    * <br/>
    * @p.ostcond La lista rimane invariata.
    * <br/>
    * @r.esult {@code set(Object o)} deve lanciare {@link NullPointerException} se chiamata con argomento {@code null}.<br/>
    */
   @Test(expected = NullPointerException.class)
   public void testSet1(){
      it.next();
      it.set(null);
   }
   
	/**
    * Test del metodo {@link myAdapter.ListIterator#set(Object o) set} su una lista di 4 elementi nel caso in cui come parametro l'oggetto non sia {@code null}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code set(Object o)} inserisca l'elemento specificato al posto dell'elemento dell'ultimo metodo {@code next()} o {@code previous()} invocato sull'iteratore.
    * <br/>
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code set(Object o)} nel caso di argomento non {@code null} venga correttamente sostituito l'elemento specificato al posto di quello dell'ultimo {@code next()} o {@code previous()}.    
    * <br/>
    * @d.escription Si suppongono testati e funzionanti i metodi {@code next()}, {@code get()} di HList, e poi:<br/>
    * 1. Si scorre l'iteratore fino al secondo elemento della lista con 2 chiamate al metodo {@code next()}.<br/>
    * 2. Si sostituisce il secodo elemento della lists con un nuovo elemento tramite il metodo {@code set(Object o)} invocato sull'iteratore della lista.<br/>
    * 4. Si verifica che la lista aggiornata sia corretta utilizzando il metodo {@code get(int index)} di HList sulla lista.<br/>
    * 
    * @p.recond La lista ha 4 elementi
    * <br/>
    * @p.ostcond La lista ha 4 elementi, ma uno è stato modificato.
    * <br/>
    * @r.esult {@code set(Object o)} deve sostituire l'oggetto specificato al posto di quello dell'ultima invocazione fatta sul metodo {@code next()} o {@code previous()}.<br/>
    */
   @Test
	public void testSet2(){
      it.next();
      it.next();
      it.set("L");
      assertTrue("Primo elemento della lista non è A", list.get(0)=="A");
      assertTrue("Secondo elemento della lista non è L", list.get(1)=="L");
      assertTrue("Terzo elemento della lista non è C", list.get(2)=="C");
      assertTrue("Quarto elemento della lista non è D", list.get(3)=="D");
   }
   
   /**
    * Metodo tearDown di chiusura
    */
   @After
	public void tearDown(){
		System.out.println("Nothing to do...");
	}
}
