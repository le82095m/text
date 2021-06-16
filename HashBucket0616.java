public class HashBucket {
    private static class TreeNode {
        private int key;
        private int value;
        TreeNode next;
        public TreeNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private TreeNode[] array;
    private int size;
    private static final double LOAD_FACTOR = 0.75;

    public static void main(String[] args) {

    }
}
