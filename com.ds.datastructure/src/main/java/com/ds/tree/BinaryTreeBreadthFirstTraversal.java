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
