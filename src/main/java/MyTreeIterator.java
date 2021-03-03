import java.util.Iterator;
import java.util.Stack;

public class MyTreeIterator {
    public static void main(String[] args) {

        BST a = new BST();
        NodeClass root = null;

        root = a.insert(root, 8);
        root = a.insert(root, 3);
        root = a.insert(root, 6);
        root = a.insert(root, 10);
        root = a.insert(root, 4);
        root = a.insert(root, 7);
        root = a.insert(root, 1);
        root = a.insert(root, 14);
        root = a.insert(root, 13);

    }
}


class TreeIterator implements Iterator<Node> {

    private final Node root;

    Stack<Node> stack = new Stack<>();

    public TreeIterator(Node root) {
        leftMostNode(root);
        this.root = root;
    }

    void leftMostNode(Node root) {
        while(root != null) {
            stack.push(root);
            root = root.getLeft();
        }
    }

    @Override
    public boolean hasNext() {
        // enter your code
        return stack.size() > 0;
    }

    @Override
    public Node next() {
        // enter your code

        Node topNode = stack.pop();
        if(topNode.getRight() != null) {
            leftMostNode(topNode.getRight());
        }
        return topNode;
    }
}

interface Node {
    NodeClass getLeft();
    NodeClass getRight();
}


class NodeClass implements Node {

    NodeClass left;
    NodeClass right;
    int val;

    @Override
    public NodeClass getLeft() {
        return left;
    }

    @Override
    public NodeClass getRight() {
        return right;
    }
}

class BST {

    public NodeClass insert(NodeClass node, int val) {
        if(node == null) {
            return createNewNode(val);
        }

        if(val < node.val) {
            node.left = insert(node.left, val);
        } else if((val > node.val)) {
            node.right = insert(node.right, val);
        }

        return node;
    }

    public NodeClass createNewNode(int k) {
        NodeClass a = new NodeClass();
        a.val = k;
        a.left = null;
        a.right = null;
        return a;
    }
}
