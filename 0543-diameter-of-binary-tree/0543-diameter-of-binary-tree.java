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
    static class TreeInfo
    {
        int ht;
        int diam;
        TreeInfo(int ht, int diam)
        {
            this.ht=ht;
            this.diam=diam;
        }
    }
    public TreeInfo diameter(TreeNode root)
    {
        if(root== null) return new TreeInfo(0,0);
        TreeInfo leftSubinfo=diameter(root.left);
        TreeInfo rightSubinfo=diameter(root.right);
        
        int currHeight= Math.max(leftSubinfo.ht,rightSubinfo.ht)+1;
        
        int diam1=leftSubinfo.diam;
        int diam2=rightSubinfo.diam;
        int diam3=leftSubinfo.ht+rightSubinfo.ht;
        
        int currdiam= Math.max(diam1,Math.max(diam2,diam3));
        
        return new TreeInfo(currHeight, currdiam);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).diam;
    }
}