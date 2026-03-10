package com.tcpserver.nic.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;

public class MinAndMaxArrayElement {

    public static void main(String[] args) {
        MinAndMaxArrayElement m1 = new MinAndMaxArrayElement();
        int[] arr = {26,16,89,56,91,6,82,11};
        m1.minAndMaxElement(arr);
        m1.minAndMaxStreams(arr);
        m1.minAndMaxSummaryStatistics(arr);
        minAndMaxCollections(arr);
    }

    public void minAndMaxElement(int[] arr)
    {
        int min = arr[0];
        int max = arr[0];
        for(int i=1; i<arr.length-1;i++){
            if(arr[i]<min) min = arr[i];
            if(arr[i]>max) max=arr[i];
        }
        System.out.println("---------- NORMAL METHOD ----------");
        System.out.println("Minimum Element  : "+min);
        System.out.println("Maximum Element  : "+max);
    }

    public void minAndMaxStreams(int[] arr)
    {
        int min = Arrays.stream(arr).min().orElseThrow();
        int max = Arrays.stream(arr).max().orElseThrow();

        System.out.println("----------- USING STREAMS -----------");
        System.out.println("Minimum Element  : "+min);
        System.out.println("Maximum Element  : "+max);
    }

    public void minAndMaxSummaryStatistics(int[] arr)
    {
        IntSummaryStatistics stats = Arrays.stream(arr).summaryStatistics();

        System.out.println("--------- USING SUMMARY STATISTICS -----------");
        System.out.println("Minimum Element  : "+stats.getMin());
        System.out.println("Maximum Element  : "+stats.getMax());
    }

    public static void minAndMaxCollections(int[] arr)
    {
        List<Integer> li = Arrays.stream(arr).boxed().toList();
        int min = Collections.min(li);
        int max = Collections.max(li);

        System.out.println("----------- USING COLLECTIONS -------------");
        System.out.println("Minimum Element  : "+min);
        System.out.println("Maximum Element  : "+max);
    }
}
