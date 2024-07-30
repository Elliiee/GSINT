package easy;

public class Prob657 {
    public boolean judgeCircle(String moves){
        int rightCount = 0; 
        int downCount = 0;
        for (char c : moves.toCharArray()){
            if (c == 'R'){
                rightCount++;
            } else if (c == 'L'){
                rightCount--;
            } else if (c == 'D'){
                downCount++;
            } else if (c == 'U'){
                downCount--;
            }
        }
        return rightCount == 0 && downCount == 0;
    }
}
