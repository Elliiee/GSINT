package easy;
/*
 * You are given a string s. Simulate events at each second i:
 * If s[i] == 'E', a person enters the waiting room and takes one of the chairs in it.
 * If s[i] == 'L', a person leaves the waiting room, freeing up a chair.
 * Return the minimum number of chairs needed so that a chair is available 
 * for every person who enters the waiting room given that it is initially empty.
 */
public class Prob3168 {
    public int minimumChairs(String s){
        int chairs = 0;
        int taken = 0;  
        for (char c : s.toCharArray()){
            if (c == 'E'){
                if (chairs - taken <= 0){
                    chairs++;
                } 
                taken++;
            } else if (c == 'L'){
                taken--;
            }
        }
        return chairs;
    }
}
