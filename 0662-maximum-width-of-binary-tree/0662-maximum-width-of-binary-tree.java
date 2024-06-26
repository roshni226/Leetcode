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
class Pair
{
    TreeNode node;
    int index;
    Pair(TreeNode node, int index)
    {
        this.node=node;
        this.index=index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        if(root==null) return ans;
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(root,1));
        while(!q.isEmpty())
        {
            int levelSize= q.size();
            int first= q.peek().index;
            int last= q.peek().index;
            for(int i=0;i<levelSize;i++)
            {
                Pair p= q.remove();
                TreeNode curr=p.node;
                int currIdx= p.index;
                
                if(curr.left!=null)
                    q.add(new Pair(curr.left,2*currIdx));
                if(curr.right!=null)
                    q.add(new Pair(curr.right,2*currIdx+1));
                last= currIdx;
                
            }
            
            ans= Math.max(ans,last-first+1);
        }
        
        return ans;
    }
}