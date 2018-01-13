package com.ds.binarysearchtree;

import java.util.Stack;

//A binary tree node
class MyNode
{

    int data;
    MyNode left, right;

    MyNode(int d)
    {
        data = d;
        left = right = null;
    }
}

public class PreorderTraversalToBST
{
    // The main function that constructs BST from pre[]
    MyNode constructTree(int pre[], int size)
    {

        // The first element of pre[] is always root
        MyNode root = new MyNode(pre[0]);

        Stack<MyNode> s = new Stack<MyNode>();

        // Push root
        s.push(root);

        // Iterate through rest of the size-1 items of given preorder array
        for (int i = 1; i < size; ++i)
        {
            MyNode temp = null;

            /* Keep on popping while the next value is greater than
             stack's top value. */
            while (!s.isEmpty() && pre[i] > s.peek().data)
            {
                temp = s.pop();
            }

            // Make this greater value as the right child and push it to the stack
            if (temp != null)
            {
                temp.right = new MyNode(pre[i]);
                s.push(temp.right);
            }

            // If the next value is less than the stack's top value, make this value
            // as the left child of the stack's top node. Push the new node to stack
            else
            {
                temp = s.peek();
                temp.left = new MyNode(pre[i]);
                s.push(temp.left);
            }
        }

        return root;
    }

    // A utility function to print inorder traversal of a Binary Tree
    void printInorder(MyNode node)
    {
        if (node == null)
        {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        PreorderTraversalToBST tree = new PreorderTraversalToBST();
        int pre[] = new int[]
        { 10, 5, 1, 7, 40, 50 };
        int size = pre.length;
        MyNode root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }

}
