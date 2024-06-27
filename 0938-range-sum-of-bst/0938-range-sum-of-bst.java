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
    static int ans;
    public void sum(TreeNode root, int low, int high)
    {
        if(root==null)
            return;
        if(root.val<low)
            sum(root.right,low,high);
        else if(root.val>high)
            sum(root.left,low,high);
        else
        {
            ans+=root.val;
            sum(root.left,low,high);
            sum(root.right,low,high);
        }
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        ans=0;
        sum(root,low,high);
        return ans;
    }
}