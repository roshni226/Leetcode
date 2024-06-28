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
    
    public TreeNode createBST(int st, int end, List<Integer> temp)
    {
        if(st>end)
            return null;
        
        int mid=(st+end)/2;
        
        TreeNode root= new TreeNode(temp.get(mid));
        
        root.left=createBST(st,mid-1,temp);
        root.right=createBST(mid+1,end,temp);
        
        return root;
        
    }
    public void inorder(TreeNode root,List<Integer> temp)
    {
        if(root==null)
            return;
        inorder(root.left,temp);
        temp.add(root.val);
        inorder(root.right,temp);
        
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> temp= new ArrayList<>();
        TreeNode ans;
        inorder(root,temp);
        ans=createBST(0,temp.size()-1,temp);
        return ans;     
        
    }
}