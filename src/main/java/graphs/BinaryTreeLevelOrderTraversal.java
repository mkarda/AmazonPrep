package graphs;

import java.util.ArrayList;
import java.util.List;

//preorder -> root, left, right
//inorder -> left, root, right
//postorder -> left, right, root



public class BinaryTreeLevelOrderTraversal {
    //wypisac rzedy jako arrays
    static List<List<Integer>> levels = new ArrayList<>();


    public static void main(String[] args) {

        TreeNode t = new TreeNode(2, new TreeNode(4, new TreeNode(6), new TreeNode(9)), new TreeNode(2));

        List<List<Integer>> lists = levelOrder(t);
        System.out.println(lists);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

    public static void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }


}
