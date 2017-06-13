package com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by djr4488 on 6/9/17.
 */
@Entity
@Table(name = "alert_entries")
public class Alerts extends Identifiable {
    @Column(name = "title")
    private String title;
    @Column(name = "time")
    private Long time;
    @Column(name = "expires")
    private Long expires;
    @Column(name = "description", columnDefinition = "BLOB")
    private String description;
    @Column(name = "uri")
    private String uri;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
