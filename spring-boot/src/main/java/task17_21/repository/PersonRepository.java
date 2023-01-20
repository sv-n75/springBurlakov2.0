package task17_21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import task17_21.model.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(String name);

   // List<Person> findByAge(Integer age);

    List<Person> findAll();

    @Query(
            value = "SELECT * FROM person_17  p WHERE  DATEDIFF(java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(p.getBirthday())) >?1",
            nativeQuery = true)
    List<Person> findMoreThan(Integer n);

}
