package com.company.demo.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserStatusResponse {
    private long id;
    private boolean status;
    private boolean oldStatus;

    public UserStatusResponse() {
    }

    public UserStatusResponse(long id, boolean status, boolean oldStatus) {
        this.id = id;
        this.status = status;
        this.oldStatus = oldStatus;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(boolean oldStatus) {
        this.oldStatus = oldStatus;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}