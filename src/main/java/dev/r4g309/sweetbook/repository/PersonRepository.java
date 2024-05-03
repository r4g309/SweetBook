package dev.r4g309.sweetbook.repository;

import dev.r4g309.sweetbook.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByBirthYearLessThanAndDeathYearGreaterThan(Integer birthYear, Integer deathYear);
}
