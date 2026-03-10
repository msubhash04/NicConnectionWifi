package com.tcpserver.nic.model;

public class ReverseSubString {
    public static void main(String[] args) {
        String str = "tharun";
        int start=3, end=4;
        ReverseSubString r1 = new ReverseSubString();
        String result = r1.reverseSubstring(str,start,end);
        System.out.println("The reverse Sub String  :  "+result);
    }

    public String reverseSubstring(String str,int start,int end)
    {
        String subString = str.substring(start,end+1);

        String reversed = new StringBuilder(subString).reverse().toString();

        return str.substring(0,start)+reversed+str.substring(end+1);
    }
}
