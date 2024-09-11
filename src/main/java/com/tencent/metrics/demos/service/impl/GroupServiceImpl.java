package com.tencent.metrics.demos.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.tencent.metrics.demos.dao.GroupDao;
import com.tencent.metrics.demos.exception.GroupException;
import com.tencent.metrics.demos.metrics.MetricsHelper;
import com.tencent.metrics.demos.metrics.tag.BusinessFailureCountTag;
import com.tencent.metrics.demos.metrics.tag.DatabaseQueryDurationTag;
import com.tencent.metrics.demos.metrics.tag.ExternalCallDurationTag;
import com.tencent.metrics.demos.model.Group;
import com.tencent.metrics.demos.proxy.CloudProxy;
import com.tencent.metrics.demos.proxy.RequestBase;
import com.tencent.metrics.demos.service.GroupService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupServiceImpl implements GroupService {

    protected final static Logger log = LoggerFactory.getLogger(GroupServiceImpl.class);

    @Autowired
    private GroupDao groupDao;


    @Autowired
    private MeterRegistry meterRegistry;

    @Override
    public Boolean addGroup(Group group){
        // Business Failure Count
        MetricsHelper metric = new MetricsHelper(meterRegistry);
        Tags tags = metric.buildBusinessFailureCountTags(new BusinessFailureCountTag("deleteRepositoryPersonal", "", "", ""));
        Counter counter = metric.buildBusinessFailureCount(tags);
        try{
            // mock business failure
            if (StringUtils.isBlank(group.getId())){
                throw new GroupException("Group id is null");
            }
            if (StringUtils.isBlank(group.getName())){
                throw new GroupException("Group name is null");
            }
        }catch (GroupException ge){
            log.error("addGroup failed, errorMsg: {}", ge.getMessage());
            counter.increment();
        }catch (Exception ex){
            log.error("addGroup failed, error: ", ex);
            counter.increment();
        }
        return true;
    }

    @Override
    public Boolean deleteGroup(String groupId) {
        MetricsHelper metrics = new MetricsHelper(meterRegistry);
        Tags tags = metrics.buildDatabaseQueryDurationTags(new DatabaseQueryDurationTag("user_login", "user_login_group", "delete", "deleteGroup"));
        Timer timer = metrics.buildDatabaseQueryDurationTimer(tags);
        log.info("deleteGroup timer starting");
        Timer.Sample start = Timer.start();
        try{
            return groupDao.deleteGroup(groupId);
        }finally {
            start.stop(timer);
            log.info("deleteGroup timer stopping");
        }
    }

    @Override
    public Boolean updateGroup(Group group) {
        MetricsHelper metrics = new MetricsHelper(meterRegistry);
        Tags tags = metrics.buildDatabaseQueryDurationTags(new DatabaseQueryDurationTag("user_login", "user_login_group", "update", "updateGroup"));
        Timer timer = metrics.buildDatabaseQueryDurationTimer(tags);
        log.info("updateGroup timer starting");
        Timer.Sample start = Timer.start();
        try{
            return groupDao.updateGroup(group);
        }finally {
            start.stop(timer);
            log.info("updateGroup timer stopping");
        }
    }

    @Override
    public Group getGroup(String groupId) {
        MetricsHelper metrics = new MetricsHelper(meterRegistry);
        Tags tags = metrics.buildDatabaseQueryDurationTags(new DatabaseQueryDurationTag("user_login", "user_login_group", "select", "getGroup"));
        Timer timer = metrics.buildDatabaseQueryDurationTimer(tags);
        log.info("getGroup timer starting");
        Timer.Sample start = Timer.start();
        try{
            return groupDao.getGroup(groupId);
        }finally {
            start.stop(timer);
            log.info("getGroup timer stopping");
        }
    }

    @Override
    public Boolean deployGroup(String groupId) {
        String host = "https://cloud.tencent.com";
        int port = 8080;
        String uri = "/deploy/group"+groupId;
        String method = RequestMethod.POST.toString();
        String body = "";

        MetricsHelper metric = new MetricsHelper(meterRegistry);
        ExternalCallDurationTag tag = new ExternalCallDurationTag(method,
                host, uri, "v1");
        io.micrometer.core.instrument.Timer.Sample start = Timer.start();
        try {
            CloudProxy cloudProxy = new CloudProxy();
            RequestBase req = new RequestBase(host, port, uri, method, body);
            cloudProxy.ExternalCall(req);
        } catch (Exception ex) {
            tag.setException(ex.getMessage());
            log.error("call external error, exception: ", ex);
            throw ex;
        } finally {
            start.stop(metric.buildExternalCallDurationTimer(metric.buildExternalCallDurationTags(tag)));
        }
        return true;
    }
}
