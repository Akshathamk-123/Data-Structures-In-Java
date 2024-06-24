package linked_list.skip_list;

import java.util.Random;

class SkipListNode {
    int value;
    SkipListNode[] next;

    public SkipListNode(int value, int levels) {
        this.value = value;
        this.next = new SkipListNode[levels];
    }
}

public class skip_list_implementation{
    private static final int MAX_LEVEL = 4;
    private static final double PROBABILITY = 0.5; // Probability for promoting to higher levels
    private SkipListNode head;
    private int levels;

    public skip_list_implementation() {
        this.head = new SkipListNode(Integer.MIN_VALUE, MAX_LEVEL);
        this.levels = 1;
    }

    // Insert a value into the skip list
    public void insert(int value) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL];
        SkipListNode current = head;

        // Find the appropriate position to insert the new node
        for (int i = levels - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
            update[i] = current;
        }

        current = current.next[0];

        // If value is already present, return
        if (current != null && current.value == value) {
            return;
        }

        // Determine the level for the new node
        int newLevel = randomLevel();
        if (newLevel > levels) {
            for (int i = levels; i < newLevel; i++) {
                update[i] = head;
            }
            levels = newLevel;
        }

        // Create new node
        SkipListNode newNode = new SkipListNode(value, newLevel);

        // Insert the new node
        for (int i = 0; i < newLevel; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }

    // Search for a value in the skip list
    public boolean search(int value) {
        SkipListNode current = head;

        for (int i = levels - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
        }

        current = current.next[0];

        return current != null && current.value == value;
    }

    // Delete a value from the skip list
    public void delete(int value) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL];
        SkipListNode current = head;

        // Find the node to delete
        for (int i = levels - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
            update[i] = current;
        }

        current = current.next[0];

        // If value is found, delete it
        if (current != null && current.value == value) {
            for (int i = 0; i < levels; i++) {
                if (update[i].next[i] != current) {
                    break;
                }
                update[i].next[i] = current.next[i];
            }

            // Update levels if necessary
            while (levels > 1 && head.next[levels - 1] == null) {
                levels--;
            }
        }
    }

    // Randomly determine the level of a node
    private int randomLevel() {
        int level = 1;
        Random rand = new Random();
        while (rand.nextDouble() < PROBABILITY && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    // Print the skip list
    public void printSkipList() {
        System.out.println("Skip List:");
        for (int i = levels - 1; i >= 0; i--) {
            SkipListNode current = head.next[i];
            System.out.print("Level " + i + ": ");
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next[i];
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        skip_list_implementation skipList = new skip_list_implementation();

        skipList.insert(10);
        skipList.insert(5);
        skipList.insert(20);
        skipList.insert(15);
        skipList.insert(30);

        skipList.printSkipList();

        System.out.println("Search for 20: " + skipList.search(20));
        System.out.println("Search for 25: " + skipList.search(25));

        skipList.delete(15);
        skipList.delete(5);

        skipList.printSkipList();
    }
}
