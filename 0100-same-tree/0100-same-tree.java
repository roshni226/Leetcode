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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;//any one tree is empty
        // using level order traversal to check
        Queue<TreeNode> t1= new LinkedList<>();
        Queue<TreeNode> t2= new LinkedList<>();
        
        //root of tree 1 is p
        //root of tree 2 is q
        t1.add(p);
        t1.add(null);
        t2.add(q);
        t2.add(null);
        
        while(!t1.isEmpty() && !t2.isEmpty())
        {
            TreeNode curr1= t1.remove();
            TreeNode curr2= t2.remove();
            
            if(curr1==null && curr2==null)
            {
                continue;
            }
            if(curr1==null || curr2==null)// any one is null
            {
                return false;
            }
            
            if(curr1.val != curr2.val)
            {
                return false;
            }
            
                t1.add(curr1.left);
                t2.add(curr2.left);
                t1.add(curr1.right);
                t2.add(curr2.right);
         }
        return true;
    }
}