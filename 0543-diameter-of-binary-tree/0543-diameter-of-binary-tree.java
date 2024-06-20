/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int height(TreeNode root)
    {
        if(root==null) return 0;
        int leftH= height(root.left);
        int rightH= height(root.right);
        return Math.max(leftH,rightH)+1;
    }
    public int diameter(TreeNode root)
    {
        if(root==null) return 0;
        int diam1= diameter(root.left);
        int diam2= diameter(root.right);
        int diam3= height(root.left)+height(root.right);
        return Math.max(diam1,Math.max(diam2,diam3));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        return diameter(root); 
    }
}