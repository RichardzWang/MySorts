// Richard Wang
// APCS1 pd9
// HW53 -- Poker Face
// 2016-1-4

/*
  1. More work is usually done at the end of insertion sort because the later elements have to compare with the large number of sorted elements.
  2. For n items, n - 1 passes are necessary to sort.
  3. After pass p, p + 1 elements are sorted at the front of the ArrayList.
  4. The runtim classification is O(N^2).
 */
import java.util.ArrayList;

public class InsertionSort {

    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    public static void insertionSortV( ArrayList<Comparable> data )
    {
	for ( int a = 1; a < data.size(); a++ ) { //Starts on index 1
	    Comparable hold = data.get(a);
	    int c = a;
	    for (c = a; c > 0; c-- ) { //Starts on index of selected element
		if ( hold.compareTo( data.get(c - 1) ) >= 0 )
		    break; // Exits loop when element is greater than or equal to one of the sorted.  Otherwise, c will equal 0, placing it at the front.
	    }
	    data.remove(a); //remove element
	    data.add(c, hold); //places in correct place within sorted elements
	}
    }

    public static ArrayList<Comparable> insertionSort( ArrayList<Comparable> input )
    {
	ArrayList <Comparable> data = new ArrayList <Comparable>();
	for (int i = 0; i < input.size(); i++) {
	    data.add(input.get(i));
	}
	insertionSortV(data);
	return data;
    }
    
    public static void main(String[] args) {
	ArrayList hed = new ArrayList<Integer>();
	  hed.add(7);
	  hed.add(1);
	  hed.add(5);
	  hed.add(12);
	  hed.add(3);
	  System.out.println( "ArrayList hed before sorting:\n" + hed );
	  ArrayList hedSorted = insertionSort( hed );
	  System.out.println( "sorted version of ArrayList hed:\n" 
	  + hedSorted );
	  System.out.println( "ArrayList hed after sorting:\n" + hed );

	  ArrayList popo = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList popo before sorting:\n" + popo );
	  ArrayList popoSorted = insertionSort( popo );
	  System.out.println( "sorted version of ArrayList popo:\n" 
	  + popoSorted );
	  System.out.println( "ArrayList popo after sorting:\n" + popo );
    }

}
