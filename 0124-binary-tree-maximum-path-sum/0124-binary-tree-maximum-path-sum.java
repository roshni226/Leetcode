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
    public int maxPathUtil(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int leftPath= Math.max(0,maxPathUtil(root.left));
        int rightPath= Math.max(0,maxPathUtil(root.right));
        
        int currAns= Math.max(Math.max(root.val,leftPath+rightPath+root.val),
                      Math.max(leftPath+root.val,rightPath+root.val));
        
        ans= Math.max(ans,currAns);
        
        int currPath= Math.max(root.val,
                               Math.max(leftPath+root.val,rightPath+root.val));
        
        return currPath;
    }
    public int maxPathSum(TreeNode root) {
        ans=Integer.MIN_VALUE;
        maxPathUtil(root);
        return ans;
    }
}