package trees.Heap;
import java.util.ArrayList;
public class min_heap_imp {
    private ArrayList<Integer> heap;
    public min_heap_imp() {
        this.heap = new ArrayList<>();
    }
    // Helper methods
    private int parent(int index) {
        return (index - 1) / 2;
    }
    private int leftChild(int index) {
        return 2 * index + 1;
    }
    private int rightChild(int index) {
        return 2 * index + 2;
    }
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    private void heapifyUp(int index) {
        while (index > 0 && heap.get(parent(index)) > heap.get(index)) {
            swap(index, parent(index));
            index = parent(index);
        }
    }
    private void heapifyDown(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int smallest = index;
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }
    // Insert a new node
    public void insert(int data) {
        heap.add(data);
        heapifyUp(heap.size() - 1);
    }
    // Delete the root node
    public int delete() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int root = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return root;
    }
    // Traverse the heap (in-order, pre-order, post-order)
    public void inOrderTraversal(int index) {
        if (index >= heap.size()) {
            return;
        }
        inOrderTraversal(leftChild(index));
        System.out.print(heap.get(index) + " ");
        inOrderTraversal(rightChild(index));
    }
    public void preOrderTraversal(int index) {
        if (index >= heap.size()) {
            return;
        }
        System.out.print(heap.get(index) + " ");
        preOrderTraversal(leftChild(index));
        preOrderTraversal(rightChild(index));
    }
    public void postOrderTraversal(int index) {
        if (index >= heap.size()) {
            return;
        }
        postOrderTraversal(leftChild(index));
        postOrderTraversal(rightChild(index));
        System.out.print(heap.get(index) + " ");
    }
    // Search for a node
    public int search(int data) {
        return heap.indexOf(data);
    }
    // Update a node
    public void update(int oldData, int newData) {
        int index = search(oldData);
        if (index == -1) {
            throw new IllegalArgumentException("Node not found");
        }
        heap.set(index, newData);
        if (newData < oldData) {
            heapifyUp(index);
        } else {
            heapifyDown(index);
        }
    }
    // Print heap
    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        min_heap_imp heap = new min_heap_imp();

        // Insertions
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);
        heap.insert(15);

        // Print heap
        System.out.print("Heap: ");
        heap.printHeap();

        // Traversals
        System.out.print("In-order: ");
        heap.inOrderTraversal(0);
        System.out.println();

        System.out.print("Pre-order: ");
        heap.preOrderTraversal(0);
        System.out.println();

        System.out.print("Post-order: ");
        heap.postOrderTraversal(0);
        System.out.println();

        // Search
        int searchResult = heap.search(20);
        System.out.println("Search for 20: " + (searchResult != -1 ? "Found at index " + searchResult : "Not found"));

        // Update
        heap.update(20, 25);
        System.out.print("Heap after update: ");
        heap.printHeap();

        // Deletion
        int deleted = heap.delete();
        System.out.println("Deleted root: " + deleted);
        System.out.print("Heap after deletion: ");
        heap.printHeap();
    }
}

