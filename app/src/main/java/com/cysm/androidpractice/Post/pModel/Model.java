package com.cysm.androidpractice.Post.pModel;

import java.io.Serializable;

public class Model implements Serializable {
    private String name;
    private String job;
    private String id;
    private String createdAt;

    public Model(String name, String job, String id, String createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}