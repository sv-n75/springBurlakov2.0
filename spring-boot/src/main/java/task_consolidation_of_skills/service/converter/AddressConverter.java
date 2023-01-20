package task_consolidation_of_skills.service.converter;

import org.springframework.stereotype.Component;
import task_consolidation_of_skills.model.Address;
import task_consolidation_of_skills.service.dto.AddressDto;

@Component
public class AddressConverter {
    public AddressDto getAddressDto(Address address) {
        return new AddressDto(address.getId(), address.getRegionCode(), address.getDistrictName(), address.getNameTown()
                ,address.getStreetName(), address.getHouseNumber()
                , address.getCaseNumber(), address.getOfficeRoomNumber());
    }
}
