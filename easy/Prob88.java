package easy;
/*
 * 88. Merge Sorted Array
 * You are given two integer arrays nums1 and nums2,
 * sorted in non-decreasing order, and two integers m and n, 
 * representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, 
 * but instead be stored inside the array nums1. 
 * To accommodate this, nums1 has a length of m + n, 
 * where the first m elements denote the elements that should be merged, 
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class Prob88 {
    //因为这里题目说的是nums1的长度正好是两者长度之和，那就是可以从后来往前面放，并且两者都已经是递增的顺序
    public void merge(int[] nums1, int m, int[] nums2, int n){
        m--; //m is the total length, minus 1 to get the last index of nums1
        n--; //the same as m 
        int i = nums1.length-1; 
        while (i >= 0){
            if (m < 0){
                nums1[i--] = nums2[n--];
            } else if (n < 0){
                nums1[i--] = nums1[m--];
            } else {
                if (nums1[m] > nums2[n]){
                    nums1[i--] = nums1[m--];
                } else {
                    nums1[i--] = nums2[n--];
                }
            }
        }
    }  
}
