package com.example.model;

public class records {
    String accountno;
    String id;
    String idcard;
    String name;
    String password;
    String roleid;
    boolean status;

    public records(String accountno, String id, String idcard, String name, String password, String roleid, boolean status) {
        this.accountno = accountno;
        this.id = id;
        this.idcard = idcard;
        this.name = name;
        this.password = password;
        this.roleid = roleid;
        this.status = status;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
