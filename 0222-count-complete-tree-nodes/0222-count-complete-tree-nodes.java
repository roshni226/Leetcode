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
    public int findLHeight(TreeNode root)
    {
         int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
        
    }
    public int findRHeight(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1+findRHeight(root.right);
        
    }
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lh=findLHeight(root);
        int rh=findRHeight(root);
        if(lh==rh)
        {
            return (int)Math.pow(2,lh)-1;
        }
        else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }
        
    }
}