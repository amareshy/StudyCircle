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
package com.ds.binarysearchtree;

import java.util.Scanner;

public class BinarySearchTreeDelete
{
    static BinarySearchTreeSearchInsert bstInsert;

    public BinarySearchTreeDelete()
    {
        bstInsert = new BinarySearchTreeSearchInsert();
    }

    public static void main(String[] args)
    {
        BinarySearchTreeDelete bstDelete = new BinarySearchTreeDelete();
        bstDelete.createBST();
        while (true)
        {
            System.out.print("Enter node to be deleted from BST : ");
            Scanner scanner = new Scanner(System.in);
            int item = scanner.nextInt();
            if (item == -1)
            {
                break;
            }
            bstDelete.deletionInBinaryTree(bstInsert.root, item);
        }
    }

    private void createBST()
    {
        System.out.println("Enter no of node in BST : ");
        @SuppressWarnings ("resource")
        Scanner scanner = new Scanner(System.in);
        int noOfInput = scanner.nextInt();
        for (int i = 1; i <= noOfInput; i++)
        {
            System.out.print("Enter node" + i + "  : ");
            int item = scanner.nextInt();
            bstInsert.root = bstInsert.insertKeyInBST(bstInsert.root, item);
        }

        System.out.println("BST created.....");
    }

    private void deletionInBinaryTree(Node root, int item)
    {
        if (root == null)
        {
            return;
        }

        Node tempNode = root;
        while (tempNode != null)
        {
            if (tempNode.item == item)
            {
                //Deletion Logic should be called.
                deleteNode(root, tempNode);
                break;
            }
            else if (item < tempNode.item)
            {
                tempNode = tempNode.left;
            }
            else if (item > tempNode.item)
            {
                tempNode = tempNode.right;
            }
            else
            {
                System.out.println("Item not found....");
            }
        }
    }

    private void deleteNode(Node parent, Node tempNode)
    {
        System.out.println("tempNode : " + tempNode.item);

        //case 1:  when node has no child : Leaf node
        if (deleteLeafNode(tempNode))
        {
            return;
        }

        //Case 2: If node has only one child :
        if (deleteNodeHasOneChild(tempNode))
        {
            return;
        }

        //Case 3: if Both Left and right child are not null. Take the Smallest in the right sub tree of tempNode. Replace with the tempNode to smallest node and simply delete the temp node.
        deleteNodeHasBothChild(tempNode);
    }

    private boolean deleteLeafNode(Node tempNode)
    {
        if (tempNode.left == null && tempNode.right == null)
        {
            System.out.println("Leaf node... Simply delete : Left = " + tempNode.left + " Right : " + tempNode.right);
            return true;
        }
        return false;
    }

    private boolean deleteNodeHasOneChild(Node tempNode)
    {
        if (tempNode.left == null && tempNode.right != null)
        {
            System.out.println("Has one right child: Left = " + tempNode.left + " Right : " + tempNode.right);
            return true;
        }

        if (tempNode.left != null && tempNode.right == null)
        {
            System.out.println("Has one left child: Left = " + tempNode.left + " Right : " + tempNode.right);
            return true;
        }
        return false;
    }

    private void deleteNodeHasBothChild(Node tempNode)
    {

    }
}
