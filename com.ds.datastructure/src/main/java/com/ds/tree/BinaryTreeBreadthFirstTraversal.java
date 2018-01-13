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

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBreadthFirstTraversal
{
    BinaryTree binaryTree;

    /**
     * Level Order Traversal.
     */
    public BinaryTreeBreadthFirstTraversal()
    {
        binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
    }

    public void levelOrderTraversal(Node root)
    {
        Queue<Node> queue = new LinkedList<Node>();
        Node tempRoot = root;

        while (tempRoot != null)
        {
            if (tempRoot.left != null)
            {
                queue.add(tempRoot.left);
            }
            if (tempRoot.right != null)
            {
                queue.add(tempRoot.right);
            }

            System.out.print(tempRoot.item + " ");

            tempRoot = queue.poll();

        }

    }
}
