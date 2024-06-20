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
    static boolean flag;
    public int height(TreeNode root)
    {
        if(root==null) return 0;
        
        int leftH=height(root.left);
        int rightH=height(root.right);
        if(Math.abs(leftH-rightH)>1)
        {
            flag=false;
        }
        return Integer.max(leftH,rightH)+1;
    }
    public boolean isBalanced(TreeNode root) {
        flag=true;
        height(root);
        return flag;
    }
}