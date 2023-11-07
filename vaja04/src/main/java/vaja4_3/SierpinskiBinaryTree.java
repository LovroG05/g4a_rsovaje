package vaja4_3;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


class Node {
    int data;
    vaja4_1.Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {
    vaja4_1.Node root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private vaja4_1.Node insertRec(vaja4_1.Node root, int data) {
        // Если дерево пустое, создаем новый узел
        if (root == null) {
            root = new vaja4_1.Node(data);
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

    private void visualizeBST(vaja4_1.Node node, String prefix) {
        if (node != null) {
            // Выводим значение узла с отступом для наглядности
            System.out.println(prefix + "└── " + node.data);
            // Рекурсивно визуализируем левое и правое поддеревья
            visualizeBST(node.left, prefix + "    ");
            visualizeBST(node.right, prefix + "    ");
        }
    }
}

public class SierpinskiBinaryTree extends JFrame {
    private final int[] values = {10, 4, 15, 2, 7, 12, 20, 1, 3, 6, 8, 11, 14, 18, 22};
    private Node root;
    private int[] sortedValues;
    private int depth;

    public static void main(String[] args) {
        SierpinskiBinaryTree frame = new SierpinskiBinaryTree();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
        vaja4_1.BST bst = new vaja4_1.BST();
        for (char c : charArray) {
            bst.insert(Character.getNumericValue(c));
        }
        bst.visualizeBST();
    }

    public SierpinskiBinaryTree() {
        setTitle("Sierpinski Binary Tree");
        sortedValues = Arrays.copyOf(values, values.length);
        Arrays.sort(sortedValues);
        depth = (int) (Math.log(values.length) / Math.log(2));

        root = sortedArrayToBST(sortedValues, 0, sortedValues.length - 1);

        SierpinskiPanel panel = new SierpinskiPanel(root, depth);
        add(panel);
    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    class SierpinskiPanel extends JPanel {
        private final Node root;
        private final int depth;

        public SierpinskiPanel(Node root, int depth) {
            this.root = root;
            this.depth = depth;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawSierpinskiTree(g, getWidth() / 2, 50, depth, 300, root);
        }

        private void drawSierpinskiTree(Graphics g, int x, int y, int depth, int size, Node node) {
            if (node == null || depth == 0) {
                return;
            }

            g.drawLine(x, y, x, y + size);
            g.drawLine(x, y, x - size / 2, y + size / 2);
            g.drawLine(x, y, x + size / 2, y + size / 2);

            int nextSize = size / 2;

            drawSierpinskiTree(g, x, y + size, depth - 1, nextSize, node.left);
            drawSierpinskiTree(g, x - size / 2, y + size / 2, depth - 1, nextSize, node.left);
            drawSierpinskiTree(g, x + size / 2, y + size / 2, depth - 1, nextSize, node.right);
        }
    }

    private Node sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }
}
