package com.tencent.metrics.demos.controller;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.*;

@RestController
public class PathVariableController {

    @Timed(value = "path.variable.login", description = "path variable controller login", extraTags = {"userId", "roleId"})
    @RequestMapping(value = "/user/{userId}/roles/{roleId}", method = RequestMethod.GET)
    public String getLogin(@PathVariable("userId") String userId, @PathVariable("roleId") String roleId) {
        return "User Id : " + userId + " Role Id : " + roleId;
    }

    @Counted(value = "path.variable.regExp", description = "path variable controller regExp", extraTags = {"userId", "roleId"})
    @RequestMapping(value = "/javabeat/{regexp1:[a-z-]+}", method = RequestMethod.GET)
    public String getRegExp(@PathVariable("regexp1") String regexp1) {
        return "URI Part : " + regexp1;
    }
}
