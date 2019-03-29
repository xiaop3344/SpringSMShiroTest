package com.xdl.bean;

import java.io.Serializable;

public class Role_Permission implements Serializable {

    private int rid;
    private int pid;

    public Role_Permission() {
    }

    public Role_Permission(int rid, int pid) {
        this.rid = rid;
        this.pid = pid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
