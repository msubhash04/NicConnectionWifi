package com.tcpserver.nic.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramPrac {

    public static void main(String[] args) {
        int[] arr = {5,3,1,8,9,-4,7};
        ProgramPrac p1 = new ProgramPrac();
        p1.minAndMaxSimple(arr);
        p1.minAndMaxStream(arr);
        p1.minAndMaxSummaryStatistics(arr);
        p1.minAndMaxColldection(arr);
        p1.reverseArraySimple(arr);
    }

    public void minAndMaxSimple(int[] arr)
    {
        int min=arr[0], max=arr[0];
       for(int i=1; i<arr.length;i++)
       {
           if(arr[i]<min) min=arr[i];
           if(arr[i]>max) max=arr[i];
       }
        System.out.println("Min And Max Simple");
        System.out.println("Minimum  :  "+min+"      Maximum  : "+max);
    }

    public void minAndMaxStream(int[] arr)
    {
        int min = Arrays.stream(arr).min().orElseThrow();
        int max = Arrays.stream(arr).max().orElseThrow();
        System.out.println("Min And Max Streams");
        System.out.println("Minimum  : "+min+"     Maximum  : "+max);
    }

    public void minAndMaxSummaryStatistics(int[] arr)
    {
        IntSummaryStatistics  stat  = Arrays.stream(arr).summaryStatistics();
        int min = stat.getMin();
        int max = stat.getMax();
        System.out.println("Min And Max Summary Statistics");
        System.out.println("Minimum  :  "+min+"     Maximum  :  "+max);
    }

    public void minAndMaxColldection(int[] arr)
    {
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        int min = Collections.min(list);
        int max = Collections.max(list);
        System.out.println("Min And Max Of Collections");
        System.out.println("Minimum  : "+min+"    Maximum  :  "+max);
    }

    public void reverseArraySimple(int[] arr)
    {
        int start=0, end=arr.length-1;
        while(start<end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        System.out.println("Reveresed Array Simple");
        System.out.print("[ ");
        for(int num : arr)
        {
            System.out.print(num+" ");
        }
        System.out.println("]");
    }

    public void reverseArrayCollections(int[] arr)
    {
        List<Integer>  lis = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.reverse(lis);
        System.out.println("Reversed Array Collections");
        System.out.println(lis);
    }
}
