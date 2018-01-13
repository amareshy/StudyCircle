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
package com.ds.linkedlist;

import java.util.Scanner;

public class SinglyLinkedList
{
    Node head = null;
    Node lastNode = null;

    public SinglyLinkedList()
    {
    }

    public static void main(String[] args)
    {
        @SuppressWarnings ("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter no of nodes in linked list : ");

        int noOfNode = scanner.nextInt();
        int data;
        Node node;
        SinglyLinkedList singlyList = new SinglyLinkedList();
        System.out.println("Please enter your linkedlist data separating by enter key.....");
        for (int i = 0; i < noOfNode; i++)
        {
            data = scanner.nextInt();
            node = singlyList.createNode(data);
            singlyList.addNode(node);
        }

        singlyList.displayNodes();
    }

    private Node createNode(int data)
    {
        return new Node(data);
    }

    private void addNode(Node node)
    {
        if (this.head == null)
        {
            this.head = node;
            lastNode = node;
            return;
        }

        lastNode.next = node;
        lastNode = node;
    }

    private void displayNodes()
    {
        Node node = head;
        while (true)
        {
            System.out.print(node.data + "  ");
            if (node.next == null)
            {
                break;
            }
            node = node.next;
        }

    }
}
