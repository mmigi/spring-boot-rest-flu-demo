package com.company.demo.controllers;

import com.company.demo.models.responses.UserStatisticResponse;
import com.company.demo.models.responses.UserStatusResponse;
import com.company.demo.services.UserStatisticService;
import com.company.demo.services.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * Controller for getting user information
 */
@Controller
public class UserStatusController {
    @Autowired
    private UserStatusService userStatusService;
    @Autowired
    private UserStatisticService userStatisticService;

    /**
     * Change sttaus of user which is find by userId
     * and returns UserId, current status, old status
     *
     * @param userId User ID
     * @param status New status
     * @return UserId, current status, old status in JSON format
     */
    @RequestMapping(value = "/user/{id}/{status}", method = RequestMethod.GET)
    public
    @ResponseBody
    UserStatusResponse changeStatus(@PathVariable("id") long userId,
                                    @PathVariable("status") boolean status) throws InterruptedException {
        return userStatusService.changeUserStatus(userId, status);
    }

    /**
     * Returns User statistic in JSON format
     * according to their status and update time
     *
     * @param status User status
     * @param time   Update time
     * @return User ID, picture ID, time stamp (if it was in request)
     * @throws InterruptedException
     * @throws ParseException
     */
    @RequestMapping(value = "/user/statistic", method = RequestMethod.POST)
    public
    @ResponseBody
    List<UserStatisticResponse> getStatistic(@RequestParam(value = "status", required = false) Boolean status,
                                             @RequestParam(value = "time", required = false) String time) throws InterruptedException, ParseException {

        return userStatisticService.getUserStatistic(status, time);
    }

}
