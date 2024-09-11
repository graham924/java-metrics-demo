package com.tencent.metrics.demos.dao;

import com.tencent.metrics.demos.model.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupDao {

    //@Autowired
    //private JdbcTemplate jdbcTemplate;

    public Boolean addGroup(Group group){
        // select * from group where id = groupId

        // if not exist, insert into group (id, name) values (groupId, groupName)
        return true;
    }

    public Boolean deleteGroup(String groupId){
        // select * from group where id = groupId

        // if exist, delete from group where id = groupId
        return true;
    }

    public Boolean updateGroup(Group group){
        // select * from group where id = groupId

        // if exist, update group set name = groupName where id = groupId
        return true;
    }

    public Group getGroup(String groupId){
        // select * from group where id = groupId

        // if exist, return group
        return new Group(groupId, "groupName");
    }
}
