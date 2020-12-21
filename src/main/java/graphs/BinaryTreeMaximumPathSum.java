package graphs;

public class BinaryTreeMaximumPathSum {

    //najwiekszy wynik scieżki prze node, niekoniecznie przez root

    public static void main(String[] args) {

        TreeNode t = new TreeNode(2, new TreeNode(4, new TreeNode(6), new TreeNode(9)), new TreeNode(2));

        int answer = max_gain(t);
        System.out.println(answer);

    }

    static int max_sum = Integer.MIN_VALUE;

    public static int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }
}
