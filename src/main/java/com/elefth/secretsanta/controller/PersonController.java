package com.elefth.secretsanta.controller;

import com.elefth.secretsanta.domain.Person;
import com.elefth.secretsanta.domain.dto.PossibleGiftDto;
import com.elefth.secretsanta.services.PersonService;
import com.elefth.secretsanta.services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Map;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
@Controller("/")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/graph")
    @ResponseBody
    public Map<String, Object> graph(@RequestParam(value = "limit",required = false) Integer limit) {
        return personService.graph(limit == null ? 100 : limit);
    }

    @RequestMapping(value = "/people/addPossibleGift", method = RequestMethod.POST)
    @ResponseBody
    public Person addPossibleGift(@RequestBody PossibleGiftDto possibleGiftDTO) {
        return personService.addPossibleGift(possibleGiftDTO.getPersonFrom(), possibleGiftDTO.getPersonTo());
    }

    @RequestMapping(value = "/people/loggedUsers", method = RequestMethod.GET)
    public String getLoggedUsersFromSessionRegistry(final Locale locale, final Model model) {
        model.addAttribute("users", personService.getUsersFromSessionRegistry());
        return "users";
    }

}
