package com.goko.hibernate.basic.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.goko.hibernate.basic.entities.Person;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByHomeDirection(String homeDirection);

    @Query("SELECT p FROM Person p WHERE homeDirection LIKE %?1%")
    List<Person> findAllLikeDirection(String homeDirection);

    @Query("SELECT p.name, p.homeDirection FROM Person p WHERE p.id = %?1%")
    List<Object[]> findHomeDirectionByPersonId(Long Id);
}
