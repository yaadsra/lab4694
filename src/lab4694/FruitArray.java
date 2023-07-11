package lab4694;

public class FruitArray {
	
	public static void main(String[] args) {
		
		// ------------------ Part 1 ------------------
		
        // 1: Create a string array of size 10 with fruit names
        String[] fruits = {"Apple", "Avocado", "Apricot", "Berry", "Banana", "Orange", "Peach", "Kiwi", "Mango", "Plum"};

        // 2: Show the original array and array size
        System.out.println("Original Array: ");
        displayArray(fruits);
        System.out.println("Original Array Size: " + fruits.length);

        // 3: Copy the original array into another
        String[] copiedArray = fruits.clone();

        // 4: Insert a new fruit name at index 3 of the array
        String newFruit = "Grape";
        insertElement(copiedArray, newFruit, 3);
        System.out.println("\nNew Fruit: " + newFruit);

        // 4a. Show the current array and array size
        System.out.println("\nAfter Insertion at index 3 Array: ");
        displayArray(copiedArray);
        System.out.println("After Insertion at index 3 Array Size: " + copiedArray.length);

        // 4b. Create a new array of size 11, insert the new fruit at index 3
        String[] newArray = new String[11];
        System.arraycopy(fruits, 0, newArray, 0, fruits.length);
        insertElement(newArray, newFruit, 3);
        System.out.println("\nAfter Insertion at index 3 of new Array: ");
        displayArray(newArray);
        System.out.println("After Insertion at index 3 of new Array Size: " + newArray.length);

        // 5: Delete the fruit from index 6 of original array
        String deletedFruit = deleteElement(fruits, 6);
        System.out.println("\nDeleted Fruit: " + deletedFruit);

        // 5a. Show the current array and array size
        System.out.println("\nAfter deleting from index 6 of Array: ");
        displayArray(fruits);
        System.out.println("After deleting from index 6 of Array Size: " + fruits.length);

        // 5b. Create an array of size 9 with updated fruit names after deletion
        String[] updatedArray = new String[9];
        System.arraycopy(fruits, 0, updatedArray, 0, updatedArray.length);
        System.out.println("\nAfter deleting from index 6 of new Array: ");
        displayArray(updatedArray);
        System.out.println("After deleting from index 6 of new Array Size: " + updatedArray.length);

        
        // ------------------ Part 2: ------------------

        
        // 1. Create a linked list of strings
        LinkedList linkedList = new LinkedList();

        // 2. Add names of 10 fruits to the linked list using addNode logic
        linkedList.addNode("Apple");
        linkedList.addNode("Avocado");
        linkedList.addNode("Apricot");
        linkedList.addNode("Berry");
        linkedList.addNode("Banana");
        linkedList.addNode("Orange");
        linkedList.addNode("Peach");
        linkedList.addNode("Kiwi");
        linkedList.addNode("Mango");
        linkedList.addNode("Plum");

        // 3. Display the original linked list
        System.out.println("\nNodes of singly linked list:");
        linkedList.displayList();

        // 4. Find the size of the linked list
        int linkedListSize = linkedList.getSize();
        System.out.println("Linked List Size: " + linkedListSize);
    }

    // Display the contents of an array
    private static void displayArray(String[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println("]");
    }

    // Insertion algorithm
    private static void insertElement(String[] array, String newElement, int position) {
        for (int i = array.length - 1; i >= position; i--) {
            array[i] = array[i - 1];
        }
        array[position] = newElement;
    }

    // Deletion algorithm
    private static String deleteElement(String[] array, int position) {
        String deletedElement = array[position];
        for (int i = position + 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
        return deletedElement;
    }

    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private static class LinkedList {
        Node head;
        int size;

        LinkedList() {
            this.head = null;
            this.size = 0;
        }

        void addNode(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

        void displayList() {
            if (head == null) {
                System.out.println("Singly Linked List is empty");
                return;
            }
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        int getSize() {
            return size;
        }
    }
}

