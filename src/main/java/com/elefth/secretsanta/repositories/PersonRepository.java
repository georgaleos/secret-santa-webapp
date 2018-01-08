package com.elefth.secretsanta.repositories;

import com.elefth.secretsanta.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Collection<Person> findByName(@Param("name") String name);

    Collection<Person> findByNameLike(@Param("name") String name);

    Person findByEmail(@Param("email") String email);

    @Query("MATCH (pf:Person)<-[g:POSSIBLE_GIFT]-(pt:Person) RETURN pf,g,pt LIMIT {limit}")
    Collection<Person> graph(@Param("limit") int limit);

}
