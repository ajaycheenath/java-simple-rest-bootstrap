package com.cheenath.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "app")
public class App {
    @Id
    private Integer id;
    private String appName;
    private int port;
    private Date createDate;
    private String repo;

    protected App() {
    }

    public App(final Integer id, final String appName, final int port, final Date createDate, final String repo) {
        this.id = id;
        this.appName = appName;
        this.port = port;
        this.createDate = createDate;
        this.repo = repo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

}
