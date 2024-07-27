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
    public TreeNode buildTree(int[] preorder, int[] inorder, int ps,int pe, int is,  int ie, Map<Integer,Integer> map)
    {
        if(ps>pe || is>ie)
        {
            return null;
        }
        if(ps==pe||is==ie)
        {
            return new TreeNode(preorder[ps]);
        }
        TreeNode root= new TreeNode(preorder[ps]);
        int rootidx=map.get(preorder[ps]);
        int leftSubSize= rootidx-is;
        root.left=buildTree(preorder,inorder,ps+1,ps+leftSubSize,is,rootidx,map);
        root.right=buildTree(preorder,inorder,ps+leftSubSize+1,pe,rootidx+1,ie,map);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n= preorder.length;
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(inorder[i],i);
        }
        if(n==0) return null;
        return buildTree(preorder, inorder,0,n-1,0,n-1,map);
    }
}