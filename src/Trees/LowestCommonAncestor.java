package Trees;

public class LowestCommonAncestor {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }  
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) { return null;}
        if (p == q) { return p;}
        if (p.val < root.val && q.val < root.val) { return lowestCommonAncestor(root.left, p, q);}
        if (p.val > root.val && q.val > root.val) { return lowestCommonAncestor(root.right, p, q);}

        return root;
    } 
    public static void main(String[] args) {

        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3, new TreeNode(1), new TreeNode(4));
        root.left.right = new TreeNode(2);

        root.right = new TreeNode(8, new TreeNode(7), new TreeNode(9));

        TreeNode p = root.left;
        TreeNode q = root.right;

        TreeNode output = lca.lowestCommonAncestor(root, p, q);
        System.out.print("lowest Common Ancestor: " + output.val);

    }
}
