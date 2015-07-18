package com.company.demo.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {

    public User findById(long id);

    public List<User> findByStatus(boolean status);

}
