import java.util.List;

public class SetParents {

    public static void main(String[] args) {

    }

    void setParents(List<Node> nodes) {
        // enter your code
        for (Node n : nodes) {

            if (n.getRight() != null) {
                n.getRight().setParent(n);
            }
            if (n.getLeft() != null) {
                n.getLeft().setParent(n);
            }
        }
    }
}


interface Node {
    Node getLeft();

    Node getRight();

    Node getParent();

    void setParent(Node parent);
}