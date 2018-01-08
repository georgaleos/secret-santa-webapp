package com.elefth.secretsanta.events;

import com.elefth.secretsanta.domain.Person;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private final String appUrl;
    private final Locale locale;
    private final Person person;

    public OnRegistrationCompleteEvent(final Person person, final Locale locale, final String appUrl) {
        super(person);
        this.person = person;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public Person getPerson() {
        return person;
    }

}
