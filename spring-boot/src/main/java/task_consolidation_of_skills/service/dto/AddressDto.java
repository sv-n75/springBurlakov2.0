package task_consolidation_of_skills.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDto {
    private Long id;
    private Integer regionCode;
    private String districtName;
    private String nameTown;
    private String streetName;
    private Integer houseNumber;
    private Integer caseNumber;
    private Integer officeRoomNumber;
}
