package easy;
/*
 * 选一个最小的起始的数字，然后逐个相加每一位数，每次都要大于1
 */
public class Prob1413 {
    public int minStartValue(int[] nums){
        /*
         * Approach 1 Brute Force 
         * An intuitive method is to start from the smallest possible value: 1 
         * then, calculate startVal + nums[i], if it's total is < 1, startVal is too small 
         * try again with a larger startVal, but how?  
         * increase the startVal by 1 
         * repeat the whole process, untill the total value is always > 1, then the startVal 
         * is the min value for the finanl result. 
         */

         int startVal = 1;

         //这个while loop 的写法要熟练才行，不太习惯
         while (true){
            int total = startVal; 
            boolean isValid = true; 

            for (int num : nums){
                total += num; 
                if (total < 1){
                    isValid = false; 
                    break; //break out of the loop, the startVal is too small 
                }
            }
            if (isValid){
                return startVal;
            } else {
                startVal += 1; 
            }
         }
    }

    /*
     * Approach 2 Binary Search 
     * The final answer of the minimum startVal separates all valid values from all invalid start values. 
     * left bound can be set to 1 
     * how to set right boud?
     * from the constraints we know: -100 <= nums[i] <= 100
     * so 100 * nums.length + 1 should be enough for the right bound. 
     * (the total will always be larger than 1)
     * [1, 1 + 100*nums.length] 看起来是左闭右闭的区间，因为都可以用
     */
    public int minStartValue2(int[] nums){
        int n = nums.length;
        int m = 100; 
        int left = 1; 
        int right = m * n + 1; 

        while (left < right){
            int middle = (right + left)/2; 
            int total = middle; 
            boolean isValid = true; 

            for (int num : nums){
                total += num; 
                if (total < 1){
                    isValid = false; 
                    break;
                }
            }

            if (isValid){
                right = middle; //middle could be the answer, so right assigned to middle 
            } else {
                left = middle + 1; //middle couldn't be the answer, left assirng to middle + 1
            }
        }
        return left; 
        //when the left and right meet together, we have found the final answer. 
    }

    /*
     * Approach 3: Prefix total 
     * the key step: the minimum startValue is the value that makes the minimum element 
     * in the step-by-step sums equal to exactly 1. 
     * We just need to iterate over the array using startVal = 0, find the minimum
     * step-by-step total in this iteration, and we should have minTotal + startValue = 1; 
     */
    //这个代码很简单，但是算法自己怎么能想出来
    public int minStartValue3(int[] nums){
        int minTotal = 0;
        int total = 0;

        for (int num : nums){
            total += num; 
            minTotal = Math.min(minTotal, total);
        }

        return 1 + minTotal;
    }
}

