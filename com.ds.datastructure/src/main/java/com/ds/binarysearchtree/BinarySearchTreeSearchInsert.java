package com.ds.binarysearchtree;

public class BinarySearchTreeSearchInsert
{
    Node root;

    public BinarySearchTreeSearchInsert()
    {
        root = null;
    }

    public void createFixedBinarySearchTree()
    {
        root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
    }

    public Node searchKeyInBinarySearchTree(Node root, int item)
    {
        if (root == null)
        {
            System.out.println("Not Found...");
            return null;
        }
        if (root.item == item)
        {
            System.out.println("Element found : " + root.item);
            return root;
        }

        if (item < root.item)
        {
            return searchKeyInBinarySearchTree(root.left, item);
        }
        return searchKeyInBinarySearchTree(root.right, item);
    }

    public Node insertKeyInBST(Node root, int item)
    {
        if (root == null)
        {
            return new Node(item);
        }
        Node tempNode = root;

        while (tempNode != null)
        {
            if (item < tempNode.item)
            {
                if (tempNode.left == null)
                {
                    tempNode.left = new Node(item);
                    System.out.println("Item : " + item + " is inserted to left of " + tempNode.item);
                    break;
                }
                tempNode = tempNode.left;
            }
            else
            {
                if (tempNode.right == null)
                {
                    tempNode.right = new Node(item);
                    System.out.println("Item : " + item + " is inserted to right of " + tempNode.item);
                    break;
                }
                tempNode = tempNode.right;
            }
        }
        return root;
    }

    public static void main(String[] args)
    {
        BinarySearchTreeSearchInsert binarySearchTree = new BinarySearchTreeSearchInsert();
        binarySearchTree.createFixedBinarySearchTree();
        Node node = binarySearchTree.searchKeyInBinarySearchTree(binarySearchTree.root, 13);

        System.out.println("returned Node : " + (node != null ? node.item : node));

        System.out.println("Insert item in BST.................");
        binarySearchTree.insertKeyInBST(binarySearchTree.root, 5);
    }
}
