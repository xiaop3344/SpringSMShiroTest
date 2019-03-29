package com.xdl.bean;

import java.io.Serializable;

public class Role implements Serializable {

    private int id;
    private String name;
    private Permission permission;

    public Role() {
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
