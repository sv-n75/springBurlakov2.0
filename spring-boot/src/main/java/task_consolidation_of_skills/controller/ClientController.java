package task_consolidation_of_skills.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import task_consolidation_of_skills.model.Client;
import task_consolidation_of_skills.model.Order;
import task_consolidation_of_skills.service.ClientService;
import task_consolidation_of_skills.service.dto.ClientDto;
import task_consolidation_of_skills.service.dto.OrderDto;

import java.util.List;

@RestController
@RequestMapping(path = "clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/clients")
    public List<ClientDto> getClients() {
        return clientService.getClientsDto();
    }

    @PostMapping("/client")
    public String addClient(@RequestBody Client client){
        clientService.addClient(client);
        return "Client is added";
    }

    @GetMapping("/client/id/{id}")
    public ClientDto getClient(@PathVariable Long id){
        return clientService.getClientsById(id);
    }

    @DeleteMapping("/client/id/{id}")
    public String deleteClient(@PathVariable Long id){
        clientService.deleteClientById(id);
        return "Client is deleted";
    }

    @PutMapping("/addOrder/{id}")
    public String addOrder(@PathVariable Long id, @RequestBody Order order){
        clientService.addOrderByClientById(id, order);
        return "order is added";
    }

    @GetMapping("/order")
    public OrderDto getOrder(@RequestParam Long id, @RequestParam Integer number){
        return clientService.getOrder(id, number);
    }

    @GetMapping("/orders/{id}")
    public List<OrderDto> getOrders(@PathVariable Long id){
        return clientService.getOrders(id);
    }

    @DeleteMapping("/deleteOrder")
    public String deleteOrder(@RequestParam Long id, @RequestParam Integer number){
        clientService.deleteOrder(id, number);
        return "order is deleted";
    }

    @PutMapping("/updateClient/{id}")
    public String updateClient(@PathVariable Long id,@RequestBody Client client ){
        clientService.updateClientsById(id, client);
        return "Client is updated";
    }

    @PutMapping("/updateOrder")
    public String updateOrder(@RequestParam Long id, @RequestParam Integer number, @RequestBody Order order){
        clientService.updateOrder(id, number, order);
        return "order is updated";
    }


}
