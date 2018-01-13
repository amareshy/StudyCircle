package com.ds.tree;

import java.util.Stack;

public class PostorderTraversalWithoutRecursion
{
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        Node root = tree.createBinaryTree();

        postorderTraversalUsingTwoStask(root);
    }

    //TODO : Need to revisit.........
    private static void postOrderTraversalUsingOneStack(Node treeRoot)
    {
        if (treeRoot == null)
        {
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.push(treeRoot);

        Node node = stack.pop();
        while (!stack.isEmpty())
        {
            Node root = node;
            while (root != null)
            {
                if (root.right != null)
                {
                    stack.push(root.right);
                    stack.push(root);
                }
                else
                {
                    stack.push(root);
                }
                root = root.left;
            }

            node = stack.pop();
            if (node.right != null && node.right == node)
            {

            }
        }
    }

    //PostOrder Traversal using Two Stack....
    private static void postorderTraversalUsingTwoStask(Node root)
    {
        if (root == null)
        {
            return;
        }

        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> resultStack = new Stack<Node>();

        s1.push(root);

        while (!s1.isEmpty())
        {
            Node node = s1.pop();
            if (node.left != null)
            {
                s1.push(node.left);
            }
            if (node.right != null)
            {
                s1.push(node.right);
            }

            resultStack.push(node);
        }

        while (!resultStack.isEmpty())
        {
            System.out.print(resultStack.pop().item + " ");
        }
    }

}
