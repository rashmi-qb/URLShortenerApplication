package com.urlshortener.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "URL_MAPPING")
public class UrlMapping {

    @Column(name = "id")
    @Id
    @JsonIgnore
    Integer id;

    @Column(name = "short_url")
    String shortUrl;

    @Column(name = "original_url")
    String originalUrl;

    @Column(name = "count")
    Integer count;

    @Column(name = "call_time")
    Date callTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public int getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCallTime() {
        return callTime;
    }

    public void setCallTime(Date updatedDate) {
        this.callTime = updatedDate;
    }
}
