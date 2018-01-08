package com.elefth.secretsanta.domain.validation;

import com.elefth.secretsanta.domain.dto.PersonDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    public void initialize(PasswordMatches constraint) {
    }

    public boolean isValid(final Object obj, ConstraintValidatorContext context) {
        final PersonDto personDto = (PersonDto) obj;
        return personDto.getPassword().equals(personDto.getMatchingPassword());
    }
}
