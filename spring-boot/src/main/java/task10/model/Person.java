package task10.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "personinformation")
@Data
@NoArgsConstructor
public class Person  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "age")
    private Integer age;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "passport")
    private String passport;

}
