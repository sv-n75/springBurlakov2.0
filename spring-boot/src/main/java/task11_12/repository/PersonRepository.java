package task11_12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import task11_12.model.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findFirstByNameAndAge(String name, Integer age);

    List<Person> findByAge(Integer age);

    List<Person> findAll();

    @Query(
            value = "SELECT * FROM personinformation  p WHERE p.age > 10",
            nativeQuery = true)
    List<Person> findMoreThan();
}
