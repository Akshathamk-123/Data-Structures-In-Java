package trees.B_Tree;

class BTreeNode {
    int[] keys; // An array of keys
    int t; // Minimum degree (defines the range for number of keys)
    BTreeNode[] C; // An array of child pointers
    int n; // Current number of keys
    boolean leaf; // Is true when node is leaf. Otherwise false

    // Constructor
    BTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        this.keys = new int[2 * t - 1];
        this.C = new BTreeNode[2 * t];
        this.n = 0;
    }

    // A utility function to insert a new key in this node
    void insertNonFull(int k) {
        int i = n - 1;
        if (leaf) {
            // Find the location of the new key to be inserted and move all greater keys to one place ahead
            while (i >= 0 && keys[i] > k) {
                keys[i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = k;
            n = n + 1;
        } else {
            while (i >= 0 && keys[i] > k)
                i--;
            if (C[i + 1].n == 2 * t - 1) {
                splitChild(i + 1, C[i + 1]);
                if (keys[i + 1] < k)
                    i++;
            }
            C[i + 1].insertNonFull(k);
        }
    }

    // A utility function to split the child y of this node
    void splitChild(int i, BTreeNode y) {
        BTreeNode z = new BTreeNode(y.t, y.leaf);
        z.n = t - 1;

        for (int j = 0; j < t - 1; j++)
            z.keys[j] = y.keys[j + t];

        if (!y.leaf) {
            for (int j = 0; j < t; j++)
                z.C[j] = y.C[j + t];
        }

        y.n = t - 1;

        for (int j = n; j >= i + 1; j--)
            C[j + 1] = C[j];

        C[i + 1] = z;

        for (int j = n - 1; j >= i; j--)
            keys[j + 1] = keys[j];

        keys[i] = y.keys[t - 1];

        n = n + 1;
    }

    // A function to traverse all nodes in a subtree rooted with this node
    void traverse() {
        int i;
        for (i = 0; i < n; i++) {
            if (!leaf)
                C[i].traverse();
            System.out.print(keys[i] + " ");
        }

        if (!leaf)
            C[i].traverse();
    }

    // A function to search a key in the subtree rooted with this node
    BTreeNode search(int k) {
        int i = 0;
        while (i < n && k > keys[i])
            i++;
        if (keys[i] == k)
            return this;
        if (leaf)
            return null;
        return C[i].search(k);
    }

    // Function to remove a key from the subtree rooted with this node
    void remove(int k) {
        int idx = findKey(k);

        if (idx < n && keys[idx] == k) {
            if (leaf)
                removeFromLeaf(idx);
            else
                removeFromNonLeaf(idx);
        } else {
            if (leaf) {
                System.out.println("The key " + k + " is not present in the tree\n");
                return;
            }
            boolean flag = (idx == n);

            if (C[idx].n < t)
                fill(idx);

            if (flag && idx > n)
                C[idx - 1].remove(k);
            else
                C[idx].remove(k);
        }
    }

    // A utility function to find the index of the first key that is greater than or equal to k
    int findKey(int k) {
        int idx = 0;
        while (idx < n && keys[idx] < k)
            ++idx;
        return idx;
    }

    // A function to remove the idx-th key from this node - which is a leaf node
    void removeFromLeaf(int idx) {
        for (int i = idx + 1; i < n; ++i)
            keys[i - 1] = keys[i];
        n--;
    }

    // A function to remove the idx-th key from this node - which is a non-leaf node
    void removeFromNonLeaf(int idx) {
        int k = keys[idx];

        if (C[idx].n >= t) {
            int pred = getPred(idx);
            keys[idx] = pred;
            C[idx].remove(pred);
        } else if (C[idx + 1].n >= t) {
            int succ = getSucc(idx);
            keys[idx] = succ;
            C[idx + 1].remove(succ);
        } else {
            merge(idx);
            C[idx].remove(k);
        }
    }

    // A function to get the predecessor of the key- where the key is present in the idx-th position in the node
    int getPred(int idx) {
        BTreeNode cur = C[idx];
        while (!cur.leaf)
            cur = cur.C[cur.n];
        return cur.keys[cur.n - 1];
    }

    // A function to get the successor of the key- where the key is present in the idx-th position in the node
    int getSucc(int idx) {
        BTreeNode cur = C[idx + 1];
        while (!cur.leaf)
            cur = cur.C[0];
        return cur.keys[0];
    }

    // A function to fill child C[idx] which has less than t-1 keys
    void fill(int idx) {
        if (idx != 0 && C[idx - 1].n >= t)
            borrowFromPrev(idx);
        else if (idx != n && C[idx + 1].n >= t)
            borrowFromNext(idx);
        else {
            if (idx != n)
                merge(idx);
            else
                merge(idx - 1);
        }
    }

    // A function to borrow a key from C[idx-1] and insert it into C[idx]
    void borrowFromPrev(int idx) {
        BTreeNode child = C[idx];
        BTreeNode sibling = C[idx - 1];

        for (int i = child.n - 1; i >= 0; --i)
            child.keys[i + 1] = child.keys[i];

        if (!child.leaf) {
            for (int i = child.n; i >= 0; --i)
                child.C[i + 1] = child.C[i];
        }

        child.keys[0] = keys[idx - 1];

        if (!child.leaf)
            child.C[0] = sibling.C[sibling.n];

        keys[idx - 1] = sibling.keys[sibling.n - 1];

        child.n += 1;
        sibling.n -= 1;
    }

    // A function to borrow a key from the C[idx+1] and place it in C[idx]
    void borrowFromNext(int idx) {
        BTreeNode child = C[idx];
        BTreeNode sibling = C[idx + 1];
        child.keys[child.n] = keys[idx];
        if (!(child.leaf))
            child.C[child.n + 1] = sibling.C[0];

        keys[idx] = sibling.keys[0];
        for (int i = 1; i < sibling.n; ++i)
            sibling.keys[i - 1] = sibling.keys[i];

        if (!sibling.leaf) {
            for (int i = 1; i <= sibling.n; ++i)
                sibling.C[i - 1] = sibling.C[i];
        }
        child.n += 1;
        sibling.n -= 1;
    }

    // A function to merge C[idx] with C[idx+1]
    void merge(int idx) {
        BTreeNode child = C[idx];
        BTreeNode sibling = C[idx + 1];
        child.keys[t - 1] = keys[idx];
        for (int i = 0; i < sibling.n; ++i)
            child.keys[i + t] = sibling.keys[i];

        if (!child.leaf) {
            for (int i = 0; i <= sibling.n; ++i)
                child.C[i + t] = sibling.C[i];
        }
        for (int i = idx + 1; i < n; ++i)
            keys[i - 1] = keys[i];
        for (int i = idx + 2; i <= n; ++i)
            C[i - 1] = C[i];
        child.n += sibling.n + 1;
        n--;
    }
    // Update the value of a node with the given key
    void update(int oldKey, int newKey) {
        remove(oldKey);
        insertNonFull(newKey);
    }
}
public class b_tree_imp {
    private BTreeNode root;
    private int t; // Minimum degree
    public b_tree_imp(int t) {
        this.root = null;
        this.t = t;
    }
    // Function to traverse the tree
    public void traverse() {
        if (root != null)
            root.traverse();
    }
    // Function to search a key in this tree
    public BTreeNode search(int k) {
        return (root == null) ? null : root.search(k);
    }
    // Function to insert a new key in this tree
    public void insert(int k) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = k;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                BTreeNode s = new BTreeNode(t, false);
                s.C[0] = root;
                s.splitChild(0, root);
                int i = 0;
                if (s.keys[0] < k)
                    i++;
                s.C[i].insertNonFull(k);
                root = s;
            } else
                root.insertNonFull(k);
        }
    }
    // Function to delete a key in this tree
    public void remove(int k) {
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }
        root.remove(k);

        if (root.n == 0) {
            if (root.leaf)
                root = null;
            else
                root = root.C[0];
        }
    }
    // Update the value of a node with the given key
    public void update(int oldKey, int newKey) {
        if (root != null) {
            root.update(oldKey, newKey);
        }
    }
    public static void main(String[] args) {
        b_tree_imp t = new b_tree_imp(3);
        t.insert(10);
        t.insert(20);
        t.insert(5);
        t.insert(6);
        t.insert(12);
        t.insert(30);
        t.insert(7);
        t.insert(17);
        System.out.println("Traversal of the constructed tree is");
        t.traverse();
        System.out.println();
        t.remove(6);
        System.out.println("Traversal of the tree after removal of 6");
        t.traverse();
        System.out.println();
        t.remove(13);
        System.out.println("Traversal of the tree after removal of 13");
        t.traverse();
        System.out.println();
        t.remove(7);
        System.out.println("Traversal of the tree after removal of 7");
        t.traverse();
        System.out.println();
        t.remove(4);
        System.out.println("Traversal of the tree after removal of 4");
        t.traverse();
        System.out.println();
        t.remove(2);
        System.out.println("Traversal of the tree after removal of 2");
        t.traverse();
        System.out.println();
        t.remove(16);
        System.out.println("Traversal of the tree after removal of 16");
        t.traverse();
        System.out.println();
        t.update(20, 25);
        System.out.println("Traversal of the tree after updating 20 to 25");
        t.traverse();
        System.out.println();
    }
}
