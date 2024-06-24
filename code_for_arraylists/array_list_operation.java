package code_for_arraylists;
import java.util.ArrayList;

public class array_list_operation {
    public static void main(String[] args) {
        // Creating an ArrayList of Strings
        ArrayList<String> arrayList = new ArrayList<>();

        // Adding elements to the ArrayList
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Orange");
        arrayList.add("Grapes");

        // Printing the ArrayList
        System.out.println("ArrayList after adding elements: " + arrayList);

        // Accessing elements using get() method
        String fruit = arrayList.get(2);
        System.out.println("Fruit at index 2: " + fruit);

        // Updating element at index 1
        arrayList.set(1, "Mango");
        System.out.println("Updated ArrayList: " + arrayList);

        // Removing element "Orange"
        arrayList.remove("Orange");
        System.out.println("ArrayList after removing \"Orange\": " + arrayList);

        // Size of the ArrayList
        System.out.println("Size of ArrayList: " + arrayList.size());

        // Iterating over ArrayList using enhanced for-loop
        System.out.print("Iterating over ArrayList: ");
        for (String item : arrayList) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}


