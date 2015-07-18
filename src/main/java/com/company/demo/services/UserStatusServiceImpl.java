package com.company.demo.services;

import com.company.demo.models.User;
import com.company.demo.models.UserDao;
import com.company.demo.models.responses.UserStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStatusServiceImpl implements UserStatusService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserStatusResponse changeUserStatus(long userId, boolean status) throws InterruptedException {
        User user = userDao.findById(userId);
        boolean oldStatus = user.isStatus();
        if (status == oldStatus) {
            return new UserStatusResponse(userId, status, oldStatus);
        }
        user.setStatus(status);
        userDao.save(user);
        Thread.currentThread().sleep(5000);
        return new UserStatusResponse(userId, status, oldStatus);
    }
}
