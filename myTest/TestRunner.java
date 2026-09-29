package myTest;

import java.util.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Classe Test Runner esegue tutti i test definiti nelle altre classi (TestListAdapter e TestListIterator).<br/>
 * Scrive il risultato dei test, il numero complessivo dei test, il numero di test falliti e il tempo richiesto per l'esecuzione dei test.<br/>
 * Si utilizza JUnit 4-13-2, hamcrest-core-1.3.<br/>
 */
 
public class TestRunner{
   /**
    * main di TestRunner
    * 
    * @param argv array di String
    */
	public static void main(String[] argv){
	   
	   org.junit.runner.Result res1 = org.junit.runner.JUnitCore.runClasses(TestListAdapter.class);
	   org.junit.runner.Result res2 = org.junit.runner.JUnitCore.runClasses(TestListIterator.class);
		
		System.out.println("Per TestListAdapter:");
		System.out.println("Ho eseguito " + res1.getRunCount() + " test");
		System.out.println("Ho eseguito i test in " + res1.getRunTime() + " millisecondi");
		System.out.println("Sono falliti " + res1.getFailureCount() + " test");
		List<Failure> l1 = res1.getFailures();
		ListIterator<Failure> li1 = l1.listIterator();
		while(li1.hasNext())
			System.out.println(li1.next());
			
		System.out.println("Per TestListIterator:");
		System.out.println("Ho eseguito " + res2.getRunCount() + " test");
		System.out.println("Ho eseguito i test in " + res2.getRunTime() + " millisecondi");
		System.out.println("Sono falliti " + res2.getFailureCount() + " test");
		List<Failure> l2 = res2.getFailures();
		ListIterator<Failure> li2 = l2.listIterator();
		while(li2.hasNext())
			System.out.println(li2.next());
	}
}
