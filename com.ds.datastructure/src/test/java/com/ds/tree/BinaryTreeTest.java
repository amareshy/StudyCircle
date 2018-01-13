package com.ds.tree;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest
{

    @Test
    public void createBinaryTreeTest()
    {
        BinaryTree binaryTree = new BinaryTree();
        Assert.assertNull(binaryTree.root);

        binaryTree.createBinaryTree();

        Assert.assertNotNull(binaryTree.root);
    }

    @Test
    public void deleteTreeTest()
    {
        BinaryTree binaryTree = new BinaryTree();
        Assert.assertNull(binaryTree.root);

        binaryTree.createBinaryTree();
        Assert.assertNotNull(binaryTree.root);

        binaryTree.deleteTree(binaryTree.root);

        System.out.println("Tree deleted.");
    }

    @Test
    public void heightOfTreeTest()
    {
        BinaryTree binaryTree = new BinaryTree();
        Assert.assertNull(binaryTree.root);

        binaryTree.createBinaryTree();
        Assert.assertNotNull(binaryTree.root);

        int h = binaryTree.heightOfTree(binaryTree.root);

        System.out.println("Tree height : " + h);
    }

    @Test
    public void countLeafNodeTest()
    {
        BinaryTree binaryTree = new BinaryTree();
        Assert.assertNull(binaryTree.root);

        binaryTree.createBinaryTree();
        Assert.assertNotNull(binaryTree.root);

        int count = binaryTree.countLeafNode(binaryTree.root);

        System.out.println("Tree leaf node count : " + count);
    }
}
