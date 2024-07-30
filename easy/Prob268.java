package easy;
//268.Missing Number
/*
 * Given an array nums containing n distinct numbers in the range [0, n], 
 * return the only number in the range that is missing from the array.
 */
public class Prob268 {
    public int missingNumber(int[] nums){ //[0, n] total length is n + 1
        int missing = nums.length; //because 1 missing, so total length is n
        for (int i = 0; i < nums.length; i++){
            missing ^= i ^ nums[i]; //missing = i ^ nums[i] ^ missing, i is from 0 to n-1
            //so we need to add n (here is "missing"), so we XOR the whole range of [0, n] 
        }
        return missing; 
    }
    /*
     * AND & : both be 1, then 1 
     * OR |: at least one 1, then 1 
     * NOT ~: flip the bit 
     * XOR ^: if bits are different, then 1, otherwise 0 
     */
}
