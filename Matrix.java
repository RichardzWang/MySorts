// Richard Wang
// APCS1 pd9
// HW54 -- Red vs Blue
// 2016-1-5

/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below.
        Categorize runtime of each. 
        Test in your main method.
  ====================================*/ 

public class Matrix {

    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;


    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix( ) {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }//O(1)


    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	matrix = new Object[a][a];
    }//O(1)


    //return size of this matrix, where size is 1 dimension
    private int size() {
	return matrix.length;
    }//O(1)


    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return matrix[r][c];
    }//O(1)


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	return (matrix[r][c]==null); //null is a primitive
    }//O(1)


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object old = matrix[r][c];
	matrix[r][c] = newVal;
	return old;
    }//O(1)


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String retStr = "";
	for (Object[] f : matrix) {
	    for (int c = 0; c < f.length; c++) {
		if (c != f.length - 1) {
		    retStr += (f[c] + " ");
		}
		else {
		    retStr += (f[c]);
		}
	    }
	    retStr += "\n";
	}
	return retStr;
    }//O(N^2)


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) {
	boolean ret = this == rightSide;
	if (!ret) {
	    ret = rightSide instanceof Matrix && ((Matrix) rightSide).size() == this.size(); 
	    if (ret) {
		for (int f = 0; f < ((Matrix) rightSide).size(); f++) {
		    for (int s = 0; s < ((Matrix) rightSide).size(); s++) {
			if (matrix[f][s] != ((Matrix) rightSide).get(f, s)) {
			    return false; //returns as soon as one element does not match
			}
		    }
		}
	    }
	}
	return ret;
    }//O(N^2)


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	if (c1 >= 0 && c1 < matrix.length && c2 >= 0 && c2 < matrix.length) {
	    for (int r = 0; r < matrix.length; r++) {
		matrix[r][c1] = set(r, c2, matrix[r][c1]); //Passing value, not Object
	    }
	}
	else {
	    System.out.println("Index out of bound");
	}
    }//O(N)


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
	if (r1 >= 0 && r1 < matrix.length && r2 >= 0 && r2 < matrix.length) {
	    for (int c = 0; c < matrix.length; c++) {
	    matrix[r1][c] = set(r2, c, matrix[r1][c]);
	    }
	}
	else {
	    System.out.println("Index out of bound");
	}
    }//O(N)
	

    //main method for testing
    public static void main( String[] args ) {
	Matrix test1 = new Matrix();
	Matrix test2 = new Matrix();
	Matrix test3 = new Matrix(3);
	System.out.println(test1.equals(test2));
	System.out.println("Should return true");
	System.out.println();

	int p = 0;
	for (int c = 0; c < test1.size(); c++) {
	    for (int s = 0; s < test1.size(); s++) {
		test1.set(c, s, p++);
	    }
	}
	System.out.println(test1);
	System.out.println(test1.equals(test2));
	System.out.println("Should return false");
	System.out.println();

	test1.swapRows(0, 1);
	System.out.println(test1);
	System.out.println();

	test1.swapColumns(0, 1);
	System.out.println(test1);
	System.out.println();

	System.out.println(test2);
	System.out.println(test2.isEmpty(0,0));
	System.out.println("Should return true");
	System.out.println();

	System.out.println(test1.equals(test3));
	System.out.println("Should return false");
	System.out.println();
	
	
    }

}//end class Matrix
