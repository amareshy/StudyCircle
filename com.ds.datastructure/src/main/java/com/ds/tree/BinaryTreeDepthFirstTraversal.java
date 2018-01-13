package com.ds.tree;

/**
 * All the Depth First Traversal of Tree.
 */
public class BinaryTreeDepthFirstTraversal
{
    BinaryTree binaryTree;

    /**
     *
     */
    public BinaryTreeDepthFirstTraversal()
    {

        binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
    }

    /* Given a binary tree, print its nodes in inOrder*/
    public void printTreeInOrder(Node node)
    {
        if (node == null)
        {
            return;
        }

        printTreeInOrder(node.left);
        System.out.print(node.item + " ");

        printTreeInOrder(node.right);
    }

    /* Given a binary tree, print its nodes in preOrder*/
    public void printTreePreOrder(Node node)
    {
        if (node == null)
        {
            return;
        }

        System.out.print(node.item + " ");
        printTreePreOrder(node.left);
        printTreePreOrder(node.right);

    }

    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    public void printTreePostOrder(Node node)
    {
        if (node == null)
        {
            return;
        }

        printTreePostOrder(node.left);
        printTreePostOrder(node.right);

        System.out.print(node.item + " ");
    }
}
