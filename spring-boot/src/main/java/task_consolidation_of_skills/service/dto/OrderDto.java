package task_consolidation_of_skills.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class OrderDto {
private Long id;
private Integer number;
private LocalDate dateOfCreation;
private String description;
private Integer sum;
private Long clientId;
}
