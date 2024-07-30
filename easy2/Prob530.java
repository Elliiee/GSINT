package easy2;
/*
 * 530. Minimum Absolute Difference in BST
 * Given the root of a Binary Search Tree (BST), 
 * return the minimum absolute difference between the values of any two different nodes in the tree.
 */
//it's a bst tree, so the answer should between the nodes connected together 
import java.util.*;
public class Prob530 {
    List<Integer> result = new ArrayList<>();

    public int getMinimumDifference(TreeNode root){
        int min = Integer.MAX_VALUE;

        if (root == null) return min;

        inorder(root);

        for (int i = 1; i < result.size(); i++){
            min = Math.min(min, Math.abs(result.get(i) - result.get(i-1)));
        }
        return min;
    }

    private void inorder(TreeNode root){
        if (root == null) return;

        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
}
