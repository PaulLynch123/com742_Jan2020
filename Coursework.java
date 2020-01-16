package CourseworkJan2020;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;        //to use Array.sort in some alternative methods

public class Coursework {

    private static void printMethodName(){
        //HELPER METHOD TO PRINT CURRENT METHOD NAME
        //get the method name of the StackTrace at position index 2
        System.out.println("Name of tested method is : " + Thread.currentThread().getStackTrace()[2].getMethodName());

/*
        //GET METHOD NAME BY THROWING EXCEPTIONS which is apparently expensive
        String nameOfCurrMethod = new Exception()
                .getStackTrace()[1]   // if I used [1] I get the method above the current method which is what I want
                .getMethodName();
        System.out.println("Name of current method: " + nameOfCurrMethod);
 */

    }//printMethodName

    public static int[] readArrayFromFile(String filename1) {
        /*
        Description: Reads an array from file using UUlib.
        Parameters:  filename of textfile.
        Returns: int array of numbers
        */
        int[] array1 = new int[1];

        try {

            FileReader fr1 = new FileReader(filename1);
            BufferedReader br1 = new BufferedReader(fr1);
            String c1 = br1.readLine();

            //class Integer
            Integer size1 = Integer.parseInt(c1);
            array1 = new int[size1];
            System.out.println("First number in text file and supposedly Length of Array is : " + array1.length);

            for (int i = 0; i < size1; i++) {

                c1 = br1.readLine();
                array1[i] = Integer.parseInt(c1);
                //System.out.println(array1[i]);    Don't want to print the huge array evey time
            }//for
            br1.close();
            fr1.close();
        }//try
        catch (IOException e1) {
            System.out.println(e1);
        }//catch
        printMethodName();
        return array1;
    }//readArrayFromFile


    public static int countPositiveValues(int[] array2) {
        /*
        Description: Counts the positive integer values in an array
        Parameters:  int array to be counted
        Returns: int number of positive values
        */
        int positiveCount = 0;
        for (int i = 0; i < array2.length; i++) {

            if (array2[i] > 0) {
                //int [] array3[positiveCount] = array2[i];
                positiveCount++;
            }//if
        }//for
        printMethodName();
        return positiveCount;

        // Task: COMPLETED

    }//countPositiveValues


    public static int countNegativeValues(int[] array3) {
        /*
        Description: Counts the negative integer values in an array
        Parameters:  int array to be counted
        Returns: int number of negative values
        */

        int negativeCount = 0;

        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 0) {
                negativeCount++;
            }//if
        }//for
        printMethodName();
        return negativeCount;

        // Task: COMPLETED
    }//countNegativeValues


    public static int countZeroValues(int[] array4) {
        /*
        Description: Counts the zero integer values in an array
        Parameters:  int array to be counted
        Returns: int number of zero values
        */

        int zeroCount = 0;
        for (int i = 0; i < array4.length; i++) {
            if (array4[i] == 0) {
                zeroCount++;
            }//if
        }//for
        printMethodName();
        return zeroCount;
        // Task: COMPLETED
    }//countZeroValues

    public static double meanArrayValue(int[] array1) {
        /*
        Description: Computes mean value from an array
        Parameters:  int array of values from which mean is computed
        Returns: double calculated mean value
        */
        double meanValue = 0;

        for (int i = 0; i < array1.length; i++) {
            meanValue = meanValue + array1[i];
        }//for
        meanValue = meanValue / array1.length;

        printMethodName();
        return meanValue;
        // Task: COMPLETE
    }//meanArrayValue

    private static int[] sortArrayAscending(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }//if
            }//for
        }//for
        return array;
        //HELPER METHOD NEEDED TO SORT ARRAY FOR SEVERAL OTHER METHODS

    }//sortArrayAscending

    public static double medianArrayValue(int[] array2) {
        /*
        Description: Computes median value from a sorted array
        Parameters:  int array of values from which median is computed
        Returns: double calculated median value
        Note: Array must be sorted!
        */
        double medianValue;
        /*
        int temp;
        for (int i = 0 ; i < array2.length ; i++){
            for(int j = i + 1 ; j < array2.length ; j++){
                if (array2[i] > array2[j]){
                    temp = array2[i];
                    array2[i] = array2[j];
                    array2[j] = temp;
                }//if
            }//for
        }//for
         */
        array2 = sortArrayAscending(array2);
        /*PRINTING SORTED ARRAY
        for(int i = 0 ; i < (array2.length-1) ; i++){
            System.out.println(array2[i] + " , ");
        }//for
        System.out.println(array2[(array2.length-1)]);
         */

        int index = (int) ((array2.length / 2.0) - 1);
        if ((array2.length % 2) == 0) {
            medianValue = (array2[index] + array2[index + 1]) / 2.0;
        }//if
        else {
            medianValue = array2[index];
        }//else

        printMethodName();
        return medianValue;
        // Task: COMPLETE

    }//medianArrayValue


    /*
    public static int modeArrayValue(int[] array1) {

        //Description: Computes the first mode value from a sorted array
        //Parameters:  int array of values from which mode is computed
        //Returns: int first mode value
        //Note: Array must be sorted!

        int [] array2 = sortArrayAscending(array1);

        int mode = array2[0];
        int index = 1 , count = 1 , countMax = 1;
        int matchIndex , tempCount = 0;
        ArrayList<Integer> additionalModeValues = new ArrayList<Integer>();
        for (int i = 0 ; i < array2.length ; i++){
            if((i+1) < array1.length){
                if(array2[i] == array2[i+1]){
                    count++;
                    //mode = array1[i];
                }//if
            }//if
            else{
                count++;
            }//else


            if (count == countMax){
                matchIndex = i;
                tempCount = count;
                additionalModeValues.add(array1[i]);
            }//if


            if (count > countMax){
                countMax = count;
                index = i;
                //mode = array1[i];

                additionalModeValues.clear();
            }//if
            else{
                if(!(count == countMax)){
                    count = 1;
                }//if

            }//else
        }//for


        if(countMax == tempCount){
            System.out.println("More than one mode value present");
            //System.out.println(additionalModeValues);
            for (Integer i : additionalModeValues)
                System.out.println(i);
            //if(additionalModeValues.get(i) == additionalModeValues.get((i+countMax)));
        }//if



        return array2[index];
        // Task: Complete method code
    }//modeArrayValue

     */

    public static int modeWithMoreThanOne(int[] array66) {

        //sort array (ascending)
        int[] array2 = sortArrayAscending(array66);

        //arrayList to hold previous modes values
        ArrayList<Integer> additionalModeValues = new ArrayList<Integer>();
        int matchIndex;
        int tempCount = 1;

        int maxValue = array2[0];
        int lastValue = maxValue;
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < array2.length; i++) {
            if (array2[i] == lastValue) {
                count++;
            } //if
            else {
                count = 1;
                lastValue = array2[i];
            }//else

            //used to capture possible previous modes)
            if (count == maxCount) {
                matchIndex = i;
                tempCount = count;
                additionalModeValues.add(array2[i]);
            }//if


            if (count > maxCount) {
                maxCount = count;
                maxValue = lastValue;

                //used to clear possible mode values
                additionalModeValues.clear();

            }//if
        }//for

        //used to see if more than mode
        if (maxCount == tempCount) {
            System.out.println("More than one mode value present");
            System.out.println(additionalModeValues);
            System.out.print("Additional modes are: ");
            for (Integer i : additionalModeValues) {       //for each (Type of object, then name it, colon, then name of array or arrayList
                System.out.print(i + " , ");
            }//for

            System.out.println();    //to take a new line
            //if(additionalModeValues.get(i) == additionalModeValues.get((i+maxCount))){
        }//if

        printMethodName();
        return maxValue;

    }//modeWithMoreThanOne


    public static int modeArrayValue(int[] array1) {
        /*
        Description: Computes the first mode value from a sorted array
        Parameters:  int array of values from which mode is computed
        Returns: int first mode value
        Note: Array must be sorted!
        */

        //sort array (ascending)
        int[] array2 = sortArrayAscending(array1);

        int maxValue = array2[0];
        int lastValue = maxValue;
        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < array2.length; i++) {
            if (array2[i] == lastValue) {
                count++;
            } //if
            else {
                count = 1;
                lastValue = array2[i];
            }//else
            if (count > maxCount) {
                maxCount = count;
                maxValue = lastValue;
            }//if
        }//for

        printMethodName();
        return maxValue;

        // Task: COMPLETE
    }//modeArrayValue


    public static int modeUnsortedArray(int a[]) {
        int maxValue = 0, maxCount = 0, i, j;

        for (i = 0; i < a.length; ++i) {
            int count = 0;
            for (j = 0; j < a.length; ++j) {
                if (a[j] == a[i])
                    ++count;
            }//for

            if (count > maxCount) {
                maxCount = count;
                maxValue = a[i];
            }//if
        }//for
        printMethodName();
        return maxValue;
    }//modeUnsortedArray


    public static int minArrayValue(int[] array) {
        /*
        Description: Computes minimum value from an int array
        Parameters:  int array of values from which to find minimum
        Returns: int minimum value
        */

        int minValue = array[0];

        for (int i = 1 ; i < array.length ; i++){
            if(array[i] < minValue){
                minValue = array[i];
            }//if
        }//for
        //used to print name of current method
        printMethodName();
        return minValue;

        // Task: Complete method code
    }//minArrayValue

    protected static int minArrayUsingArraySortMethod(int [] array22){
        Arrays.sort(array22);
        printMethodName();
        return array22[0];
    }//minArrayUsingArraySortMethod

    public static int maxArrayValue(int[] array) {
        /*
        Description: Computes maximum value from an int array
        Parameters:  int array of values from which to find maximum
        Returns: int maximum value
        */
//kEY TO THIS IS THAT YOU ARE COMPARING SECOND NUMBER TO FIRST NUMBER...LAST NUMBER TO SECOND LAST NUMBER
//assign the first value of the array to the maxValue outside the loop
        int maxValue = array[0];
        //start the loop at index 1 rather than zero
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }//if
        }//for
        printMethodName();
        return maxValue;

        // Task: Complete method code
    }//maxArrayValue

    protected static int maxArrayUsingArraySortMethod(int [] array11){
        printMethodName();

        Arrays.sort(array11);
        return array11[array11.length-1];
    }//maxArrayUsingArraySortMethod


    public static void swap1(int[] array, int posA, int posB) {
        //USING THIS SWAP1 METHOD IN THE BUBBLE SORT METHOD
        /*
        Description: Swaps two values in an int array
        Parameters:  int array of values and positions of elements to be swapped
        Returns: void
        */
        //printMethodName();
        try {
            int tmp = array[posA];
            array[posA] = array[posB];
            array[posB] = tmp;
        }//try
        catch (IndexOutOfBoundsException e1){
            System.out.println("Exception Out Of Bounds Caught");
            //BREAK CAN ONLY BE IN A SWITCH OR LOOP
            //break;
            System.out.println("INSIDE CATCH - testing if it broke out after the Exception error message");
        }//catch
        //System.out.println("OUTSIDE CATCH - testing if it broke out after the Exception error message");
    }//swap


    public static void bubbleSort(int[] array) {
        /*
        Description: Sorts a int array using bubblesort algoritm
        Parameters:  int array of values to be sorted
        Returns: void
        */
        printMethodName();
        int ncomps=0, nswaps=0; // declare and initialise counters
        for (int out = array.length-1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                ncomps++; // increment number of comparisons
                if (array[in] > array[in+1]) {
                    nswaps++;  // increment number of swaps
                    swap1(array, in, in+1);
                }//if
            }//for
        }//for
        System.out.println("Comps="+ncomps+" Swaps="+nswaps);
    }//bubbleSort


    public static int binarySearch(int array[], int key) {
        /*
        Description: Performs binary search on an array for a specified value
        Parameters:  int array of values and int key which item to be searched
        Returns: int indicating first location of item, or -1 in case not found
        */

        //search the middle index of the array then move up or down
        //low / middle // high
        int low = 0, high = array.length - 1;
        int count = 0;

        while (low <= (high)) {
            count++;
            int middle = low + (high-low) / 2;      //lower mid when it is even

            // Check if key is at mid index
            if (array[middle] == key){
                System.out.println("Matched Count is : " + count);
                return middle;
            }//if

            // If key greater, ignore lower half
            if (array[middle] < key)
                low = middle + 1;       //moving low to ignore everything below middle index value

                // If key is smaller, ignore top half
            else
                high = middle - 1;      //moving high to ignore everything above middle index value
        }//while

        // if we reach here, then element was not present
        System.out.println("Count is : " + count);
        return -1;

        // Task: COMPLETE

    }//binarySearch



}//CLASS


