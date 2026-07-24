package trees;

import java.util.HashMap;

public class ConstructBinaryTreeFromTraversal {

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

    // initi preorder index to 0 and creat5e inorderMap
    int preorderIndex = 0;
    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode arrayToTree(int[] preorder, int left, int right) {

        // base case 
        if (left > right) { return null;}

        // the first element in preorder is always the root
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // find where the split occurs
        int inorderIndex = inorderMap.get(rootValue);

        // build the left and right subtrees
        root.left = arrayToTree(preorder, left, inorderIndex - 1);
        root.right = arrayToTree(preorder, inorderIndex + 1, right);

        // return the root
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // loop through inorder to map the index and value
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // return the tree
        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    public static void printTree(TreeNode root) {

        if (root == null) { return;}

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromTraversal cbt = new ConstructBinaryTreeFromTraversal();
        int[] preorder = {1,2,3,4};
        int[] inorder = {2,1,3,4};
        TreeNode output = cbt.buildTree(preorder,inorder);
        System.out.print("Output: ");
        printTree(output);

    }
}
