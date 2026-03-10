package com.tcpserver.nic.dwnfail;

import com.tcpserver.nic.client.Test;

public class Clone implements Cloneable{
    public Test t;
    int j;

    public Clone(Test t,int j){
        this.t=t;
        this.j=j;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
