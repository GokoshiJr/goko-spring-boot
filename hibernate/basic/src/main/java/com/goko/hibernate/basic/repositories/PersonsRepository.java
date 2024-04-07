package com.goko.hibernate.basic.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.goko.hibernate.basic.entities.Person;
import java.util.List;
import java.util.Optional;

public interface PersonsRepository extends CrudRepository<Person, Long> {
    @Query(value = "SELECT * FROM Persons WHERE name LIKE %?1% LIMIT 1", nativeQuery = true)
    Optional<Person> findOneLikeName(String name);

    List<Person> findByHomeDirection(String homeDirection);

    @Query("SELECT p FROM Person p WHERE homeDirection LIKE %?1%")
    List<Person> findAllLikeDirection(String homeDirection);

    @Query("SELECT p.name, p.homeDirection FROM Person p WHERE p.id = %?1%")
    List<Object[]> findHomeDirectionByPersonId(Long Id);

}
