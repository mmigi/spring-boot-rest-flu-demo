package com.company.demo.models.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserStatisticResponse {
    private long id;
    private long pictureId;
    @JsonFormat(pattern = "yyyy-MM-dd-hh-mm-ss")
    private Date timeUpdated;

    public UserStatisticResponse() {
    }


    public UserStatisticResponse(long id, long pictureId, Date timeUpdated) {
        this.id = id;
        this.pictureId = pictureId;
        this.timeUpdated = timeUpdated;
    }

    public long getPictureId() {
        return pictureId;
    }

    public void setPictureId(long pictureId) {
        this.pictureId = pictureId;
    }

    public Date getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Date timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}