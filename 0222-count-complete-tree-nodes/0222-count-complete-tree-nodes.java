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
    static int count;
    public void util(TreeNode root)
    {
        if(root.left!=null)
        {
            count++;
            util(root.left);
        }
        if(root.right!=null)
        {
            count++;
            util(root.right);
        }
    }
    public int countNodes(TreeNode root) {
        count=0;
        if(root==null) return 0;
        count++;
        util(root);
        return count;
    }
}