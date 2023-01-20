package task17_21.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person_17")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String surname;


   @NotBlank(message = "name should  not be empty" )
    private String name;

    private String patronymic;

    @Column(name = "date_birthday")
    private LocalDate birthday;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Pattern(regexp = "^([A-ZА-Я])(\\w{7,9})$"
            , message = "password does not match valid format")
    private String password;

    private String address;

    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$"
            , message = "This phone number is not valid")
    private String mobile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    @Valid
    private Passport personPassport;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    private Department department;

}
