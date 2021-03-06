package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {

        TreeNode t = new TreeNode(2,
                new TreeNode(4,
                        new TreeNode(6),
                        new TreeNode(9)),
                new TreeNode(2));
        List<List<Integer>> answer = zigzagLevelOrder(t);
        System.out.println(answer);

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        // add the root element with a delimiter to kick off the BFS loop
        LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
        node_queue.addLast(root);
        //dodajemy null jako znacznik konca nodów dla danej liniii, jak sie natkniemy to resetujemy liste i zmieniamy jak strone dodawania nodów
        node_queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<Integer>();
        boolean is_order_left = true;

        while (node_queue.size() > 0) {
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                if (is_order_left)
                    level_list.addLast(curr_node.val);
                else
                    level_list.addFirst(curr_node.val);

                if (curr_node.left != null)
                    node_queue.addLast(curr_node.left);
                if (curr_node.right != null)
                    node_queue.addLast(curr_node.right);

            } else {
                // we finish the scan of one level
                results.add(level_list);
                level_list = new LinkedList<Integer>();
                // prepare for the next level
                if (node_queue.size() > 0)
                    node_queue.addLast(null);
                is_order_left = !is_order_left;
            }
        }
        return results;
    }
}
