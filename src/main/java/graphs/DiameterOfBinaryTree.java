package graphs;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {

        TreeNode t = new TreeNode(2,
                new TreeNode(4,
                        new TreeNode(6),
                        new TreeNode(9)),
                new TreeNode(2));
        int answer = diameterOfBinaryTree(t);
        System.out.println(answer);


    }

    static int ans = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
//        return ans - 1;
        return ans;
    }
    public static int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R);
        return Math.max(L, R) + 1;
    }
}
