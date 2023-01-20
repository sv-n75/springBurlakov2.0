package task13_14_15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import task13_14_15.model.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findFirstByNameAndAge(String name, Integer age);

    List<Person> findByAge(Integer age);

    List<Person> findAll();

    @Query(
            value = "SELECT * FROM person_passport  p WHERE p.year > ?1",
            nativeQuery = true)
    List<Person> findMoreThan(Integer n);

}
