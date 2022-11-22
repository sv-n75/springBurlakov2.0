package task11_12.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PersonExceptionEnum {

    PERSON_NOT_FOUND("Person is not found in this DB "),
    BAD_REQUEST("This request is bad! It is not working");

    private final String message;
}
