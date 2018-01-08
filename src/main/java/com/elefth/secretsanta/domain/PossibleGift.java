package com.elefth.secretsanta.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
@RelationshipEntity(type = "POSSIBLE_GIFT")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PossibleGift {

    @GraphId
    private Long id;

    @StartNode
    private Person personFrom;

    @EndNode
    private Person personTo;

    public PossibleGift() {
    }

    public PossibleGift(Person personFrom, Person personTo) {
        this.personFrom = personFrom;
        this.personTo = personTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPersonFrom() {
        return personFrom;
    }

    public Person getPersonTo() {
        return personTo;
    }
}
