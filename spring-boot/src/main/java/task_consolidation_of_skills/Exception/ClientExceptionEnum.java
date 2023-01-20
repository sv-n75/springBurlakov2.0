package task_consolidation_of_skills.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClientExceptionEnum {
    CLIENT_NOT_FOUND("Client Not found in this DB"),
    ORDER_NOT_FOUND("Order not in client orderList"),
    BAD_REQUEST("this is bad request");

    private final String message;
}
