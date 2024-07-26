package easy;
import java.util.*;
public class Prob1356 {
    /*
     * arr is an integer array
     * convert the numbers to binary and count how many 1 it has 
     * sort the counts in ascending order 
     * also, if the numbers have the same amount of 1
     * you have to sort the same amount in ascending order in 十进制/decimal, too, 
     */
    //Bit manipulation is always 很难
    /*
     * 1的数量叫,set bits, 或者也叫做，hamming weight
     * 一般用语言自带的method就可以算出 Integer.bitCount(n);
     */
    public int[] sortByBits(int[] arr){
        //a way to convert an array of primitive int values into an array of Integer objects. 
        //Arrays.stream(arr) method creates an 'IntStream' from the 'int' array
        //.boxed() method converts the 'IntStream' into a 'Stream<Integer>'
        //toArray() method collects the 'Stream<Integer>' into an array
        //'Integer[]::new' is used to create a new array of 'Integer' objects of the correct size 
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Comparator<Integer> comparator = new CustomComparator();

        Arrays.sort(nums, comparator);

        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }

    class CustomComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b){
            if (Integer.bitCount(a) == Integer.bitCount(b)){
                return a - b; //ascending order of decimal 
            }
            return Integer.bitCount(a) - Integer.bitCount(b); 
            //ascending order of set bits/hamming weight
        }
    }
    /*
     * Use Comparable when you want to define a default or natural ordering for a class.
     * Use Comparator when you want to define multiple ways to compare instances of a class, 
     * or when you need to define the comparison logic outside the class being compared.
     */
}
