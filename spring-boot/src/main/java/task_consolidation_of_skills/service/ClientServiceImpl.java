package task_consolidation_of_skills.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import task_consolidation_of_skills.Exception.ClientException;
import task_consolidation_of_skills.Exception.ClientExceptionEnum;
import task_consolidation_of_skills.model.Client;
import task_consolidation_of_skills.model.Order;
import task_consolidation_of_skills.repository.ClientRepository;
import task_consolidation_of_skills.repository.OrderRepository;
import task_consolidation_of_skills.service.converter.ClientConverter;
import task_consolidation_of_skills.service.converter.OrderConverter;
import task_consolidation_of_skills.service.dto.ClientDto;
import task_consolidation_of_skills.service.dto.OrderDto;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientConverter clientConverter;

    private final OrderConverter orderConverter;

    private final OrderRepository orderRepository;


    @Override
    public void addClient(Client client) {
        List<Order> orderList = client.getOrderList();
        if (orderList != null) {
        } else {
            orderList = new ArrayList<>();
        }
        for (Order o : orderList) {
            o.setClient(client);
        }
        clientRepository.save(client);
    }

    @Override
    public ClientDto getClientsById(Long id) {
        return clientConverter.getClientDto(findById(id));
    }

    @Override
    public void updateClientsById(Long id, Client client) {
        Client c = findById(id);
        if (client.getTitle() != null) c.setTitle(client.getTitle());
        if (client.getIndividualTaxNumber() != null) c.setIndividualTaxNumber(client.getIndividualTaxNumber());
        if (client.getPhoneNumber() != null) c.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(c);
    }


    @Override
    public List<ClientDto> getClientsDto() {
        return clientConverter.getClientsDto(clientRepository.findAll());
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.delete(findById(id));
    }

    @Override
    public void addOrderByClientById(Long id, Order order) {
        Client c = findById(id);
        order.setClient(c);
        c.getOrderList().add(order);
        clientRepository.save(c);
    }

    @Override
    public OrderDto getOrder(Long id, Integer number) {
        return orderConverter.getOrderDto(findByNumber(id, number));
    }

    @Override
    public void updateOrder(Long id, Integer number, Order order) {
        Order order1 = findByNumber(id, number);
        if (order.getNumber() != null) order1.setNumber(order.getNumber());
        if (order.getDateOfCreation() != null) order1.setDateOfCreation(order.getDateOfCreation());
        if (order.getDescription() != null) order1.setDescription(order.getDescription());
        if (order.getSum() != null) order1.setSum(order.getSum());
        orderRepository.save(order1);
    }

    @Override
    public List<OrderDto> getOrders(Long id) {
        Client c = findById(id);
        return orderConverter.getOrderDtoList(c.getOrderList());
    }

    @Override
    public void deleteOrder(Long id, Integer number) {
        Client c = findById(id);
        Order order = c.getOrderList().stream().filter(o -> o.getNumber().equals(number))
                .findFirst().orElseThrow(() -> new ClientException(ClientExceptionEnum
                        .ORDER_NOT_FOUND.getMessage()));
        c.getOrderList().remove(order);
        orderRepository.delete(order);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientException(ClientExceptionEnum.CLIENT_NOT_FOUND.getMessage()));
    }

    @Override
    public Order findByNumber(Long id, Integer number) {
        Client c = findById(id);
        return c.getOrderList().stream().filter(o -> o.getNumber().equals(number))
                .findFirst().orElseThrow(() -> new ClientException(ClientExceptionEnum
                        .ORDER_NOT_FOUND.getMessage()));
    }


}
