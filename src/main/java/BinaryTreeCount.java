public class BinaryTreeCount {
    public static void main(String[] args) {

        NodeT root = new NodeT();
        NodeT a = new NodeT();
        NodeT b = new NodeT();
        NodeT c = new NodeT();
        NodeT d = new NodeT();
        root.setLeft(a);
        root.setRight(b);
        root.getLeft().setLeft(c);
        root.getLeft().setRight(d);

        treeDepth(root);
        System.out.println(treeDepth(root));
    }

    static int treeDepth(NodeT root) {

        if (root == null) {
            return 0;
        } else {
            int depthLeft = treeDepth(root.getLeft());
            int depthRight = treeDepth(root.getRight());

            if (depthLeft > depthRight) {
                return depthLeft + 1;

            } else {
                return depthRight + 1;
            }
        }
    }

    static int treeLeafCount(Node root) {
        // enter your code
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        } else return treeLeafCount(root.getLeft()) + treeLeafCount(root.getRight());
    }

}


class NodeT {
    private NodeT left;
    private NodeT right;

    public NodeT getLeft() {
        return left;
    }

    public void setLeft(NodeT left) {
        this.left = left;
    }

    public NodeT getRight() {
        return right;
    }

    public void setRight(NodeT right) {
        this.right = right;
    }
}