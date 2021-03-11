public class MergeNodes {

    public static void main(String[] args) {

        NodeM n11 = new NodeM();
        NodeM n12 = new NodeM();
        NodeM n13 = new NodeM();
        NodeM n14 = new NodeM();

        n11.setData(1);
        n12.setData(2);
        n13.setData(5);
        n14.setData(7);

        n11.setNext(n12);
        n12.setNext(n13);
        n13.setNext(n14);

        NodeM n21 = new NodeM();
        NodeM n22 = new NodeM();
        NodeM n23 = new NodeM();
        NodeM n24 = new NodeM();
        NodeM n25 = new NodeM();
        NodeM n26 = new NodeM();
        NodeM n27 = new NodeM();

        n21.setNext(n22);
        n22.setNext(n23);
        n23.setNext(n24);
        n24.setNext(n25);
        n25.setNext(n26);
        n26.setNext(n27);


        n21.setData(1);
        n22.setData(1);
        n23.setData(1);
        n24.setData(2);
        n25.setData(4);
        n26.setData(5);
        n27.setData(7);

        merge(n11, n21);

    }

    static NodeM merge(NodeM head1, NodeM head2) {

        NodeM mergeNode = new NodeM();
        mergeNode.setData(0);
        NodeM tail = mergeNode;

        while (true) {
            if (head1 == null) {
                tail.setNext(head2);
                break;
            }
            if (head2 == null) {
                tail.setNext(head1);
                break;
            }
            if(head1.getData() <= head2.getData()) {
                tail.setNext(head1);
                head1 = head1.getNext();
            }
            else {
                tail.setNext(head2);
                head2 = head2.getNext();
            }
            tail = tail.getNext();
        }
        return mergeNode.getNext();
    }
}


class NodeM {

    private int data;
    private NodeM next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeM getNext() {
        return next;
    }

    public void setNext(NodeM next) {
        this.next = next;
    }
}
