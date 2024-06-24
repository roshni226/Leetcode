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
    public boolean Symmetric(TreeNode root1, TreeNode root2)
    {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val!= root2.val) return false;
        
        boolean ans1= Symmetric(root1.left,root2.right);
        boolean ans2= Symmetric(root1.right,root2.left);
        
        return ans1 && ans2;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return Symmetric(root.left,root.right);
    }
}