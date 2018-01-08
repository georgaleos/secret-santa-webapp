package com.elefth.secretsanta.repositories;

import com.elefth.secretsanta.domain.Privilege;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.Set;

/**
 * @author <a href="mailto:george@elefth.com">Eleftheriadis Georgios</a>
 */
@RepositoryRestResource(collectionResourceRel = "privileges", path = "privileges")
public interface PrivilegeRepository extends PagingAndSortingRepository<Privilege, Long> {

    Privilege findByName(@Param("name") String name);

    @Query("MATCH (p:Privilege)<-[h:HAS_PRIVILEGE]-(r:Role {name: {name}}) RETURN p,h,r")
    Collection<Privilege> findByRoleName(@Param("name") String name);

}
