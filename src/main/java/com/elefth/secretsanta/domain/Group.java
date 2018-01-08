package com.elefth.secretsanta.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
@NodeEntity
public class Group {

    @GraphId
    private Long id;

    private String name;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    @Relationship(type = "BELONGS_TO", direction = Relationship.INCOMING)
    private Set<Person> members;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getMembers() {
        return members;
    }

    public void setMembers(Set<Person> members) {
        this.members = members;
    }

    public void addMember(Person person) {
        if (members == null) {
            members = new HashSet<>();
        }
        members.add(person);
    }
}
