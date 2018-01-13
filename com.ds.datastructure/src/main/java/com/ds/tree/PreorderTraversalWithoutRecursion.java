package com.ds.tree;

import java.util.Stack;

public class PreorderTraversalWithoutRecursion
{
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        Node root = tree.createBinaryTree();

        preorderTraversalWithoutRecursion(root);
        System.out.println();
        System.out.println("Constructing another tree for traversal......");

        Node root2 = constructingTree();
        System.out.println("Now Traversal......");
        preorderTraversalWithoutRecursion(root2);
    }

    //Using Stack to print a tree in preorder.
    private static void preorderTraversalWithoutRecursion(Node root)
    {
        if (root == null)
        {
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            Node node = stack.pop();
            System.out.print(node.item + " ");

            if (node.right != null)
            {
                stack.push(node.right);
            }

            if (node.left != null)
            {
                stack.push(node.left);
            }
        }
    }

    private static Node constructingTree()
    {
        Node root = null;
        root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);

        return root;
    }
}
