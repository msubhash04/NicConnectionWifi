package com.tcpserver.nic.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {26,16,89,56,91,6,82};
        ReverseArray r1 = new ReverseArray();
        reverseArray(arr);
        r1.reverseArrayUsingCollection(arr);
    }

    public static void reverseArray(int[] arr)
    {
        int start = 0;
        int end = arr.length-1;

        while(start<end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        System.out.print("Reversed Array :  [");
//        for(int i=0; i<=arr.length-1;i++)
//        {
//            System.out.print(arr[i]+" ");
//        }
        for(int a1:arr)
        {
            System.out.print(a1+" ");
        }
        System.out.print("]");
    }

    public void reverseArrayUsingCollection(int[] arr)
    {
        List<Integer> li = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.reverse(li);
        System.out.println("Reverse Array : "+li);
    }
}
