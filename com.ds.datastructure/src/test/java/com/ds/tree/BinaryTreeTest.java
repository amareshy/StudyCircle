//**********************************************************************
// Copyright (c) 2017 Telefonaktiebolaget LM Ericsson, Sweden.
// All rights reserved.
// The Copyright to the computer program(s) herein is the property of
// Telefonaktiebolaget LM Ericsson, Sweden.
// The program(s) may be used and/or copied with the written permission
// from Telefonaktiebolaget LM Ericsson or in accordance with the terms
// and conditions stipulated in the agreement/contract under which the
// program(s) have been supplied.
// **********************************************************************
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
