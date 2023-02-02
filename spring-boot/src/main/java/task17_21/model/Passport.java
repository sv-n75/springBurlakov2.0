package task17_21.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "passport_17",
        uniqueConstraints = @UniqueConstraint(columnNames = {"series", "number"}))
public class Passport {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "passport_id")
    private Long Id;

    @Pattern(regexp = "^[0-9]{4}$", message = "must be four digits")
    private String series;

    @Pattern(regexp = "^[0-9]{6}$", message = "should be six digits")
    private String number;

    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;
}
