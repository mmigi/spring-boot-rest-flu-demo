package com.company.demo.services;

import com.company.demo.models.User;
import com.company.demo.models.UserDao;
import com.company.demo.models.responses.UserStatisticResponse;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserStatisticServiceImpl implements UserStatisticService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserStatisticResponse> getUserStatistic(Boolean status, String updateTime) throws ParseException {
        List<User> users = new ArrayList<>();
        if (status != null) {
            users = userDao.findByStatus(status);
        } else {
            users = (List<User>) userDao.findAll();

        }
        if (updateTime != null) {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy-HH-mm-ss");
            DateTime dateTime = formatter.parseDateTime(updateTime);
            DateTime userTimeUpdated;
            for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
                User user = iterator.next();
                userTimeUpdated = new DateTime(user.getUpdateTime());
                if (userTimeUpdated.isBefore(dateTime)) {
                    iterator.remove();
                }
            }
        }

        List<UserStatisticResponse> response = new ArrayList<>();
        for (User user : users) {
            UserStatisticResponse userStatisticResponse = new UserStatisticResponse(user.getId(), user.getPictureId(),
                    user.getUpdateTime());
            response.add(userStatisticResponse);
        }

        return response;
    }
}
