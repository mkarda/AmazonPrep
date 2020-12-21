package graphs;

public class MaxDepthTopBottom {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(2,
                            new TreeNode(4,
                                    new TreeNode(6),
                                    new TreeNode(9)),
                            new TreeNode(2,
                                    new TreeNode(7),
                                    new TreeNode(4)));

        getMaxDepth(t, 1);
        System.out.println(ans);

        int maxDepthReturning = getMaxDepthReturning(t, 0);
        System.out.println(maxDepthReturning);
    }

    static int ans;

    static void getMaxDepth(TreeNode root, int depth) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            ans = Math.max(ans, depth);
        }

        getMaxDepth(root.left, depth + 1);
        getMaxDepth(root.right, depth + 1);
    }


    static int getMaxDepthReturning(TreeNode root, int depth) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
//            depth = Math.max(ans, depth);
            return depth + 1;
        }

        int a = getMaxDepthReturning(root.left, depth + 1);
        int b = getMaxDepthReturning(root.right, depth + 1);
        return Math.max(a,b);
//        return depth;
    }
}
