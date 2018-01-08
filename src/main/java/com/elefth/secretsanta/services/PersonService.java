package com.elefth.secretsanta.services;

import com.elefth.secretsanta.domain.Person;
import com.elefth.secretsanta.domain.dto.PersonDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
public interface PersonService {

    @Transactional
    Person addPossibleGift(String personFromEmail, String personToEmail);

    @Transactional(readOnly = true)
    Map<String, Object> graph(int limit);

    Person registerNewUserAccount(PersonDto personDto);

    List<String> getUsersFromSessionRegistry();
}
