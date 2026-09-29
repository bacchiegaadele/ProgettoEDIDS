package myTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.util.*;
import myAdapter.*;

/**
 * Test suite per la classe {@link myAdapter.ListAdapter}, che implementa {@link myAdapter.HCollection} e {@link myAdapter.HList}.<br/>
 *
 * Summary:<br/>
 * Verifica il corretto funzionamento dei metodi di una {@link myAdapter.HList} implementata da {@link myAdapter.ListAdapter}.<br/>
 *
 * Design:<br/>
 * Si utilizzano JUnit 4.13.2, hamcrest-core-1.3.<br/>
 * La test suite include test cases per verificare il corretto e completo funzionamento dei metodi {@code add(Object o)}, {@code addAll(HCollection c)}, {@code clear()}, {@code contains(Object o)}, {@code containsAll(HCollection c)}, {@code isEmpty()}, {@code iterator()}, {@code remove(Object o)} {@code removeAll(HCollection c)}, {@code retainAll(HCollection c)}, {@code size()}, {@code toArray()}, {@code toArray(Objiect[] arr)}, {@code equals(Object o)} e {@code hashCode()} di HCollection su ListAdapter vuoti e non.<br/>
 * Inoltre include test cases per verificare il corretto e completo funzionamento dei metodi {@code add(int index, Object o)}, {@code addAll(int index, HCollectio c)}, {@code remove(int index)}, {@code get(int index)}, {@code set(int index, Object o)}, {@code indexOf()}, {@code lastIndexOf()}, {@code listIterator()}, {@code listIterator(int index)} e {@code subList(int fromIndex, int toIndex)} di HList su ListAdapter vuoti e non.<br/>
 * Si suppongono funzionanti i metodi di {@link myAdapter.ListIterator}.<br/>
 * Prima di ogni test case si popola la lista con 4 elementi.<br/>
 * Nella descrizione dei diversi testCase, e' implicita l'esecuzione della funzione setUp annotata con @Before e che suppone testato e funzionante il metodo {@code add(Object o)} usato per la funzione setUp.<br/>
 */

public class TestListAdapter{
   //Variabili
	private HList list;

	/**
	 *Metodo di setup: prima di ogni test istanzio una lista nuova con 4 elementi
	 */
	@Before
	public void setUp(){
		System.out.println("Istanzio una lista nuova");
		list = new ListAdapter();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
	}
	
	//TEST SU METODI DI HCOLLECTION E HLIST

   //TEST SU ISEMPTY
	/**
    * Test del metodo {@link myAdapter.ListAdapter#isEmpty() isEmpty} su una lista di 4 elementi.
    * <br/>
    * @s.ummary Verifica che il metodo {@code isEmpty()} restituisca correttamente {@code true} quando la lista è vuota, {@code false} altrimenti.
    * <br/>
    * @d.esign Si vuole verificare che {@code isEmpty()} si appoggi al metodo isEmpty() di Vector e restituisca {@code true} quando la lista è vuota, altrimenti {@code false} se contiene almeno un elemento.
     * <br/>
     * @d.escription Si suppongono testati e funzionanti il metodo {@code size()}, {@code clear()}, poi:<br/>
     * 1. Si controlla che la collezione inizialmente non sia vuota, isEmpty() restituisce false, e che abbia la dimensione 4.<br/>
     * 2. Si svuota la collezione.<br/>
     * 3. Si verifica che isEmpty() restituisca true e che abbia dimensione 0.<br/>
     * 
     * @p.recond La lista ha 4 elementi.<br/>
     * 
     * @p.ostcond La lista è vuota.<br/>
     * 
     * @r.esult {@code isEmpty()} deve restuire {@code true} se la lista è vuota, {@code false} altrimenti.<br/>
     */
	@Test
	public void testEmpty(){
		assertFalse("La lista è vuota", list.isEmpty());
		assertEquals("La dimensione dalla lista non è 4", 4, list.size());
		list.clear();
		assertTrue("La lista non è vuota", list.isEmpty());
		assertEquals("La dimensione dalla lista non è 0", 0, list.size());
	}
	
	//TEST SU SIZE
	/**
    * Test del metodo {@link myAdapter.ListAdapter#size() size} su una lista di 4 elementi e poi svotata.
    * <br/>
    * @s.ummary Verifica che il metodo {@code size()} ritorna correttamente la dimensione della lista.
    * <br/>
    * @d.esign Si verifica che {@code size()} si appoggi correttamente al metodo size() di Vector e ritorni la dimensione della lista.
    * <br/>
    * @d.escription Si suppongono testati e funzionanti il metodo {@code isEmpty()}, {@code clear()}, e poi:<br/>
    * 1. Si controlla che la lista sia della stessa dimensione corretta, {@code 4}.<br/>
    * 2. Si svuota la lista.<br/>
    * 3. Si controlla che la dimensione diventi {@code 0}.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista è vuota.<br/>
    * 
    * @r.esult {@code size()} deve restuire la dimensione della lista, ovvero il numero degli elementi che la lista contiene.<br/>
    */
	@Test
	public void testSize(){
	   assertFalse("La lista è vuota", list.isEmpty());
		assertTrue("La lista non ha dimensione 4", list.size()==4);
		list.clear();
		assertTrue("La lista è non vuota", list.isEmpty());
		assertTrue("La lista non ha dimensione 0", list.size()==0);
	}
	
	//TEST SU CLEAR
	/**
    * Test del metodo {@link myAdapter.ListAdapter#clear() clear} su una lista di 4 elementi e poi vuota.
    * <br/>
    * @s.ummary Verifica che la lista venga svuotata correttamente
    * <br/>
    * @d.esign Si vuole verificare che il metodo {@code clear()} rimuova correttamente tutti gli elementi presenti con conseguente azzeramento della dimensione della lista. 
    * <br/>
    * @d.escription Si suppongono testati e funzionanti i metodi {@code isEmpty()}, {@code size()}, poi:<br/>
    * 1. Si controlla che la collezione non sia vuota all'inizio.<br/>
    * 2. Si chiama il metodo clear() e si svuota la collezione.<br/>
    * 3. Si controlla che la collezione sia vuota e di dimensione {@code 0}.<br/>
    * 4. Si controlla che alla chiamata del metodo clear() su collezione vuota, il controllo fatto al punto 3 non cambia.<br/>
    * 
    * @p.recond La ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista è vuota.<br/>
    * 
    * @r.esult {@code clear())} svuota la lista, rendendola di dimensione {@code 0}.<br/>
    */
	@Test
	public void testClear(){
	   assertTrue("Dimensione della lista non è quattro prima clear", list.size()==4);
	   assertFalse("La lista prima clear è vuota", list.isEmpty());
	   list.clear();
	   assertTrue("Dimensione della lista non è zero dopo primo clear", list.size()==0);
	   assertTrue("La lista dopo primo clear non è vuota", list.isEmpty());
	   list.clear();
	   assertTrue("Dimensione della lista non è zero dopo secondo clear", list.size()==0);
	   assertTrue("La lista dopo secondo clear non è vuota", list.isEmpty());
	}
		
   //TEST SU ADD
	/**
    * Test del metodo {@link myAdapter.ListAdapter#add(Object o) add} nel caso di argomento {@code null}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code add(Object o)} lancia {@link NullPointerException} se fornito un argomento {@code null}.
    * <br/>
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code add(Object o)} nel caso di argomento {@code null} venga correttamente lanciata l'eccezione {@link NullPointerException}.   
    * <br/>
    * @d.escription Si esegue direttamente il metodo add fornendo come argomento null e si verifica che venga lanciata un'eccezione NullPointerException.
    * <br/>
    * @p.recond La lista ha 4 elementi.
    * <br/>
    * @p.ostcond La lista rimane invariata.
    * <br/>
    * @r.esult {@code add(Object o)} deve lanciare {@link NullPointerException} se chiamata con argomento {@code null}.
    */
   @Test(expected = NullPointerException.class)
   public void testAdd1(){
      list.add(null);
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#add(Object o) add} su una lista contenente 4 elementi e poi svuotata.
    * <br/>
    * @s.ummary Verifica che il corretto funzionamento del metodo {@code add(Object o)} su una lista, aggiungendo uno o più elementi.
    * <br/>
    * @d.esign Si verifica che il metodo {@code add(Object o)} si appoggi correttamente al metodo add(Object o) di Vector e che restituisca {@code true} se l'oggetto posto come argomento viene inserito correttamente. 
    * <br/>
    * @d.escription Si suppone testati e funzionanti i metodi {@code clear()}, {@code size()}, e poi:<br/>
    * 1. Si aggiunge un elemento alla lista.<br/>
    * 2. Si verifica che add(Object o) restituisca true e che la dimensione sia incrementata di 1, {@code 5}.<br/>
    * 3. Si svuota la lista e si aggiungono 2 elementi.<br/>
    * 4. Si verifica che i due add(Object o) restituiscano true e che la dimensione della lista sia {@code 2}.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista ha 2 elementi.<br/>
    * 
    * @r.esult {@code add(Object o)} deve restituire {@code true} se l'elemento è stato inserito nella lista correttamente.<br/>
    */
	@Test
	public void testAdd2(){
	   assertTrue("Elemento non aggiunto correttamente", list.add("E"));
	   assertTrue("Dimensione della lista non è 5 dopo un add", list.size()==5);
	   list.clear();
	   assertTrue("Elemento non aggiunto correttamente", list.add("A"));
	   assertTrue("Elemento non aggiunto correttamente", list.add("B"));
	   assertTrue("Dimensione della lista non è 2 dopo 2 add", list.size()==2);
	}
	
	/**
    * Test del metodo {@link myAdapter.ListAdapter#add(int index, Object o) add} nel caso in cui come parametro ho l'oggetto {@code null}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code add(int index, Object o)} lancia {@link NullPointerException} se forniti come parametri un indice valido e un oggetto {@code null}.
    * <br/>
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code add(int index, Object o)} nel caso in cui i parametri siano l'indice valido ed l'oggetto {@code null} venga correttamente lanciata l'eccezione {@link NullPointerException}.
    * <br/>
    * @d.escription Si esegue direttamente il metodo add(int index, Object o) fornendo come argomenti indice ed null e si verifica che venga lanciata un'eccezione NullPointerException.
    * <br/>
    * @p.recond La lista ha 4 elementi.
    * <br/>
    * @p.ostcond La lista rimane invariata.
    * <br/>
    * @r.esult {@code add(int index, Object o)} deve lanciare {@link NullPointerException} se chiamata con argomenti indice valido ed oggetto {@code null}.<br/>
    */
   @Test(expected = NullPointerException.class)
   public void testAdd3(){
      list.add(2, null);
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#add(int index, Object o) add} nel caso in cui come parametro ho indice negativo.
    * <br/>
    * @s.ummary Verifica che il metodo {@code add()} lancia {@link IndexOutOfBoundsException} se forniti come parametri un indice negativo e un oggetto.
    * <br/>
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code add(int index, Object o)} nel caso in cui i parametri siano l'indice negativo ed l'oggetto venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo add(int index, Object o) fornendo come argomenti indice negativo e l'oggetto e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code add(int index, Object o)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con argomenti indice negativo ed oggetto.<br/>
    */
   @Test(expected = IndexOutOfBoundsException.class)
   public void testAdd4(){
      list.add(-1, "E");
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#add(int index, Object o) add} nel caso in cui come parametro ho indice maggiore della dimensione della lista.
    * <br/>
    * @s.ummary Verifica che il metodo {@code add(int index, Object o)} lancia {@link IndexOutOfBoundsException} se forniti come parametri un indice maggiore della dimensione della lista e un oggetto.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code add(int index, Object o)} nel caso in cui i parametri siano l'indice maggiore della dimensione della lista ed l'oggetto venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo add(int index, Object o) fornendo come argomenti indice maggiore della dimensione della lista e l'oggetto e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code add(int index, Object o)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con argomenti indice maggiore della dimensione della lista ed oggetto.<br/>
    */
   @Test(expected = IndexOutOfBoundsException.class)
   public void testAdd5(){
      list.add(6, "E");
   } 
	
	/**
    * Test del metodo {@link myAdapter.ListAdapter#add(int index, Object o) add} su una lista contenente 4 elementi e poi svuotata nel caso in cui come parametri ho un indice valido e un oggetto non null.
    * <br/>
    * @s.ummary Verifica che il corretto funzionamento del metodo {@code add(int index, Object o)} su una lista, aggiungendo uno o più elementi agli indici specificati.<br/>
    * 
    * @d.esign Si verifica che il metodo {@code add(int index, Object o)} si appoggi correttamente al metodo insertElementAt(int index, Object o) di Vector.<br/>
    * 
    * @d.escription Si suppone testato e funzionante i metodi {@code clear()}, {@code size()}, {@code get(Object o)}, e poi:<br/>
    * 1. Si aggiunge un elemento alla lista con add(int index, Object o).<br/>
    * 2. Si verifica che la dimensione sia incrementata di 1, {@code 5}.<br/>
    * 3. Si svuota la lista e si aggiungono 2 elementi con 2 add(int index, Object o).<br/>
    * 4. Si verifica che la dimensione della lista sia {@code 2}.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista ha 2 elementi.<br/>
    * 
    * @r.esult {@code add(int index, Object o)} non deve ritornare nulla se i parametri sono un indice valido e un oggetto non null.<br/>
    */
	@Test
	public void testAdd6(){
	   list.add(1, "E");
	   assertTrue("Dimensione della lista non è 5 dopo un add", list.size()==5);
	   assertEquals("Secondo elemento non è E", "E", list.get(1));
	   assertEquals("Terzo elemento non è B", "B", list.get(2));
	   list.clear();
	   list.add(0, "B");
	   list.add(1, "C");
	   assertTrue("Dimensione della lista non è 2 dopo 2 add", list.size()==2);
	   assertEquals("Primo elemento non è B", "B", list.get(0));
	   assertEquals("Secondo elemento non è C", "C", list.get(1));
	}
	
	//TEST SU ADDALL
	/**
    * Test del metodo {@link myAdapter.ListAdapter#addAll(HCollection c) addAll} nel caso di argomento {@code null}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code addAll(HCollection c)} lancia {@link NullPointerException} se fornito un argomento {@code null}.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code addAll(HCollection c)} nel caso di argomento {@code null} venga correttamente lanciata l'eccezione {@link NullPointerException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo addAll(HCollection c) fornendo come argomento null e si verifica che venga lanciata un'eccezione NullPointerException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code addAll(HCollection c)} deve lanciare {@link NullPointerException} se chiamata con argomento {@code null}.<br/>
    */
   @Test(expected = NullPointerException.class)
   public void testAddAll1(){
      list.addAll(null);
   }
   
	/**
    * Test del metodo {@link myAdapter.ListAdapter#addAll(HCollection c) addAll} su una lista contenente 4 elementi e poi svuotata.
    * <br/>
    * @s.ummary Verifica che il corretto funzionamento del metodo {@code addAll(HCollection c)} su una lista in cui aggiungo una collezione (lista) di elementi.
    * <br/>
    * @d.esign Si verifica che il metodo {@code addAll(HCollection c)} si appoggi correttamente al metodo add(Object o) e che restituisca {@code true} se tutti gli oggetti della collezione posta come argomento vengono inseriti correttamente.<br/>
    * 
    * @d.escription Si suppone testati e funzionanti i metodi {@code clear()}, {@code size()}, e poi:<br/>
    * 1. Si aggiunge una collezione di 2 elementi alla lista.<br/>
    * 2. Si verifica che addAll(HCollection c) restituisca true e che la dimensione sia incrementata di 2, {@code 6}.<br/>
    * 3. Si svuota la lista e si aggiunge un'altra collezione di 3 elementi.<br/>
    * 4. Si verifica che addAll(HCollection c) restituisca true e che la dimensione della lista sia {@code 3}.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista ha 3 elementi.<br/>
    * 
    * @r.esult {@code addAll(HCollection c)} deve restituire {@code true} se tutti gli elementi della collezione vengono inseriti correttamente nella lista.<br/>
    */
	@Test
	public void testAddAll2(){
	   HList coll = new ListAdapter();
	   coll.add("E");
	   coll.add("F");
	   assertTrue("Elemento non aggiunto correttamente", list.addAll(coll));
	   assertTrue("Dimensione della lista non è 6 dopo addAll", list.size()==6);
	   list.clear();
	   coll.add("G");
	   assertTrue("Collezione non aggiunto correttamente", list.addAll(coll));
	   assertTrue("Dimensione della lista non è 3 dopo addAll", list.size()==3);
	}

   /**
    * Test del metodo {@link myAdapter.ListAdapter#addAll(int index, HCollection c) addAll} nel caso in cui come parametro ho indice negativo.
    * <br/>
    * @s.ummary Verifica che il metodo {@code addAll(int index, HCollection c)} lancia {@link IndexOutOfBoundsException} se forniti come parametri un indice negativo e una collezione non {@code null}.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code addAll(int index, HCollection c)} nel caso in cui i parametri siano l'indice negativo ed la collezione venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo addAll(int index, HCollection c) fornendo come argomenti indice negativo e la collezione e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code addAll(int index, HCollection c)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con argomenti indice negativo e collezione.<br/>
    */
   @Test(expected = IndexOutOfBoundsException.class)
   public void testAddAll3(){
      HList coll = new ListAdapter();
	   coll.add("E");
	   coll.add("F");
      list.add(-1, coll);
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#addAll(int index, HCollection c) addAll} nel caso in cui come parametro ho indice maggiore della dimensione della lista.
    * <br/>
    * @s.ummary Verifica che il metodo {@code addAll(int index, HCollection c)} lancia {@link IndexOutOfBoundsException} se forniti come parametri un indice maggiore della dimensione della lista e una collezione non {@code null}.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code addAll(int index, HCollection c)} nel caso in cui i parametri siano l'indice maggiore della dimensione della lista ed la collezione venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo addAll(int index, HCollection c) fornendo come argomenti indice maggiore della dimensione della lista e la collezione e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code addAll(int index, HCollection c)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con argomenti indice maggiore della dimensione della lista e collezione.<br/>
    */
   @Test(expected = IndexOutOfBoundsException.class)
   public void testAddAll4(){
      HList coll = new ListAdapter();
	   coll.add("E");
	   coll.add("F");
      list.add(7, coll);
   } 

	/**
    * Test del metodo {@link myAdapter.ListAdapter#addAll(int index, HCollection c) addAll} nel caso di argomenti indice valido e collezione {@code null}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code addAll(int index, HCollection c)} lancia {@link NullPointerException} se forniti come argomenti un indice valido e una collezione {@code null}.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code addAll(int index, HCollection c)} nel caso di argomento {@code null} venga correttamente lanciata l'eccezione {@link NullPointerException}.<br/>    
    * 
    * @d.escription Si esegue direttamente il metodo addAll fornendo come argomenti indice valido e collezione null e si verifica che venga lanciata un'eccezione NullPointerException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code addAll(int index, HCollection c)} deve lanciare {@link NullPointerException} se chiamata con argomenti indice valido e collezione {@code null}.<br/>
    */
   @Test(expected = NullPointerException.class)
   public void testAddAll5(){
      list.addAll(3, null);
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#addAll(int index, HCollection c) addAll} su una lista contenente 4 elementi e poi svuotata nel caso in cui come parametri ho un indice valido e una collezione non null.
    * <br/>
    * @s.ummary Verifica che il corretto funzionamento del metodo {@code addAll(int index, HCollection c)} su una lista, aggiungendo una colleziona all'indice specificato.
    * <br/>
    * @d.esign Si verifica che il metodo {@code addAll(int index, HCollection c)} si appoggi correttamente al metodo add(int index, Object o).<br/> 
    * 
    * @d.escription Si suppone testato e funzionante i metodi {@code clear()}, {@code size()}, {@code get(Object o)}, e poi:<br/>
    * 1. Si crea una nuova lista e aggiungono 2 elementi.<br/>
    * 2. Si aggiunge alla lista chiamante la nuova lista con addAll(int index, HCollection c).<br/>
    * 3. Si verifica che la dimensione sia {@code 6} e che gli elementi siano corretti con get(Object o).<br/>
    * 4. Si svuota la lista chiamante.<br/>
    * 5. aggiunge alla lista chiamante la nuova lista con addAll(int index, HCollection c).<br/>
    * 6. Si verifica che la dimensione sia {@code 2} e che gli elementi siano corretti con get(Object o).<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista ha 2 elementi.<br/>
    * 
    * @r.esult {@code addAll(int index, HCollection c)} deve ritornare {@code true} se gli elementi della collezione vengono inseriti correttamente, {@code false} altrimenti.<br/>
    */
	@Test
	public void testAddAll6(){
	   HList coll = new ListAdapter();
	   coll.add("E");
	   coll.add("F");
	   assertTrue("Nuova lista non aggiunta correttamente", list.addAll(1, coll));
	   assertEquals("A", list.get(0));
      assertEquals("E", list.get(1));
      assertEquals("F", list.get(2));
      assertEquals("B", list.get(3));
      assertEquals("C", list.get(4));
      assertEquals("D", list.get(5));
	   assertTrue("Dimensione della lista non è 6 dopo addAll", list.size()==6);
	   list.clear();
	   assertTrue("Nuova lista non aggiunta correttamente", list.addAll(0, coll));
	   assertEquals("E", list.get(0));
      assertEquals("F", list.get(1));
	   assertTrue("Dimensione della lista non è 2 dopo clear e addAll", list.size()==2);
	}	
	
	//TEST SU REMOVE
	/**
    * Test del metodo {@link myAdapter.ListAdapter#remove(Object o) remove} quando l'argomento fornito e' {@code null}. 
    * <br/>
    * @s.ummary Verifica che venga lanciata l'eccezione {@link NullPointerException} quando l'oggetto fornito e' {@code null}.<br/>
    * 
    * @d.esign Si vuole verificare che il metodo {@code remove(Object o)} lanci correttamente {@link NullPointerException} quando l'argomento fornito e' {@code null}.<br/> 
    * 
    * @d.escription Si chiama direttamente remove(null) sulla lista e si verifica il corretto lancio di NullPointerException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista e' rimasta invariata.<br/>
    * 
    * @r.esult {@code remove(Object o)} deve lanciare {@link NullPointerException} quando l'argomento e' {@code null}.<br/>
    */
   @Test(expected = NullPointerException.class)
   public void testRemove1(){
       list.remove(null);
   }
	
	/**
    * Test del metodo {@link myAdapter.ListAdapter#remove(Object o) remove} con argomento oggetto presente e non dalla lista. 
    * <br/>
    * @s.ummary Verifica la corretta rimozione di un elemento dalla lista, se presente.
    * <br/>
    * @d.esign Si verifica che il metodo {@code remove(Object o)} restituisca correttamente {@code true} quando l'oggetto specificato e' presente nella lista e viene rimosso correttamente, {@code false} altrimenti se non presente.<br/>
    * 
    * @d.escription Si suppongono testati e funzionanti i metodi {@code contains(Object o)}, {@code size()}, e poi:<br/>
    * 1. Si verifica che la lista contenga un elemento noto.<br/>
    * 2. Si invoca remove(Object o) usando come argomento l'elemento noto e si verifica che restituisca {@code true}.<br/>
    * 3. Si verifica che l'elemento noto non sia piu' presente nella lista.<br/>
    * 4.  Si invoca remove() usando come argomento un elemento non presente nella lista e si verifica che restituisca {@code false}.<br/> 
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista ha 3 elementi.<br/>
    * 
    * @r.esult {@code remove(Object o)} verifica se l'elemento specificato e' presente nella lista, se presente ritorna {@code true} e lo rimuove, altrimenti ritorna {@code false}.<br/>
    */
	@Test
	public void testRemove2(){
	   assertTrue("La lista non contiene A", list.contains("A"));
	   assertTrue("Elemento non rimosso correttamente", list.remove("A"));
	   assertFalse("La lista contiene A", list.contains("A"));
	   assertFalse("Elemento rimosso correttamente", list.remove("A"));
	   assertTrue("Dimensione della lista non è 3 dopo remove", list.size()==3);
	}
	
	/**
    * Test del metodo {@link myAdapter.ListAdapter#remove(int index) remove} nel caso in cui come parametro ho indice negativo.
    * <br/>
    * @s.ummary Verifica che il metodo {@code remove(int index)} lancia {@link IndexOutOfBoundsException} se fornito come parametro un indice negativo.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code remove(int index)} nel caso in cui il parametro sia un indice negativo venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo remove(int index) fornendo come argomento un indice negativo e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code remove(int index)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con argomento indice negativo.<br/>
    */
   @Test(expected = IndexOutOfBoundsException.class)
   public void testRemove3(){
      list.remove(-3);
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#remove(int index) remove} nel caso in cui come parametro ho indice maggiore della dimensione della lista.
    * <br/>
    * @s.ummary Verifica che il metodo {@code remove(int index)} lancia {@link IndexOutOfBoundsException} se fornito come parametro un indice maggiore della dimensione della lista.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code remove(int index)} nel caso in cui il parametro sia un indice maggiore della dimensione della lista venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo remove(int index) fornendo come argomento un indice maggiore della dimensione della lista e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code remove(int index)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con argomento indice maggiore della dimensione della lista.<br/>
    */
   @Test(expected = IndexOutOfBoundsException.class)
   public void testRemove4(){
      list.remove(5);
   }
		
	/**
    * Test del metodo {@link myAdapter.ListAdapter#remove(int index) remove} con argomento indice valido dell'elemento da rimuovere dalla lista. 
    * <br/>
    * @s.ummary Verifica la corretta rimozione di un elemento dalla lista nell'indice specificato come parametro.<br/>
    * 
    * @d.esign Si verifica che il metodo {@code remove(int index)} restituisca correttamente l'oggetto rimosso all'indice specificato nella lista e che l'ogetto venga rimosso correttamente.<br/>
    * 
    * @d.escription Si suppone testato e funzionante il metodo {@code size()}, e poi:<br/>
    * 1. Si invoca remove(int index) usando come argomento un indice valido e si verifica che restituisca l'oggetto rimosso all'indice specificato.<br/>
    * 2. Si verifica che la dimensione della lista sia decrementata di 1, {@code 3}.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista ha 3 elementi.<br/>
    * 
    * @r.esult {@code remove(int index)} restituisce l'oggetto rimosso se fornito come parametro un indice valido.<br/>
    */
	@Test
	public void testRemove5(){
	   assertEquals("L'elemento rimosso non è A", "A", list.remove(0));
	   assertTrue("Dimensione della lista non è 3 dopo remove", list.size()==3);
	}
	
	//TEST SU REMOVEALL
	/**
    * Test del metodo {@link myAdapter.ListAdapter#removeAll(HCollection c) removeAll} nel caso di argomento {@code null}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code removeAll(HCollection c)} lancia {@link NullPointerException} se fornito un argomento {@code null}.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code removeAll(HCollection c)} nel caso di argomento {@code null} venga correttamente lanciata l'eccezione {@link NullPointerException}.<br/>    
    * 
    * @d.escription Si esegue direttamente il metodo removeAll(HCollection c) fornendo come argomento null e si verifica che venga lanciata un'eccezione NullPointerException.
    * <br/>
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code removeAll(HCollection c)} deve lanciare {@link NullPointerException} se chiamata con argomento {@code null}.<br/>
    */
   @Test(expected = NullPointerException.class)
   public void testRemoveAll1(){
      list.removeAll(null);
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#removeAll(HCollection c) removeAll} quando la lista e la collezione (lista) hanno elementi in comune. 
    * <br/>
    * @s.ummary Verifica la corretta rimozione di un'intera collezione dalla lista di partenza, se hanno elementi in comune.<br/>
    * 
    * @d.esign Si vuole verificare che il metodo {@code removeAll(HCollection c)} restituisca correttamente {@code true} quando la collezione specificata contiene anche elementi presenti nella lista e ne li rimuove, {@code false} se non hanno elementi in comune.<br/>
    *
    * @d.escription Si suppongono testati e funzionanti i metodi {@code size()}, {@code add()}, {@code contains()}, e poi:<br/>
    * 1. Si crea una nuova lista.<br/>
    * 2. Si aggiungono due elementi alla nuova lista in modo che le due liste abbiano questi due elementi in comune.<br/>
    * 3. Si verifica che alla chiamata removeAll(HCollection c) usando come argomento la nuova lista il metodo restituisca true.<br/>
    * 4. Si verifica che la lista di partenza contiene gli elementi non in comune con la nuova lista.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista ha 2 elementi.<br/>
    * 
    * @r.esult {@code removeAll(HCollection c)} deve restituire {@code true} se la lista viene modificata come risultato della chiamata del metodo e {@code false} altrimenti.<br/>
    */
   @Test
   public void testRemoveAll2(){
      HList removeList = new ListAdapter();
      removeList.add("A");
      removeList.add("C");
      assertTrue("Elementi di removeList non rimossi correttamente", list.removeAll(removeList));
      assertTrue("La lista non contiene B", list.contains("B"));
      assertTrue("La lista non contiene D", list.contains("D"));
      assertFalse("La lista contiene A", list.contains("A"));
      assertFalse("La lista contiene C", list.contains("C"));
      assertTrue("La lista non ha dimensione 2", list.size() == 2);
    }
    
    /**
    * Test del metodo {@link myAdapter.ListAdapter#removeAll(HCollection c) removeAll} quando la lista e la collezione (lista) non hanno elementi in comune. 
    * <br/>
    * @s.ummary Verifica che non avvenga la rimozione di un'intera collezione dalla lista di partenza, dato che non hanno elementi in comune.<br/>
    * 
    * @d.esign Si vuole verificare che il metodo {@code removeAll(HCollection c)} restituisca correttamente {@code true} quando la collezione specificata contiene anche elementi presenti nella lista e ne li rimuove, {@code false} se non hanno elementi in comune.<br/>
    *
    * @d.escription Si suppongono testati e funzionanti i metodi {@code size()}, {@code remove()}, {@code contains()}, e poi:<br/>
    * 1. Si crea una nuova lista.<br/>
    * 2. Si aggiungono due elementi alla nuova lista in modo che le due liste non abbiano questi elementi in comune.<br/>
    * 3. Si verifica che alla chiamata removeAll(HCollection c) usando come argomento la nuova lista il metodo restituisca false.<br/>
    * 4. Si verifica che la lista di partenza contiene gli elementi non in comune con la nuova lista, ovvero tutti.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code removeAll(HCollection c)} deve restituire {@code true} se la lista viene modificata come risultato della chiamata del metodo e {@code false} altrimenti.<br/>
    */
   @Test
   public void testRemoveAll3(){
      HList removeList = new ListAdapter();
      removeList.add("E");
      removeList.add("F");
      assertFalse("Elementi di removeList rimossi correttamente", list.removeAll(removeList));
      assertTrue("La lista non contiene A", list.contains("A"));
      assertTrue("La lista non contiene B", list.contains("B"));
      assertTrue("La lista non contiene C", list.contains("C"));
      assertTrue("La lista non contiene D", list.contains("D"));
      assertTrue("La lista non ha dimensione 4", list.size() == 4);
    }   
	
	//TEST SU RETAINALL
	/**
    * Test del metodo {@link myAdapter.ListAdapter#retainAll(HCollection c) retainAll} nel caso di argomento {@code null}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code retainAll(HCollection c)} lancia {@link NullPointerException} se fornito un argomento {@code null}.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code retainAll(HCollection c)} nel caso di argomento {@code null} venga correttamente lanciata l'eccezione {@link NullPointerException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo retainAll(HCollection c) fornendo come argomento null e si verifica che venga lanciata un'eccezione NullPointerException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code retainAll(HCollection c)} deve lanciare {@link NullPointerException} se chiamata con argomento {@code null}.<br/>
    */
   @Test(expected = NullPointerException.class)
   public void testRetainAll1(){
      list.retainAll(null);
   }
	
	/**
    * Test del metodo {@link myAdapter.ListAdapter#retainAll(HCollection c) retainAll} quando la collezione di partenza viene modificata dal metodo.
    * <br/>
    * @s.ummary Verifica la corretta rimozione da questa collezione di tutti gli elementi non presesenti nella collezione data come argomento.<br/>
    * 
    * @d.esign Si vuole verificare che il metodo {@code retainAll(HCollection c)} restituisca correttamente {@code true} quando la lista di partenza contiene anche elementi non presenti nella collezione specificata e rimuove tutte le istanze di questi elementi dalla lista di partenza, {@code false} se la collezione specificata contiene la lista di partenza.<br/>
    * 
    * @d.escription Si suppongono testati e funzionanti i metodi {@code containsAll(HCollection c)}, {@code size()}, {@code contains(Object o)}, e poi:<br/>
    * 1. Si crea una lista di supporto che ha alcuni elementi in comune con la lista di partenza.<br/>
    * 2. Si verifica che alla chiamata retainAll(HCollection c) usando come argomento la lista di supporto il risultato sia true.<br/>
    * 3. Si controlla che la dimensione della lista analizzata e' diminuita e che ora la lista di supporto la contiene.<br/>
    * 4. Si verifica che la lista di supporto contiene non solo la lista di partenza ma anche altri elementi.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista e' stata modificata.<br/>
    * 
    * @r.esult {@code retainAll(HCollection c)} deve restituire {@code true} se la lista viene modificata come risultato della chiamata del metodo e {@code false} altrimenti.<br/>
    */
   @Test
   public void testRetainAll2(){
     HList list2 = new ListAdapter();
     list2.add("B");
     list2.add("C");
     list2.add("F");
     assertTrue("La lista di partenza non viene modificata", list.retainAll(list2));
     assertTrue("La dimensione della lista non è 2", list.size() == 2);          
     assertTrue("Le due liste non sono uguali", list2.containsAll(list));   
     assertTrue("Le due liste non contengono A", list.contains("A") == list2.contains("A")); 
     assertTrue("Le due liste non contengono A", list.contains("D") == list2.contains("D"));
     assertTrue("Le due liste contengono entrambe F", !list.contains("F") == list2.contains("F"));  
   }

   /**
    * Test del metodo {@link myAdapter.ListAdapter#retainAll(HCollection) retainAll} quando la collezione specificata contiene la lista chiamante. 
    * <br/>
    * @s.ummary Verifica che se la collezione specificata contiene la lista chiamante il metodo {@code removeAll(HCollection c)} restituisce {@code false} e la lista di partenza non cambia.<br/>
    * 
    * @d.esign Si vuole verificare che il metodo {@code containsAll(HCollection c)} restituisca correttamente {@code false} quando la collezione specificata contiene la lista chiamante.<br/>
    * 
    * @d.escription Si suppone testato e funzionante il metodo {@code containsAll(HCollection c)}, e poi:<br/>
    * 1. Si crea una lista copia della lista di partenza.<br/>
    * 2. Si verifica che la lista copia contiene la lista di partenza.<br/>
    * 3. Si verifica che alla chiamata del metodo retainAll() usando come argomento la lista copia ritorni false.<br/>
    * 4. Si verifica che le due liste siano ancora uguali.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista è rimasta invariata.<br/>
    * 
    * @r.esult {@code retainAll(HCollection c)} deve restituire {@code false} se la collezione specificata contiene la lista chiamante.<br/>
    */
   @Test
   public void testRetainAll3(){
      HList list2 = new ListAdapter(list);
      assertTrue("Le due liste non sono uguali", list.containsAll(list2));
      assertFalse("La lista di partenza viene modificata", list.retainAll(list));
      assertEquals("Le due liste non sono uguali", list, list2); 
   }

   /**
    * Test del metodo {@link myAdapter.ListAdapter#retainAll(HCollection c) retainAll} quando la collezione data come argomento e' vuota.
    * <br/>
    * @s.ummary Verifica il corretto funzionamento del metodo retainAll quando si cerca di mantere una collezione vuota nella lista di partenza.<br/>
    * 
    * @d.esign Si vuole verificare che il metodo {@code retainAll(HCollection c)} restituisca correttamente {@code true} quando la collezione data come argomento e' vuota che al termine della chiamata del metodo la lista di partenza sia vuota.<br/>
    * 
    * @d.escription Si suppone testato e funzionante il metodo {@code isEmpty()}, e poi:<br/>
    * 1. Si crea una lista vuota.<br/>
    * 2. Si chiama il metodo retainAll(HCollection c) usando come argomento la lista vuota e si verifica restituisca true.<br/>
    * 3. Si verifica che la lista di partenza sia vuota.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista e' vuota.<br/>
    * 
    * @r.esult {@code retainAll(HCollection c)} deve restituire {@code true} se lista specificata come argomento e' vuota, infatti si svuota.<br/>
    */
   @Test
   public void testRetainAll4(){
      HList list2 = new ListAdapter();
      assertTrue("La lista di partenza non viene modificata", list.retainAll(list2));
      assertTrue("La lista non è vuota", list.isEmpty());
   }
	
	//TEST SU CONTAINS
	/**
    * Test del metodo {@link myAdapter.ListAdapter#contains(Object o) contains} nel caso di argomento {@code null}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code contains(Object o)} lancia {@link NullPointerException} se fornito un argomento {@code null} come parametro.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code contains(Object o)} nel caso di argomento {@code null} venga correttamente lanciata l'eccezione {@link NullPointerException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo contains(Object o) fornendo come argomento null e si verifica che venga lanciata un'eccezione NullPointerException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code contains(Object o)} deve lanciare {@link NullPointerException} se chiamata con argomento {@code null}.<br/>
    */
   @Test(expected = NullPointerException.class)
   public void testContains1(){
      list.contains(null);
   }
	
	/**
    * Test del metodo {@link myAdapter.ListAdapter#contains(Object o) contains} su una lista contenente 4 elementi e poi svuotata.
    * <br/>
    * @s.ummary Verifica che il corretto funzionamento del metodo {@code contains(Object o)} su una lista, cercando elementi che possono o meno essere presenti.<br/>
    * 
    * @d.esign Si verifica che il metodo {@code contains(Object o)} si appoggi correttamente al metodo contains(Object o) di Vector e che restituisca {@code true} se il valore posto come argomento è presente nella lista, {@code false} altrimenti. 
    * <br/>
    * @d.escription Si suppone testato e funzionante il metodo {@code clear()}, e poi:<br/>
    * 1. Si verifica che contains(Object o) restituisca true per un oggetto presente nella lista, con cui è stata popolata in fase di setUp.<br/>
    * 2. Si verifica che contains(Object o) restituisca false per un oggetto non presente nella lista.<br/>
    * 4.  Si svuota la lista e si verifica che contains(Object o) restituisca false per qualsiasi oggetto dato che la lista è vuota.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista è vuota.<br/>
    * 
    * @r.esult {@code contains(Object o)} deve restituire {@code true} se l'argomento è presente nella collezione, {@code false} altrimenti.<br/>
    */
	@Test
	public void testContains2(){
	   assertTrue("A non è presente nella lista", list.contains("A"));
	   assertFalse("L è presente nella lista", list.contains("L"));
	   list.clear();
	   assertFalse("Un oggetto qualsiasi è presente nella lista", list.contains(new Object()));
	}
	
	//TEST SU CONTAINSALL
	/**
    * Test del metodo {@link myAdapter.ListAdapter#containsAll(HCollection c) containsAll} nel caso di argomento {@code null}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code containsAll(HCollection c)} lancia {@link NullPointerException} se fornito un argomento {@code null}.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code containsAll(HCollection c)} nel caso di argomento {@code null} venga correttamente lanciata l'eccezione {@link NullPointerException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo containsAll(HCollection c) fornendo come argomento null e si verifica che venga lanciata un'eccezione NullPointerException.
    * <br/>
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code containsAll(HCollection c)} deve lanciare {@link NullPointerException} se chiamata con argomento {@code null}.<br/>
    */
   @Test(expected = NullPointerException.class)
   public void testContainsAll1(){
      list.containsAll(null);
   }
	
	/**
    * Test del metodo {@link myAdapter.ListAdapter#containsAll(HCollection c) containsAll}.
    * <br/>
    * @s.ummary Verifica che venga il metodo {@code containsAll(HCollection c)} si comporti nel modo atteso sia nel caso gli elementi siano tutti contenuti che non.<br/>
    * 
    * @d.esign Si verifica che il metodo {@code containsAll(HCollection c)} verifichi correttamente la presenza di una collezione di oggetti al suo interno restituendo {@code true} se tutti gli elementi della collezione specificata sono contenuti nella collezione chiamante, {@code false} quando anche un solo oggetto dovesse mancare.<br/>
    * 
    * @d.escription Si suppone testato e funzionante il metodo {@code add}, e poi:<br/>
    * 1. Si istanzia una nuova lista vuota.<br/>
    * 2. Si chiama containsAll(HCollection c) usando come argomento la nuova lista vuota e si verifica che il metodo restituisca true.<br/>
    * 3. Si aggiungono 2 elementi alla nuova lista presenti nella lista.<br/>
    * 4. Si chiama containsAll(HCollection c) usando come argomento la lista chiamante appena riempita e si verifica che restituisca true.<br/>
    * 5. Si aggiunge un ulteriore elemento alla nuova lista, che non appartiene anche alla lista chiamante.<br/>
    * 6. Si chiama containsAll(HCollection c) usando come argomento la nuova lista ora contenente un elemento non contenuto nella collezione chiamante.<br/>
    * 7. Si verifica che il metodo restituisca false in quanto non tutti gli elementi della nuova lista sono contenuti nella lista chiamante.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista è rimasta invariata.<br/>
    * 
    * @r.esult Il metodo {@code containsAll(HCollection c)} deve restituire {@code false} se manca anche solo un oggetto, {@code true} se tutti gli oggetti sono presenti.<br/>
    */
   @Test
   public void testContainsAll2(){
      HList newList = new ListAdapter();
      assertTrue("La lista non contiene la nuova lista vuota", list.containsAll(newList));
      newList.add("B");
      newList.add("C"); 
      assertTrue("La lista non contiene la nuova lista di elementi B e C", list.containsAll(newList));
      newList.add("F");
      assertFalse("La lista contiene la nuova lista di elementi B, C e F", list.containsAll(newList));
   }
	
	//TEST SU GET
	/**
    * Test del metodo {@link myAdapter.ListAdapter#get(int index) get} nel caso in cui come parametro ho indice negativo.
    * <br/>
    * @s.ummary Verifica che il metodo {@code get(int index)} lancia {@link IndexOutOfBoundsException} se fornito come parametro un indice negativo.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code get(int index)} nel caso in cui il parametro sia un indice negativo venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo get(int index) fornendo come argomento un indice negativo e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code get(int index)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con argomento indice negativo.<br/>
    */
   @Test(expected = IndexOutOfBoundsException.class)
   public void testGet1(){
      list.get(-2);
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#get(int index) get} nel caso in cui come parametro ho indice maggiore della dimensione della lista.
    * <br/>
    * @s.ummary Verifica che il metodo {@code get(int index)} lancia {@link IndexOutOfBoundsException} se fornito come parametro un indice maggiore della dimensione della lista.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code get(int index)} nel caso in cui il parametro sia un indice maggiore della dimensione della lista venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo get(int index) fornendo come argomento un indice maggiore della dimensione della lista e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code get(int index)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con argomento indice maggiore della dimensione della lista.<br/>
    */
   @Test(expected = IndexOutOfBoundsException.class)
   public void testGet2(){
      list.get(6);
   }
	
	 /**
    * Test del metodo {@link myAdapter.ListAdapter#get(int index) get} nel caso in cui come parametro ho indice valido relativo alla lista.
    * <br/>
    * @s.ummary Verifica che il metodo {@code get(int index)} restituisca l'oggetto all'indice specificato.<br/>
    * 
    * @d.esign Si verifica che alla chiamata del metodo {@code get(int index)} nel caso in cui il parametro sia un indice valido venga correttamente restituito il corrispondente oggetto nella lista.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo get(int index) fornendo come argomento un indice valido e si verifica che venga restituito correttamente l'oggetto corrispondente e che venga solo mostrato e non rimosso dalla lista. Si presuppone testato e funzionante il metodo {@code size()}.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code get(int index)} deve ritornare l'elemento della lista corrispondente all'indice passato come argomento.<br/>
    */
	@Test
	public void testGet3(){
	   assertEquals("L'elemento di indice 1 non è B", "B", list.get(1));
	   assertNotEquals("L'elemento di indice 0 è B", "B", list.get(0));
	   assertTrue("La dimensione della lista non è 4", list.size()==4);
	}
	
	//TEST SU SET
	/**
    * Test del metodo {@link myAdapter.ListAdapter#set(int index, Object o) set} nel caso in cui come parametro ho indice negativo.
    * <br/>
    * @s.ummary Verifica che il metodo {@code set(int index, Object o)} lancia {@link IndexOutOfBoundsException} se fornito come parametro un indice negativo.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code set(int index, Object o)} nel caso in cui il parametro sia un indice negativo venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>    
    * 
    * @d.escription Si esegue direttamente il metodo set(int index, Object o) fornendo come argomento un indice negativo e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code set(int index, Object o)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con argomento indice negativo.<br/>
    */
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSet1(){
      list.set(-2, "E");
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#set(int index, Object o) set} nel caso in cui come parametro ho indice maggiore della dimensione della lista.
    * <br/>
    * @s.ummary Verifica che il metodo {@code set(int index, Object o)} lancia {@link IndexOutOfBoundsException} se fornito come parametro un indice maggiore della dimensione della lista.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code set(int index, Object o)} nel caso in cui il parametro sia un indice maggiore della dimensione della lista venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>  
    * 
    * @d.escription Si esegue direttamente il metodo set(int index, Object o) fornendo come argomento un indice maggiore della dimensione della lista e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code set(int index, Object o)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con argomento indice maggiore della dimensione della lista.<br/>
    */
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSet2(){
      list.set(6, "E");
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#set(int index, Object o) set} nel caso in cui come parametro ho l'oggetto {@code null}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code set(int index, Object o)} lancia {@link NullPointerException} se forniti come parametri un indice valido e un oggetto {@code null}.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code set(int index, Object o)} nel caso in cui i parametri siano l'indice valido ed l'oggetto {@code null} venga correttamente lanciata l'eccezione {@link NullPointerException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo set(int index, Object o) fornendo come argomenti indice ed oggetto null e si verifica che venga lanciata un'eccezione NullPointerException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code set(int index, Object o)} deve lanciare {@link NullPointerException} se chiamata con argomenti indice valido ed oggetto {@code null}.<br/>
    */
   @Test(expected = NullPointerException.class)
   public void testSet3(){
      list.set(2, null);
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#set(int index, Object o) get} nel caso in cui come parametro ho indice valido relativo alla lista ed un oggetto non null.
    * <br/>
    * @s.ummary Verifica che il metodo {@code set(int index, Object o)} sostituisca l'oggetto all'indice specificato della lista con quello fornito come parametro e restituisca l'oggetto che viene sostituito.<br/>
    * 
    * @d.esign Si verifica che alla chiamata del metodo {@code set(int index, Object o)} nel caso in cui i parametri siano un indice valido ed un oggetto non null avvenga la sostituzione correttamente e venga restituito l'oggetto che viene sostituito della lista.<br/>   
    * 
    * @d.escription Si esegue direttamente il metodo set(int index, Object o) fornendo come argomenti un indice valido e un oggetto non null. Poi si verifica che venga sostituito correttamente e venga restituito correttamente l'oggetto che viene sostituito della lista. Si presuppone testati e funzionanti i metodi {@code get()} e {@code size()}.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code set(int index, Object o)} deve ritornare l'elemento della lista che viene sostituito.<br/>
    */
	@Test
	public void testSet4(){
	   assertEquals("L'elemento di indice 1 non è B", "B", list.get(1));
	   list.set(1, "G");
	   assertEquals("L'elemento di indice 1 non è G", "G", list.get(1));
	   assertNotEquals("L'elemento di indice 1 è B", "B", list.get(1));
	   assertTrue("La dimensione della lista non è 4", list.size()==4);
	}	
		
	//TEST SU INDEXOF
	/**
    * Test del metodo {@link myAdapter.ListAdapter#indexOf(Object o) indexOf} nel caso di argomento {@code null}.<br/>
    * 
    * @s.ummary Verifica che il metodo {@code indexOf(Object o)} lancia {@link NullPointerException} se fornito un argomento {@code null} come parametro.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code indexOf(Object o)} nel caso di argomento {@code null} venga correttamente lanciata l'eccezione {@link NullPointerException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo indexOf(Object o) fornendo come argomento null e si verifica che venga lanciata un'eccezione NullPointerException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code indexOf(Object o)} deve lanciare {@link NullPointerException} se chiamata con argomento {@code null}.<br/>
    */
   @Test(expected = NullPointerException.class)
   public void testIndexOf1(){
      list.indexOf(null);
   }
   
	/**
    * Test del metodo {@link myAdapter.ListAdapter#indexOf(Object o) indexOf} nel caso in cui come parametro ho oggetto non null che appartiene o non alla lista
    * <br/>
    * @s.ummary Verifica che il metodo {@code indexOf(Object o)} restituisce l'indice della prima occorrenza dell'elemento specificato come parametro, o ritorna {@code -1} se l'elemento non è presente nella lista.<br/>
    * 
    * @d.esign Si verifica che alla chiamata del metodo {@code indexOf(Object o)} nel caso in cui il parametro sia un oggetto non null venga restituito l'indice della lista relativo all'oggetto specificato, se presente, altrimenti {@code -1}.<br/>   
    * 
    * @d.escription Si suppone testati e funzionanti i metodi {@code add()} e {@code clear()}, e poi:<br/>
    * 1. Si svuota la lista con il metodo clear().<br/>
    * 2. Si aggiungono 4 nuovi elementi con add(Object o), rispettivamente: A, A, B, B.<br/>
    * 3. Si verifica che chiamato il metodo indexOf(Object o) su B restituisca l'indice della prima occorrenza, ovvero {@code 2}.<br/>
    * 4. Si verifica che chiamato il metodo indexOf(Object o) su A non restituisca l'indice dell'ultima occorrenza, ovvero {@code 1}.<br/>
    * 5. Si verifica che chiamato il metodo indexOf(Object o) su un oggetto non appartenente alla lista restituisca {@code -1}.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista ha altri 4 elementi.<br/>
    * 
    * @r.esult {@code indexOf(Object o)} deve ritornare l'indice della lista che corrisponde alla prima occorrenza dell'oggetto passato come parametro se presente nella lista, {@code -1} altrimenti.<br/>
    */
	@Test
	public void testIndexOf2(){
	   list.clear();
	   list.add("A");
	   list.add("A");
	   list.add("B");
	   list.add("B");
	   assertEquals("Primo B non è in posizione 2", 2, list.indexOf("B"));
	   assertNotEquals("Primo A è in posizione 1", 1, list.indexOf("A"));
	   assertEquals("L'elemento C è nella lista", -1, list.indexOf("C"));
	}
	
	//TEST SU LASTINDEXOF
	/**
    * Test del metodo {@link myAdapter.ListAdapter#lastIndexOf(Object o) lastIndexOf} nel caso di argomento {@code null}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code lastIndexOf(Object o)} lancia {@link NullPointerException} se fornito un argomento {@code null} come parametro.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code lastIndexOf(Object o)} nel caso di argomento {@code null} venga correttamente lanciata l'eccezione {@link NullPointerException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo lastIndexOf(Object o) fornendo come argomento null e si verifica che venga lanciata un'eccezione NullPointerException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code lastIndexOf(Object o)} deve lanciare {@link NullPointerException} se chiamata con argomento {@code null}.<br/>
    */
   @Test(expected = NullPointerException.class)
   public void testLastIndexOf1(){
      list.indexOf(null);
   }
	
	/**
    * Test del metodo {@link myAdapter.ListAdapter#lastIndexOf(Object o) lastIndexOf} nel caso in cui come parametro ho oggetto non null che appartiene o non alla lista
    * <br/>
    * @s.ummary Verifica che il metodo {@code lastIndexOf(Object o)} restituisce l'indice dell'ultima occorrenza dell'elemento specificato come parametro, o ritorna {@code -1} se l'elemento non è presente nella lista.<br/>
    * 
    * @d.esign Si verifica che alla chiamata del metodo {@code lastIndexOf(Object o)} nel caso in cui il parametro sia un oggetto non null venga restituito l'indice della lista relativo all'oggetto specificato, se presente, altrimenti {@code -1}.<br/>  
    * 
    * @d.escription Si suppone testati e funzionanti i metodi {@code add()} e {@code clear()}, e poi:<br/>
    * 1. Si svuota la lista con il metodo clear().<br/>
    * 2. Si aggiungono 4 nuovi elementi con add(Object o), rispettivamente: A, A, B, B.<br/>
    * 3. Si verifica che chiamato il metodo lastIndexOf(Object o) su B restituisca l'indice dell'ultima occorrenza, ovvero {@code 3}.<br/>
    * 4. Si verifica che chiamato il metodo lastIndexOf(Object o) su A non restituisca l'indice della prima occorrenza, ovvero {@code 0}.<br/>
    * 5. Si verifica che chiamato il metodo lastIndexOf(Object o) su un oggetto non appartenente alla lista restituisca {@code -1}.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista ha altri 4 elementi.<br/>
    * 
    * @r.esult {@code lastIndexOf(Object o)} deve ritornare l'indice della lista che corrisponde all'ultima occorrenza dell'oggetto passato come parametro se presente nella lista, {@code -1} altrimenti.<br/>
    */
	@Test
	public void testLastIndexOf2(){
	   list.clear();
	   list.add("A");
	   list.add("A");
	   list.add("B");
	   list.add("B");
	   assertEquals("Ultimo B non è in posizione 3", 3, list.lastIndexOf("B"));
	   assertNotEquals("Ultimo A è in posizione 0", 0, list.lastIndexOf("A"));
	   assertEquals("L'elemento C è nella lista", -1, list.indexOf("C"));
	}		
	
   //TEST SU TOARRAY
   /**
    * Test del metodo {@link myAdapter.ListAdapter#toArray() toArray} su una collezione contenente elementi e non.
    * <br/>
    * @s.ummary Verifica la corretta conversione di una collezione in array di oggetti. L'ordine non e' preciso.<br/>
    * 
    * @d.esign Si vuole verificare che il metodo {@code toArray()} crei e popoli correttamente un array di {@link Object} della giusta dimensione e con tutti gli elementi contenuti nella collezione.<br/>
    * 
    * @d.escription Si suppongono testati e funzionanti i metodi {@code size()}, {@code contains()}, {@code clear()}, e poi:<br/>
    * 1. Si verifica una chiamata a toArray() e si salva l'array restituito.<br/>
    * 2. Si controlla che la dimensione dell'array cosi' ottenuto sia uguale a quella della lista.<br/>
    * 3. Si verifica che la lista contenga tutti gli elementi contenuti nell'array.<br/>
    * 4. Si svuota la lista e si dimostra che alla chiamata di toArray() su una lista vuota viene restituito un array vuoto, ovvero verifichiamo che la dimensione dell'array sia {@code 0}.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista è vuota.<br/>
    * 
    * @r.esult {@code toArray()} restituisce un array di tipo Object della stessa dimensione della collezione e contenente tutti gli elementi della collezione.<br/>
    */
   @Test
   public void testToArray1(){
      Object[] arr = list.toArray();
      assertEquals("La lista e l'array non hanno la stessa dimensione", list.size(), arr.length);
      for(int i = 0; i < arr.length; i++)
         assertTrue("La lista non contiene un elemento dell'array", list.contains(arr[i]));
      list.clear();
      assertTrue("La dimensione dell'array non è 0", list.toArray().length == 0);
   }
	
	/**
    * Test del metodo {@link myAdapter.ListAdapter#toArray(Object[] arr) toArray} quando {@code arr} e' {@code null}.
    * <br/>
    * @s.ummary Verifica che venga lanciata l'eccezione {@link NullPointerException} quando l'array fornito e' {@code null}.<br/>
    * 
    * @d.esign Si vuole verificare che il metodo {@code toArray(Object[] arr)} lanci correttamente {@link NullPointerException} quando l'array fornito {@code arr} e' {@code null}.<br/>
    * 
    * @d.escription  Si chiama direttamente toArray(null) sulla lista e si verifica il corretto lancio di NullPointerException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista e' rimasta invariata.<br/>
    * 
    * @r.esult {@code toArray(Object[] arr)} deve lanciare {@link NullPointerException} quando {@code arr} e' {@code null}.<br/>
    */
   @Test (expected = NullPointerException.class)
   public void testToArray2(){
      list.toArray(null);
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#toArray(Object[] arr) toArray} quando {@code arr} e' di dimensioni maggiori o uguali alla collezione.
    * <br/>
    * @s.ummary Verifica il funzionamento del metodo {@code toArray(Object[] arr)} su una collezione contenente elementi e non.
    * <br/>
    * @d.esign Si vuole verificare che il metodo {@code toArray(Object[] arr)} popola direttamente l'array {@code arr} fornito come argomento con gli oggetti della collezione. Se {@code arr} e' di dimensione maggiore alla collezione allora i primi {@code c1.size()} valori sono i valori della collezione e i rimanenti sono valori null.
    * <br/>
    * @d.escription Si suppongono testati e funzionanti i metodi {@code clear()}, {@code size()}, {@code contains()}, {@code equals} e poi:<br/>
    * 1. Si crea un array Object di dimensione maggiore della collezione.<br/>
    * 2. Si chiama toArray() fornendo come parametro l'array appena creato e si verifica che l'array ritornato sia uguale all'array precedentemente creato.<br/>
    * 3. Si verifica che i primi {@code c1.size()} elementi dell'array creato sono contenuti nella collezione e che i rimanenti siano impostati a null.<br/>
    * 4. Si svuota la collezione e si verifica che dopo la chiamata di toArray() usando come argomento l'array creato al punto 1., questo contenga solo elementi null.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista e' vuota.<br/>
    * 
    * @r.esult {@code toArray(Object[] arr)} riempie l'array fornito come argomento con gli oggetti della collezione, senza modificarne la dimensione.<br/>
    */
   @Test
   public void testToArray3(){
        Object[] a = new Object[6];
        Object[] b = list.toArray(a);
        assertSame("L'array restituito deve essere lo stesso passato come argomento", a, b);
        assertEquals("Il primo elemento non corrisponde", "A", b[0]);
        assertEquals("Il secondo elemento non corrisponde", "B", b[1]);
        assertEquals("Il terzo elemento non corrisponde", "C", b[2]);
        assertEquals("Il quarto elemento non corrisponde", "D", b[3]);
        assertNull("Elemento a[4] deve essere null", b[4]);
        assertNull("Elemento a[5] deve essere null", b[5]);
        list.clear();
        b = list.toArray(a);
        assertSame("Dopo clear, l'array restituito deve essere ancora lo stesso", a, b);
        for (int i = 0; i < a.length; i++)
            assertNull("Dopo clear, tutti gli elementi devono essere null. Indice " + i, b[i]);
   }

   /**
    * Test del metodo {@link myAdapter.ListAdapter#toArray(Object[] arr) toArray} quando {@code arr} e' di dimensioni minori della lista.
    * <br/>
    * @s.ummary Verifica che il metodo {@code toArray(Object[] arr)} restituisca un array Object di opportune dimensioni con gli elementi della lista.<br/>
    * 
    * @d.esign Si vuole verificare che il metodo {@code toArray(Object[] arr)} restituisca un array di Objects di dimensioni appropriate contenente gli oggetti della lista, quando {@code arr} e' di dimensioni inferiori alla collezione. {@code arr} non deve essere modificato.<br/>
    * 
    * @d.escription Si suppongono testati e funzionanti i metodi {@code size()}, {@code contains()}, {@code equals(Object o)}, e poi:<br/>
    * 1. Si crea un array Object di dimensione minore della lista.<br/>
    * 2. Si chiama toArray(Object[] arr) fornendo come parametro l'array appena creato e si verifica che l'array ritornato non sia uguale all'array precedentemente creato.<br/>
    * 3. Si verifica che l'array ritornato sia delle stesse dimensioni della lista e contenga tutti gli elementi della lista.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista e' rimasta invariata.<br/>
    * 
    * @r.esult {@code toArray(Object[] arr)} restituisce un nuovo array delle dimensioni appropriate e contenente tutti gli elementi della lista se {@code arr} e' di dimensione minore della lista.<br/>
    */
   @Test
   public void testToArray4(){
      Object[] a = new Object[1];
      Object[] b = list.toArray(a);
      assertFalse("I due array sono uguali", a.equals(b));
      assertTrue("L'array b non ha la stessa dimensione della lista", b.length == list.size());
      for(int i = 0; i < a.length; i++)
         assertTrue("L'array b non contiene un elemento della lista", list.contains(b[i]));
   }

	//TEST SU ITERATOR
	/**
    * Test del metodo {@link myAdapter.ListAdapter#iterator() iterator} su una collezione contenente elementi e non.
    * <br/>
    * @s.ummary Verifica che il metodo {@code iterator()} restituisca un iteratore sulla collezione.<br/>
    * 
    * @d.esign Si vuole verificare che il metodo {@code iterator()} restituisca un'istanza di {@link myAdapter.HIterator}. L'iteratore potra' leggere gli elementi della collezione e rimuovere elementi dalla collezione.<br/>
    * 
    * @d.escription Si suppone testato e funzionante il metodo {@code contains()}, e poi:<br/>
    * 1. Si verifica che l'oggetto restituito alla chiamata di iterator() sia un'istanza di HIterator.<br/>
    * 2. Si crea un ciclo while che continua finche' l'iteratore ha elementi da leggere.<br/>
    * 3. Dentro al ciclo while si legge l'elemento successivo della vista e si verifica che sia presente nella collezione.<br/>
    * 4. Si rimuove l'elemento appena letto tramite l'iteratore e si controlla che non sia piu' contenuto nella collezione.<br/>
    * 5. Alla fine del ciclo while la collezione e' vuota e si controlla che l'iteratore di una collezione vuota non abbia elementi successivi.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista e' vuota.<br/>
    * 
    * @r.esult {@code iterator()} deve restituire un'istanza di {@code HIterator} che compie correttamente i metodi descritti in {@link myAdapter.HIterator}.<br/>
    */
   @Test
   public void testIterator(){
      assertTrue("L'iteratore della lista non è un'istanza di HIterator", list.iterator() instanceof HIterator);
      HIterator it = list.iterator();
      while(it.hasNext()){
         Object v = it.next();
         assertTrue("La lista non contiene l'elemento v", list.contains(v));
         it.remove();
         assertFalse("La lista contiene l'elemento v", list.contains(v));
      }
      assertTrue("La lista non è stata svuotata", list.size() == 0);
      it = list.iterator();
      assertFalse("La lista ha elementi", it.hasNext());
   }
	
	//TEST SU LISTITERATOR
	/**
    * Test del metodo {@link myAdapter.ListAdapter#listIterator() listIterator} su una lista contenente elementi e non.
    * <br/>
    * @s.ummary Verifica che il metodo {@code listIterator()} restituisca un iteratore sulla lista.<br/>
    * 
    * @d.esign Si vuole verificare che il metodo {@code listIterator()} restituisca un'istanza di {@link myAdapter.HListIterator}. L'iteratore potra' leggere gli elementi della list e rimuovere elementi dalla lista.<br/>
    * 
    * @d.escription Si suppone testato e funzionante il metodo {@code contains()}, e poi:<br/>
    * 1. Si verifica che l'oggetto restituito alla chiamata di listIterator() sia un'istanza di HListIterator.<br/>
    * 2. Si crea un ciclo while che continua finche' l'iteratore ha elementi da leggere.<br/>
    * 3. Dentro al ciclo while si legge l'elemento successivo della vista e si verifica che sia presente nella lista.<br/>
    * 4. Si rimuove l'elemento appena letto tramite l'iteratore e si controlla che non sia piu' contenuto nella lista.<br/>
    * 5. Alla fine del ciclo while la lista e' vuota e si controlla che l'iteratore di una lista vuota non abbia elementi successivi.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista e' vuota.<br/>
    * 
    * @r.esult {@code listIterator()} deve restituire un'istanza di {@code HListIterator} che compie correttamente i metodi descritti in {@link myAdapter.HListIterator}.<br/>
    */
   @Test
   public void testListIterator1(){
      assertTrue("L'iteratore della lista non è un'istanza di HIterator", list.listIterator() instanceof HListIterator);
      HListIterator it = list.listIterator();
      while(it.hasNext()){
         Object v = it.next();
         assertTrue("La lista non contiene l'elemento v", list.contains(v));
         it.remove();
         assertFalse("La lista contiene l'elemento v", list.contains(v));
      }
      assertTrue("La lista non è stata svuotata", list.size() == 0);
      it = list.listIterator();
      assertFalse("La lista ha elementi", it.hasNext());
   }
	
	/**
    * Test del metodo {@link myAdapter.ListAdapter#listIterator(int index) listIterator} nel caso in cui come parametro ho indice negativo.
    * <br/>
    * @s.ummary Verifica che il metodo {@code listIterator(int index)} lancia {@link IndexOutOfBoundsException} se fornito come parametro un indice negativo.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code listIterator(int index)} nel caso in cui il parametro sia un indice negativo venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>  
    * 
    * @d.escription Si esegue direttamente il metodo listIterator(int index) fornendo come argomento un indice negativo e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code listIterator(int index)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con argomento indice negativo.<br/>
    */
   @Test(expected = IndexOutOfBoundsException.class)
   public void testListIterator2(){
      HListIterator it = list.listIterator(-2);
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#listIterator(int index) listIterator} nel caso in cui come parametro ho indice maggiore della dimensione della lista.
    * <br/>
    * @s.ummary Verifica che il metodo {@code listIterator(int index)} lancia {@link IndexOutOfBoundsException} se fornito come parametro un indice maggiore della dimensione della lista.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code listIterator(int index)} nel caso in cui il parametro sia un indice maggiore della dimensione della lista venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>
    * 
    * @d.escription Si esegue direttamente il metodo listIterator(int index) fornendo come argomento un indice maggiore della dimensione della lista e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code listIterator(int index)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con argomento indice maggiore della dimensione della lista.<br/>
    */
   @Test(expected = IndexOutOfBoundsException.class)
   public void testListIterator3(){
      HListIterator it = list.listIterator(7);
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#listIterator(int index) listIterator} con parametro un indice valido su una lista contenente elementi e non.
    * <br/>
    * @s.ummary Verifica che il metodo {@code listIterator()} restituisca un iteratore sulla lista a partire dall'indice specificato come parametro.<br/>
    * 
    * @d.esign Si vuole verificare che il metodo {@code listIterator(int index)} restituisca un'istanza di {@link myAdapter.HListIterator} a partire dall'indice specificato come parametro. L'iteratore potra' leggere gli elementi della list e rimuovere elementi dalla lista.<br/>
    * 
    * @d.escription Si suppone testato e funzionante il metodo {@code contains()}, e poi:<br/>
    * 1. Si verifica che l'oggetto restituito alla chiamata di listIterator(int index) sia un'istanza di HListIterator.<br/>
    * 2. Si crea un ciclo while che continua finche' l'iteratore ha elementi da leggere.<br/>
    * 3. Dentro al ciclo while si legge l'elemento successivo della vista e si verifica che sia presente nella lista.<br/>
    * 4. Si rimuove l'elemento appena letto tramite l'iteratore e si controlla che non sia piu' contenuto nella lista.<br/>
    * 5. Alla fine del ciclo while la lista e' vuota e si controlla che l'iteratore di una lista vuota non abbia elementi successivi.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista ha 1 elemento.<br/>
    * 
    * @r.esult {@code listIterator(int index)} deve restituire un'istanza di {@code HListIterator} a partire dall'indice specificato come parametro che compie correttamente i metodi descritti in {@link myAdapter.HListIterator}.<br/>
    */
   @Test
   public void testListIterator4(){
      assertTrue("L'iteratore della lista non è un'istanza di HIterator", list.listIterator(1) instanceof HListIterator);
      HListIterator it = list.listIterator(1);
      while(it.hasNext()){
         Object v = it.next();
         assertTrue("La lista non contiene l'elemento v", list.contains(v));
         it.remove();
         assertFalse("La lista contiene l'elemento v", list.contains(v));
      }
      assertTrue("La lista non ha un elemento", list.size() == 1);
      it = list.listIterator();
      assertTrue("La lista non ha elementi", it.hasNext());
   }
	
	//TEST SU EQUALS
	/**
    * Test del metodo {@link myAdapter.ListAdapter#equals(Object o) equals}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code equals(Object o)} funzioni correttamente, fornendo liste uguali e diverse.
    * <br/>
    * @d.esign Si vuole verificare che {@code equals(Object o)} restituisca correttamente {@code true} se l'oggetto fornito come argomento e' anch'esso una lista e le due liste sono uguali, {@code false} quando anche solo una di queste condizioni non e' verificata.
    * <br/>
    * @d.escription Si suppongono testati e funzionanti i metodi {@code add()}, {@code clear()}, e poi:<br/>
    * 1. Si crea una nuova lista con gli stessi elementi della lista di partenza.<br/>
    * 2. Si verifica che le due liste siano entrambe istanze di HList.<br/>
    * 3. Si controlla che le due liste siano uguali con il metodo equals(Object o).<br/>
    * 4. Si aggiunge un elemento dalla nuova lista.<br/>
    * 5. Si verifica che le due liste siano diverse con il metodo equals(Object o).<br/>
    * 6. Si svuota la nuova lista e si verifica che le due liste siano diverse con il metodo equals(Object o).<br/>
    * 7. Si svuota la lista di partenza e si verifica che le due liste siano uguali con il metodo equals(Object o).<br/>
    *   
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista è vuota.<br/>
    * 
    * @r.esult Il metodo {@code equals()} deve restituire {@code true} quando le due liste sono uguali, {@code false} altrimenti.<br/>
    */
   @Test
   public void testEquals(){
      HList list2 = new ListAdapter(list);
      assertTrue("Le due liste non sono istanze di HList", list instanceof HList && list instanceof HList);
      assertTrue("Le due liste non sono uguali", list.equals(list2));
      list2.add("E");
      assertFalse("Le due liste sono uguali", list.equals(list2));
      list2.clear();
      assertFalse("Le due liste sono uguali", list.equals(list2));
      list.clear();
      assertTrue("Le due liste non sono uguali", list.equals(list2));
   }	
	
	//TEST SU HASHCODE
	/**
    * Test del metodo {@link myAdapter.ListAdapter#hashCode() hashCode}.
    * <br/>
    * @s.ummary Verifica che il metodo {@code hashCode()} generi correttamente l'hashCode della lista che chiama il metodo.<br/>
    * 
    * @d.esign Si vuole verificare che il metodo {@code hashCode()} preveda il corretto aggiornamento dell'hashCode della lista al variare degli elementi contenuti nella lista, senza generare errori.<br/>
    * 
    * @d.escription Si suppone testato e funzionante il metodo {@code clear()}, e poi:<br/>
    * 1. Si crea una nuova lista inizialmente uguale alla lista chiamante.<br/>
    * 2. Si verifica che le due liste siano uguali e che di conseguenza anche i loro hashCode siano uguali.<br/>
    * 3. Si svuota la lista di partenza e si verifica che l'hashCode di una lista vuota e' 0.<br/>
    * 4. Si confronta l'hashCode della lista vuota con la nuova lista e si verifica che non siano uguali, modifiche alla collezione comportano modifiche all'hashcode.<br/>
    *      
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista è vuota.<br/>
    * 
    * @r.esult Il metodo {@code hashCode()} restituisce un numero intero corrispondente all'hashCode della lista che lo chiama.<br/>
    */
   @Test
   public void testHashCode(){
      HList newList = new ListAdapter(list);
      assertEquals("Le due liste non sono uguali", list, newList);
      assertEquals("L'hashCode delle due liste non è uguale", list.hashCode(), newList.hashCode());
      list.clear();
      assertTrue("L'hashCode della lista vuota non è zero", list.hashCode() == 0);
      assertFalse("L'hashCode delle due liste è uguale dopo clear", list.hashCode() == newList.hashCode());
   }
   
	//TEST SU SUBLIST   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#subList(int toIndex, int fromIndex) subList} nel caso in cui come parametri ho indice iniziale negativo e indice finale valido della lista.
    * <br/>
    * @s.ummary Verifica che il metodo {@code subList(int toIndex, int fromIndex))} lancia {@link IndexOutOfBoundsException} se fornito come parametri un indice iniziale negativo e un indice finale valido della lista.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code subList(int toIndex, int fromIndex)} nel caso in cui il primo parametro sia un indice iniziale negativo della lista venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>  
    * 
    * @d.escription Si esegue direttamente il metodo subList(int toIndex, int fromIndex) fornendo come primo argomento un indice iniziale negativo della lista e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code subList(int toIndex, int fromIndex)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con primo argomento indice iniziale negativo.<br/>
    */
	@Test(expected = IndexOutOfBoundsException.class)
   public void testSubList1(){
      HList sub = list.subList(-1, 2);
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#subList(int toIndex, int fromIndex) subList} nel caso in cui come parametri ho indice iniziale maggiore dell'indice finale della lista.
    * <br/>
    * @s.ummary Verifica che il metodo {@code subList(int toIndex, int fromIndex))} lancia {@link IndexOutOfBoundsException} se fornito come parametri un indice iniziale maggiore dell'indice finale della lista.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code subList(int toIndex, int fromIndex)} nel caso in cui come parametri ho un indice iniziale maggiore dell'indice finale della lista venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>  
    * 
    * @d.escription Si esegue direttamente il metodo subList(int toIndex, int fromIndex) fornendo come argomenti un indice iniziale maggiore all'indice finale della lista e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code subList(int toIndex, int fromIndex)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con argomenti indice iniziale maggiore dell'indice finale.<br/>
    */
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSubList2(){
      HList sub = list.subList(3, 1);
   }
   
   /**
    * Test del metodo {@link myAdapter.ListAdapter#subList(int toIndex, int fromIndex) subList} nel caso in cui come parametri ho indice iniziale valido e indice finale maggiore della dimensione della lista.
    * <br/>
    * @s.ummary Verifica che il metodo {@code subList(int toIndex, int fromIndex))} lancia {@link IndexOutOfBoundsException} se fornito come parametri un indice iniziale valido e un indice finale maggiore della dimensione della lista.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code subList(int toIndex, int fromIndex)} nel caso in cui il secondo parametro sia un indice finale maggiore della dimensione della lista venga correttamente lanciata l'eccezione {@link IndexOutOfBoundsException}.<br/>  
    * 
    * @d.escription Si esegue direttamente il metodo subList(int toIndex, int fromIndex) fornendo come secondo argomento un indice finale maggiore della dimensione della lista e si verifica che venga lanciata un'eccezione IndexOutOfBoundsException.<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code subList(int toIndex, int fromIndex)} deve lanciare {@link IndexOutOfBoundsException} se chiamata con secondo argomento indice finale maggiore della dimensione della lista.<br/>
    */
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSubList3(){
      HList sub = list.subList(2, 6);
   }
	
	/**
    * Test del metodo {@link myAdapter.ListAdapter#subList(int toIndex, int fromIndex) subList} nel caso in cui come parametri ho indice iniziale e finale validi.
    * <br/>
    * @s.ummary Verifica che il metodo {@code subList(int toIndex, int fromIndex))} restituisca una porzione della lista compresa tra l'indice iniziale specificato (incluso) e l'indice finale specificato (escluso) se fornito come parametri un indice iniziale e uno finale validi.<br/>
    * 
    * @d.esign Si vuole verificare che alla chiamata del metodo {@code subList(int toIndex, int fromIndex)} nel caso in cui i parametri siano validi venga correttamente restituita la sottolista compresa tra l'indice iniziale specificato (incluso) e l'indice finale specificato (escluso).<br/>  
    * 
    * @d.escription Si suppongono testati e funzionanti i metodi {@code get(int index)} di HList, {@code size()} di HCollection, e poi:<br/>
    * 1. Si crea una prima sottolista compresa nella lista di partenza.<br/>
    * 2. Si verifica la dimensione con size() e che contenga gli elementi corretti con get(int index).<br/>
    * 3. Si crea una seconda sottolista uguale alla lista di partenza.<br/>
    * 4. Si verifica la dimensione con size() e che contenga gli elementi corretti con get(int index).<br/>
    * 5. Si crea una terza sottolista vuota rispetto alla lista di partenza.<br/>
    * 6. Si verifica la dimensione con size().<br/>
    * 
    * @p.recond La lista ha 4 elementi.<br/>
    * 
    * @p.ostcond La lista rimane invariata.<br/>
    * 
    * @r.esult {@code subList(int toIndex, int fromIndex)} deve restituire una porzione della lista compresa tra indice iniziale specificato (incluso) ed indice finale specificato (escluso) se chiamato con argomenti validi.<br/>
    */
	@Test
	public void testSubList4(){
	   HList sub1 = list.subList(1, 3);
	   assertEquals("La dimensione della sottolista non è 2", 2, sub1.size());
	   assertEquals("Il primo elemento della sottolista non è B", "B", sub1.get(0));
	   assertEquals("Il secondo elemento della sottolista non è C", "C", sub1.get(1));
	   
	   HList sub2 = list.subList(0, list.size());
	   assertEquals("La dimensione della sottolista non è uguale a quella della lista", list.size(), sub2.size());
	   for(int i = 0; i < list.size(); i++)
	      assertEquals("Il primo elemento della sottolista non è uguale a quello della lista", list.get(0), sub2.get(0));
	      
      HList sub3 = list.subList(2, 2);
	   assertEquals("La dimensione della sottolista non è 0", 0, sub3.size());
	}
	
	/**
    * Metodo tearDown di chiusura
    */
	@After
	public void tearDown(){
		System.out.println("Nulla da fare...");
	}
}
