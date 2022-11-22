package task13_14_15.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "passport",
        uniqueConstraints = @UniqueConstraint(columnNames = {"series", "number"}))
public class Passport {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    private Long Id;

    private String series;

    private String number;

    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;
}
