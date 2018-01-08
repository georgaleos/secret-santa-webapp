package com.elefth.secretsanta.services;

import com.elefth.secretsanta.domain.Group;
import com.elefth.secretsanta.domain.Person;
import com.elefth.secretsanta.repositories.GroupRepository;
import com.elefth.secretsanta.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Group addMember(Long groupId, String personEmail) {
        Group group = groupRepository.findOne(groupId);

        Person person = personRepository.findByEmail(personEmail);

        group.addMember(person);

        return groupRepository.save(group);
    }

}
