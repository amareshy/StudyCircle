package com.ds.linkedlist;

public class MergeSortForLinkedList
{
    Node head = null;

    public static void main(String[] args)
    {
        //        2->3->20->5->10->15
        MergeSortForLinkedList mergeSortForLinkedList = new MergeSortForLinkedList();
        mergeSortForLinkedList.push(2);
        mergeSortForLinkedList.push(3);
        mergeSortForLinkedList.push(20);
        mergeSortForLinkedList.push(5);
        mergeSortForLinkedList.push(10);
        mergeSortForLinkedList.push(15);
        mergeSortForLinkedList.push(45);

        mergeSortForLinkedList.printList(mergeSortForLinkedList.head);

        //        Node middle = mergeSortForLinkedList.getMiddleNodeOFList(mergeSortForLinkedList.head);
        System.out.println();
        //        System.out.println("Middle node is : " + middle.data);
        // Apply merge Sort
        mergeSortForLinkedList.head = mergeSortForLinkedList.mergeSort(mergeSortForLinkedList.head);
        System.out.print("\n Sorted Linked List is: \n");
        mergeSortForLinkedList.printList(mergeSortForLinkedList.head);
    }

    static class Node
    {
        int data;
        Node next;

        public Node(int item)
        {
            this.data = item;
            this.next = null;
        }

    }

    Node mergeSort(Node node)
    {
        if (node == null || node.next == null)
        {
            return node;
        }

        Node middNode = getMiddleNodeOFList(node);
        Node nextOfMiddle = middNode.next;

        middNode.next = null;

        Node left = mergeSort(node);
        Node right = mergeSort(nextOfMiddle);

        // Merge the left and right lists
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    Node sortedMerge(Node a, Node b)
    {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.data <= b.data)
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else
        {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;

    }

    Node getMiddleNodeOFList(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        Node slowPtr = head;
        Node fastPtr = head.next;

        while (fastPtr != null)
        {
            fastPtr = fastPtr.next;
            if (fastPtr != null)
            {
                fastPtr = fastPtr.next;
                slowPtr = slowPtr.next;
            }
        }
        return slowPtr;
    }

    void push(int data)
    {
        Node node = new Node(data);
        if (head == null)
        {
            head = node;
            return;
        }

        Node tempNode = head;
        while (tempNode.next != null)
        {
            tempNode = tempNode.next;
        }
        tempNode.next = node;
    }

    void printList(Node node)
    {
        do
        {
            System.out.print(node.data + "->");
            node = node.next;
        }
        while (node != null);

    }

}
