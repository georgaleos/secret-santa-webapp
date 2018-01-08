package com.elefth.secretsanta.controller;

import com.elefth.secretsanta.domain.Group;
import com.elefth.secretsanta.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
@RestController
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(value = "/groups/{id}/addMember", method = RequestMethod.POST)
    public Group addGroupMember(@PathVariable("id") long id, @RequestParam("email") String email) {
        return groupService.addMember(id, email);
    }

}
