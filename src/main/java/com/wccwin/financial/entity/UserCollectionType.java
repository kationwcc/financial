package com.wccwin.financial.entity;

import javax.persistence.*;

@Entity
@Table(name = "f_user_collection_type", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"uid", "cid"})
})
public class UserCollectionType {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "uid", nullable = false)
    private int uid;

    @Column(name = "cid", nullable = false)
    private int cid;

    @Column(name = "[sort]")
    private int sort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
