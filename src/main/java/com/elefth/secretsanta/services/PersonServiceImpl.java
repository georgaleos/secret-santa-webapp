package com.elefth.secretsanta.services;

import com.elefth.secretsanta.domain.Person;
import com.elefth.secretsanta.domain.PossibleGift;
import com.elefth.secretsanta.domain.dto.PersonDto;
import com.elefth.secretsanta.domain.exceptions.UserAlreadyExistException;
import com.elefth.secretsanta.repositories.PersonRepository;
import com.elefth.secretsanta.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SessionRegistry sessionRegistry;

    @Override
    @Transactional
    public Person addPossibleGift(String personFromEmail, String personToEmail) {
        Person personFrom = personRepository.findByEmail(personFromEmail);
        Person personTo = personRepository.findByEmail(personToEmail);

        if (!personFrom.getGroup().equals(personTo.getGroup())) {
            throw new IllegalArgumentException();
        }

        personFrom.addPossibleGift(new PossibleGift(personFrom, personTo));

        return personRepository.save(personFrom);
    }

    private Map<String, Object> toD3Format(Collection<Person> people) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> relationships = new ArrayList<>();
        int i = 0;
        for (Person person : people) {
            nodes.add(map("name", person.getName(), "label", "person"));
            int target = i;
            i++;
            if (null != person.getPossibleGifts()) {
                for (PossibleGift possibleGift : person.getPossibleGifts()) {
                    Map<String, Object> actor = map("name", possibleGift.getPersonTo().getName(), "label", "person");
                    int source = nodes.indexOf(actor);
                    if (source == -1) {
                        nodes.add(actor);
                        source = i++;
                    }
                    relationships.add(map("source", source, "target", target));
                }
            }
        }
        return map("nodes", nodes, "links", relationships);
    }

    private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
        Map<String, Object> result = new HashMap<>(2);
        result.put(key1, value1);
        result.put(key2, value2);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> graph(int limit) {
        Collection<Person> result = personRepository.graph(limit);
        return toD3Format(result);
    }

    @Override
    public Person registerNewUserAccount(final PersonDto personDto) {
        if (emailExist(personDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: " + personDto.getEmail());
        }
        final Person person = new Person();

        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setPassword(passwordEncoder.encode(personDto.getPassword()));
        person.setEmail(personDto.getEmail());
        person.setRoles(Collections.singletonList(roleRepository.findByName("ROLE_USER")));
        return personRepository.save(person);
    }

    private boolean emailExist(final String email) {
        return personRepository.findByEmail(email) != null;
    }

    @Override
    public List<String> getUsersFromSessionRegistry() {
        return sessionRegistry.getAllPrincipals()
                .stream()
                .filter((u) -> !sessionRegistry.getAllSessions(u, false).isEmpty())
                .map(Object::toString)
                .collect(Collectors.toList());
    }

}
