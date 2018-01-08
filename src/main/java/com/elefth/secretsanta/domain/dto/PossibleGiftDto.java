package com.elefth.secretsanta.domain.dto;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
public class PossibleGiftDto {

    private String personFrom;

    private String personTo;

    public PossibleGiftDto() {
    }

    public String getPersonFrom() {
        return personFrom;
    }

    public void setPersonFrom(String personFrom) {
        this.personFrom = personFrom;
    }

    public String getPersonTo() {
        return personTo;
    }

    public void setPersonTo(String personTo) {
        this.personTo = personTo;
    }
}
