import java.util.ArrayList;

public class MySorts {

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
    public static void main(String[] args) {
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	ArrayList glenSorted = BogoSort.bogoSort( glen );
	System.out.println( "sorted version of ArrayList glen:\n" 
			    + glenSorted );
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = BogoSort.bogoSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	System.out.println( coco );


	ArrayList hui = new ArrayList<Integer>();
	hui.add(7);
	hui.add(1);
	hui.add(5);
	hui.add(12);
	hui.add(3);
	System.out.println( "ArrayList hui before sorting:\n" + hui );
	ArrayList huiSorted = SelectionSort.selectionSort( hui );
	System.out.println( "sorted version of ArrayList hui:\n" 
			    + huiSorted );
	System.out.println( "ArrayList hui after sorting:\n" + hui );

	ArrayList dodo = populate( 10, 1, 1000 );
	System.out.println( "ArrayList dodo before sorting:\n" + dodo );
	ArrayList dodoSorted = SelectionSort.selectionSort( dodo );
	System.out.println( "sorted version of ArrayList dodo:\n" 
			    + dodoSorted );
	System.out.println( "ArrayList dodo after sorting:\n" + dodo );
	System.out.println( dodo );

    	ArrayList hlen = new ArrayList<Integer>();
	hlen.add(7);
	hlen.add(1);
	hlen.add(5);
	hlen.add(12);
	hlen.add(3);
	System.out.println( "ArrayList hlen before sorting:\n" + hlen );
	ArrayList hlenSorted = BubbleSort.bubbleSort( hlen );
	System.out.println( "sorted version of ArrayList hlen:\n" 
			    + hlenSorted );
	System.out.println( "ArrayList hlen after sorting:\n" + hlen );

      	ArrayList bobo = populate( 10, 1, 1000 );
	System.out.println( "ArrayList bobo before sorting:\n" + bobo );
	ArrayList boboSorted = BubbleSort.bubbleSort( bobo );
	System.out.println( "sorted version of ArrayList bobo:\n" 
			    + boboSorted );
	System.out.println( "ArrayList bobo after sorting:\n" + bobo );
	System.out.println( bobo );

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
	  System.out.println( popo );


    }
}
