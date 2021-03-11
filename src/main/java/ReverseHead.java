
public class ReverseHead {
    public static void main(String[] args) {

        NodeN one = new NodeClass(1);
        one.setNext(new NodeClass(2));
        NodeN two = one.getNext();
        two.setNext(new NodeClass(3));
        NodeN three = two.getNext();
        three.setNext(new NodeClass(4));
        NodeN four = three.getNext();
        reverse(one);
    }

    static NodeN reverse(NodeN head) {
        // enter your code
        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            return head;
        }

        NodeN prev = null;
        NodeN curr = head;
        NodeN next;

        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }
}


interface NodeN {
    NodeN getNext();

    void setNext(NodeN next);
}


class NodeClass implements NodeN {

    public int val;

    public NodeClass(int val) {
        this.val = val;
    }

    public NodeN next;

    @Override
    public NodeN getNext() {
        return next;
    }

    @Override
    public void setNext(NodeN next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
