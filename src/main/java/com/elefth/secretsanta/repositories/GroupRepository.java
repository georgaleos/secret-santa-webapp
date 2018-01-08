package com.elefth.secretsanta.repositories;

import com.elefth.secretsanta.domain.Group;
import com.elefth.secretsanta.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
@RepositoryRestResource(collectionResourceRel = "groups", path = "groups")
public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {

    Group findByName(@Param("name") String name);

    Collection<Group> findByNameLike(@Param("name") String name);

    @Query("MATCH (g:Group)<-[b:BELONGS_TO]-(p:Person {id: {id}}) RETURN g,b,p")
    Collection<Group> findByMemberId(@Param("id") String id);

    @Query("MATCH (g:Group)<-[b:BELONGS_TO]-(p:Person {name: {name}}) RETURN g,b,p")
    Collection<Group> findByMemberName(@Param("name") String name);

    @Query("MATCH (g:Group)<-[b:BELONGS_TO]-(p:Person {email: {email}}) RETURN g,b,p")
    Collection<Group> findByMemberEmail(@Param("email") String email);

    Collection<Group> findByMembersContaining(@Param("member") Person member);

}
