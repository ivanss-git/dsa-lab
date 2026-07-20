package Trees;

public class SubtreeOfAnother {

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

    public boolean isSametree(TreeNode s, TreeNode t) {
        // this is a step within the main function; if empty, assume the root node is the subtree
        if (s == null && t == null) { return true;}
        // if we assume the root node is also the subtree, we must check to make sure that's true
        if (s == null || t == null || s.val != t.val) { return false;}
        // If the tree has a subtree, check to make sure L & R of each matches
        return (s.val == t.val && isSametree(s.left, t.left) && isSametree(s.right, t.right));
    }

    public boolean isSubtree(TreeNode root, TreeNode subTree) {
        // base case: if root is null, it cannot possibly have a subtree
        if (root == null) { return false;}
        // case 2: return true if the roots match
        if (isSametree(root, subTree)) { return true;}
        // recursive call to check nodes futher down the tree
        return isSubtree(root.left, subTree) || isSubtree(root.right, subTree); 
    }

    public static void main(String[] args) {
        SubtreeOfAnother soa = new SubtreeOfAnother();

        // construct the main tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3);

        // construct the subtree and print result
        TreeNode subRoot = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        boolean result = soa.isSubtree(root, subRoot);
        System.out.print(result);
    }
}
