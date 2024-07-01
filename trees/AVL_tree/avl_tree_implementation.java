package trees.AVL_tree;
class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int d) {
        key = d;
        height = 1;
    }
}
class AVLTree {
    private AVLNode root;

    // Get the height of the node
    int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.height;
    }
    // Get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
    // Right rotate subtree rooted with y
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }
    // Left rotate subtree rooted with x
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }
    // Get balance factor of node N
    int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
    // Insert a key into the AVL tree
    AVLNode insert(AVLNode node, int key) {
        // Perform the normal BST insertion
        if (node == null)
            return (new AVLNode(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        // Update height of this ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // Get the balance factor of this ancestor node to check whether
        // this node became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Find the node with minimum key value
    AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;

        // Loop down to find the leftmost leaf
        while (current.left != null)
            current = current.left;

        return current;
    }
    // Delete a node from the AVL tree
    AVLNode deleteNode(AVLNode root, int key) {
        // Perform the normal BST deletion
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
        else {
            // Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                AVLNode temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of the non-empty child
            } else {
                // Node with two children: Get the inorder successor (smallest
                // in the right subtree)
                AVLNode temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // Update height of the current node
        root.height = max(height(root.left), height(root.right)) + 1;

        // Get the balance factor of this node (to check whether this node
        // became unbalanced)
        int balance = getBalance(root);
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    // In-order traversal
    void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }
    // Pre-order traversal
    void preorder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    // Post-order traversal
    void postorder(AVLNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }
    // Search for a key in the AVL tree
    boolean search(int key) {
        return searchRec(root, key) != null;
    }
    AVLNode searchRec(AVLNode root, int key) {
        if (root == null || root.key == key)
            return root;

        if (root.key > key)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }
    // Update the value of a node with the given key
    void update(int oldKey, int newKey) {
        root = deleteNode(root, oldKey);
        root = insert(root, newKey);
    }
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
        System.out.println("In-order traversal:");
        tree.inorder(tree.root);
        System.out.println();
        System.out.println("Pre-order traversal:");
        tree.preorder(tree.root);
        System.out.println();
        System.out.println("Post-order traversal:");
        tree.postorder(tree.root);
        System.out.println();
        System.out.println("Search for 30: " + (tree.search(30) ? "Found" : "Not Found"));
        System.out.println("Search for 100: " + (tree.search(100) ? "Found" : "Not Found"));
        System.out.println("\nDelete 20:");
        tree.root = tree.deleteNode(tree.root, 20);
        tree.inorder(tree.root);
        System.out.println();
        System.out.println("\nUpdate 30 to 35:");
        tree.update(30, 35);
        tree.inorder(tree.root);
        System.out.println();
    }
}
