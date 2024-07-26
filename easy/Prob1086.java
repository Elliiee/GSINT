package easy;
import java.util.*;
public class Prob1086 {
    //这题不知道怎么用数据结构，算法倒是不难理解吧

    private int K;

    public int[][] highFive(int[][] items){
        this.K = 5; 

        //TreeMap makes the ID in the increasing order 
        TreeMap<Integer, Queue<Integer>> allScores = new TreeMap<>();
        for (int[] item : items){
            allScores.putIfAbsent(item[0], new PriorityQueue<>((a, b) -> (b - a))); //max heap
            allScores.get(item[0]).add(item[1]);
        }

        //solution is an ArrayList which has int[] as element 
        List<int[]> solution = new ArrayList<>();
        for (int id : allScores.keySet()){
            int sum = 0; 
            for (int i = 0; i < this.K; i++){
                sum += allScores.get(id).poll(); //Retrieves and removes the head of this queue
            }
            solution.add(new int[]{id, sum / this.K}); //solution is still an ArrayList 
        }

        int[][] solutionArray = new int[solution.size()][]; //create a jagged array, omit the second size
        return solution.toArray(solutionArray); // ArrayList.toArray(arr)
    }
    /*
     * items, where items[i] = [IDi, scorei]
     * Return the answer as an array of pairs result, 
     * where result[j] = [IDj, topFiveAveragej] 
     * represents the student with IDj and their top five average. 
     * Sort result by IDj in increasing order.
     * For each IDi, there will be at least five scores.
     */
}
