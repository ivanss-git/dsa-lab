package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import utils.MyClass;

public class SerializeAndDeserialize {

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

    public class Codec {
        public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();           
        }

        public void serializeHelper(TreeNode root, StringBuilder sb) {
            if (root == null) { 
                sb.append("#,"); 
                return;
            }
            sb.append(root.val).append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }

        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) { 
                return null;
            }
            String[] tokens = data.split(",");
            Queue<String> queue = new LinkedList<>(Arrays.asList(tokens));
            return deserializeHelper(queue);
        }

        public TreeNode deserializeHelper(Queue<String> queue) {
        String currentToken = queue.poll();
        if (currentToken == null || currentToken.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(currentToken));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
        }
    }
    public static void main(String[] args) {
        // Build a sample binary tree: [1, 2, 3, null, null, 4, 5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeAndDeserialize sad =new SerializeAndDeserialize();
        Codec codec = sad.new Codec();

        // Test serialize
        String serialized = codec.serialize(root);
        MyClass.log("Serialized: " + serialized);
        
        // Test deserialize
        TreeNode deserializedRoot = codec.deserialize(serialized);
        String reserialized = codec.serialize(deserializedRoot);
        MyClass.log("Re-serialized: " + reserialized);
    }
}
