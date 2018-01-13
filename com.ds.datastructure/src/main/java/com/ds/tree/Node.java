package com.ds.tree;

public class Node
{
    final int item;
    Node left, right;

    public Node(int item)
    {
        this.item = item;
    }

    /**
     * @return the left
     */
    public Node getLeft()
    {
        return left;
    }

    /**
     * @return the right
     */
    public Node getRight()
    {
        return right;
    }

    /**
     * @return the item
     */
    public int getItem()
    {
        return item;
    }
}
