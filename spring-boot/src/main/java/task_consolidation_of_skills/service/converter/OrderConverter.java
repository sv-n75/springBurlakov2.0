package task_consolidation_of_skills.service.converter;

import org.springframework.stereotype.Component;
import task_consolidation_of_skills.model.Order;
import task_consolidation_of_skills.service.dto.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderConverter {
    public OrderDto getOrderDto(Order order){
        return new OrderDto(order.getId(), order.getNumber(), order.getDateOfCreation(), order.getDescription()
                , order.getSum(), order.getClient().getId());
    }

    public List<OrderDto> getOrderDtoList(List<Order> orders){
        return orders.stream().map(this::getOrderDto).collect(Collectors.toList());
    }
}
