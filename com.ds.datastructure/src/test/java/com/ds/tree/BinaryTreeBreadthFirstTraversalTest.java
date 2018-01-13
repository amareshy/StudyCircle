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

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeBreadthFirstTraversalTest
{
    BinaryTreeBreadthFirstTraversal bfsTraversal;

    @Before
    public void setupTest()
    {
        bfsTraversal = new BinaryTreeBreadthFirstTraversal();
    }

    @Test
    public void levelOrderTraversalTest()
    {
        bfsTraversal.levelOrderTraversal(bfsTraversal.binaryTree.root);
        System.out.println("Level Order Traversal end.");
    }

}
