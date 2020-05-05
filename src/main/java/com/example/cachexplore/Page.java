package com.example.cachexplore;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Integer pageNumber;
    private String content;

    public Page() {

    }

    public Page(Integer pageNumber, String content) {
        this.pageNumber = pageNumber;
        this.content = content;
    }

    public Integer getpageNumber() {
        return pageNumber;
    }

    public void setpageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Page{" + "pageNumber='" + pageNumber + '\'' + ", content='" + content + '\'' + '}';
    }

}