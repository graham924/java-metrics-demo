package com.tencent.metrics.demos.service;

import com.tencent.metrics.demos.model.Group;

public interface GroupService {
    public Boolean addGroup(Group group);

    public Boolean deleteGroup(String groupId);

    public Boolean updateGroup(Group group);

    public Group getGroup(String groupId);

    Boolean deployGroup(String groupId);
}
