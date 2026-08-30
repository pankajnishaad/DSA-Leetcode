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
    private void dfs(TreeNode node, String path, List<String> res)
    {
        if(path.equals("")) path=""+node.val;
        else path+="->"+node.val;
        if(node.left==null && node.right==null)
        {
            res.add(path);
            return;
        }
        if(node.left!=null)
        {
            dfs(node.left, path, res);
        }
        if(node.right!=null)
        {
            dfs(node.right, path, res);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        dfs(root, "", res);
        return res;
    }
}