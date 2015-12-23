// Richard Wang
// APCS1 pd9

/*======================================
  class BubbleSort -- implements bubblesort algorithm (vanilla version)
  ======================================*/

import java.util.ArrayList;

public class BogoSort {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) 
    {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }


    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) 
    {
	int randomIndex;
	//setup for traversal fr right to left
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static boolean isSorted( ArrayList<Comparable> data ) {
	for ( int c = 0; c < data.size() - 1; c++ ) {
	    if ( data.get(c).compareTo( data.get(c + 1) ) == 1 ) {
		return false;
	    }
	}
	return true;
    }

    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bogoSortV( ArrayList<Comparable> data ) {
	while (! (isSorted(data)) ) {
	    shuffle( data );
	}
    }//end bubbleSortV -- O(N^2)


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bogoSort( ArrayList<Comparable> input ){
	ArrayList<Comparable> data = new ArrayList<Comparable>();
	for(int c = 0; c < input.size(); c++) {
	    data.add(input.get(c));
	}
	bogoSortV(data);
	return data;
    }//end bubbleSort -- O(N^2)


    public static void main(String [] args){
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	ArrayList glenSorted = bogoSort( glen );
	System.out.println( "sorted version of ArrayList glen:\n" 
			    + glenSorted );
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = bogoSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	System.out.println( coco );


    }//end main

}//end class BubbleSort
