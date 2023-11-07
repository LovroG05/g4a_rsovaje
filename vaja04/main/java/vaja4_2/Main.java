package vaja4_2;


class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {
    Node root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Визуализация BST
    public void visualizeBST() {
        System.out.println("Дерево поиска:");
        visualizeBST(root, "");
    }

    private void visualizeBST(Node node, String prefix) {
        if (node != null) {
            System.out.println(prefix + "└── " + node.data);
            visualizeBST(node.left, prefix + "    ");
            visualizeBST(node.right, prefix + "    ");
        }
    }

    // Построение гистограммы длины пути поиска
    public void buildSearchPathHistogram() {
        System.out.println("graph create:");
        buildSearchPathHistogram(root, 0);
    }

    private void buildSearchPathHistogram(Node node, int depth) {
        if (node != null) {
            System.out.println(node.data + ": " + depth);
            buildSearchPathHistogram(node.left, depth + 1);
            buildSearchPathHistogram(node.right, depth + 1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        /*Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        String[] numberStrings = inputString.split(" ");
        System.out.println(numberStrings.toString());

        int[] intArray = new int[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            intArray[i] = Integer.parseInt(numberStrings[i]);
        }
        System.out.println(intArray);*/

        BST bst = new BST();
        int[] values = {5, 3, 7, 2, 4, 6, 8};

        for (int value : values) {
            bst.insert(value);
        }

        bst.visualizeBST();
        bst.buildSearchPathHistogram();
    }
}
