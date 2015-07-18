package com.company.demo.services;

import com.company.demo.models.responses.UserStatusResponse;

/**
 * User status service
 */
public interface UserStatusService {
    /**
     * Change user status
     *
     * @param userId User ID
     * @param status Status
     * @return User ID, current status and old status in JSON object
     */
    UserStatusResponse changeUserStatus(long userId, boolean status) throws InterruptedException;

}