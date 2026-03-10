package com.tcpserver.nic.model;

import java.util.Arrays;

public class ChocolateDistribution {
    public static void main(String[] args) {
        /*Given an array arr[] of n integers where arr[i] represents the number of chocolates in ith packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that:

        Each student gets exactly one packet.
        The difference between the maximum and minimum number of chocolates in the packets given to the students is minimized.
                Examples:

        Input: arr[] = {7, 3, 2, 4, 9, 12, 56}, m = 3
        Output: 2
        Explanation: If we distribute chocolate packets {3, 2, 4}, we will get the minimum difference, that is 2.

        Input: arr[] = {7, 3, 2, 4, 9, 12, 56}, m = 5
        Output: 7
        Explanation: If we distribute chocolate packets {3, 2, 4, 9, 7}, we will get the minimum difference, that is 9 - 2 = 7.
         */
        int[] arr = {7,3,2,4,9,12,56};
        int m = 4;

        ChocolateDistribution c1 = new ChocolateDistribution();
        int result = c1.distributChocolate(arr,m);
        System.out.println("The Max difference  "+result);
    }

    public int distributChocolate(int[] arr, int m)
    {
        Arrays.sort(arr);
        int maxDiff = Integer.MAX_VALUE;

        for(int i=0; i+m-1<arr.length;i++)
        {
            int diff = arr[i+m-1]-arr[i];

            if(diff < maxDiff)
            {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }
}
