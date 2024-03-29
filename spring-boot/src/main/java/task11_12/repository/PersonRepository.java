package task11_12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import task11_12.model.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findFirstByNameAndAge(String name, Integer age);

    List<Person> findByAge(Integer age);

    List<Person> findAll();

    @Query(
            value = "SELECT * FROM personinformation  p WHERE p.age > ?1",
            nativeQuery = true)
    List<Person> findMoreThan(Integer n);
}
