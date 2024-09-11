package com.tencent.metrics.demos.dao;

import com.tencent.metrics.demos.anno.DatabaseMetric;
import com.tencent.metrics.demos.model.Group;
import com.tencent.metrics.demos.model.User;

@DatabaseMetric
public class UserDao {
    public Boolean addUser(User user){
        // select * from user where id = userId

        // if exist, return false

        // if not exist, insert into user (name, age) values (userName, userAge)
        return true;
    }

    public Boolean deleteUser(String userName){
        // select * from user where id = userId

        // if exist, delete from user where id = userId
        return true;
    }

    public Boolean updateUser(User user){
        // select * from user where id = userId

        // if exist, update user set name = userName, age = userAge where id = userId

        return true;
    }

    public User getUser(String userName){
        // select * from user where id = userId

        // if exist, return user
        return new User(userName, 123);
    }
}
