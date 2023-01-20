package task_consolidation_of_skills.service;



import task_consolidation_of_skills.model.Client;
import task_consolidation_of_skills.model.Order;
import task_consolidation_of_skills.service.dto.ClientDto;
import task_consolidation_of_skills.service.dto.OrderDto;

import java.util.List;

public interface ClientService {

    void addClient(Client client);

    ClientDto getClientsById(Long id);

    void updateClientsById(Long id, Client client);

    List<ClientDto> getClientsDto();

    void deleteClientById(Long id);

    void  addOrderByClientById(Long id, Order order);

    OrderDto getOrder(Long id, Integer number);

    void updateOrder(Long id, Integer number, Order order);

    List<OrderDto> getOrders(Long id);

    void deleteOrder(Long id, Integer number);

    Client findById(Long id);

    Order findByNumber(Long id, Integer number);

}
