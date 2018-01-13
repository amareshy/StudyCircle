package com.ds.problems;

import java.util.Scanner;

public class GFG
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int noOfTest = scanner.nextInt();
        int noOfArrayElement = 0;
        for (int i = 0; i < noOfTest; i++)
        {
            //            System.out.println("Input no of elements in array for case : " + (i + 1));
            noOfArrayElement = scanner.nextInt();
            //            System.out.println("Provide array elements by space seperated ");
            int arr[] = new int[noOfArrayElement];
            for (int j = 0; j < noOfArrayElement; j++)
            {
                arr[j] = scanner.nextInt();
            }
            getNumbers(arr);

        }

    }

    public static void getNumbers(int arr[])
    {
        int start = 0, end = arr.length - 1;
        boolean found = false;
        while (start < end)
        {
            if (arr[start] == 1 || arr[start] == 2 || arr[start] == 3)
            {
                System.out.print(arr[start] + " ");
                found = true;
            }

            if (arr[end] == 1 || arr[end] == 2 || arr[end] == 3)
            {
                System.out.print(arr[end] + " ");
                found = true;
            }

            start++;
            end--;

            if (start == end)
            {
                if (arr[end] == 1 || arr[end] == 2 || arr[end] == 3)
                {
                    System.out.print(arr[end] + " ");
                    found = true;
                }
                break;
            }

        }
        if (!found)
        {
            System.out.print("-1");
        }

    }
}
