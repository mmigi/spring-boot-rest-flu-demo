package com.company.demo.services;

import com.company.demo.models.responses.UserStatisticResponse;

import java.text.ParseException;
import java.util.List;

/**
 * User statistic Service
 *
 */
public interface UserStatisticService {
    /**
     * Returns user statistic according to their status and update time
     *
     * @param status     User status
     * @param updateTime Update time
     * @return User ID, picture ID, update time (if it was in request)
     * @throws ParseException
     */
    List<UserStatisticResponse> getUserStatistic(Boolean status, String updateTime) throws ParseException;
}
