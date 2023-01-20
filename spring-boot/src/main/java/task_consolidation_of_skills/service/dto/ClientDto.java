package task_consolidation_of_skills.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClientDto {
    private Long id;
    private String title;
    private String individualTaxNumber;
    private String phoneNumber;
    private AddressDto address;
    private List<OrderDto> orderList;
}
