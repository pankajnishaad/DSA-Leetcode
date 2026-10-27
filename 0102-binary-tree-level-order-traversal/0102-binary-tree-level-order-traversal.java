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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        int height=getHeight(root);
        for(int level=0; level<height; level++)
        {
            List<Integer>currLevel=new ArrayList<>();
            collectLevel(root, level, currLevel);
            res.add(currLevel);
        }
        return res;
    }
    private int getHeight(TreeNode node)
    {
        if(node==null) return 0;
        int left=getHeight(node.left);
        int right=getHeight(node.right);
        return 1+Math.max(left, right);
    }
    private void collectLevel(TreeNode node, int level, List<Integer>currLevel)
    {
        if(node==null) return;
        if(level==0)
        {
            currLevel.add(node.val);
            return;
        }
        collectLevel(node.left, level-1, currLevel);
        collectLevel(node.right, level-1, currLevel);
    }
}