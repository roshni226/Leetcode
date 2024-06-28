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
    public boolean validate(TreeNode root, TreeNode min, TreeNode max)
    {
        if(root==null)
            return true;
        if(min!=null && root.val<=min.val)
            return false;
        if(max!=null && root.val>=max.val)
            return false;
        //Left subtree: all values less than root
        boolean ans1= validate(root.left,min,root);
        //right sutree: all values greater than root
        boolean ans2= validate(root.right,root,max);
        
        return ans1 && ans2;
    }
    public boolean isValidBST(TreeNode root) {
        return validate(root,null,null);        
    }
}