package com.elefth.secretsanta.domain.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

   private Pattern pattern;
   private Matcher matcher;

   private static final String EMAIL_PATTERN =
           "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


   public void initialize(final ValidEmail constraint) {
   }

   public boolean isValid(String email, ConstraintValidatorContext context) {
       return (validateEmail(email));
   }

    private boolean validateEmail(final String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
