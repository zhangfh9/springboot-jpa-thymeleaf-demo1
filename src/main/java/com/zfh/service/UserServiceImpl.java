package com.zfh.service;

import com.zfh.bean.User;
import com.zfh.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.saveAndFlush(user);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User findOne(Long id) {
        Optional<User> optional = userDao.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }

        return null;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
