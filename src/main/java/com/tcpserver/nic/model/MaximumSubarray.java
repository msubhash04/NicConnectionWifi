package com.tcpserver.nic.model;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {2,9,-5,8,-2,6,16,-6,-4,7};
//        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray subArray = new MaximumSubarray();
//        int maxSum = subArray.subarrayKadane(arr);
//        System.out.println("Maximum Subarray Sum :   "+maxSum);

        subArray.kadane(arr);

    }

    public int subarrayKadane(int[] arr)
    {
        int currentSum = arr[0];
        int maxSum = arr[0];
        for(int i=1; i<arr.length;i++)
        {
            currentSum = Math.max(arr[i], currentSum+arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public void kadane(int[] arr)
    {
        int currSum = arr[0], maxSum=arr[0], start=0, end=0, tempStart=0;

        for(int i=1; i<arr.length;i++)
        {
            if(arr[i] > currSum+arr[i]){
                currSum = arr[i];
                tempStart=i;
            }else{
                currSum = currSum + arr[i];
            }

            if(currSum > maxSum)
            {
                maxSum = currSum;
                start = tempStart;
                end = i;
            }
        }

        System.out.println("Maximum Sum of SubArray : "+maxSum);
        System.out.println("Sub Array : ");

        for(int i=start; i<=end; i++)
        {
            System.out.print(arr[i]+" ");
        }

    }

}
