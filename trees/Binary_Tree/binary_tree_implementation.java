package trees.Binary_Tree;
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}
class binary_tree_implementation {
    Node root;

    binary_tree_implementation() {
        root = null;
    }

    // Traversal methods
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        binary_tree_implementation tree = new binary_tree_implementation();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Inorder traversal:");
        tree.inorder(tree.root);
        System.out.println("\nPreorder traversal:");
        tree.preorder(tree.root);
        System.out.println("\nPostorder traversal:");
        tree.postorder(tree.root);
    }
}
