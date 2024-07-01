package trees.Binary_Search_tree;
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}
class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert a new node with the given key
    void insert(int key) {
        root = insertRec(root, key);
    }
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }
    // Delete a node with the given key
    void delete(int key) {
        root = deleteRec(root, key);
    }
    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }
    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            root = root.left;
            minValue = root.key;
        }
        return minValue;
    }
    // In-order traversal
    void inorder() {
        inorderRec(root);
    }
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    // Pre-order traversal
    void preorder() {
        preorderRec(root);
    }
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    // Post-order traversal
    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Search for a node with the given key
    boolean search(int key) {
        return searchRec(root, key) != null;
    }

    Node searchRec(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (root.key > key) {
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);
    }

    // Update the value of a node with the given key
    void update(int oldKey, int newKey) {
        delete(oldKey);
        insert(newKey);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println("In-order traversal:");
        tree.inorder();
        System.out.println("\n\nPre-order traversal:");
        tree.preorder();
        System.out.println("\n\nPost-order traversal:");
        tree.postorder();
        System.out.println("\n\nSearch for 40: " + (tree.search(40) ? "Found" : "Not Found"));
        System.out.println("Search for 90: " + (tree.search(90) ? "Found" : "Not Found"));
        System.out.println("\nDelete 20:");
        tree.delete(20);
        tree.inorder();
        System.out.println("\n\nDelete 30:");
        tree.delete(30);
        tree.inorder();
        System.out.println("\n\nDelete 50:");
        tree.delete(50);
        tree.inorder();
        System.out.println("\n\nUpdate 40 to 45:");
        tree.update(40, 45);
        tree.inorder();
    }
}
