package CourseworkJan2020;

import java.util.ArrayList;

public class TestingCoursework {

    private static <E> void testMethod(E method){
        System.out.println("Using a bit of Generics");
        System.out.println(method);
        System.out.println("--------------------------");
    }//testMethod

    private static void testInt(int method){
        System.out.println(method);
        System.out.println("---------------------------");
    }//testInt

    private static void testDouble(double method){
        System.out.println(method);
        System.out.println("----------------------------");
    }//testInt

    private static void printIntArray(int [] array){
        for(Integer num1 : array) {
            System.out.print(num1 + " , ");
        }//for
        System.out.println();
    }//printIntArray

    public static void main (String [] args){
//I WAS THINKING OF USING A COURSEWORK OBJECT TO DO ALL THIS TESTING... BUT DECIDED NOT TO
        //Coursework cW1 = new Coursework();
//WAS BUILDING ARRAY FOR EACH TEST WHICH WAS WASTEFUL
        //int positiveCount1 = Coursework.countPositiveValues(Coursework.readArrayFromFile("practice.txt"));
        //TestingCoursework.testInt(positiveCount1);
        //TEST: expected 5004

        //TestingCoursework.testInt(Coursework.countNegativeValues(Coursework.readArrayFromFile("practice.txt")));
        //TEST: expected 4996

        // BUILT ARRAY ONCE AND BEGAN TO TEST METHODS
        int [] practiceArray = Coursework.readArrayFromFile("practice.txt");
        System.out.println("\nBREAK - Checking second array doesn't print ----------------");

        testInt(Coursework.countPositiveValues(practiceArray));
        testInt(Coursework.countNegativeValues(practiceArray));
        testInt(Coursework.countZeroValues(practiceArray));

        testDouble(Coursework.meanArrayValue(practiceArray));
        testDouble(Coursework.medianArrayValue(practiceArray));

        //USING TEMPARRAY TO TEST METHODS WITH ANSWERS I KNOW
        int [] tempArray = {3,2,2,3,5,4,4,2,5,4,5};
        //testDouble(Coursework.medianArrayValue(tempArray));
        //testInt(Coursework.modeArrayValue(tempArray));
        //testInt(Coursework.modeUnsortedArray(tempArray));
        //testInt(Coursework.modeWithMoreThanOne(tempArray)); //this will find mode and any additional mode values
        //testInt((Coursework.modeWithMoreThanOne(practiceArray)));   //WORKS FOR SORTED ARRAY TO SHOW OTHER MODES
        int [] practiceArray2 = Coursework.readArrayFromFile("practice.txt");
        testInt(Coursework.modeArrayValue(practiceArray2));
        int [] practiceArray3 = Coursework.readArrayFromFile("practice.txt");
        testInt(Coursework.modeUnsortedArray(practiceArray3)); //WORKS CORRECTLY FOR UNSORTED ARRAY???
        int [] practiceArray4 = Coursework.readArrayFromFile("practice.txt");
        testInt(Coursework.minArrayValue(practiceArray4));
        int [] practiceArray5 = Coursework.readArrayFromFile("practice.txt");
        testInt(Coursework.maxArrayValue(practiceArray5));

        //USING ARRAY SORT METHOD FROm JAVA UTIL
        //testInt(Coursework.maxArrayUsingArraySortMethod(practiceArray));
        //testInt(Coursework.minArrayUsingArraySortMethod(practiceArray));


        //USING GENERICS FOR MY TESTING OF THE METHOD IT ACCEPTS DOUBLE AND INT
        testMethod(Coursework.maxArrayValue(practiceArray));
        testMethod(Coursework.medianArrayValue(practiceArray));


        //TEST TRY CATCH WITHIN THE SWAP1 METHOD ON MY TEMPARRAY
        printIntArray(tempArray);
        System.out.println("\n----------Swap1 method");
        Coursework.swap1(tempArray , 0 , 2);
        printIntArray(tempArray);
        System.out.println("\n----------Swap1 method with OutOfBounds");
        Coursework.swap1(tempArray , 0 , 11);
        //THE ARRAY IS SORTED IN THIS CLASS ????? WAS THINKING IT MIGHT BE ONLY INSIDE THE METHOD???
        //NO REAL NEED FOR TRY CATCH IN THE SWAP1 METHOD AS POSA AND POSB ARE DEFINED WITH ZERO AND LENGTH OF ARRAY
        System.out.println("--------");
        //TESTING BUBBLESORT WITH TEMPARRAY
        printIntArray(tempArray);
        System.out.println("--------");
        Coursework.bubbleSort(tempArray);
        System.out.println("--------");
        printIntArray(tempArray);
        System.out.println("--------");
        Coursework.bubbleSort(practiceArray);
        //zero swaps in my bubble sort. I must have already sorted the 'practiceArray'
        System.out.println("--------");
        //I'll build another one from the file and sort it
        int [] practiceArray6 = Coursework.readArrayFromFile("practice.txt");
        System.out.println("--------");
        Coursework.bubbleSort(practiceArray6);
        System.out.println("--------");
        //JUST ENSURING I UNDERSTAND HOW FILE READ IN WORKS
        int [] practiceArray7 = Coursework.readArrayFromFile("practice2.txt");
        printIntArray(practiceArray7);

        //Binary Search
        int [] practiceArray8 = Coursework.readArrayFromFile("practice.txt");

        int answer1 = Coursework.binarySearch(practiceArray8 , 10000);
        if (answer1 == -1){
            System.out.println("ANSWER1 - Search not found");
        }//if
        else{
            System.out.println("ANSWER1 - Found in location: " + answer1);
        }//else

        System.out.println("--------");
        System.out.println("Unsorted Array at position zero : " + practiceArray8[0]);
        System.out.println("--------");

//BINARY SEARCH ONLY WORKS ON A SORTED ARRAY
        int answer2 = Coursework.binarySearch(practiceArray8 , 2276239);
        if (answer2 == -1){
            System.out.println("ANSWER2 - Search not found");
        }//if
        else{
            System.out.println("ANSWER2 - Found in location: " + answer2);
        }//else

        System.out.println("--------");
        System.out.println("Sorted Array at position zero : " + practiceArray6[0]);
        System.out.println("--------");

//search a random number I know exists in the text file
        int answer3 = Coursework.binarySearch(practiceArray6 , 2276239);
        if (answer3 == -1){
            System.out.println("ANSWER3 - Search not found");
        }//if
        else{
            System.out.println("ANSWER3 - Found in location: " + answer3);
        }//else

        System.out.println("--------");
//search the given key in the sorted array. Expected at index 8863
        int answer4 = Coursework.binarySearch(practiceArray6 , 7833106);
        if (answer4 == -1){
            System.out.println("ANSWER4 - Search not found");
        }//if
        else{
            System.out.println("ANSWER4 - Found in location: " + answer4);
        }//else


    }//main

}//TestingCoursework
