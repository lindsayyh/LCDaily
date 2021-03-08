package Leetcode;

public class LCA4 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>(Arrays.asList(nodes));
        return lowestCommonAncestorHelper(root,set);
    }
    public TreeNode lowestCommonAncestorHelper(TreeNode root,Set<TreeNode> set) {
        if(root == null || set.contains(root)){
            return root;
        }
        TreeNode left = lowestCommonAncestorHelper(root.left,set);
        TreeNode right = lowestCommonAncestorHelper(root.right,set);
        if(left!=null && right!=null){
            return root;
        }
        return left == null?right:left;
    }
}
