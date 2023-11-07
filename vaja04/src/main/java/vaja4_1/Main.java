package vaja4_1;

import java.util.Scanner;

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
        // Если дерево пустое, создаем новый узел
        if (root == null) {
            root = new Node(data);
            return root;
        }
        // Рекурсивно вставляем узел в левое или правое поддерево в зависимости от значения
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Визуализация BST
    public void visualizeBST() {
        System.out.println("BS Tree:");
        visualizeBST(root, "");
    }

    private void visualizeBST(Node node, String prefix) {
        if (node != null) {
            // Выводим значение узла с отступом для наглядности
            System.out.println(prefix + "└── " + node.data);
            // Рекурсивно визуализируем левое и правое поддеревья
            visualizeBST(node.left, prefix + "    ");
            visualizeBST(node.right, prefix + "    ");
        }
    }
}

class TST {
    char data;
    TST left, middle, right;

    public TST(char data) {
        this.data = data;
        left = middle = right = null;
    }

    // Визуализация TST
    public void visualizeTST() {
        System.out.println("TS Tree:");
        visualizeTST(this, "");
    }

    private void visualizeTST(TST node, String prefix) {
        if (node != null) {
            // Выводим символ узла с отступом для наглядности
            System.out.println(prefix + "└── " + node.data);
            // Рекурсивно визуализируем левое, среднее и правое поддеревья
            visualizeTST(node.left, prefix + "    ");
            visualizeTST(node.middle, prefix + "    ");
            visualizeTST(node.right, prefix + "    ");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        char[] charArray = inputString.toCharArray();

        System.out.println(charArray);

        // Создание и визуализация BST
        BST bst = new BST();
        for (char c : charArray) {
            bst.insert(Character.getNumericValue(c));
        }
        bst.visualizeBST();

        // Создание и визуализация TST
        TST tst = new TST(charArray[0]);
        for (int i = 1; i < charArray.length; i++) {
            tst.middle = new TST(charArray[i]);
            tst = tst.middle;
        }
        tst.visualizeTST();
    }
}
