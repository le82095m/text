import java.util.Objects;

public class Node {
    public int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val;
    }
}
