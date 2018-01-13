package com.ds.tree;

import java.util.Stack;

public class InorderTreeTraversalWithoutRecursion
{
    public static void main(String[] args)
    {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.createBinaryTree();
        inOrderTraversalWithoutRecursionAndStask(root);
        System.out.println();
        inOrderTraversalUsingStask(root);
    }

    private static void inOrderTraversalUsingStask(Node root)
    {
        System.out.print("inOrderTraversalUsingStask======= : ");

        if (root == null)
            return;

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        Node node = root;

        while (node.left != null)
        {
            node = node.left;
            stack.push(node);
        }

        while (!stack.isEmpty())
        {
            node = stack.pop();
            System.out.print(node.item + " ");
            if (node.right != null)
            {
                node = node.right;
                while (node != null)
                {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    /* Function to traverse binary tree without recursion and
    without stack */

    //TODO : Need to revisit...
    private static void inOrderTraversalWithoutRecursionAndStask(Node root)
    {

        System.out.print("inOrderTraversalWithoutRecursionAndWithoutStask======= : ");
        Node current, pre;
        if (root == null)
            return;

        current = root;
        while (current != null)
        {
            if (current.left == null)
            {
                System.out.print(current.item + " ");
                current = current.right;
            }
            else
            {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null)
                {
                    pre.right = current;
                    current = current.left;
                }

                /* Revert the changes made in if part to restore the
                   original tree i.e.,fix the right child of predecssor*/
                else
                {
                    pre.right = null;
                    System.out.print(current.item + " ");
                    current = current.right;
                } /* End of if condition pre->right == NULL */

            } /* End of if condition current->left == NULL*/

        } /* End of while */

    }
}
