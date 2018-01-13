package com.ds.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class BinaryTreeDepthFirstTraversalTest
{
    private BinaryTreeDepthFirstTraversal binaryTreeTraversal;
    private Node root;

    @Before
    public void beforeTest()
    {
        binaryTreeTraversal = new BinaryTreeDepthFirstTraversal();
        root = binaryTreeTraversal.binaryTree.root;
    }

    @Test
    public void printTreeInOrderTest()
    {
        System.out.println("\nInorder traversal of binary tree is ");
        binaryTreeTraversal.printTreeInOrder(root);
    }

    @Test
    public void printTreePreOrderTest()
    {
        System.out.println("Preorder traversal of binary tree is ");
        binaryTreeTraversal.printTreePreOrder(root);
    }

    @Test
    public void printTreePostOrder()
    {
        System.out.println("\nPostorder traversal of binary tree is ");
        binaryTreeTraversal.printTreePostOrder(root);
    }

    @After
    public void tearDown()
    {

    }
}
