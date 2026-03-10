package com.tcpserver.nic.model;

import java.util.Arrays;
import java.util.HashSet;

public class DuplicateEleArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,2,5,2,3,9,3};

        DuplicateEleArray e1 = new DuplicateEleArray();
        e1.duplicateSimple(arr);
//        e1.dupliacteLessSpaceComplexity(arr);

    }

    public void duplicateSimple(int[] arr)
    {
        HashSet<Integer>  dupli = new HashSet<>();
        for(int num:arr)
        {
            if(!dupli.add(num))
            {
                System.out.print(num+" ");
            }
        }
    }

    public void dupliacteLessSpaceComplexity(int[] arr)
    {
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1;i++)
        {
            if(arr[i]==arr[i+1] && (i==0 || arr[i] != arr[i-1]))
            {
                System.out.print(arr[i]+" ");
            }
        }
    }
}
