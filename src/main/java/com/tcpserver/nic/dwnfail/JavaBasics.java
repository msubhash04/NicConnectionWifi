package com.tcpserver.nic.dwnfail;


import com.tcpserver.nic.client.Test;

import java.util.*;
import java.sql.*;

public class JavaBasics {

    public static void main(String[] args) throws CloneNotSupportedException{
//        int x = 10;
//        int y = 010;
//        int z = 0x10;
//
//        System.out.println(x+"  ---  "+y+"  ---  "+z);

//        float a = 123.456F;
//        float b = 123.456f;
//        double c = 123.456;
//        double d = 0xFace;
//        double e = 0xBeef;
//        System.out.println(a+"  ---  "+b+"  ---  "+c+"  ---  "+d+"  ---  "+e);



//        Test  t=new Test();
//        t.i = 5;
//        Clone c=new Clone(t,10);
//        System.out.println(c.t.i+"--------- "+c.j);
//
//        Clone t2=(Clone) c.clone();
//        t2.t.i=6;
//        t2.j=7;
//        System.out.println(c.t.i+"--------- "+c.j);
//        System.out.println(t2.t.i+"--------- "+t2.j);


        //Date ambuiguity problem... The date is present in the java.util and java.sql package....
        Date d = new Date();

        //This below error i got...
//        D:\SUBHASH\QUANTUM_NIC_TCP\nic\src\main\java\com\tcpserver\nic\dwnfail\JavaBasics.java:40:9
//        java: reference to Date is ambiguous
//        both class java.sql.Date in java.sql and class java.util.Date in java.util match
    }
}
