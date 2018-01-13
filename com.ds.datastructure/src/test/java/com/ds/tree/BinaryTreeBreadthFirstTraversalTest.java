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
