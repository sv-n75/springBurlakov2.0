package task_consolidation_of_skills.service.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import task_consolidation_of_skills.model.Client;
import task_consolidation_of_skills.service.dto.ClientDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClientConverter {

    private final AddressConverter addressConverter;
    private final OrderConverter orderConverter;

    public ClientDto getClientDto(Client client) {
        return new ClientDto(client.getId(), client.getTitle(), client.getIndividualTaxNumber()
                , client.getPhoneNumber(), addressConverter.getAddressDto(client.getAddress())
                , orderConverter.getOrderDtoList(client.getOrderList()));
    }

    public List<ClientDto> getClientsDto(List<Client> clientList) {
        return clientList.stream().map(this::getClientDto).collect(Collectors.toList());
    }
}
