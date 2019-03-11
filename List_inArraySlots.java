/**
  Implement a list of integer elements, including
  both data and operations.
 */

public class List_inArraySlots {

    private int[] intElements;
    private double[] doubleElements;
    private String[] stringElements;
    private int filledElements; // the number of elements in this list

    /* type identifier for each element
       That is, typeOfElements[i] == 0 means element i is an integer;
                                     1 means element i is a double;
                                     2 means element i is a String.
        Optional extra education in programming (not comp sci):
            replace these "magic numbers" with an "enumerated type".
     */
    private int[] typeOfElements;

    private static final int INITIAL_CAPACITY = 10;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
        intElements     = new int[INITIAL_CAPACITY];
        doubleElements  = new double[INITIAL_CAPACITY];
        stringElements  = new String[INITIAL_CAPACITY];
        typeOfElements  = new int[INITIAL_CAPACITY];
    }


    /**
      @return the number of elements in this list
     */
    public int size() {
        return filledElements;
    }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
    public String toString() {
        String output = "[";
        for (int i = 0; i < filledElements; i++) {
            if (typeOfElements[i] == 0)
                output += intElements[i];
            else if (typeOfElements[i] == 1)
                output += doubleElements[i];
            else
                output += stringElements[i];
            output += ",";
        }
        return output + "]";
    }


    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int type   // same meaning as in typeOfElements
                       , int intValue
                       , double doubleValue
                       , String stringValue
                       ) {
           if (filledElements == typeOfElements.length) expand();

           typeOfElements[filledElements]   = type;
           intElements[filledElements]      = intValue;
           doubleElements[filledElements]   = doubleValue;
           stringElements[filledElements]   = stringValue;

           filledElements++;
           return true;
     }


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
     private void expand() {
          int[] biggerInt = new int[ intElements.length * 2];
          for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
              biggerInt[ elemIndex] = intElements[ elemIndex];
          intElements = biggerInt;

          double[] biggerDouble = new double[ doubleElements.length * 2];
          for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
              biggerDouble[ elemIndex] = doubleElements[ elemIndex];
          doubleElements = biggerDouble;

          String[] biggerString = new String[ stringElements.length * 2];
          for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
              biggerString[ elemIndex] = stringElements[ elemIndex];
          stringElements = biggerString;

          int[] biggerType = new int[ typeOfElements.length * 2];
          for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
              biggerType[ elemIndex] = typeOfElements[ elemIndex];
          typeOfElements = biggerType;
     }
}
