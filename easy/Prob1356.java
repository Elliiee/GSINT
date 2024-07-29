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
     * Use Comparable when you want to define a default or natural ordering for a class,
     * with method compareTo()
     * Use Comparator when you want to define multiple ways to compare instances of a class, 
     * with method compare(), which sometimes use the compareTo() method inside 
     * or when you need to define the comparison logic outside the class being compared.
     */


     /*
      * Approach 2 Bit Manipulation
      we will obtain the hamming weight using bit manipulation instead of built-in method 
      which is what most interviews will be expecting. 
      At the heart of bit manipulation are the bit-wise operators:
      NOT (~): flip the bit
      AND (&): if both are 1, it will be 1, otherwise 0 
      OR (|): if at least one 1 bit, it will be 1, otherwise 0 
      XOR (^): if both are different bits, it will be 1, otherwise, the same, it will be 0
      left shift (<<): 
      1 left shift is equivalent to x2
      right shift (>>)
      1 right shift is equivalent to /2
      */
      /*
       * To find the hamming weight, we can use what is called a "mask".
       * This mask will have a single set bit at position 0. 
       * algorithm: 
       * 1. AND this mask with the number, if the result is 1, then it is 1 at the position
       * 2. left shift the mask and AND again, repeat 
       * how do we end the repeat/loop? 
       * first choice: iterate for 31 times 
       * second choice: whenever we find a set bit, flip it to 0 (use XOR)
       * second choice is better, 31 is too much for most of the numbers, right ? 
       */
    //only need to change the object of the Comparator
    //the way of getting the set bits 
    class CustomComparator2 implements Comparator<Integer> {
        private int findWeight(int num){
            int mask = 1; 
            int weight = 0;
            while (num > 0){
                if ((num & mask) > 0){
                    weight++;
                    num ^= mask;
                }
                mask <<= 1;
            }
            return weight; 
        }

        @Override
        public int compare(Integer a, Integer b){
            if (findWeight(a) == findWeight(b)){
                return a - b;
            }
            return findWeight(a) - findWeight(b);
        }
    }


    /*
     * Approach 3: Brian Kerninghan's Algorithm
     * it is an elegant and efficient way to find the number of set bits in a number.   
     * the algorithm runs until there are no more set bits 
     * how do we do it? 
     * algorithm: 
     * num &= (num - 1) (AND, if both are 1, it will be 1)
     * the only net change is that the LSB (least significant bit) will be set to 0, (1 & 0 = 0)
     */
    //this algorithm saves few line of code from approach 2, and no need mask

    class CustomComparator3 implements Comparator<Integer> {
        private int findWeight(int num){
            int weight = 0;
            while (num > 0){
                weight++;
                num &= (num - 1);
            }
            return weight;
        }

        @Override
        public int compare(Integer a, Integer b){
            if (findWeight(a) == findWeight(b)){
                return a - b;
            }
            return findWeight(a) - findWeight(b);
        }
    }
}
