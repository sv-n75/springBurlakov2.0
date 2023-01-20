package task_consolidation_of_skills.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address_consolidation_of_skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "region_code")
    private Integer regionCode;

    @Column(name = "district_name")
    private String districtName;

    @Column(name = "name_of_town")
    private String nameTown;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "house_number")
    private Integer houseNumber;

    @Column(name = "case_number")
    private Integer caseNumber;

    @Column(name = "office_room_number")
    private Integer officeRoomNumber;
}
