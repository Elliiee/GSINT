package easy2;
/*
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced
 * A height-balanced binary tree is a binary tree 
 * in which the depth of the two subtrees of every node never differs by more than one.
 */
//这题我以前做过，但是现在完全记不得，还是觉得很难想到。
public class Prob110 {
    private boolean result = true; 

    public boolean isBalanced(TreeNode root){
        if (root == null) return true;
        
        maxDepth(root);
        return result; 
    }

    private int maxDepth(TreeNode node){
        if (node == null) return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        if (Math.abs(left - right) > 1){
            result = false; 
        }

        return Math.max(left, right) + 1; 
    }
}
