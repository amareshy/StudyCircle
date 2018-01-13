package com.ds.tree;

public class BinaryTree
{
    Node root;

    public BinaryTree()
    {
        root = null;
    }

    /**
     * Create a binary tree.
     */
    public Node createBinaryTree()
    {
        this.root = new Node(1);
        this.root.left = new Node(2);
        this.root.right = new Node(3);
        this.root.left.left = new Node(4);
        this.root.left.right = new Node(5);

        return this.root;
    }

    public void deleteTree(Node node)
    {
        if (node == null)
        {
            return;
        }

        deleteTree(node.left);
        deleteTree(node.right);

        System.out.println("Deleted node is :" + node.item);
        node = null;
    }

    public int heightOfTree(Node root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = heightOfTree(root.left);
            int rheight = heightOfTree(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    public int countLeafNode(Node node)
    {
        if (node == null)
        {
            return 0;
        }

        if (node.left == null && node.right == null)
            return 1;
        else
        {
            return countLeafNode(node.left) + countLeafNode(node.right);
        }

    }
}
