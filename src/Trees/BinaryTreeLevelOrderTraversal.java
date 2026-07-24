package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) { return null;}

        // initialize queue to the root of BT by inserting it if possible
        q.offer(root);

        while (!q.isEmpty()) {
            int lvlSize = q.size();
            List<Integer> sublist = new ArrayList<>();

            for (int i = 0; i < lvlSize; i++) {
                TreeNode current = q.poll();
                sublist.add(current.val);

                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            list.add(sublist);
        }
        return list;
    }
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal btlot = new BinaryTreeLevelOrderTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));

        List<List<Integer>> output = btlot.levelOrder(root);
        System.out.print(output);
    }
}
