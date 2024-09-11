package com.tencent.metrics.demos.controller;

import com.tencent.metrics.demos.model.Group;
import com.tencent.metrics.demos.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/group/add", method = RequestMethod.POST)
    public Boolean addGroup(@RequestBody Group group){
        return groupService.addGroup(group);
    }

    @RequestMapping(value = "/group/delete", method = RequestMethod.POST)
    public Boolean deleteGroup(String groupId){
        return groupService.deleteGroup(groupId);
    }

    @RequestMapping(value = "/group/update", method = RequestMethod.POST)
    public Boolean updateGroup(@RequestBody Group group){
        return groupService.updateGroup(group);
    }

    @RequestMapping(value = "/group/get", method = RequestMethod.POST)
    public Group getGroup(String groupId){
        return groupService.getGroup(groupId);
    }

    @RequestMapping(value = "/group/deploy", method = RequestMethod.POST)
    public Boolean deployGroup(String groupId){
        return groupService.deployGroup(groupId);
    }
}
